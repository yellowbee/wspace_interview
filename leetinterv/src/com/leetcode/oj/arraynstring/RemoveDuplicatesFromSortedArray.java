package com.leetcode.oj.arraynstring;

import java.util.Arrays;

/*
 * Given a sorted array, remove the duplicates in place such
 * that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do
 * this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
		int[] A = {1};
		System.out.println(rd.removeDuplicates(A));
		System.out.println(Arrays.toString(A));
	}
	
	public int removeDuplicates(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		else if (A.length == 1) {
			return 1;
		}
		
		// maintain two pointers; one pointing to the one being visited;
		// another pointing to the position to store the next unique element
        int cur_visited = 1;
        int cur_storage = 1;
        
        while (cur_visited < A.length) {
        	if (A[cur_visited] > A[cur_storage-1]) {
        		A[cur_storage] = A[cur_visited];
        		cur_visited++;
        		cur_storage++;
        	}
        	else {
        		cur_visited++;
        	}
        }
        
        return cur_storage;
    }
}
