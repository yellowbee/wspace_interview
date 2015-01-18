package com.leetcode.oj.arraynstring;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Category: Unknown
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * For example,Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4].
 * Return its length: 4. Your algorithm should run in O(n) complexity.
 * 
 * Discussion:
 * Since it requires O(n) solution, normal sort won't work here.
 * Hash probably is the best choice.
 * 3 Steps:
 * 1. create the hashmap to hold <num, index>
 * 2. scan the num vector from left to right, for each num
 * 		i, check whether num -1 is in the map  (loop)
 * 		ii, check whether num+1 is in the map  (loop)
 * 3. track the sequence length during scanning.
 * 

 */

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i=0; i<num.length; i++) {
        	m.put(new Integer(num[i]), new Integer(i));
        }
        
        boolean[] visited = new boolean[num.length];
        Arrays.fill(visited, false);
        int maxLen = Integer.MIN_VALUE;
        for (int i=0; i<num.length; i++) {
        	if (visited[i]) {
        		continue;
        	}
        	visited[i] = true;
        	
        	int len = 1;
        	int num1 = num[i] - 1;
        	while (m.containsKey(new Integer(num1))) {
        		visited[m.get(new Integer(num1)).intValue()] = true;
        		len++;
        		num1--;
        	}
        	int num2 = num[i] + 1;
        	while (m.containsKey(new Integer(num2))) {
        		visited[m.get(new Integer(num2)).intValue()] = true;
        		len++;
        		num2++;
        	}
        	maxLen = maxLen > len ? maxLen : len;
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		LongestConsecutiveSequence lc = new LongestConsecutiveSequence();
		int[] num = {-1,0,1};
		System.out.println(lc.longestConsecutive(num));
	}
}
