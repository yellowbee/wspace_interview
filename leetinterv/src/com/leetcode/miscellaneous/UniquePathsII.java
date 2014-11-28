package com.leetcode.miscellaneous;

/*
 * [[0,1,0,0,0],[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
 * 
 * Solution: iteration
 * Note: when initializing the first row and the first column,
 * if both the previous and current cell is empty, then there's
 * path; when computing the complete array, if the current cell
 * is empty, then add the possible number of paths from both the
 * top and left, where 0 means there's no path leading to here.
 */

public class UniquePathsII {
	public static void main(String[] args) {
		UniquePathsII up = new UniquePathsII();
		int[][] grid = {{0,1,0,0,0},
						{1,0,0,0,0},
						{0,0,0,0,0},
						{0,0,0,0,0}};

		System.out.println(up.uniquePathsWithObstacles(grid));
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int num_row = obstacleGrid.length;
		int num_col = obstacleGrid[0].length;
		
        int[][] C = new int[num_row][num_col];
        
        // initialization
        if (obstacleGrid[0][0] != 1) {
        	C[0][0] = 1;
        }
        else {
        	C[0][0] = 0;
        }
        
        for (int j=1; j<num_col; j++) {
        	if (obstacleGrid[0][j]!=1 && C[0][j-1]!=0) {
        		C[0][j] = 1;
        	}
        	else {
        		C[0][j] = 0;
        	}
        }
        for (int i=1; i<num_row; i++) {
        	if (obstacleGrid[i][0]!=1 && C[i-1][0]!=0) {
        		C[i][0] = 1;
        	}
        	else {
        		C[i][0] = 0;
        	}
        }
        
        for (int i=1; i<num_row; i++) {
        	for (int j=1; j<num_col; j++) {
        		if (obstacleGrid[i][j]!=1) {
        			C[i][j] = C[i-1][j] + C[i][j-1];
        		}
        		else {
        			C[i][j] = 0;
        		}
        	}
        }
        return C[num_row-1][num_col-1];
    }
}
