package com.leetcode.bitoperation;

/*
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Solution: bit manipulation
 */

public class MajorityElement {
	public int majorityElement(int[] num) {
		int major_num = 0;
		int LEN = num.length;
		
        for (int i=0; i<=31; i++) {
        	int numOfOnes = 0;
        	for (int j=0; j<LEN; j++) {
        		if ((num[j] & (1<<i)) != 0) {
        			numOfOnes++;
        		}
        	}
        	if (numOfOnes > LEN / 2) {
        		major_num += (1<<i);
        	}
        }
        
        return major_num;
    }
}
