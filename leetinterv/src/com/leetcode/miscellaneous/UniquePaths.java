package com.leetcode.miscellaneous;

/*
 * A robot is located at the top-left corner of a m x n grid
 * (marked 'Start' in the diagram below). The robot can only
 * move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid
 * (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * 
 * Solution: iteration
 */

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if (m == 0 || n==0) {
			return 0;
		}
		
		int[][] C = new int[m][n];
		
		// initialization
		C[0][0] = 1;
		for (int j=1; j<n; j++) {
			C[0][j] = 1;
		}
		for (int i=1; i<m; i++) {
			C[i][0] = 1;
		}
		
		for (int i=1; i<m; i++) {
			for (int j=1; j<n; j++) {
				C[i][j] = C[i-1][j] + C[i][j-1];
			}
		}
		
		return C[m-1][n-1];
	}
}
