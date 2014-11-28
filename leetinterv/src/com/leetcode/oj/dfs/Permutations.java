package com.leetcode.oj.dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * Solution: DFS
 */

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
        boolean[] used = new boolean[num.length];
        for (int i=0; i<used.length; i++) {
        	used[i] = false;
        }
        List<Integer> so_far = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(1, used, num, so_far, result);
        return result;
    }
	
	private void helper(int level, boolean[] used, int[] num, List<Integer> so_far, List<List<Integer>> result) {
		for (int i=0; i<num.length; i++) {
			if (!used[i]) {
				so_far.add(num[i]);
				used[i] = true;
				
				if (level == num.length) {
					result.add(new ArrayList<Integer>(so_far));
				}
				else {
					helper(level+1, used, num, so_far, result);
				}
				
				//reset
				so_far.remove(so_far.size()-1);
				used[i] = false;
			}
		}
	}
}
