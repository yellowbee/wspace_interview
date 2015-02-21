package com.leetcode.binarysearch;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

{4,5,6,7,8,9,1,2,3}
{6,7,8,9,1,2,3,4,5}
{10,4,5,6,7,8,9}

 */
public class SearchInRotatedSortedArrayV2 {
	public static void main(String[] args) {
		int[] A = {3,1};
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 1));
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 7));
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 8));
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 9));
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 1));
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 2));
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 3));
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 4));
		System.out.println(SearchInRotatedSortedArrayV2.search(A, 0));
	}
	
	// The observation is : if you cut a rotated sorted array in halves,
	// only one of the halves is rotated, and the other half is of normal order.
	// Find that non-rotated half first. If the target falls into the range, it must
	// be in that half if it is in the array at all; otherwise, it can only fall into
	// the other half(which is the rotated half).
	public static int search(int[] A, int target) {
		int LEN = A.length;
		int left = 0;
		int right = LEN-1;
		int mid = 0;
		while (left <= LEN-1 && right >= 0 && left <= right) {
			mid = (left + right) / 2;
			if (A[mid] == target) return mid;
			
			// first two corner cases are trivial to take care of
			if (A[mid] == A[left]) {
				left = mid + 1;
			}
			else if (A[mid] == A[right]) {
				right = mid - 1;
			}
			else if (A[mid] > A[left]) { // left half is non-rotated
				if (target < A[mid] && target >= A[left]) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
			else { // right half is non-rotated
				if (target > A[mid] && target <= A[right]) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
