package com.leetcode.oj.arraynstring;

public class KthOfTwoSortedArray {
	public static void main(String[] args) {
		int[] A =  {1,1,1,1,1};
		int[] B = {1,1,1};
		
		System.out.println(KthOfTwoSortedArray.findKth(A, 0, A.length, B, 0, B.length, 10));
	}
	
	//public static int findKth(int[] A, int[] B, int k, int aStart, int m, int bStart, int n) {
	public static int findKth(int[] A, int aStart, int m, int[] B, int bStart, int n, int k) {
		assert m >= 0 : "m >= 0";
		assert n >= 0 : "n >= 0";
		assert k > 0 : "k > 0";
		assert k <= m+n : "k <= m+n";
		
		int i = (int)((double)m/(m+n)*(k-1));
		int j = k - 1 - i;
		
		assert i >= 0 : "i >= 0";
		assert j >= 0 : "j >= 0";
		assert i <= m : "i <= m";
		assert j <= n : "j <= n";
		// invariant: i + j = k-1
		// Note: A[-1] = -INF and A[m] = +INF to maintain invariant
		int Ai_1 = (i == 0 ? Integer.MIN_VALUE : A[aStart+i-1]);
		int Bj_1 = (j == 0 ? Integer.MIN_VALUE : B[bStart+j-1]);
		int Ai = (i == m ? Integer.MAX_VALUE : A[aStart+i]);
		int Bj = (j == n ? Integer.MAX_VALUE : B[bStart+j]);
		
		if (Bj_1 < Ai && Ai < Bj) {
			return Ai;
		}
		else if (Ai_1 < Bj && Bj < Ai) {
			return Bj;
		}
		
		assert((Ai > Bj && Ai_1 > Bj) || (Ai < Bj && Ai < Bj_1));
		
		if (Ai < Bj) {
			return findKth(A, aStart+i+1, m-i-1, B, bStart+0, j, k-i-1);
		}
		else {
			return findKth(A, aStart+0, i, B, bStart+j+1, n-j-1, k-j-1);
		}
	}
}
