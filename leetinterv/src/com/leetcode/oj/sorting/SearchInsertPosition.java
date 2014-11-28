package com.leetcode.oj.sorting;

public class SearchInsertPosition {
	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] A = {1,3,5,6};
		int target = 7;
		System.out.println(sip.searchInsert(A, target));
	}
	
	public int searchInsert(int[] A, int target) {
        return helper(A, 0, A.length-1, target);
    }
	
	private int helper(int[] A, int left, int right, int target) {
		if (left < right) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				return mid;
			}
			else if (target < A[mid]){
				return helper(A, left, mid-1, target);
			}
			else {
				return helper(A, mid+1, right, target);
			}
		}
		else {
			if (A[left] < target) {
				return left + 1;
			}
			else {
				return left;
			}
		}
	}
}
