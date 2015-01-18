package com.leetcode.oj.arraynstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c,
 * and d in S such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * 
 * Solution: very similar to the solution to 3sum. For 4sum, just one more outer
 * loop is added.
 */

public class FourSum {
	public static void main(String[] args) {
		int[] num = {1, 0, -1, 0, -2, 2};
		System.out.println(FourSum.fourSum(num, 0));
	}
	public static List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		
		for (int i=0; i<num.length; i++) {
			for (int j=i+1; j<num.length; j++) {
				int left = j+1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum == target) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[left]);
						temp.add(num[right]);
						if (!set.contains(temp)) {
							result.add(temp);
							set.add(temp);
						}
						left++;
						right--;
					}
					else if (sum < target) {
						left++;
					}
					else {
						right--;
					}
				}
			}
		}
		
		return result;
	}
}
