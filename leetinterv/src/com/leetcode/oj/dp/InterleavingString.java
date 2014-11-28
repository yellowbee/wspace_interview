package com.leetcode.oj.dp;

import java.util.Arrays;
import java.util.List;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example, Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * Category: string
 * Solution: DP
 * Define M[i][j] to be a boolean value indicating whether S1[1..i] and S2[1..j]
 * match S3[1..i+j]
 * M[i][j] = (S1[i]==S3[i+j] && M[i-1][j]) || (S2[j]==S3[i+j] && M[i][j-1])
 */

public class InterleavingString {
	public static void main(String[] args) {
		InterleavingString ils = new InterleavingString();
		System.out.println(ils.isInterleave("", "abc", "ab"));
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("#" + s1);
		char[] S1 = sb.toString().toCharArray();
		
		sb.delete(0, sb.length());
		sb.append("#" + s2);
		char[] S2 = sb.toString().toCharArray();
		
		sb.delete(0, sb.length());
		sb.append("#" + s3);
		char[] S3 = sb.toString().toCharArray();
		
		boolean M[][] = new boolean[S1.length][S2.length];
		M[0][0] = true;
		
		if (S1.length > 1) {
			for (int i=1; i<S1.length; i++) {
				if (S1[i] == S3[i]) {
					M[i][0] = M[i-1][0];
				}
				else {
					M[i][0] = false;
				}
			}
		}
		if (S2.length > 1) {
			for (int j=1; j<S2.length; j++) {
				if (S2[j] == S3[j]) {
					M[0][j] = M[0][j-1];
				}
				else {
					M[0][j] = false;
				}
			}
		}
		for (int i=1; i<S1.length; i++) {
			for (int j=1; j<S2.length; j++) {
				M[i][j] = (S1[i]==S3[i+j] && M[i-1][j]) || (S2[j]==S3[i+j] && M[i][j-1]);
			}
		}
		
		return M[S1.length-1][S2.length-1];
    }
}
