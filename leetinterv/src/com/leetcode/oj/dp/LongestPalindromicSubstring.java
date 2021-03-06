package com.leetcode.oj.dp;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there
 * exists one unique longest palindromic substring.
 * 
 * longest palindrome
 * P[i, j] =   true, if P[i+1, j-1] && S[i] == S[j]
 *             false, otherwise
 */

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("ccd"));
	}
	
	public String longestPalindrome(String s) {
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
		
		int i_max = 0;
		int j_max = -1;
		
		for (int i=0; i<slen; i++) {
			for (int j=i; j<slen; j++) {
				if (P[i][j] && (j-i)>(j_max-i_max)) {
					i_max = i;
					j_max = j;
				}
			}
		}
		
		return s.substring(i_max, j_max+1);
    }
}
