package com.leetcode.oj.arraynstring;

import java.util.HashMap;
import java.util.Map;


/*
 * Given a string, find the length of the longest substring without
 * repeating characters. For example, the longest substring without
 * repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		char[] S = s.toCharArray();
		
		int[] visited = new int[256];
		for (int i=0; i<256; i++) {
			visited[i] = -1;
		}
		
		int left = 0;
		int right = 0;
		int maxLen = -1;
		while (right < S.length) {
			if (visited[S[right]] != -1) {
				maxLen = right - left > maxLen ? right - left : maxLen;
				int prev_dup = visited[S[right]];
				
				// attention: only reset previous elements in the CURRENT window
				for (int j=left; j<=prev_dup; j++) {
					visited[S[j]] = -1;
				}
				left = prev_dup + 1;
				
			}
			visited[S[right]] = right;
			right++;
		}
		
		maxLen =  right - left > maxLen ? right - left : maxLen;
		return maxLen;
	}
}
