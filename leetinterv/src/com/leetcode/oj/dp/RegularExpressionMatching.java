package com.leetcode.oj.dp;

/*
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 * Solution: 2-D DP
 * Define M[i, j] as true if s[0, i] can be matched with p[0, j]
 * 
 */

public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(RegularExpressionMatching.isMatch("aaa", "ab*a"));
	}
	
	public static boolean isMatch(String s, String p) {
		int SLEN = s.length();
		int PLEN = p.length();
		
		// if s is an empty string
		if (SLEN == 0) {
			if (PLEN % 2 != 0) return false;
			for (int j=1; j<PLEN; j+=2) {
				if (p.charAt(j) != '*') return false;
			}
			return true;
		}
		
		// looking for the first char in pattern that can be matched with
		// the first char in s.
		int k = 0;
		while (k < PLEN) {
			if (p.charAt(k) == '.' || p.charAt(k) == s.charAt(0)) {
				p = p.substring(k, PLEN);
				break;
			}
			
			if (k+1 < PLEN) {
				if (p.charAt(k+1) == '*') {
					k += 2;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		if (k < PLEN) {
			PLEN = p.length();
		}
		else {
			return false;
		}
		
		
        boolean[][] M = new boolean[SLEN][PLEN];
        //initialize first row and first col
        for (int i=0; i<SLEN; i++) {//complete string to match against the pattern of size 1, at the beginning of p
        	if (i == 0) {
        		char ch = p.charAt(0);
        		if (ch == s.charAt(0) || ch == '.') {
        			M[i][0] = true;
        		}
        		else {
        			M[i][0] = false;
        		}
        	}
        	else {
        		M[i][0] = false;
        	}
        }
        for (int j=1; j<PLEN; j++) {//first string char to match against p of all sizes
        	if (j == 1) {
        		if (p.charAt(1) == '*' && M[0][0]) {
        			M[0][1] = true;
        		}
        		else {
        			M[0][1] = false;
        		}
        	}
        	else {
        		if (M[0][j-2] && p.charAt(j) == '*') {
        			M[0][j] = true;
        		}
        		else {
        			M[0][j] = false;
        		}
        	}
        }
        
        for (int i=1; i<SLEN; i++) {
        	for (int j=1; j<PLEN; j++) {
        		if (M[i-1][j-1] && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')) {
        			M[i][j] = true;
        		}
        		else if (j >= 2 && M[i][j-2]) {
        			if (p.charAt(j) == '*') {
        				M[i][j] = true;
        			}
        		}
        		else if (M[i-1][j]) {
        			if (p.charAt(j) == '*' && s.charAt(i) == s.charAt(i-1)) {
        				M[i][j] = true;
        			}
        		}
        		else {
        			M[i][j] = false;
        		}
        	}
        }
        
        return M[SLEN-1][PLEN-1];
    }
}
