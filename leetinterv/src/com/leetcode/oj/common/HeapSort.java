package com.leetcode.oj.common;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] A = {-1, 20, 3, 5, 8, 10, 11, 15};
		HeapSort.minHeapify(A, 1);
		System.out.println(Arrays.toString(A));
		
		int[] B = {-1, 2, 8, 1, 9, 10, 3, 5, 6};
		HeapSort.buildMinHeap(B);
		System.out.println(Arrays.toString(B));
	}
	
	public static void minHeapify(int[] A, int i) {
		int l = 2*i;
		int r = 2*i + 1;
		int hsize = A.length - 1;
		int smallest = i;
		
		if (l <= hsize && A[l] < A[i]) {
			smallest = l;
		}
		if (r <= hsize && A[r] < A[smallest]) {
			smallest = r;
		}
		if (smallest != i) {
			int temp = A[i];
			A[i] = A[smallest];
			A[smallest] = temp;
			minHeapify(A, smallest);
		}
	}
	
	public static void buildMinHeap(int[] A) {
		int hsize = A.length - 1;
		for (int i=(hsize / 2); i>=1; i--) {
			HeapSort.minHeapify(A, i);
		}
	}
}
