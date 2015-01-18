package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of integers that might contain duplicates,
 * S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * Solution: Using bit mask is a clean way to iterate all the subsets.
 */

public class SubsetsII {
	public static void main(String[] args) {
		SubsetsII ss = new SubsetsII();
		int[] num = {1,2,2};
		List<List<Integer>> result = ss.subsetsWithDup(num);
		System.out.println(result);
	}
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length == 0) return result;
		
		for (int mask=1; mask < (1<<num.length); mask++) {
			List<Integer> subset = new ArrayList<Integer>();
			for (int i=0; i<num.length; i++) {
				if ((mask & (1<<i)) != 0) {
					subset.add(num[i]);
				}
			}
			if (!result.contains(subset)) {
				result.add(subset);
			}
		}
		
		//add the empty subset
		result.add(new ArrayList<Integer>());
		return result;
    }
}
