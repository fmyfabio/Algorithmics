package com.wallethub;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Class to process the big file and get the N most used words.
 * 
 * My approach to solve this problem was based on mapreduce algorithmic.
 * 
 * @author fabio.santos
 */
public class TopPhrases {

	/**
	 * MAP-REDUCE APPROACH
	 */
	
	private final Integer READ_LINES_LIMIT = 4;
	private final Integer MAX_THREAD_QUEUE_POOL = 10;
	private final Integer THREAD_POOL = 5;
	
	//Declaring the QUEUE and EXECUTOR threads to handle the CPU and MEMORY of the machine 
	private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(MAX_THREAD_QUEUE_POOL);
	private ThreadPoolExecutor executor = new ThreadPoolExecutor(THREAD_POOL, THREAD_POOL, 0L, TimeUnit.MILLISECONDS, queue);
	
	/**
	 * Pricipal method to get the List of N most used words in the file
	 */
	public List<String> getTopPhrases(Integer topNumberPrases, String path) throws IOException {
		FileInputStream inputStream = new FileInputStream(path);
		
		//Doing the MAP operation
		List<Map<String, Integer>> mappingList = this.mappingOperation(inputStream);
		//Doing the REDUCE operation
		Map<String, Integer> reducingMap = this.reducingOperation(mappingList);
		//Doing the process of output
		List<String> listOutPut = this.processOutPut(topNumberPrases, reducingMap);
		
		return listOutPut;
	}

	/**
	 * Process output
	 */
	private List<String> processOutPut(Integer topNumberPrases, Map<String, Integer> reducingMap) {
        //Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(reducingMap.entrySet());

        // Sort list with Collections.sort(), provide a custom Comparator
        // Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        List<String> listOutPut = new ArrayList<>();
        for (int i = 0; i < topNumberPrases; i++) {
        	listOutPut.add(list.get(i).getKey()+"-"+list.get(i).getValue());
		}

        return listOutPut;	
	}
	
	/**
	 * Method to perform the MAP operation
	 */
	private List<Map<String, Integer>> mappingOperation(FileInputStream inputStream) throws IOException {
		// Using Scanner to read the file
		// Scanner don't set all file in memory, just the line reding
		Scanner sc = new Scanner(inputStream, "UTF-8");
		
		// The final MAP list result
		List<Map<String, Integer>> mappingList = new ArrayList<>();
		
		// List that represent each first fragment of the file
		List<String> documentDataSet = new ArrayList<>();
		int i = 0;
		
		while (sc.hasNextLine()) {
			// Build a document
			documentDataSet.addAll(Arrays.asList(sc.nextLine().split("\\|")));
			
			// Checking if the point is ready to execute the next step (PROCESS THE DOCUMENT PARALLEL)
			// Each document is made of '4' lines in the fila, specified on variable READ_LINES_LIMIT
			if ((i != 0 && i%READ_LINES_LIMIT == 0) || !sc.hasNextLine()) {
				
				// Checking if the THREAD POLL is fulll
				while(queue.size() >= MAX_THREAD_QUEUE_POOL){}
				
				// Run parallel document process
				MappingProcessThread mappingProcessThread = new MappingProcessThread(mappingList, documentDataSet);
				executor.execute(mappingProcessThread);	
				documentDataSet = new ArrayList<>();
				i=0;
			}
			i++;
		}
		
        inputStream.close();
        sc.close();
        
        // Checking if there is no threads in the POOL to end the process
        while(queue.size() != 0){}
        return mappingList;
	}
	
	/**
	 * Method to perform the REDUCE operation
	 */
	private Map<String, Integer> reducingOperation(List<Map<String, Integer>> mappingList) {
		// The final REDUCE result
		Map<String, Integer> mapResult = new HashMap<>();
		
		// Iteration on the each part of the MAP operation Result
		for (Map<String, Integer> mapIteration : mappingList) {
			
			// Checking if the THREAD POOL is full
			while(queue.size() >= MAX_THREAD_QUEUE_POOL){}
			
			// Running the parallel reducing process
			ReducingProcessThread reducingProcessThread = new ReducingProcessThread(mapResult, mapIteration);
			executor.execute(reducingProcessThread);			
		}
		
        // Checking if there is no threads in the POOL to end the process
		while(queue.size() != 0){}
		return mapResult;		
	}
	
	/**
	 * Method to run the REDUCE process in parallel
	 */
	private class ReducingProcessThread implements Runnable {
		
		private Map<String, Integer> mapResult;
		private Map<String, Integer> mapIteraion;
		
		public ReducingProcessThread(Map<String, Integer> mapResult, Map<String, Integer> mapIteraion) {
			this.mapResult = mapResult;
			this.mapIteraion = mapIteraion;
		}
		
		@Override
		public void run() {
			// Itaration of uma fragment made by MAP operation
			mapIteraion.entrySet().stream().parallel().forEach(p -> {
				this.reducing(p.getKey(), p.getValue());
			});
		}

		private void reducing(String key, Integer value) {
			// This process will collect all the common key and storage in
			// a common global map the SUM of all words related to the key
			if (mapResult.get(key) == null) {
				mapResult.put(key, value);
			} else {
				mapResult.put(key, mapResult.get(key) + value); 
			}
		}
		
	}
	
	/**
	 * Method to run the MAP process in parallel
	 */
	private class MappingProcessThread implements Runnable {
		
		private List<Map<String, Integer>> list;
		private List<String> documentDataSet;
		
		public MappingProcessThread(List<Map<String, Integer>> list, List<String> documentDataSet) {
			this.list = list;
			this.documentDataSet = documentDataSet;
		}

		@Override
		public void run() {
			// Processing each line of the document generated from the file
			this.documentDataSet.stream().parallel().forEach(p -> {				
				// Splitting and Mapping operations
				this.mapping(Arrays.asList(p.split(" ")));	
			});			
		}
	
		private void mapping(List<String> listSplit) {
			// The process will colect the matching words on the line and
			// count the total of each one of the them.
			Map<String, Integer> map = new HashMap();
			
			listSplit.stream().forEach(p -> {
				if (p != null && p.length() > 0) {
					
					if (map.get(p) == null) {
						map.put(p, 1);
					} else {
						map.put(p, map.get(p) + 1);
					}
					
				}
			});
			
			list.add(map);
		}
		
	}
	
}
