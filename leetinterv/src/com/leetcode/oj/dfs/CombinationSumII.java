package com.leetcode.oj.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static void main(String[] args) {
		CombinationSumII cs2 = new CombinationSumII();
		//int[] num = {1,1,2,5,6,7,10};
		//int[] num = {10,1,2,7,6,1,5};
		int[] num = {2};
		
		List<List<Integer>> result = cs2.combinationSum2(num, 1);
		System.out.println(result);
	}
	
	private void quickSort(int[] num, int l, int r) {
		if (l >= r) return;
		
		int p_idx = partition(num, l, r);
		quickSort(num, l, p_idx-1);
		quickSort(num, p_idx+1, r);
		
	}
	
	private int partition(int[] num, int l, int r) {
		// Taking the pivot from the rightmost element will guarantee
		// the sorting is stable.
		int pivot = num[r];
		int i = l-1;
		for (int j=l; j<r; j++) {
			if (num[j] <= pivot) {
				i++;
				int temp = num[j];
				num[j] = num[i];
				num[i] = temp;
			}
		}
		i++;
		num[r] = num[i];
		num[i] = pivot;
		return i;
	}
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> sofar = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		for (int i=0; i<used.length; i++) {
			used[i] = false;
		}
		quickSort(num, 0, num.length-1);
		helper(result, sofar, num, used, 0, target);
		return result;
    }
	
	private void helper(List<List<Integer>> result, List<Integer> sofar, int[] num, boolean[] used, int sum_sofar, int target) {
		
		for (int i=0; i<num.length; i++) {
			if (!sofar.isEmpty() && num[i] < sofar.get(sofar.size()-1)) {
				continue;
			}
			
			if (used[i] || (i>0 && num[i-1] == num[i] && !used[i-1])) {
				continue;
			}
			
			if (num[i] + sum_sofar == target) {// there's a hit
				sofar.add(num[i]);
				used[i] = true;
				result.add(new ArrayList<Integer>(sofar));
				sofar.remove(sofar.size()-1);
				used[i] = false;
				break;
			}
			
			else if (num[i] + sum_sofar < target) {
				sofar.add(num[i]);
				used[i] = true;
				helper(result, sofar, num, used, sum_sofar+num[i], target);
				sofar.remove(sofar.size()-1);
				used[i] = false;
			}
		}
	}
}
