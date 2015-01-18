package com.interviewexposed.arraynstring;

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
	
	// implementation 1, time limit exceeded
	/*public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
        	if (!map.containsKey(s.charAt(right))) {
        		// the value stores the idx of that character in the string
        		map.put(s.charAt(right), right);
        		right++;
        	}
        	else {
        		if (right - left > maxLen) maxLen = right - left;
        		left = map.get(s.charAt(right)) + 1;
        		right = left;;
        		map = new HashMap<Character, Integer>();
        	}
        }
        
        maxLen = right - left > maxLen ? right - left : maxLen; 
        return maxLen;
    }*/
	
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		char[] S = s.toCharArray();
		
		int[] visited = new int[256];
		for (int i=0; i<256; i++) {
			visited[i] = -1;
		}
		
		int left = 0;
		int right = 0;
		int maxLen = 0;
		while (right < S.length) {
			if (visited[S[right]] == -1) {// not visited yet
				visited[S[right]] = right;
				right++;
			}
			else {
				maxLen = right - left > maxLen ? right - left : maxLen;
				left = visited[S[right]] + 1;
				right = left;
				for (int j=0; j<left; j++) {
					visited[S[j]] = -1;
				}
			}
		}
		
		maxLen = left - right > maxLen ? left - right : maxLen;
		return maxLen;
	}
}
