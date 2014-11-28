package com.leetcode.oj.llist;

import java.util.Arrays;

/*
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the
 * color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite
 * array with total number of 0's, then 1's and followed by 2's.Could you come up
 * with an one-pass algorithm using only constant space?
 * 
 * Solution: So far, it cannot be put into a certain category; since it's operation
 * is similar to those of linked lists, this problem is put in the current package.
 */

public class SortColors {
	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] A = {0,1,0};
		sc.sortColors(A);
		System.out.println(Arrays.toString(A));
	}
	
	public void sortColors(int[] A) {
        int red = 0;
        int blue = A.length-1;
        int idx = 0;
        
        while (idx <= blue && red < blue) {
        	if (A[idx] == 0) {
        		// the following if statement is very important
        		// if idx and red both point to zero, grow both pointers
        		if (idx == red) {
        			idx++;
        			red++;
        			continue;
        		}
        		swap(A, idx, red);
        		red++;
        	}
        	else if (A[idx] == 2) {
        		swap(A, idx, blue);
        		blue--;
        	}
        	else {
        		idx++;
        	}
        }
    }
	
	private void swap(int[] A, int idx1, int idx2) {
		int temp = A[idx1];
		A[idx1] = A[idx2];
		A[idx2] = temp;
	}
}
