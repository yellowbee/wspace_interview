package com.interviewexposed.recursion;

import java.util.Arrays;

public class Combination {
	public static void main(String[] args) {
		String s = "abcd";
		for (int i=1; i<=s.length(); i++) {
			Combination.findCombination(s, i);
		}
	}

	// combination of the characters in a string
	public static void findCombination(String s, int combo_size) {
	    char[] A = s.toCharArray();
	    boolean[] used = new boolean[A.length];
	    Arrays.fill(used, Boolean.FALSE);
	    StringBuilder sofar = new StringBuilder();
	    
	    helper(A, used, sofar, -1, combo_size);
	}

	public static void helper(char[] A, boolean[] used, StringBuilder sofar, int last_used, int combo_size) {
	    for (int i=0; i<used.length; i++) {
	        // i>last_used to avoid duplicates
	        if (i>last_used) {
	            // set
	            used[i] = true;
	            sofar.append(A[i]);
	            
	            if (sofar.length() == combo_size) {
	                System.out.println(sofar.toString());
	            }
	            else {
	                helper(A, used, sofar, i, combo_size);
	            }
	            
	            //reset
	            used[i] = false;
	            sofar.deleteCharAt(sofar.length()-1);
	        }
	    }
	}
}
