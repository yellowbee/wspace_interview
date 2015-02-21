package com.leetcode.oj.arraynstring;

import java.util.Arrays;

/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args) {
		int[] A = {1,1,1};
		int newLen = RemoveDuplicatesFromSortedArrayII.removeDuplicates(A);
		System.out.println(Arrays.toString(A));
		System.out.println(newLen);
	}
	
	public static int removeDuplicates(int[] A) {
		if (A.length <= 2) return A.length;
		
        int LEN = A.length;
        int insert = 2;
        int check = 2;
        while (check < LEN) {
        	if (!(A[insert-1]==A[check] && A[insert-2]==A[check])) {
        		A[insert] = A[check];
        		insert++;
        		check++;
        	}
        	else {
        		check++;
        	}
        }
        return insert;
    }
}
