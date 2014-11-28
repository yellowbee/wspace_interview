package com.leetcode.miscellaneous;

import java.util.LinkedList;
import java.util.Stack;

/*
 * "()", "()(()", ")()())", "(()", "(()(((()"
 */

public class LongestValidParentheses {
	public static void main(String[] args) {
		LongestValidParentheses lvp = new LongestValidParentheses();
		String s = "(()(((()";
		System.out.println(lvp.longestValidParentheses(s));
	}
	
	public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] charray = s.toCharArray();
        int max_len = 0;
        
        for (int i=0; i<charray.length; i++) {
        	if (charray[i] == '(') {
        		stack.push(i);
        	}
        	else {
        		if (!stack.isEmpty() && charray[stack.peek()] == '(') {
        			stack.pop();
        			max_len = Math.max(max_len, stack.empty()?i+1:i-stack.peek());
        		}
        		else {
        			stack.push(i);
        		}
        	}
        }
        
        return max_len;
    }
}
