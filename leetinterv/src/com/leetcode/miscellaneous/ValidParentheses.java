package com.leetcode.miscellaneous;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 */

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if (ch == '(' || ch == '[' || ch == '{') {
        		stack.push(ch);
        	}
        	else if (stack.isEmpty()) {
        		return false;
        	}
        	else if (ch == ')' && stack.peek() != '(') {
        		return false;
        	}
        	else if (ch == ']' && stack.peek() != '[') {
        		return false;
        	}
        	else if (ch == '}' && stack.peek() != '{') {
        		return false;
        	}
        	else {
        		stack.pop();
        	}
        }
        
        if (stack.isEmpty()) {
        	return true;
        }
        else {
        	return false;
        }
    }
}
