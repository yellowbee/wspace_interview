package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * [解题思路]
 * 典型的递归。一步步构造字符串。当左括号出现次数<n时，就可以放置新的左括号;
 * 当右括号出现次数小于左括号出现次数时，就可以放置新的右括号。
 */

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		List<String> result = gp.generateParenthesis(3);
		System.out.println(result);
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(result, new StringBuffer(), n);
        return result;
    }
	
	public void helper(List<String> result, StringBuffer cur, int n) {
		if (cur.length() == 2*n) {
			result.add(cur.toString());
			return;
		}
		
		int left = 0;
		int right = 0;
		for (int i=0; i<cur.length(); i++) {
			if (cur.charAt(i) == '(') {
				left++;
			}
			else if (cur.charAt(i) == ')') {
				right++;
			}
		}
		
		if (left < n) {
			cur.append('(');
			helper(result, cur, n);
			cur.deleteCharAt(cur.length()-1);
		}
		
		if (right < left) {
			cur.append(')');
			helper(result, cur, n);
			cur.deleteCharAt(cur.length()-1);
		}	
	}
}
