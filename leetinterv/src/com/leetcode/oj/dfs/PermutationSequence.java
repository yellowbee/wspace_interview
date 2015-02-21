package com.leetcode.oj.dfs;

import java.util.Arrays;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

This implementation cannot pass leetcode time limited test.
 */

public class PermutationSequence {
	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(9,21778));
	}
	
	public String getPermutation(int n, int k) {
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		StringBuffer sofar = new StringBuffer();
		int[] count = new int[1];
		count[0] = 0;
		helper(visited, sofar, count, n, k);
		return sofar.toString();
    }
	
	public boolean helper(boolean[] visited, StringBuffer sofar, int[] count, int n, int k) {
		if (count[0] == k) {
			return true;
		}
		if (sofar.length() == n) {
			count[0]++;
			if (count[0] == k) {
				return true;
			}
			else {
				return false;
			}
		}

		for (int i=0; i<visited.length; i++) {
			if (!visited[i]) {
				sofar.append(Integer.toString(i+1));
				visited[i] = true;
				if (helper(visited, sofar, count, n, k)) return true;
				visited[i] = false;
				sofar.deleteCharAt(sofar.length()-1);
			}
		}
		return false;
	}
}
