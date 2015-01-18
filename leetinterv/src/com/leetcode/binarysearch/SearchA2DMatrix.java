package com.leetcode.binarysearch;

/*
 * Write an efficient algorithm that searches for a value in an
 * m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:

	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
 * Given target = 3, return true.
 * 
 * Solution: take the first col and locate the row that might contain
 * the target using binary search; again use binary search to decide
 * if the target is contained in that row.
 */

public class SearchA2DMatrix {
	public static void main(String[] args) {
		SearchA2DMatrix sm = new SearchA2DMatrix();
		/*int[] col = {1, 10, 23};
		int target = 24;
		System.out.println(sm.binarySearch(col, target, 0, col.length-1));*/
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int target = 17;
		System.out.println(sm.searchMatrix(matrix, target));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int[] first_col = getColumn(matrix);
        int row_idx = binarySearch(first_col, target, 0, first_col.length-1);
        
        if (row_idx < 0) {
        	return false;
        }
        
        if (matrix[row_idx][0] == target) {
        	return true;
        }
        else {
        	int col_idx = binarySearch(matrix[row_idx], target, 0, matrix[row_idx].length-1);
        	if (matrix[row_idx][col_idx] == target) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
    }
	
	private int[] getColumn(int[][] matrix) {
		int[] col = new int[matrix.length];
		for (int i=0; i<col.length; i++) {
			col[i] = matrix[i][0];
		}
		return col;
	}
	
	private int binarySearch(int[] col, int target, int begin, int end) {
		if (begin == end) {
			if (target < col[begin]) {
				return begin - 1;
			}
			else if (target == col[begin]) {
				return begin;
			}
			else {
				return begin;
			}
		}
		else if (begin > end) {
			return begin - 1;
		}
		else {
			int mid = (begin+end)/2;
			if (target == col[mid]) {
				return mid;
			}
			else if (target < col[mid]) {
				return binarySearch(col, target, begin, mid-1);
			}
			else {
				return binarySearch(col, target, mid+1, end);
			}
		}
	}
}
