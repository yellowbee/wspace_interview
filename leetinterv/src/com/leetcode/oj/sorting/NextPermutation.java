package com.leetcode.oj.sorting;

import java.util.Arrays;

/*
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation npt = new NextPermutation();
		int[] num = {1,1,5};
		npt.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
	
	public void nextPermutation(int[] num) {
        for (int i=num.length-1; i>0; i--) {
        	if (num[i] > num[i-1]) { // swap if less significant digit is bigger than more significant digit
        		swap(num, i, i-1);
        		return;
        	}
        }
        
        int left = 0;
        int right = num.length-1;
        while (left < right) { // re-arrange sequence to ascending order
        	swap(num, left, right);
        	left++;
        	right--;
        }
    }
	
	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
