package com.amazon.llist;

import java.util.Stack;

/*
 * Add a method to the stack data structure to
 * keep track of the smallest element in a stack.
 * 
 * Solution: at each push, if the new top element is
 * smaller than the history min, make it the pre-node
 * pointing to the history min node, so that the linked
 * list is acting like a min history list.
 */

public class StackWMin {
	private Stack<Integer> stack;
	private Stack<Integer> stack_min;
	
	public static void main(String[] args) {
		StackWMin mystack = new StackWMin();
		mystack.push(3);
		mystack.push(1);
		mystack.push(5);
		mystack.push(2);
		mystack.push(4);
		System.out.println(mystack.getMin()); // 1 expected
		mystack.pop(); // 3,1,5,2
		System.out.println(mystack.getMin()); // 1 expected
		mystack.pop(); // 3,1,5
		mystack.pop(); // 3,1
		System.out.println(mystack.getMin()); // 1 expected
		mystack.pop(); // 3
		System.out.println(mystack.getMin()); // 3 expected
	}
	
	public StackWMin() {
		stack = new Stack<Integer>();
		stack_min = new Stack<Integer>();
	}
	
	public void push(int element) {
		stack.push(element);
		if (stack_min.isEmpty()) {
			stack_min.push(element);
		}
		else if (element < stack_min.peek()) {
			stack_min.push(element);
		}
	}
	
	public int pop() {
		if (stack.peek() == stack_min.peek()) {
			stack_min.pop();
		}
		return stack.pop();
	}
	
	public int getMin() {
		return stack_min.peek();
	}
}
