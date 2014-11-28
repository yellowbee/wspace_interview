package com.leetcode.oj.sorting;

import java.util.Arrays;

/*
 * Given a sorted array of integers, find the starting and ending position of
 * a given target value. Your algorithm's runtime complexity must be in the
 * order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * Solution: since a time complexity of O(log n) is required, it comes naturally that
 * binary search should be used. Two binary searches are needed, one for the left boundary,
 * one for the right boundary. A boolean is passed to the recursion method, indicating if
 * a left or right boundary is under search. 
 */

public class SearchForARange {
	public static void main(String[] args) {
		SearchForARange sfr = new SearchForARange();
		int[] A = {5,7,7,8,8,10};
		int[] result = sfr.searchRange(A, 10);
		System.out.println(Arrays.toString(result));
		
	}
	
	public int[] searchRange(int[] A, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
        helper(A, result, target, 0, A.length-1, true);
        helper(A, result, target, 0, A.length-1, false);
        return result;
    }
	
	public void helper(int[] A, int[] result, int target, int start, int end, boolean isLeft) {
		if (start == end) {
			if (A[start] == target) {
				if (isLeft) {
					result[0] = start;
				}
				else {
					result[1] = start;
				}
			}
		}
		else if (start < end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				if (isLeft) {
					result[0] = mid;
					helper(A, result, target, start, mid-1, true);
				}
				else {
					result[1] = mid;
					helper(A, result, target, mid+1, end, false);
				}
			}
			else if (A[mid] < target) {
				helper(A, result, target, mid+1, end, isLeft);
			}
			else {
				helper(A, result, target, start, mid-1, isLeft);
			}
		}
	}
}
