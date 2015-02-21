package com.leetcode.oj.search;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	public static void main(String[] args) {
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(8));
	}
	
	public int totalNQueens(int n) {
        int[] count = new int[1];
        count[0] = 0;
        
        List<Integer> sofar = new ArrayList<Integer>();
        helper(n, sofar, count);
        return count[0];
    }
	
	public void helper(int n, List<Integer> sofar, int[] count) {
		if (sofar.size() == n) {
			count[0]++;
			return;
		}
		int row = sofar.size();
		for (int j=0; j<n; j++) {
			if (isCompatible(row, j, sofar)) {
				sofar.add(j);
				helper(n, sofar, count);
				sofar.remove(sofar.size()-1);
			}
		}
	}
	
	// method to determine if the pair of coordinates
	// is compatible with other queens already on the board
	// (x, y) is the pair of coordinates of the current queen,
	// sofar is the col number of all the queens already on the board
	public boolean isCompatible(int row, int col, List<Integer> sofar) {
		for (int i=0; i<sofar.size(); i++) {
			int j = sofar.get(i).intValue();
			// if either row numbers or the col numbers are the same
			// the current queen is not compatible with the existing ones
			if (i == row || j == col) return false;
			// if current queen stands in any diagonal lines of existing
			// queens
			if (Math.abs(i-row) == Math.abs(j-col)) return false;
		}
		return true;
	}
}
