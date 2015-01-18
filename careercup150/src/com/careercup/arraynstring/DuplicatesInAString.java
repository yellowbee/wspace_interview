package com.careercup.arraynstring;


/*
 * Implement an algorithm to determine if a string has all unique characters. What if you
 * can not use additional data structures?
 * 
 * Note: No mater how large is an extra space, as long as it's constant, it is considered
 * as "no extra space except for a vairable or two";
 */

public class DuplicatesInAString {
	public static void main(String[] args) {
		System.out.println(DuplicatesInAString.isUniqueChars2("world"));
	}
	
	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i=0; i<str.length(); i++) {
			if (char_set[str.charAt(i)]) {
				return false;
			}
			char_set[str.charAt(i)] = true;
		}
		
		return true;
	}
}
