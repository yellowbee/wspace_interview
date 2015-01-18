package com.amazon.dp;

import java.util.Arrays;

/*
 * given a large array of int return the
 * length of the longest increasing(non-necessarily-adjacent) sub-sequence
 * 
 * Solution: DP
 * L[i] = 1 + max(L[j]), where j<i, A[j]<A[i]
 *        1, otherwise
 *        
 * Time complexity: O(n^2)
 */

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] A = {16, 3, 5, 19, 10, 14, 12, 0, 15};
		System.out.println(LIS(A));
	}
	
	public static int LIS(int[] A) {
		int[] L = new int[A.length]; // L[i] is the length of LIS ending with A[i]
		int[] P = new int[A.length]; // P[i] is the idx of the prev element in LIS ending with A[i]
		L[0] = 1;
		for (int i=1; i<A.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j=0; j<i; j++) {
				if (A[i] > A[j] && (L[j]+1) > max) {
					max = L[j] + 1;
					P[i] = j;
				}
			}
			if (max > 1) {
				L[i] = max;
			}
			else {
				L[i] = 1;
				P[i] = -1;
			}
		}
		
		int result = Integer.MIN_VALUE;
		int result_idx = -1;
		for (int i=0; i<A.length; i++) {
			if (L[i] > result) {
				result = L[i];
				result_idx = i;
			}
		}
		
		int cur_idx = result_idx;
		while (cur_idx != -1) {
			System.out.print(A[cur_idx] + ", ");
			if (cur_idx == 0) break;
			cur_idx = P[cur_idx];
		}
		System.out.println();
		System.out.println(Arrays.toString(P));
		System.out.println(Arrays.toString(L));
		return result;
	}
}
