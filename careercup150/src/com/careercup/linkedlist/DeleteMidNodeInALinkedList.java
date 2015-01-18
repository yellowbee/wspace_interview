package com.careercup.linkedlist;

import com.leetcode.oj.common.ListNode;

public class DeleteMidNodeInALinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		LinkedListUtil.appendToTail(head, 2);
		LinkedListUtil.appendToTail(head, 3);
		LinkedListUtil.appendToTail(head, 4);
		LinkedListUtil.appendToTail(head, 5);
		LinkedListUtil.printList(head);
		
		ListNode mid = head.next.next;
		System.out.println(mid.val);
		
		DeleteMidNodeInALinkedList.deleteMidNode(mid);
		LinkedListUtil.printList(head);
	}
	
	public static void deleteMidNode(ListNode mid) {
		ListNode n = mid;
		ListNode prev = null;
		while (n.next != null) {
			n.val = n.next.val;
			prev = n;
			n = n.next;
		}
		prev.next = null;
	}
}
