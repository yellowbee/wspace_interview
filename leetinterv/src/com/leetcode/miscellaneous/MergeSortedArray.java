package com.leetcode.miscellaneous;

import java.util.Arrays;

/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n)
 * to hold additional elements from B. The number of elements initialized in
 * A and B are m and n respectively.
 */

public class MergeSortedArray {
	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] A = {2, 7, 9, 12, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] B = {3, 6, 8, 10, 15};
		int m = 5;
		int n = B.length;
		msa.merge(A, m, B, n);
		System.out.println(Arrays.toString(A));
	}
	
	public void merge(int A[], int m, int B[], int n) {
        if (n == 0) {
        	return;
        }
        if (m == 0) {
        	for (int i=0; i<n; i++) {
        		A[i] = B[i];
        	}
        	return;
        }
        
        int insert_pos = m + n - 1;
        int a_ptr = m - 1;
        int b_ptr = n - 1;
        
        while (b_ptr >= 0 && a_ptr >= 0) {
        	if (A[a_ptr] >= B[b_ptr]) {
        		A[insert_pos] = A[a_ptr];
        		a_ptr--;
        	}
        	else {
        		A[insert_pos] = B[b_ptr];
        		b_ptr--;
        	}
        	insert_pos--;
        }
        
        // if B is not finished being inserted in A
        if (b_ptr >= 0){
        	while (b_ptr >= 0) {
        		A[insert_pos] = B[b_ptr];
        		insert_pos--;
        		b_ptr--;
        	}
        }
    }
}
