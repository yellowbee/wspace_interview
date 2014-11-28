package com.leetcode.oj.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
 * Category: DP
 * 
 * P[i] = P[j] + S[j+1, i], where S[j+1, i] in dict and 0 <= j < i
 */

public class WordBreakII {
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		WordBreakII wb = new WordBreakII();
		wb.printResult(wb.wordBreak(s, dict));
	}
	
	/*
	 * In order to pass OJ time limit check, we need to combine dfs and dp.
	 */
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        if (s==null || s.length()==0) return ret;
        int n = s.length();
        
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, false);
        
        for (int i=0; i<n; i++) {
        	if (dict.contains(s.substring(0, i+1))) {
        		dp[i] = true;
        	}
        	else {
        		for (int j=0; j<i; j++) {
        			if (dp[j] == true && dict.contains(s.substring(j+1, i+1))) {
        				dp[i] = true;
        				break;
        			}
        		}
        	}
        }
          
        if (dp[n-1] == false) return ret; //DP的作用就这一行！！！
        StringBuilder cur = new StringBuilder();
        dfs(s, 0, cur, ret, dict);
        return ret;
    }

	public void dfs(String s, int start, StringBuilder cur, ArrayList<String> ret, Set<String> dict)  {
		int slen = s.length();
		if (start >= slen) {
			ret.add(cur.toString());
			return;
		}
		
		for (int i=start; i<slen; i++) {
			String subs = s.substring(start, i+1);
			if (dict.contains(subs)) {
				int oldlen = cur.length();
				if (cur.length() > 0) {
					cur.append(" ");
				}
				cur.append(subs);
				
				dfs(s, i+1, cur, ret, dict);
				cur.delete(oldlen, cur.length());
			}
		}
	}
	
    /*public void dfs(String s, int start, StringBuilder cur, ArrayList<String> ret, Set<String> dict)  {
        int n = s.length();
        if (start >= n) {
            ret.add(new String(cur));
            return;
        }
        for (int i=start+1; i<=n; i++) {
            String sub = s.substring(start, i);
            if (dict.contains(sub)) {
                int oldLen = cur.length();
                if (oldLen!=0) cur.append(" ");
                cur.append(sub);
                dfs(s, i, cur, ret, dict);
                cur.delete(oldLen, cur.length());
            }
        }
    }*/
	
	/* Pure DP; it will get us the correct result, but will not pass the time limit check of OJ
	 * public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s == null) {
        	return null;
        }
        if (s.isEmpty()) {
        	ArrayList<String> result = new ArrayList<String>();
        	result.add("");
        	return result;
        }
        
        ArrayList<ArrayList<String>> P = new ArrayList<ArrayList<String>>();
        
        // calculate P[0]
        if (dict.contains(s.substring(0, 1))) {
        	ArrayList<String> sentences = new ArrayList<String>();
        	sentences.add(s.substring(0,1));
        	P.add(sentences);
        }
        else {
        	P.add(0, null);
        }
        
        for (int i=1; i<s.length(); i++) {
        	ArrayList<String> sentences = new ArrayList<String>();
        	if (dict.contains(s.substring(0, i+1))) {
        		sentences.add(s.substring(0, i+1));
        	}
        	for (int j=0; j<i; j++) {
        		if (P.get(j) != null && dict.contains(s.substring(j+1, i+1))) {
        			ArrayList<String> lhs = P.get(j);
        			for (int k=0; k<lhs.size(); k++) {
        				sentences.add(lhs.get(k) + " " + s.substring(j+1, i+1));
        			}
        		}
        	}
        	if (sentences.size() != 0) {
        		P.add(i, sentences);
        	}
        	else {
        		P.add(i, null);
        	}
        }
        return P.get(s.length()-1);
    }*/
	
	public void printResult(ArrayList<String> result) {
		for (int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
