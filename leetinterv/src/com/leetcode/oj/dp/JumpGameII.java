package com.leetcode.oj.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given an array of non-negative integers, you are initially
 * positioned at the first index of the array. Each element in
 * the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2.
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Solution: DP
 * Test cases:
 * [2,3,1,1,4]
 * [2,3,0,1,4]
 * [8,0,8,5,0,1,1,0,9,4,1,5,1,3,8,0,3,2,2,7,1,7,3,4,5,3,6,1,1,6,7,9,7,5,5,9,8,6,9,7,2,2,5,5,5,3,8,0,5,0,9,9,0,3]
 */

public class JumpGameII {
	
	public static void main(String[] args) {
		JumpGameII jg2 = new JumpGameII();
		int[] A = {2,3,1,1,4};
		System.out.println(Arrays.toString(jg2.jump(A)));
	}
	
	public int[] jump(int[] A) {
		// let min[i] be the minimum steps to reach end from position i
        int[] min = new int[A.length];
        min[A.length-1] = 0;
        
        for (int i=A.length-2; i>=0; i--) {
        	if (A[i] == 0) {
        		min[i] = -1;
        	}
        	else if (A[i] >= A.length-1-i) {
        		min[i] = 1;
        	}
        	else if (A[i] == 1) {
        		if (min[i+1] != -1) {
        			min[i] = min[i+1] + 1;
        		}
        		else {
        			min[i] = -1;
        		}
        	}
        	else if (A[i] == A[i+1]+1) {
        		if (min[i+1] != -1) {
        			min[i] = min[i+1];
        		}
        		else {
        			min[i] = -1;
        		}
        	}
        	else {
        		int m = Integer.MAX_VALUE;
        		for (int j=1; j<=A[i]; j++) {
        			if (min[i+j]!=-1) {
        				m = m < min[i+j]+1 ? m : min[i+j]+1;
        			}
        			/*else {
        				m = Integer.MAX_VALUE;
        			}*/
        		}
        		if (m < Integer.MAX_VALUE) {
        			min[i] = m;
        		}
        		else {
        			min[i] = -1;
        		}
        	}
        }
        
        return min;
    }
}
