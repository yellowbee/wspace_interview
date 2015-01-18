package com.leetcode.oj.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 * Given two words (start and end), and a dictionary,
 * find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 */

public class WordLadderII {
	public static void main(String[] args) {
		String[] dict_array = {"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<String>(Arrays.asList(dict_array));
		List<List<String>> result = WordLadderII.findLadders("hit", "cog", dict);
		for (List<String> ls : result) {
			System.out.println(ls);
		}
	}
	
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Queue<String> cur_level = new LinkedList<String>();
        Queue<String> next_level = new LinkedList<String>();
        // map is for storing the path
        Map<String, List<String>> path = new HashMap<String, List<String>>();
        // set is for storing ancestors of all levels higher than the current level
        Set<String> ancestors = new HashSet<String>();
        boolean found = false;

        cur_level.add(start);
        while (!cur_level.isEmpty()) {
        	String cur_word = cur_level.remove();
        	ancestors.add(cur_word);
        	List<String> preds = path.get(cur_word);
        	
        	// go through all letters of the cur word
        	for (int i=0; i<cur_word.length(); i++) {
        		for (char ch='a'; ch<='z'; ch++) {
        			String new_word = cur_word.substring(0, i) + Character.toString(ch) + cur_word.substring(i+1, cur_word.length());
        			
        			if (new_word.equals(end)) { // found
        				found = true;
        			}
        			else { // if not legal, move on
	        			if (!dict.contains(new_word)) continue; // has to be in the dict
	        			if (new_word.equals(cur_word)) continue; // cannot be the same word as the current word
	        			if (cur_level.contains(new_word) || ancestors.contains(new_word)) continue; // cannot be any word among words from current level or previous levels
        			}
        			
        			// adds cur_word to new_word's prev set
        			if (path.containsKey(new_word)) {
        				path.get(new_word).add(cur_word);
        			}
        			else {
        				path.put(new_word, new ArrayList<String>());
        				path.get(new_word).add(cur_word);
        			}
        			      			
        			if (!found) {
	        			// add new_word to the next level
	        			next_level.add(new_word);
        			}
        		}
        	}
        	
        	if (cur_level.isEmpty()) {
        		if (!found) {
        			Queue<String> swap = cur_level;
        			cur_level = next_level;
        			next_level = swap;
        		}
        	}
        }
        /*for (String key : path.keySet()) {
        	System.out.println(key + ":" + path.get(key));
        }
        if (path.containsKey(end)) {
        	System.out.println("found");
        }
        else {
        	System.out.println("not found");
        }*/
        return generatePath("cog", path);
    }
	
	/*private static void getPath(String start, Map<String, List<String>> path, List<List<String>> result, List<String> sofar) {
		if (path.containsKey(start)) {
			List<String> successors = path.get(start);
			for (String str : successors) {
				sofar.add(str);
				getPath(str, path, result, sofar);
				sofar.remove(sofar.size()-1);
			}
		}
		else {
			ArrayList<String> a_path = new ArrayList<String>(sofar);
			Collections.reverse(a_path);
			result.add(a_path);
		}
	}*/
	
	private static List<List<String>> generatePath(String start, Map<String, List<String>> path) {
		List<List<String>> result = new ArrayList<List<String>>();
		Stack<String> stack = new Stack<String>();
		List<String> sofar = new ArrayList<String>();
		
		stack.push(start);
		while (!stack.isEmpty()) {
			String cur = stack.pop();
			sofar.add(cur);
			if (path.containsKey(cur)) {
				for (String str : path.get(cur)) {
					stack.push(str);
				}
			}
			else {
				Collections.reverse(sofar);
				result.add(sofar);
				sofar = new ArrayList<String>();
				sofar.add(start);
			}
		}
		return result;
	}
}
