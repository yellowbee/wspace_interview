package com.interviewexposed.arraynstring;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

public class SpiralMatrixII {
	public enum Direction {
		LEFT,
		RIGHT,
		UP,
		DOWN
	}
	
	public static void main(String[] args) {
		int n = 10;
		int[][] result = SpiralMatrixII.generateMatrix(n);
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for (int i=0; i<n; i++) {
        	for (int j=0; j<n; j++) {
        		result[i][j] = -1;
        	}
        }
        
        int row = 0;
        int col = -1;
        Direction dir = Direction.RIGHT;
        
        for (int i=1; i<=n*n; i++) {
        	if (dir == Direction.RIGHT) {
        		if (col < n-1 && result[row][col+1] == -1) {
        			col++;
        		}
        		else {
        			row++;
        			dir = Direction.DOWN;
        		}
        	}
        	else if (dir == Direction.DOWN) {
        		if (row < n-1 && result[row+1][col] == -1) {
        			row++;
        		}
        		else {
        			col--;
        			dir = Direction.LEFT;
        		}
        	}
        	else if (dir == Direction.LEFT) {
        		if (col > 0 && result[row][col-1] == -1) {
        			col--;
        		}
        		else {
        			row--;
        			dir = Direction.UP;
        		}
        	}
        	else if (dir == Direction.UP) {
        		if (row > 0 && result[row-1][col] == -1) {
        			row--;
        		}
        		else {
        			col++;
        			dir = Direction.RIGHT;
        		}
        	}
        	result[row][col] = i;
        }
        
        return result;
    }
}
