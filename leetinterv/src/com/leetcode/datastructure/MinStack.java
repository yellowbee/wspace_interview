package com.leetcode.datastructure;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min_stack = new Stack<Integer>();
    
    public static void main(String[] args) {
    	MinStack ms = new MinStack();
    	ms.push(512);
    	ms.push(-1024);
    	ms.push(-1024);
    	ms.push(512);
    	
    	ms.pop();
    	ms.getMin();
    	ms.pop();
    	ms.getMin();
    	ms.pop();
    	ms.getMin();
    }
    
    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty()) {
            min_stack.push(x);
        }
        else if (x <= min_stack.peek()) {
            min_stack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        
        int val = stack.pop().intValue();
        if (val == min_stack.peek()) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
