package com.leetcode.oj.sorting;

/*
 * Test cases:
 * int[] A =  {1, 5, 7, 10, 13};
 * int[] B = {11, 15, 23, 30, 31};
 * 
 * {4}, {1,2,3}
 */

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] A =  {4};
		int[] B = {1,3,10};
		
		System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(A, B));
	}
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		
		if ((m+n) % 2 !=0) {
			return (double)findKth(A, B, (m+n)/2, 0, m-1, 0, n-1);
		}
		else {
			return (findKth(A, B, (m+n)/2, 0, m-1, 0, n-1) + findKth(A, B, (m+n)/2-1, 0, m-1, 0, n-1)) * 0.5;
		}
	}
	
	public static int findKth(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		
		// corner cases
		if (aLen == 0) return B[bStart + k];
		if (bLen == 0) return A[aStart + k];
		if (k == 0) return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
		
		int aMid = (aStart + aEnd) / 2;
		int bMid = (bStart + bEnd) / 2;
		
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		}
		else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	/*public static double findMedianSortedArrays(int A[], int B[]) {
        int mid;
        boolean odd;
        if ((A.length + B.length) % 2 == 0) { // even
        	mid = (A.length + B.length) / 2 + 1;
        	odd = false;
        }
        else { // odd
        	mid = (A.length + B.length) / 2 + 1;
        	odd = true;
        }
        
        int start_A = 0;
        int end_A = A.length - 1;
        int x = 0;;
        
        while (start_A >=0 && start_A < A.length && end_A >=0 && end_A < A.length) {
        	x = (start_A + end_A) / 2;
        	
        	if ((mid-x-2)>=0 && A[x] > B[mid - x - 2] && A[x] < B[mid - x - 1]) { // found
        		break;
        	}
        	
        	if ((mid-x-2)>=0 && A[x] > B[mid - x - 2] && A[x] > B[mid - x - 1]) { // move left
        		end_A = x - 1;
        	}
        	else if ((mid-x-2)>=0 && A[x] < B[mid - x - 2] && A[x] < B[mid - x - 1]) { // move right
        		start_A = x + 1;
        	}
        }
        
        if (x>=0 && x <A.length) {
        	if (odd) {
        		return (double)A[x];
        	}
        	else {
        		return (double)(A[x] + B[mid - x - 1]) / 2.0;
        	}
        }
        
        if (x < 0) {
        	if (odd) {
        		return (double)B[mid];
        	}
        	else {
        		return (double)(B[mid-1] + B[mid]) / 2.0;
        	}
        }
        if (x >= A.length) {
        	if (odd) {
        		return (double)B[mid - A.length - 1];
        	}
        	else {
        		return (double)(B[mid - A.length - 2] + B[mid - A.length - 1]) / 2.0;
        	}
        }
        
        return 0;
    }*/
}
