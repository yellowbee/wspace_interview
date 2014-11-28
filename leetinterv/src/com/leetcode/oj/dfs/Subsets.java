package com.leetcode.oj.dfs;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * Solution: DFS
 */

public class Subsets {
	public static void main(String[] args) {
		Subsets ss = new Subsets();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		int[] S = {1,2,3};
		result = ss.subsets(S);
		System.out.println(result);
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S.length == 0) {
			return result;
		}
		
		ArrayList<Integer> sofar = new ArrayList<Integer>();
		Arrays.sort(S);
        helper(0, S.length-1, S, sofar, result);
		
		return result;
    }
	
	private void helper(int i, int maxidx, int[] S, ArrayList<Integer> sofar, ArrayList<ArrayList<Integer>> result) {
		if (i > maxidx) {
			result.add(new ArrayList<Integer>(sofar));
		}
		else { // either include the current element or do not include it
			// do not include S[i]
			helper(i+1, maxidx, S, sofar, result);
			
			// include S[i]
			sofar.add(S[i]);
			helper(i+1, maxidx, S, sofar, result);
			sofar.remove(sofar.size()-1);
		}
	}
}
