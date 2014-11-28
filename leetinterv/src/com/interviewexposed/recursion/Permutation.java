package com.interviewexposed.recursion;

import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		Permutation.permute("abcd");
	}
	
	// permutaiton of all the characters in a string
	public static void permute(String s) {
	    char[] S = s.toCharArray();
	    boolean[] used = new boolean[S.length];
	    Arrays.fill(used, Boolean.FALSE);
	    StringBuilder sofar = new StringBuilder();
	    helper(S, used, sofar);
	}

	public static void helper(char[] S, boolean[] used, StringBuilder sofar) {
	    for (int i=0; i<used.length; i++) {
	        if (!used[i]) {
	            // set
	            used[i] = true;
	            sofar.append(S[i]);
	            
	            // if last character, output
	            if (sofar.length() == S.length) {
	                System.out.println(sofar.toString());
	            }
	            else {
	                helper(S, used, sofar);
	            }
	            
	            // reset
	            used[i] = false;
	            sofar.deleteCharAt(sofar.length()-1);
	        }
	    }
	}
}
