package com.careercup.stacknqueue;

import com.leetcode.oj.common.ListNode;

/*
 * Implement a stack
 */

public class MyStack {
	ListNode top;
	
	public void push(int x) {
		ListNode newtop = new ListNode(x);
		newtop.next = top;
		top = newtop;
	}
	
	public int pop() {
		if (top != null) {
			int val = top.val;
			top = top.next;
			return val;
		}
		return -1;
	}
}
