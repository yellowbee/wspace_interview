package com.leetcode.oj.dp;

import java.util.Set;

/* Category: DP
 * 
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * Discussion:
 * Let possible[i] = true, if s[0, i] is a word in the dictionary, or
 *                 = true, if possible[k]=true and s[k+1, i] is a word, 0 <= k <= i
 *                 = false, otherwise
 * 
 */

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {

		int len = s.length();
        boolean[] possible = new boolean[len];
        for (int j=0; j<len; j++) {
        	possible[j] = false;
        }
        
        for (int i=0; i<len; i++) {
        	if (dict.contains(s.substring(0, i+1))) {
        		possible[i] = true;
        	}
        	else {
        		for (int k=0; k<i; k++) {
        			if (possible[k] && dict.contains(s.substring(k+1, i+1))) {
        				possible[i] = true;
        				break;
        			}
        		}
        	}
        }
        
        return possible[len-1];
    }
}
