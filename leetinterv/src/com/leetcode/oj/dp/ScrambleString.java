package com.leetcode.oj.dp;

import java.util.Arrays;

/*
 * Solution: 3-D DP
 * Define boolean[][][] iss, where iss[k][i][j] is true if
 * two strings of length k starting from index i in s1 and index j in s2
 * are scramble strings, false otherwise;
 * 
 * Test cases:
 * 1) "abcdefghijklmnopq", "efghijklmnopqcadb"
 * 2) "rgeat", "great"
 */

public class ScrambleString {
	public static void main(String[] args) {
		System.out.println(ScrambleString.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
	}
	
	/*public static boolean isScramble(String s1, String s2) {
		if (s1.equals(s2)) return true;
		if (s1.length() != s2.length() || s1.length() == 1) return false;
		
		int LEN = s1.length();
		for (int i=0; i<LEN-1; i++) {
			if (isScramble(s1.substring(0, i+1), s2.substring(0, i+1)) &&
				isScramble(s1.substring(i+1, LEN), s2.substring(i+1, LEN)) ||
				isScramble(s1.substring(0, i+1), s2.substring(LEN-i-1, LEN)) &&
				isScramble(s1.substring(i+1, LEN), s2.substring(0, LEN-i-1))) {
				
				return true;
			}
		}
		
		return false;
    }*/
	
	public static boolean isScramble(String s1, String s2) {
		if (s1.equals(s2)) return true;
		if (s1.length() != s2.length() || s1.length() == 1) return false;
		
		char[] ca1 = s1.toCharArray();
		char[] ca2 = s2.toCharArray();
		Arrays.sort(ca1);
		Arrays.sort(ca2);
		// if s1 and s2 contains different sets of characters
		String sorted_s1 = Arrays.toString(ca1);
		String sorted_s2 = Arrays.toString(ca2);
		if (!sorted_s1.equals(sorted_s2)) return false;
		
		// init the 3-D matrix
		int LEN = s1.length();
		boolean[][][] iss = new boolean[LEN+1][LEN][LEN];
		for (int k=0; k<=LEN; k++) {
			for (int i=0; i<LEN; i++) {
				for (int j=0; j<LEN; j++) {
					iss[k][i][j] = false;
				}
			}
		}
		
		for (int i=0; i<LEN; i++) {
			for (int j=0; j<LEN; j++) {
				String substr1 = s1.substring(i, i+1);
				String substr2 = s2.substring(j, j+1);
				if (substr1.equals(substr2)) iss[1][i][j] = true;
			}
		}

		for (int k=2; k<=LEN; k++) {
			for (int i=0; i<=LEN-k; i++) {
				for (int j=0; j<=LEN-k; j++) {
					// for all the possible cut in position p
					// where p is the length of the left half
					for (int p=1; p<=k-1; p++) {
						if (iss[p][i][j] && iss[k-p][i+p][j+p] || iss[p][i][j+k-p] && iss[k-p][i+p][j]) {
							iss[k][i][j] = true;
							break;
						}
					}
				}
			}
		}
		
		return iss[LEN][0][0];
	}
}
