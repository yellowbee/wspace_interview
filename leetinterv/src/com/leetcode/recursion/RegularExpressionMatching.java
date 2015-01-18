package com.leetcode.recursion;

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
 * "aaa", "ab*a" -> false
 * 
 * Solution: 2-D DP
 * Define M[i, j] as true if s[0, i] can be matched with p[0, j]
 * 
 */

public class RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(RegularExpressionMatching.isMatch("ab", ".*c"));
	}
	
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		
		if (p.length() == 1) {
			if (s.length() != 1) return false;
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
				return true;
			}
			else {
				return false;
			}
		}
		
		// if p[1] is not '*'
		if (p.charAt(1) != '*') {
			if (s.length() == 0) return false;
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
				 return isMatch(s.substring(1), p.substring(1));
			}
			else {
				return false;
			}
		}
		// if p[1] is '*'
		else {
			// '*' is for 0 number of preceding characters
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			// '*' is for k number of preceding characters, where k>=1
			// try all the possibilities of k
			else {
				for (int k=1; k<=s.length(); k++) {
					if (s.charAt(k-1) == p.charAt(0) || p.charAt(0) == '.') {
						if (isMatch(s.substring(k), p.substring(2))) {
							return true;
						}
					}
					else {
						break;
					}
				}
				return false;
			}
		}
	}
}
