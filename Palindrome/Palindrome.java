package com.wallethub;

/**
 * Class to analize if the string is a palindrome or not.
 * @author fabio.santos
 * 
 * Note: I would use the java method str.equals(new StringBuilder(str).reverse().toString())
 * 		 but I intend to demonstrate my own algorithmic
 */
public class Palindrome {
	
	/** Recursive method to checking the palindrome string **/
	public boolean isPalindrome(String s) {
	    int length = s.length();
	    	    
	   // Declaring the end of the recursivity, all length two must be a palindrome
	    if (length < 2) return true;
	    // Checking if the first index and de last index is equals then keeping the iteration 
	    else return s.charAt(0) != s.charAt(length - 1) ? false : isPalindrome(s.substring(1, length - 1));
	}
	
}
