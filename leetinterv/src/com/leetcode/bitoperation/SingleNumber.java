package com.leetcode.bitoperation;

public class SingleNumber {
	public int singleNumber(int[] A) {
        int result = A[0];
        for (int i=1; i<A.length; i++) {
            result = result ^ A[i];
        }
        return result;
    }
}