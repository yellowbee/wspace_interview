package com.leetcode.miscellaneous;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple
slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/a/./b/../../c/"));
		System.out.println(sp.simplifyPath("/home//foo/"));
		System.out.println(sp.simplifyPath("/../"));
	}
	
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] str_arr = path.split("/");
        
        for (int i=0; i<str_arr.length; i++) {
        	if (str_arr[i].equals("..")) {
        		if (!stack.empty()) {
        			stack.pop();
        		}
        	}
        	else if (!str_arr[i].equals(".") && !str_arr[i].equals("")) {
        		stack.push(str_arr[i]);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<stack.size(); i++) {
        	sb.append("/");
        	sb.append(stack.get(i));
        }
        
        if (sb.toString().equals("")) {
        	return "/";
        }
        else {
        	return sb.toString();
        }
    }
}
