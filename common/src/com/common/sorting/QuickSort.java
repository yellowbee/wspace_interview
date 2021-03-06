package com.common.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(quickSort(s));
	}
	
	// implementation of QuickSort
	private static int partition(char[] A, int l, int r) {
		char temp;
		char p = A[r];
		int i = l - 1;
		for (int j=l; j<r; j++) {
			if (A[j] <= p) {
				temp = A[j];
				i++;
				A[j] = A[i];
				A[i] = temp;
			}
		}
		temp = A[r];
		A[r] = A[i+1];
		A[i+1] = temp;
		return i+1;
	}
	
	public static void quickSort(char[] A, int l, int r) {
		if (l < r) {
			int pivot = partition(A, l, r);
			quickSort(A, l, pivot-1);
			quickSort(A, pivot+1, r);
		}
	}
	
	public static String quickSort(String S) {
		char[] A = S.toCharArray();
		quickSort(A, 0, A.length-1);
		return new String(A);
	}
}
