package com.leetcode.oj.dp;

/*
 * Given a m x n grid filled with non-negative numbers, find
 * a path from top left to bottom right which minimizes the sum of all
 * numbers along its path. Note: You can only move either down or right
 * at any point in time.
 * 
 * Solution: DP
 * Let M[i,j] be the sum of the min path from [0,0] to [i,j].
 * M[i,j] = min {
 * 					M[i-1,j] + G[i,j],
 * 					M[i,j-1] + G[i,j]
 * 				}
 * M[0,j] = M[0,j-1] + G[0,j]
 * M[i,0] = M[i-1,0] + G[i,0]
 */

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int num_row = grid.length;
		if (num_row == 0) {
			return 0;
		}
		
		int num_col = grid[0].length;
        int[][] M = new int[num_row][num_col];
        
        // initialization
        M[0][0] = grid[0][0];
        for (int i=1; i<num_row; i++) {
        	M[i][0] = M[i-1][0] + grid[i][0];
        }
        for (int j=1; j<num_col; j++) {
        	M[0][j] = M[0][j-1] + grid[0][j];
        }
        
        // reference the optimal structural equations at the top
        for (int i=1; i<num_row; i++) {
        	for (int j=1; j<num_col; j++) {
        		int top = M[i-1][j] + grid[i][j];
        		int left = M[i][j-1] + grid[i][j];
        		M[i][j] = top < left ? top : left;
        	}
        }
        return M[num_row-1][num_col-1];
    }
}
