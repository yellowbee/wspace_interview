package com.topcoder.algorithm.DP;

import java.util.Arrays;

/*
 * Given a sequence of N numbers - A[1] , A[2] , ..., A[N] .
 * Find the length of the longest non-decreasing sequence.
 * 
 * Discussion:
 * Define the state i to be the longest non-decreasing sequence
 * ending with A[i]. Having all states j where j<i, we can get
 * state i by the following formula
 * S[i] = max{S[j] + 1}, where A[i] >= A[j]
 */

public class LongestNonDecSeq {
	
	
	public static void main(String[] args) {
		LongestNonDecSeq lseq = new LongestNonDecSeq();
		int[] A = {5, 3, 4, 8, 6, 7};
		lseq.printResult(lseq.find(A));
	}
	// A is the original sequence of numbers
	// S[i] contains the length of the longest sequence
	// ending with A[i], (which means that the last member
	// of the longest sequence is A[i]
	public int[] find(int[] A) {
		int[] S = new int[A.length];
		Arrays.fill(S, 1);
		
		for (int i=1; i<A.length; i++) {
			for (int j=0; j<i; j++) {
				if (A[i] >= A[j] && (S[j] + 1) > S[i]) {
					S[i] = S[j] + 1;
				}
			}
		}
		return S;
	}
	
	public void printResult(int[] S) {
		for (int i=0; i<S.length; i++) {
			System.out.print(S[i] + " ");
		}
		System.out.println();
	}
}
