package com.leetcode.oj.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Category: BFS
 * Special Requirement: Keep track of which level a node is in
 * Solution: In order to keep track of level number, we use two queues:
 *           one is the current level to work on; another is to store
 *           the children of nodes on current level.
 *
 * Discussion: This is a typical search problem. Using BFS can guarantee
 *             that the solution node has a shortest distance to the start
 *             node.
 *             
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that: 
 * Only one letter can be changed at a time Each intermediate word must
 * exist in the dictionary
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if ( start==null || end==null) {
			return 0;
		}

		int slen = start.length();
        int level = 1;
        Queue<String> curr_level = new LinkedList<String>();
        Queue<String> next_level = new LinkedList<String>();
        
        curr_level.add(start);
        while (!curr_level.isEmpty()) {
        	String cur_str = curr_level.remove();
        	/*if (cur_str.equals(end)) { // if the target word is reached, then done
        		return level;
        	}*/
        	
        	for (int i=0; i<slen; i++) {
	        	char[] cur_carray = cur_str.toCharArray();
	        	for (char ch='a'; ch<='z'; ch++) {
	        		cur_carray[i] = ch;
	        		String mutant = String.valueOf(cur_carray);
	        		if (mutant.equals(end)) {
	        			return level+1;
	        		}
	        		if (dict.contains(mutant)) {
	        			next_level.add(mutant);
	        			dict.remove(mutant);
	        		}
	        	}
        	}
        	
        	// if current level is empty, swap the level references
        	if (curr_level.isEmpty()) {
        		level++;
        		Queue<String> temp = curr_level;
        		curr_level = next_level;
        		next_level = temp;
        	}
        }
        
        return 0;
    }
	
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		HashSet<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
		System.out.println(wl.ladderLength("hit", "cog", dict));
	}
}
