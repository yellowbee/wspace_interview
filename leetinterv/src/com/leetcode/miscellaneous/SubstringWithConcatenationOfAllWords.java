package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * test cases: S: "barfoothefoobarman", L: ["foo", "bar"]
 * 			   S: "a", L: ["a"]
 */

public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		String[] L = {"a", "a"};
		System.out.println(SubstringWithConcatenationOfAllWords.findSubstring("aaa", L));
	}
	
	public static List<Integer> findSubstring(String S, String[] L) {
		List<Integer> result = new ArrayList<Integer>();
		int wlen = L[0].length();
        int awlen = wlen * L.length;
        if (S.length() < awlen) return result;
		
        Set<String> dict = new HashSet<String>();
        for (String str : L) {
        	dict.add(str);
        }     
        
        int start = 0;
        while (start <= S.length()-wlen) {
        	int cur = start;
        	Set<String> visited = new HashSet<String>();
        	
        	while (cur-start < awlen) {
        		String cur_word = S.substring(cur, cur+wlen);
	        	if (dict.contains(cur_word)) { // if cur word is in the dict, do
	        		if (visited.contains(cur_word)) {// already visited, end current loop
	        			start++;
	        			break;
	        		}
	        		else {// not visited yet
	        			visited.add(cur_word);
	        			cur += wlen;
	        			if (cur - start == awlen) {
	        				result.add(start);
	        			}
	        		}
	        	}
	        	else {// if cur word is NOT in the dict, end current loop
	        		start++;
	        		break;
	        	}
        	}
        	
        	if (cur - start == awlen) {
        		start += awlen;
        	}
        }
        
        return result;
    }
}
