package com.leetcode.binarysearch;

import java.math.BigInteger;

/*
 * Implement int sqrt(int x).

Compute and return the square root of x.

Solution: cannot decide whether overflow happens by comparing to 0;
rather, set end to no larger than sqrt(Integer.MAX_VALUE).
 */

public class SqrtX {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(SqrtX.sqrt(2147395599));
	}
	
	public static int sqrt(int x) {
        int start = 0;
        int end = (int)Math.sqrt((double)Integer.MAX_VALUE);
        int mid = 0;
        while (start < end) {
        	if (end - start == 1) {
        		return (end*end) <= x ? end : start;
        	}
        	mid = (start + end) / 2;
        	int square = mid * mid;
        	if (square == x) return mid;
        	if (square > x) {
        		end = mid; 
        	}
        	else {
        		start = mid;
        	}
        }
        
        return mid;
    }
}
