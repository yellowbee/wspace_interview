package com.leetcode.binarysearch;

public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] num) {
		// corner cases
		if (num.length == 1) return num[0];
		if (num[0] <= num[num.length-1]) return num[0];
		
		int left = 0;
		int right = num.length - 1;
		int mid;
		
		while (true) {
			mid = (left + right) / 2;
			if (num[mid]<=num[left] && num[mid]<=num[right]) return num[mid];
			
			
		}
		
    }
}
