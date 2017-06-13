package com.wallethub;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class to get the K-Complementary on a integer array
 * @author fabio.santos
 */
public class ComplementaryPairs {
	
	/** 
	 * Method to return the map of the pairs K-Complementary
	 */
    public Map<Integer, Integer> getKComplementaryPairs(Integer sum, Integer[] listOfIntegers) {

        //Building the map with the complementary number (sum - number) related to each number of the array 
        Map<Integer, Integer> pairs = Arrays.stream(listOfIntegers).collect(Collectors.toMap(number -> number, number -> sum-number));

        //Iteration on array to get the paris K-Complementary
        Map<Integer, Integer> map = Arrays.stream(listOfIntegers)
        		//Filtering: If the complementary number of the iteration element is a key on 'pairs' map
        		//           then this element is a match of the K-Complementary Pair
                .filter(number -> pairs.containsKey(sum-number) && number != sum - number)
                //Getting the pair according to filter
                .collect(Collectors.toMap(pair -> pairs.get(pair), pair -> pair));

        //Because of two stream of array(listOfIntegers) complexity O(n)+O(n) ==> O(n)
        return map;
    }
	
}
