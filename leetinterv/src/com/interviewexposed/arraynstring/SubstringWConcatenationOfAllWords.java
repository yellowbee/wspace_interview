package com.interviewexposed.arraynstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> result = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// put all strings in the map
		for (String str : L) {
			map.put(str, 0);
		}
		
		for (int idx=0; idx+2<S.length(); idx++) {
			for (int j=idx; j<S.length(); j+=3) {
				String cur_str = S.substring(j, j+3);
				if (map.containsKey(cur_str)) {
					if (map.get(cur_str).intValue() == 0) {
						map.put(cur_str, 1);
					}
					else {
						// reset the map
						for (String str : L) {
							map.put(str, 0);
						}
						break;
					}
				}
				else {
					// reset the map
					for (String str : L) {
						map.put(str, 0);
					}
					break;
				}
			}
		}
		
		for (String str : map.keySet()) {
			if (map.get(str).intValue() != 1) {

			}
		}
		
		return null;
    }
}
