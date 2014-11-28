package com.leetcode.oj.dp;

import java.util.ArrayList;

/*
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s. 
 * For example, given s = "aab", Return
 * [
 * 	["aa","b"],
 * 	["a","a","b"]
 * ]
 */

/*
 * Category: DFS, DP(optional)
 */

public class PalindromePartition {
	public ArrayList<ArrayList<String>> partition(String s) {
		int slen = s.length();
		ArrayList<ArrayList<String>> result = new  ArrayList<ArrayList<String>>();
		ArrayList<String> cur = new ArrayList<String>();
		/*
		 * A DP is needed to calculate if a string
		 * is a palindrome. Define P[i][j] is the boolean
		 * value indicating whether S[i][j] is a palindrome.
		 */
		boolean[][] P = new boolean[slen][slen];
		for (int i=0; i<slen; i++) {
			for (int j=0; j<slen; j++) {
				P[i][j] = false;
			}
		}
		for(int i = slen-1; i >= 0; i--){  
			for(int j = i; j < slen; j++){  
				if(s.charAt(i) == s.charAt(j) && (j-i<2 || P[i+1][j-1])){  
					P[i][j] = true;  
				}  
			}  
		}
		
		dfs(s, 0, cur, result, P);
		return result;
    }
	
	public void dfs(String s, int start, ArrayList<String> cur, ArrayList<ArrayList<String>> result, boolean[][] P) {
		int slen = s.length();
		if (start >= slen) {
			result.add(new ArrayList<String>(cur));
			return;
		}

		for (int i=start; i<slen; i++) {
			if (P[start][i]) {
				int oldlen = cur.size();
				cur.add(s.substring(start, i+1));
				dfs(s, i+1, cur, result, P);
				int newlen = cur.size();
				for (int k=newlen-1; k>=oldlen; k--) {
					cur.remove(k);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PalindromePartition pp = new PalindromePartition();
		System.out.println(pp.partition("aab"));
	}
}
