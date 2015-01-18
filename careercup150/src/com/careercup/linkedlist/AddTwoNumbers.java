package com.careercup.linkedlist;

import com.leetcode.oj.common.ListNode;

/*
 * EXAMPLE
 * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 */

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(3);
		LinkedListUtil.appendToTail(h1, 1);
		LinkedListUtil.appendToTail(h1, 5);
		LinkedListUtil.printList(h1);
		
		ListNode h2 = new ListNode(5);
		LinkedListUtil.appendToTail(h2, 9);
		LinkedListUtil.appendToTail(h2, 4);
		LinkedListUtil.printList(h2);
		
		ListNode result = AddTwoNumbers.addTwoNumbers(h1, h2);
		LinkedListUtil.printList(result);
	}
	
	public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
		// create a dummy node as the first node of the result list
		ListNode h3 = new ListNode(-1);
		ListNode p1 = h1;
		ListNode p2 = h2;
		ListNode p3 = h3;
		
		int carry = 0;
		while (p1 != null) {
			int sum = p1.val + p2.val + carry;
			carry = sum / 10;
			sum %= 10;
			p3.next = new ListNode(sum);
			
			p1 = p1.next;
			p2 = p2.next;
			p3 = p3.next;
		}
		
		if (carry != 0) {
			p3.next = new ListNode(1);
		}
		
		return h3.next;
	}
}
