package com.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * Solution: 题目描述的不是很清楚，其实就是第i+1个字符串是第i个字符串的读法，第一字符串为 “1”
 * 比如第四个字符串是1211，它的读法是 1个1、1个2,2个1，因此第五个字符串是111221。
 * 第五个字符串的读法是：3个1、2个2、1个1，因此第六个字符串是312211
 */

public class CountAndSay {
	public static void main(String[] args) {
		CountAndSay cns = new CountAndSay();
		System.out.println(cns.countAndSay(10));
		
	}
	
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        String prev = "1";
        for (int i=2; i<=n; i++) {
        	map.clear();
        	char[] prev_arr = prev.toCharArray();
        	StringBuffer cur = new StringBuffer();
        	map.put(prev_arr[0], 1);
        	for (int j=1; j<prev_arr.length; j++) {
        		if (map.containsKey(prev_arr[j])) {
        			map.put(prev_arr[j], map.get(prev_arr[j]).intValue()+1);
        		}
        		else {
        			cur.append(map.get(prev_arr[j-1]));
        			cur.append(prev_arr[j-1]);
        			map.clear();
        			map.put(prev_arr[j], 1);
        		}
        	}
        	cur.append(map.get(prev_arr[prev_arr.length-1]));
			cur.append(prev_arr[prev_arr.length-1]);
			prev = cur.toString();
        }
        return prev;
    }
}
