package com.leetcode.miscellaneous;


/*
 * 算法很简单，核心思想是：对某个值A[i]来说，能trapped的最多的water取决于在i之前最高的值
 * leftMostHeight[i]和在i右边的最高的值rightMostHeight[i]。（均不包含自身）。
 * 如果min(left,right) > A[i]，那么在i这个位置上能trapped的water就是min(left,right) – A[i]。
 * 有了这个想法就好办了，第一遍从左到右计算数组leftMostHeight，第二遍从右到左计算rightMostHeight，
 * 在第二遍的同时就可以计算出i位置的结果了，而且并不需要开空间来存放rightMostHeight数组。
 * 时间复杂度是O(n)，只扫了两遍。
 */

public class TrappingRainWater {
	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		//int[] A = {5,2,1,2,1,5};
		System.out.println(trw.trap(A));
	}
	
	public int trap(int[] A) {
		if (A.length <= 1) {
			return 0;
		}
		
		int trap = 0;
		
		int[] leftMostHeight = new int[A.length];
		leftMostHeight[0] = Integer.MIN_VALUE;
		int leftMost = leftMostHeight[0];
		for (int i=1; i<A.length; i++) {
			if (A[i-1] > leftMost) {
				leftMostHeight[i] = A[i-1];
				leftMost = A[i-1];
			}
			else {
				leftMostHeight[i] = leftMost;
			}
		}
		
		int[] rightMostHeight = new int[A.length];
		rightMostHeight[A.length-1] = Integer.MIN_VALUE;
		int rightMost = rightMostHeight[A.length-1];;
		for (int j=A.length-2; j>0; j--) {
			if (A[j+1] > rightMost) {
				rightMostHeight[j] = A[j+1];
				rightMost = A[j+1];
			}
			else {
				rightMostHeight[j] = rightMost;
			}
			int min = Math.min(leftMostHeight[j], rightMostHeight[j]);
			if (min > A[j]) {
				trap += min - A[j];
			}
		}
		
		return trap;
    }
}
