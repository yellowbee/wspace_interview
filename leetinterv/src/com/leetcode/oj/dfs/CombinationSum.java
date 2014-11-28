package com.leetcode.oj.dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3]
 * 
 *  Solution: typical recursion/DFS problem. Check each candidate in order and
 *  check if so far there's a hit. If there's a hit, save it in the result.
 */

public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> result = cs.combinationSum(candidates, target);
		System.out.println(result);
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sofar = new ArrayList<Integer>();
        helper(result, sofar, candidates, target, 0);
        return result;
    }
	
	private void helper(List<List<Integer>> result, List<Integer> sofar, int[] candidates, int target, int sum_sofar) {
		for (int i=0; i<candidates.length; i++) {
			if (!sofar.isEmpty() && candidates[i] < sofar.get(sofar.size()-1)) {
				continue;
			}
			
			if (sum_sofar + candidates[i] == target) {
				sofar.add(candidates[i]);
				result.add(new ArrayList<Integer>(sofar));
				sofar.remove(sofar.size()-1);
			}
			else if (sum_sofar + candidates[i] < target) {
				sum_sofar += candidates[i];
				sofar.add(candidates[i]);
				helper(result, sofar, candidates, target, sum_sofar);
				sum_sofar -= candidates[i];
				sofar.remove(sofar.size()-1);
			}
		}
	}
}
