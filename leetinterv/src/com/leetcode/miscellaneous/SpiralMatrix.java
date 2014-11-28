package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:

	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	You should return [1,2,3,6,9,8,7,4,5].
 */

public class SpiralMatrix {
	private final int RIGHT = 0;
	private final int DOWN = 1;
	private final int LEFT = 2;
	private final int UP = 3;
	
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> result = sm.spiralOrder(matrix);
		System.out.println(result);
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int num_row = matrix.length;
		if (num_row == 0) {
			return result;
		}
		int num_col = matrix[0].length;
		
		boolean[][] visited = new boolean[num_row][num_col];
		for (int i=0; i<num_row; i++) {
			for (int j=0; j<num_col; j++) {
				visited[i][j] = false;
			}
		}
				
		int direction = RIGHT;
		int row = 0;
		int col = 0;
		for (int i=0; i<num_row*num_col; i++) {
			visited[row][col] = true;
			result.add(matrix[row][col]);
			if (direction == RIGHT) {
				if (col == num_col-1) { // reached the right most element of this line
					direction = DOWN;
					row++;
				}
				else if (!visited[row][col+1]) { // if the right neighbor has been visited yet
					col++;
				}
				else if (!visited[row+1][col]) {
					direction = DOWN;
					row++;
				}
			}
			else if (direction == DOWN) {
				if (row == num_row-1) {
					direction = LEFT;
					col--;
				}
				else if (!visited[row+1][col]) {
					row++;
				}
				else if (!visited[row][col-1]) {
					direction = LEFT;
					col--;
				}
			}
			else if (direction == LEFT) {
				if (col == 0) {
					direction = UP;
					row--;
				}
				else if (!visited[row][col-1]) {
					col--;
				}
				else if (!visited[row-1][col]) {
					direction = UP;
					row--;
				}
			}
			else if (direction == UP) {
				if (!visited[row-1][col]) {
					row--;
				}
				else if (!visited[row][col+1]) {
					direction = RIGHT;
					col++;
				}
			}
		}
		return result;
    }
}
