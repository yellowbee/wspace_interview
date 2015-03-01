package com.leetcode.oj.dp;

import java.util.Arrays;

/*
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * Solution: DP
 * Let P[i, j] to be the product of subarray with index i to j
 */

public class MaximumProductSubarray {
	public static void main(String[] args) {
		int[] A = {2,3,-2,4};
		System.out.println(MaximumProductSubarray.maxProduct(A));
		
	}
	
	public static int maxProduct(int[] A) {
		int LEN = A.length;
		int[][] P = new int[LEN][LEN];
		
		// init the diagonal
		for (int i=0; i<LEN; i++) {
			P[i][i] = A[i];
		}
	    	
		int maxProd = Integer.MIN_VALUE;
		for (int i=0; i<LEN; i++) {
			for (int j=i+1; j<LEN; j++) {
				P[i][j] = P[i][j-1] * A[j];
				maxProd = maxProd > P[i][j] ? maxProd : P[i][j];
			}
		}
		
		return maxProd;
	}
}
