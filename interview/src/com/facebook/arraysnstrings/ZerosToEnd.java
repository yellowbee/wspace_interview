package com.facebook.arraysnstrings;

import java.util.Arrays;

/*
 *  place all 0s to the end
 *  {3, 0, 2, 0, 5, 0} => {3, 2, 5, 0, 0, 0}
 *  
 *  Solution: Use two pointers to do it one pass.
 */

public class ZerosToEnd {
	public static void main(String[] args) {
		int[] A = {3, 0, 2, 0, 5, 0};
		ZerosToEnd.moveZerosToEnd(A);
		System.out.println(Arrays.toString(A));
	}
	
	public static void moveZerosToEnd(int[] A) {
		int pos = 0; // position to insert
		int cur = 0; // index of current element being visited
		
		for (int i=0; i<A.length; i++) {
			if (A[i] != 0) {
				A[pos] = A[i];
				pos++;
			}
		}
		
		if (pos < A.length) {
			for (int j=pos; j<A.length; j++) {
				A[j] = 0;
			}
		}
	}
}
