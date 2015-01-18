package com.leetcode.oj.arraynstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, find two numbers such that they add up
 * to a specific target number.
 * The function twoSum should return indices of the two numbers such
 * that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2)
 * are not zero-based. You may assume that each input would have exactly
 * one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * Solution: Use a hash table to store complements in the first round of scan;
 *           in the second round of scan, check if there's an integer is already
 *           in the hash table;
 *           
 */

public class TwoSum {
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] numbers = {2, 7, 11, 15};
		System.out.println(Arrays.toString(ts.twoSum(numbers, 9)));
	}
	
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<numbers.length; i++) {
			int compl = target - numbers[i];
			if (!map.containsKey(compl)) {
				map.put(compl, i);
			}
		}
		
		for (int i=0; i<numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				if (map.get(numbers[i]) == i) {
					continue;
				}
				
				int[] result = new int[2];
				result[0] = map.get(numbers[i]);
				result[1] = i;
				if (result[0] > result[1]) {
					int temp = result[0];
					result[0] = result[1];
					result[1] = temp;
				}
				result[0]++;
				result[1]++;
				return result;
			}
		}
		
		return null;
    }
}
