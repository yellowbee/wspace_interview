package com.expedia.arraysnstrings;

/*
 * Binary search in a rotated sorted array, such as in the case where
 * 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2
 * 
 * Test cases:
 * 0, 1, 2, 4, 5, 6, 7
 * 4, 5, 6, 7, 0, 1, 2
 * 2, 4, 5, 6, 7, 0, 1
 * 4,5,6,7,8,1,2,3
 */

public class RotatedBinarySearch {
	public static void main(String[] args) {
		int[] A = {1,2,3};
		System.out.println(RotatedBinarySearch.search(A, 4));
		
	}
	
	public static int search(int[] A, int target) {
		if (A.length == 0) return -1;
		
		int start = 0;
		int end = A.length - 1;
		int mid;
		
		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] == target) return mid;
			
			if (A[mid] >= A[start]) { // increasing
				if (target >= A[start] && target < A[mid]) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
			else if (A[mid] < A[start]) { // decreasing
				if (target > A[mid] && target <= A[end]) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
		}
		
		return -1;
	}
}
