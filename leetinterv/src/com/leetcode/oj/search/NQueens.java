package com.leetcode.oj.search;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n
 * chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [.Q.., ...Q, Q..., ..Q.]
 * [..Q., Q..., ...Q, .Q..]
 * 
 * Solutions: recursive and non-recursive
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		NQueens nqs = new NQueens();
		List<String[]> result = nqs.solveNQueens(8);
		for (String[] str_arr: result) {
			System.out.println(Arrays.toString(str_arr));
		}
	}
	
	public List<String[]> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sofar = new ArrayList<Integer>();
        helper(n, 0, result, sofar);
        return list2string(n, result);
    }
	
	public void helper(int n, int row, List<List<Integer>> result, List<Integer> sofar) {
		for (int i=0; i<n; i++) { // scan all the columns of the current row
			if (isCompatible(row, i, sofar)) {
				sofar.add(i);
				if (row == n-1) {
					result.add(new ArrayList<Integer>(sofar));
				}
				else {
					helper(n, row+1, result, sofar);
				}
				sofar.remove(sofar.size()-1);
			}
		}
	}
	
	private boolean isCompatible(int row, int col, List<Integer> sofar) {
		for (int i=0; i<sofar.size(); i++) {
			int val = sofar.get(i).intValue();
			if (val == col || i == row) {
				return false;
			}
			
			if (Math.abs(row - i) == Math.abs(col - val)) {
				return false;
			}
		}
		return true;
	}
	
	private List<String[]> list2string(int n, List<List<Integer>> list_of_lists) {
		List<String[]> list_of_strings = new ArrayList<String[]>();
		for (int j=0; j<list_of_lists.size(); j++) {
			String[] solution = new String[n];
			StringBuffer sb = new StringBuffer();
			
			for (int i=0; i<list_of_lists.get(j).size(); i++) {
				sb.delete(0, sb.length());
				int pos = list_of_lists.get(j).get(i).intValue();
				for (int k=0; k<pos; k++) {
					sb.append(".");
				}
				sb.append("Q");
				for (int k=pos+1; k<n; k++) {
					sb.append(".");
				}
				solution[i] = sb.toString();
			}
			
			list_of_strings.add(solution);
		}
		return list_of_strings;
	}
}
