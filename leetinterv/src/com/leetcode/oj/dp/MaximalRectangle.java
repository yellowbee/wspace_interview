package com.leetcode.oj.dp;

import java.util.Arrays;

/*
 * Analysis:
This is not an easy problem and the idea is not straightforward.
Since the question requires the area of all ones region, first we
can define the region (rectangle) in the matrix. Any region in the
matrix has several basic properties:   1 corner point,  width, and
length.
Also which corner point it is decide the exact place of the region,
here we consider the bottom-right corner point, because we usually
scan the matrix from (0,0) to right and down direction. For this problem,
we also need to consider the "all ones" requirement, where all the regions
are filled with 1s.

We can then have this data structure:
One 2D array(vector) ones[i][j],  where ones[i][j] stores the number of
contiguous 1s ended at matrix[i][j], along ith row. e.g.  if matrix[i] = "1011101",
then ones[i]=1,0,1,2,3,0,1. This array stores the length of the rectangle, for every
possible bottom-right corner point. The computation of ones[] can be done using DYNAMIC PROGRAMMING.

Having this two values, next is to find the height of the rectangle, as well as keep
the "all ones" requirement.
Start with a corner point [i][j],  since it is the bottom right corner, the rectangle
search direction is left and up.
For the left we already have the number of contiguous 1s ones[i][j]. How to get the
height?  We need to scan all the values above ones[i][j], it is from i-1 to 0. If meets 0,
then stop, else compute the possible rectangle area, and store the max. To compute the area,
the minimum length of rectangle should be compared and stores every time.
 */

public class MaximalRectangle {
	public static void main(String[] args) {
		char[][] matrix = {{'0','0','0','0'},
						   {'1','1','1','0'}};
						   //{'1','1','1','0'},
						   //{'1','1','1','0'}};
		System.out.println(MaximalRectangle.maximalRectangle(matrix));

	}

	public static int maximalRectangle(char[][] matrix) {
        int ROWS = matrix.length;
        if (ROWS == 0) return 0;
        
        int COLS = matrix[0].length;
        
        int[][] ones = new int[ROWS][COLS];
        int max = 0;
        
		for (int i=0; i<ROWS; i++) {
			for (int j=0; j<COLS; j++) {
				if (matrix[i][j] == '1') {
					if (j==0) {
						ones[i][j] = 1;
					}
					else {
						// Here DYNAMIC PROGRAMMING is used
						ones[i][j] = ones[i][j-1] + 1;
					}
					max = max > ones[i][j] ? max : ones[i][j];
				}
			}
		}
		
		for (int i=1; i<ROWS; i++) {
			for (int j=0; j<COLS; j++) {
				if (ones[i][j] > 0) {
					int r = i - 1;
					int min_len = ones[i][j];
					while (r >= 0) {
						if (ones[r][j] > 0) {
							min_len = min_len <= ones[r][j] ? min_len : ones[r][j];
							int cur_area = min_len * (i - r + 1);
							max = max >= cur_area ? max : cur_area;
							r--;
						}
						else {
							break;
						}
					}
				}
			}
		}
		
		return max;
    }
}
