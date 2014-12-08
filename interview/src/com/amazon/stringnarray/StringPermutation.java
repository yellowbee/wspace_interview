package com.amazon.stringnarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Print all permutations of a given string.
 */

public class StringPermutation {
	public static void main(String[] args) {
		String S = "abc";
		List<String> result = permute(S);
		System.out.println(result);
	}
	
	public static List<String> permute(String S) {
		char[] A = S.toCharArray();
		List<String> result = new ArrayList<String>();
		boolean[] used = new boolean[A.length];
		Arrays.fill(used, Boolean.FALSE);
		StringBuilder sofar = new StringBuilder();
		helper(result, sofar, A, used);
		
		return result;
	}
	
	private static void helper(List<String> result, StringBuilder sofar, char[] A, boolean[] used) {
		for (int i=0; i<A.length; i++) {
			if (!used[i]) {
				sofar.append(A[i]);
				used[i] = true;
				if (sofar.length() == A.length) {
					result.add(sofar.toString());
				}
				else {
					helper(result, sofar, A, used);
				}
				used[i] = false;
				sofar.deleteCharAt(sofar.length()-1);
			}
		}
	}
}
