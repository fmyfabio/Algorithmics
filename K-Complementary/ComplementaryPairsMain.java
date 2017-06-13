package com.wallethub;

import java.util.Map;

public class ComplementaryPairsMain {

	public static void main(String[] args) {
		ComplementaryPairs complementaryPairs = new ComplementaryPairs();
		
		//Array to be analized
        Integer[] array = new Integer[] {4,5,6,3,1,8,-7,-6};
        
        //Variable of the K
        Integer k = 10;
        
        //Getting the pairs
        Map<Integer, Integer> pairs = complementaryPairs.getKComplementaryPairs(k, array);
        
        System.out.println(pairs);
        
        //The print will be {4=6, 6=4}
	}

}
