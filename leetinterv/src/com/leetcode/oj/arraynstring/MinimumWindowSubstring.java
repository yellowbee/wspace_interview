package com.leetcode.oj.arraynstring;

/*
 * Given a string S and a string T, find the minimum window in S which
 * will contain all the characters in T in complexity O(n).
	
	For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC".
	
	Note:
	If there is no such window in S that covers all characters in T, return the emtpy string "".
	
	If there are multiple such windows, you are guaranteed that there will always be only
	one unique minimum window in S.
 *
 * This solution is judged as 'time limit exceeded' in leetcode.
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
	}
	
	public String minWindow(String S, String T) {
		Map<Character, Integer> map_to_find = new HashMap<Character, Integer>();
		Map<Character, Integer> map_found = new HashMap<Character, Integer>();
		
		int left = 0;
		int LEN = T.length();
		// count all characters from T in T map
		// get a place holder for all types of character in S map
		for (int i=0; i<T.length(); i++) {
			char cur_char = T.charAt(i);
			if (!map_to_find.containsKey(cur_char)) {
				map_to_find.put(cur_char, 1);
			}
			else {
				map_to_find.put(cur_char, map_to_find.get(cur_char)+1);
			}
			
			if (!map_found.containsKey(cur_char)) {
				map_found.put(cur_char, 0);
			}
		}
		
		int left_min = 0;
		int len_min = Integer.MAX_VALUE;

		for (int i=0; i<S.length(); i++) {
			char cur_char = S.charAt(i);
			if (map_to_find.containsKey(cur_char)) {
				map_found.put(cur_char, map_found.get(cur_char)+1);
				
				if (map_found.get(cur_char) >= map_to_find.get(cur_char)) { // if enough # of current char found
					while (!map_found.containsKey(S.charAt(left)) || ( map_found.get(S.charAt(left))>map_to_find.get(S.charAt(left))) ) {
						if (map_found.containsKey(S.charAt(left))) {
							map_found.put(S.charAt(left), map_found.get(S.charAt(left))-1);
						}
						left++;
					}

					if (i-left+1 >= LEN) { //
						if (sHasT(map_found, map_to_find) && (i-left+1 < len_min)) {
							left_min = left;
							len_min = i - left + 1;
						}
					}
				}
			}
		}
		
		
		if (len_min < Integer.MAX_VALUE) {
			return S.substring(left_min, left_min + len_min);
		}
		else {
			return "";
		}
    }
	
	private boolean sHasT(Map<Character, Integer> map_found, Map<Character, Integer> map_to_find) {
		for (Character ch : map_to_find.keySet()) {
			if (map_found.get(ch) < map_to_find.get(ch)) {
				return false;
			}
		}
		return true;
	}
}
