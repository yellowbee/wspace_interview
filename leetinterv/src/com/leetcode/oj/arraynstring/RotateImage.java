package com.leetcode.oj.arraynstring;

import java.util.Arrays;

/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 */

public class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = {{1,0,0,0},
						  {0,2,3,0},
						  {0,4,5,0},
						  {0,0,0,0}};
		
		for (int i=0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println();
		
		RotateImage ri = new RotateImage();
		ri.rotate(matrix);
		for (int i=0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println();
	}
	
	public void rotate(int[][] matrix) {
		int LEN = matrix.length;
		int swap = 0;
		
		// reverse the matrix along the left-bottom to top-right diagonal
        for (int i=0; i<=LEN-2; i++) {
        	for (int j=0; j<=LEN-2-i; j++) {
        		swap = matrix[i][j];
        		matrix[i][j] = matrix[LEN-1-j][LEN-1-i];
        		matrix[LEN-1-j][LEN-1-i] = swap;
        	}
        }
        
        // reverse the matrix along the horizontal mid line
        for (int i=0; i<=(LEN-1)/2; i++) {
        	for (int j=0; j<LEN; j++) {
        		swap = matrix[i][j];
        		matrix[i][j] = matrix[LEN-1-i][j];
        		matrix[LEN-1-i][j] = swap;
        	}
        }
    }
}
