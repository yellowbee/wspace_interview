package com.amazon.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.common.sorting.QuickSort;

/*
 * List all anagrams in a file. Assumptions: case-insensitive,
 * a-z characters only, one word per line. For example, if the
 * file contains dog, cat, ddd, goo, act, god --
 * output dog, god, act, cat
 * 
 * Solution: sort everything and put them in a hash table.
 */

public class FindAllAnagrams {
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("act");
		dict.add("cat");
		dict.add("ram");
		dict.add("mar");
		dict.add("good");
		dict.add("hello");
		
		Map<String, List<String>> result = getAnagrams(dict);
		for (String key : result.keySet()) {
			System.out.println(key + ": " + result.get(key));
		}
	}
	
	public static Map<String, List<String>> getAnagrams(Set<String> dict) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		
		for (String s : dict) {
			String sorted = QuickSort.quickSort(s);
			if (result.containsKey(sorted)) {
				result.get(sorted).add(s);
			}
			else {
				LinkedList<String> list = new LinkedList<String>();
				list.add(s);
				result.put(sorted, list);
			}
		}
		
		return result;
	}
}
