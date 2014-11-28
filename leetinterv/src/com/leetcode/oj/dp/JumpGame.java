package com.leetcode.oj.dp;

/*
 * Given an array of non-negative integers, you are initially positioned
 * at the first index of the array. Each element in the array represents
 * your maximum jump length at that position. Determine if you are able
 * to reach the last index.

	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
 *
 * Solution: 1-D DP
 * Let J[i] be a boolean value indicating whether position i is reachable.
 * 
 * J[i] =  (J[i-1] && A[i-1] >= 1)
 *      OR (J[i-2] && A[i-2] >= 2)
 *      ...
 *      OR (J[0] && A[0] >= i) 
 */

public class JumpGame {
	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] A1 = {2,3,1,1,4};
		int[] A2 = {3,2,1,0,4};
		System.out.println(jg.canJump(A2));
	}
	
	public boolean canJump(int[] A) {
        boolean[] J = new boolean[A.length];
        
        J[0] = true;
        for (int i=1; i<A.length; i++) {
        	for (int j=1; j<=i; j++) {
        		if (J[i-j] && A[i-j]>=j) {
        			J[i] = true;
        			break;
        		}
        	}
        }
        return J[A.length-1];
    }
}
