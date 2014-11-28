package com.expedia.queuenstack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Implement a queue using stacks
 */

public class QueueByStack {
	private Stack<Integer> stack_add;
	private Stack<Integer> stack_remove;
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		QueueByStack qbs = new QueueByStack();
		qbs.add(1);
		qbs.add(2);
		qbs.add(3);
		list.add(qbs.remove());
		list.add(qbs.remove());
		qbs.add(4);
		qbs.add(5);
		qbs.add(6);
		list.add(qbs.remove());
		list.add(qbs.remove());
		list.add(qbs.remove());
		list.add(qbs.remove());
		
		list.add(qbs.remove());
		
		System.out.println(list);
		
	}
	
	public QueueByStack() {
		this.stack_add = new Stack<Integer>();
		this.stack_remove = new Stack<Integer>();
	}
	
	public void add(int num) {
		stack_add.push(num);
	}
	
	public int remove() {
		if (!stack_remove.isEmpty()) {
			return stack_remove.pop();
		}
		
		while (!stack_add.isEmpty()) {
			stack_remove.add(stack_add.pop());
		}
		
		if (!stack_remove.isEmpty()) {
			return stack_remove.pop();
		}
		else {
			return -1;
		}
	}
}
