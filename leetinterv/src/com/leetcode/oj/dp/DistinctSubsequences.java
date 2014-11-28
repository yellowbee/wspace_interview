package com.leetcode.oj.dp;

/*
 * Category: DP
 * Find the number of subsequence of T in S
 * Solution:
 * Define C[i][j] as the number of subsequence T[0,i] in S[0,j]
 * C[i][j]  =  C[i][j-1], if T[i] =/= S[j]
 *          =  C[i][j-1] + C[i-1][j-1], if T[i] = S[j]
 */

public class DistinctSubsequences {
	public static void main(String[] args) {
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinct("aabb", "ab"));
		System.out.println(ds.numDistinct("ccc", "c"));
		System.out.println(ds.numDistinct("rabbbit", "rabbit"));
	}
	
	public int numDistinct(String S, String T) {
		if (S.length() == 0 || T.length() == 0) {
			return 0;
		}
		
        int slen = S.length();
        int tlen = T.length();
        int[][] C = new int[tlen][slen];
        for (int i=0; i<tlen; i++) {
        	for (int j=0; j<slen; j++) {
        		C[i][j] = 0;
        	}
        }
        // initialization
        int sum = 0;
        for (int s=0; s<slen; s++) {
        	if (T.charAt(0) == S.charAt(s)) {
        		sum++;
        	}
        		C[0][s] = sum;
        }
        
        for (int t=1; t<tlen; t++) {
        	C[t][0] = 0;
        }
        for (int t=1; t<tlen; t++) {
        	for (int s=1; s<slen; s++) {
        		if (t>s) {
        			C[t][s] = 0;
        			continue;
        		}
        		if (T.charAt(t) == S.charAt(s)) {
        			C[t][s] = C[t][s-1] + C[t-1][s-1];
        		}
        		else {
        			C[t][s] = C[t][s-1];
        		}
        	}
        }
        
        return C[tlen-1][slen-1];
    }
}
