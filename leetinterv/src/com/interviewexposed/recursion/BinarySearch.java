package com.interviewexposed.recursion;

public class BinarySearch {
	public static void main(String[] args) {
		int[] A = {2, 5, 8, 9, 10, 11, 13, 17, 21};
		System.out.println(BinarySearch.binarySearch(A, 21));
		System.out.println(BinarySearch.iterativeBinarySearch(A, 21));
	}
	
	public static int binarySearch(int[] A, int target) {
		return helper(A, 0, A.length-1, target);
	}
	// recursive way of binary search
	public static int helper(int[] A, int start, int end, int target) {
		if (start > end) return -1;
		int mid_idx = (start + end) / 2;
		
		if (A[mid_idx] == target) {
			return mid_idx;
		}
		else if (target < A[mid_idx]) {
			return helper(A, start, mid_idx-1, target);
		}
		else {
			return helper(A, mid_idx+1, end, target);
		}
	}
	
	public static int iterativeBinarySearch(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		int mid = -1;
		
		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			}
			else if (target < A[mid]) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
}
