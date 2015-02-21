package com.leetcode.binarysearch;

/*
 * duplicates are allowed
 * 
 * {1,1,1,1,1,1,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
 */

public class SearchInRotatedSortedArrayII {
	public static void main(String[] args) {
		int[] A = {1,1,1,1,1,1,1,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(SearchInRotatedSortedArrayII.search(A, 2));
	}
	
	public static boolean search(int[] A, int target) {
        int LEN = A.length;
        int left = 0;
        int right = LEN - 1;
        int mid;
        while (left < LEN && right >= 0 && left <= right) {
        	mid = (left + right) / 2;
        	if (target == A[mid]) return true;
        	
        	// corner case when duplicates are allowed
        	// In the example of {1,1,1,1,1,1,2,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        	// you cannot decide which half to go for by looking at the mid and end elements;
        	// in this case, which is the worst case, you need to traverse any half one by one
        	// (O(n) time complexity) and you go for the half that does not consist entirely of
        	// the same element as the mid one.
        	if (A[mid] == A[left] && A[mid] == A[right]) {
        		int ptr = left + 1;
        		while (ptr < mid) {
        			if (A[ptr] != A[mid]) {
        				right = mid - 1;
        				break;
        			}
        			ptr++;
        		}
        		if (right != mid - 1) {
        			left = mid + 1;
        		}
        	}
        	// corner case when left half consists of the same number
        	else if (A[mid] == A[left]) {
        		left = mid + 1;
        	}
        	// corner case when right half consists of the same number
        	else if (A[mid] == A[right]) {
        		right = mid - 1;
        	}
        	else if (A[mid] > A[left]) {
        		if (target < A[mid] && target >= A[left]) {
        			right = mid - 1;
        		}
        		else {
        			left = mid + 1;
        		}
        	}
        	else {
        		if (target > A[mid] && target <= A[right]) {
        			left = mid + 1;
        		}
        		else {
        			right = mid - 1;
        		}
        	}
        }
        
        return false;
    }
}
