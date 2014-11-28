package com.interviewexposed.arraynstring;

public class ReverseWords {
	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
		System.out.println(rw.reverseWords("b hello world this is a string"));
	}
	
	// Reverse word order in a string, in one pass, in place
	public String reverseWords(String str) {
		StringBuilder sb = new StringBuilder();
		char[] A = str.toCharArray();
		int start = A.length - 1;
		int end = A.length - 1;
		
		while (start >= 0 && end >= 0) {
			while (end >= 0 && A[end] == ' ') {
				end--; // searching for the end of the current word
			}
			start = end;
			while ((start > 0 && A[start-1] != ' ')) {
				start--; // searching for the start of the word
			}
			
			// The condition in if statement takes care of
			// boundary cases
			if (start >=0 && end >= 0) {
				sb.append(str.substring(start, end+1) + " ");
				end = start - 1; // get ready for searching the next word
			}
		}
		
		return sb.toString();
	}
}
