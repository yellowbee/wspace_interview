package com.leetcode.miscellaneous;

import java.util.Arrays;

/*
 * Given an array and a value, remove all instances of that value
 * in place and return the new length. The order of elements can be
 * changed. It doesn't matter what you leave beyond the new length.
 */

public class RemoveElement {
	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		//int[] A = {1,2,3,4,8,3,6,7,9,3};
		int[] A = {2};
		System.out.println(re.removeElement(A, 3));
		System.out.println(Arrays.toString(A));
	}
	
	public int removeElement(int[] A, int elem) {
		if (A.length == 0) {
			return 0;
		}
		
        int left = 0;
        int right = A.length-1;
        
        while (left < right) {
        	if (A[left] == elem) {
        		while (left < right && A[right] == elem) {
        			right--;
        		}
        		if (left >= right) break;
        		A[left] = A[right];
        		A[right] = elem;
        	}
        	
        	left++;
        }
        
        if (A[right] == elem) {
        	return right;
        }
        else {
        	return right+1;
        }
    }
}
