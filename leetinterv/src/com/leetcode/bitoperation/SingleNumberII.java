package com.leetcode.bitoperation;

public class SingleNumberII {
	public int singleNumber(int[] A) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        
        for (int i=0; i<A.length; i++) {
        	twos |= ones & A[i];
        	ones ^= A[i];
        	threes = ones & twos;
        	
        	ones &= ~threes;
        	twos &= ~threes;
        }
        
        return ones;
    }
}
