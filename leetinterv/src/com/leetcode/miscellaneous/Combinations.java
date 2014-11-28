package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two integers n and k, return all possible combinations of k
 * numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:

	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 * Solution: recursion
 */

public class Combinations {
	public static void main(String[] args) {
		Combinations combo = new Combinations();
		List<List<Integer>> result = combo.combine(4, 2);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list_temp = new ArrayList<Integer>();
        combineHelper(n, k, 1, list_temp, result);
        return result;
    }
	
	private void combineHelper(int n, int k, int depth, List<Integer> list_temp, List<List<Integer>> result) {
		if (depth > k) {
			result.add(new ArrayList<Integer>(list_temp));
		}
		else {
			int last = (list_temp.size()==0) ? 0 : list_temp.get(list_temp.size()-1);
			for (int i=last+1; i<=(n-k+depth); i++) {
				list_temp.add(i);
				combineHelper(n, k, depth+1, list_temp, result);
				list_temp.remove(list_temp.size()-1);
			}
		}
	}
}
