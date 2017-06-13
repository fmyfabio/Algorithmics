package com.wallethub;

public class PalindromeMain {

	public static void main(String[] args) {		
		Palindrome palindrome = new Palindrome();
		
		//Executing the first word, should be a palindrome
		boolean check1 = palindrome.isPalindrome("1221");
		//Executing the second word, shouldn't be a palindrome
		boolean check2 = palindrome.isPalindrome("1121");
		
		System.out.println("Check1: "+check1);
		System.out.println("Check2: "+check2);
	}

}
