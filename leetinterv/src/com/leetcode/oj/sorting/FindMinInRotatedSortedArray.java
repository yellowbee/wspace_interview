package com.leetcode.oj.sorting;

/*
 * Test cases:
 * {4,5,1,2,3}
 * {4,5,6,0,1,2,3}
 * {1,2,3}
 * {1,2,3,0}
 */

public class FindMinInRotatedSortedArray {
	public static void main(String[] args) {
		int[] num = {1,2,3};
		System.out.println(FindMinInRotatedSortedArray.findMin(num));
	}
	public static int findMin(int[] num) {
		if (num.length == 1) return num[0];
		
		int len = num.length;
		
		if (num[0] < num[len-1]) {
			return num[0];
		}
		
		int start = 0;
		int end = len - 1;
		int mid = 0;
		
		while (end - start >= 1) {
			if (end - start == 1) {
				return Math.min(num[start], num[end]);
			}
			mid = (start + end) / 2;
			if (num[mid] < num[mid-1] && num[mid] < num[mid+1]) {
				return num[mid];
			}
			if (num[mid] < num[start]) {
				end = mid;
			}
			else if (num[mid] > num[end]){
				start = mid;
			}
		}
		
		return -1;
    }
}
