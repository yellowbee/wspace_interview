package com.linkedin.binarysearch;

/*
 * binary search
 */

public class MinLarger {
	public static void main(String[] args) {
		char[] list = {'c', 'f', 'j', 'p', 'v'};
		char c = 'u';
		System.out.println(MinLarger.findMinLarger(list, c));
	}
	
	// find the smallest element that is strictly larger than
	// the target
	public static int findMinLarger(char[] list, char c) {
		int LEN = list.length;
		int left = 0;
		int right = LEN - 1;
		int mid;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (c < list[mid]) {
				if (mid == 0) return 0;
				if (c >= list[mid - 1]) return mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
}
