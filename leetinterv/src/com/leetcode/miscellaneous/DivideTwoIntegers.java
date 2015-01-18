package com.leetcode.miscellaneous;

/*
 * Divide two integers without using multiplication,
 * division and mod operator.
 * If it is overflow, return MAX_INT.
 */

public class DivideTwoIntegers {
	public static void main(String[] args) {
		System.out.println(DivideTwoIntegers.divide(50, 30));
	}
	
	public static int divide(int dividend, int divisor) {
		if (dividend < divisor) return 0;
		
        int count = -1;
        while (dividend > 0) {
        	count++;
        	dividend -= divisor;
        }
        
        return count;
    }
}
