package com.leetcode.binarysearch;

/*
 * Implement pow(x, n).
 * 
 * Solution: Using binary search (keep splitting the exponent in halves)
 */

public class PowerXn {
	public static void main(String[] args) {
		System.out.println(PowerXn.pow(2, -1));
	}
	
	public static double pow(double x, int n) {
		if (n == 0) return 1;
		
		int m = n > 0 ? n : -n;
		
        if (m == 1) {
        	return n > 0 ? x : 1/x;
        }
        if (m == 2) {
        	return n > 0 ? x*x : 1/(x*x);
        }
        
        int half = m / 2;
        int remain = m % 2;
        double powhalf = pow(x, half);
        if (remain == 0) {
        	return n > 0 ? powhalf*powhalf : 1/(powhalf*powhalf);
        }
        else {
        	return n > 0 ? powhalf*powhalf*x : 1/(powhalf*powhalf*x);
        }
    }
}
