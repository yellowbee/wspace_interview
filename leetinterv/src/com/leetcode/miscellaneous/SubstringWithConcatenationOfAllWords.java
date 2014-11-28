package com.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	/*public List<Integer> findSubstring(String S, String[] L) {
		final int WLEN = L[0].length();
		
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<L.length; i++) {
        	map.put(L[i], -1);
        }
        
        int cur_start_w = 0;
        int cur_end_w = 0;
        int cur_len = 0;
        while (cur_end_w <= S.length()-3) {
        	String cur_w = S.substring(cur_end_w, cur_end_w+3);
        	if (map.containsKey(cur_w) && map.get(cur_w).intValue()<cur_start_w) {
        		map.put(cur_w, cur_end_w);
        	}
        }
    }*/
}
