package com.leetcode.oj.dp;

import java.util.Arrays;

/*
 * Given a string s, partition s such that every substring of the partition
 * is a palindrome. Return the minimum cuts needed for a palindrome
 * partitioning of s. For example, given s = "aab",Return 1 since the
 * palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * Category: DP
 */

public class PalindromePartitionII {
	public int minCut(String s) {
		int slen = s.length();
		
		/*
		 * A DP is needed to calculate if a string
		 * is a palindrome. Define P[i][j] is the boolean
		 * value indicating whether S[i][j] is a palindrome.
		 */
		boolean[][] P = new boolean[slen][slen];
		for (int i=0; i<slen; i++) {
			for (int j=0; j<slen; j++) {
				P[i][j] = false;
			}
		}
		for(int i = slen-1; i >= 0; i--){  
			for(int j = i; j < slen; j++){  
				if(s.charAt(i) == s.charAt(j) && (j-i<2 || P[i+1][j-1])){  
					P[i][j] = true;  
				}  
			}  
		}
		
		int[] C = new int[slen];
		for (int i=0; i<slen; i++) {
			C[i] = i;
		}
		
		/*
		 * Define C[i] is the minimum number of cuts to make
		 * S[0][i] a palindrome partition.
		 */
		for (int i=0; i<slen; i++) {
			// if (isPalindrome(s.substring(0, i+1))) {
			if (P[0][i]) {
				C[i] = 0;
			}
			else {
				for (int j=0; j<i; j++) {
					// if (isPalindrome(s.substring(j+1, i+1))) {
					if (P[j+1][i]) {
						if (C[j] + 1 < C[i]) {
							C[i] = C[j] + 1;
						}
					}
				}
			}
		}
		return C[slen-1];
	}
	
	/*
	 * If this helper method is used to decide whether a string
	 * is a palindrome, time limit will be exceeded.
	 */
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		
		int left = 0;
		int right = s.length()-1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			else {
				left++;
				right--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitionII pp = new PalindromePartitionII();
		System.out.println(pp.minCut("aab"));
		//System.out.println(pp.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		//System.out.println(pp.minCut("leet"));
	}
}
