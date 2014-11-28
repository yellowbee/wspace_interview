package com.leetcode.miscellaneous;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
		
		// get an array of words/tokens
		String[] token_arr = s.split("\\s+");
		
		// construct the string from the last word to the first
		StringBuffer sb = new StringBuffer();
		for (int i=token_arr.length-1; i>=0; i--) {
			if (!token_arr[i].equals("")) {
				sb.append(token_arr[i] + " ");
			}
		}
		String result = sb.toString();
		
		return result.trim();
	}
	
	public static void main(String[] args) {
		ReverseWordsInAString rw = new ReverseWordsInAString();
		System.out.println(rw.reverseWords("a"));
	}
}
