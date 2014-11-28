package com.expedia.sorting;

import java.util.Arrays;

import com.leetcode.oj.common.HeapSort;

public class KMax {
	public static void main(String[] args) {
		int[] A = {-1, 2, 5, 9, 10, 1, 3, 6, 8, 20};
		int[] B = KMax.findKMax(A, 9);
		System.out.println(Arrays.toString(B));
	}
	
	public static int[] findKMax(int[] A, int k) {
		int[] K = new int[k+1];
		K[0] = -1;
		for (int i=1; i<=k; i++) {
			K[i] = A[i];
		}
		
		HeapSort.buildMinHeap(K);
		for (int i=k+1; i<A.length; i++) {
			if (A[i] > K[1]) {
				K[1] = A[i];
				HeapSort.minHeapify(K, 1);
			}
		}
		
		return K;
	}
}
