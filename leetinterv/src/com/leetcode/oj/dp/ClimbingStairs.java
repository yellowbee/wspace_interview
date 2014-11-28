package com.leetcode.oj.dp;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
   Each time you can either climb 1 or 2 steps. In how many distinct
   ways can you climb to the top?
   
   Solution: This problem can be solved using recursion, which is, however,
   not the best solution. A DP solution is better.
   C[i] = max {
   				C[i-1],
   				C[i-2] + 2
   			  }
   C[0] = 0;
   C[1] = 1;
 */

public class ClimbingStairs {
	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs(1));
		System.out.println(cs.climbStairs(2));
		System.out.println(cs.climbStairs(4));
	}
	
	//A recursive solution.
	/*public int climbStairs(int n) {
        if (n==1) {
        	return 1;
        }
        else if (n==2) {
        	return 2;
        }
        else {
        	return climbStairs(n-1) + climbStairs(n-2);
        }
    }*/
	
	// A DP solution
	public int climbStairs(int n) {
		int[] C = new int[n+1];
		C[0] = 0;
		C[1] = 1;
		if (n>=2){
			C[2] = 2;
		}
		
		for (int i=3; i<C.length; i++) {
			C[i] = C[i-1] + (C[i-2]);
		}
		
		return C[n];
	}
}
