package com.leetcode.oj.dp;

/*
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * click to show more practice.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 * Solution: Let M[i] be the the max sum of i-ended subarray of A[k, i], where 0<=k<=i
 * M[i] = max { M[i] + A[i],
 *              A[i] }
 *        put it another way, if M[i] > 0, then M[i] = M[i] + A[i]; otherwise M[i] = A[i]
 */

public class MaximumSubarray {
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(ms.maxSubArray(A));
	}
	
	public int maxSubArray(int[] A) {
        int[] M = new int[A.length];
        
        M[0] = A[0];
        int max = A[0];
        for (int i=1; i<A.length; i++) {
        	M[i] = M[i-1] > 0 ? M[i-1] + A[i] : A[i];
        	max = max > M[i] ? max : M[i];
        }
        
        return max;
    }
}
