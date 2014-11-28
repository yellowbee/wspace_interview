package com.expedia.arraysnstrings;

import java.util.Arrays;

/* Remove duplicates in a sorted array
 * {1,2,3,3,3,4,4,6,} ==> {1,2,3,4,6} 
 */

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		int[] B = RemoveDuplicates.removeDups(A);
		System.out.println(Arrays.toString(B));
	}
	
	public static int[] removeDups(int[] A) {
		int cur = 1; // currently visited
		int pos = 1; // position to insert
		
		for (int i=1; i<A.length; i++) {
			if (A[i] != A[i-1]) {
				A[pos] = A[i];
				cur++;
				pos++;
			}
			else {
				cur++;
			}
		}
		
		return Arrays.copyOfRange(A, 0, pos);
	}
}
