package com.amazon.llist;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

public class ReverseLinkedList {
	public static void main(String[] args) {
		
		
		int[] arr = {1,2,3,4,5,6};
		ListNode head = ListUtilities.arrayToList(arr);
		ListUtilities.printList(head);
		
		ListNode newHead = reverseItr(head);
		ListUtilities.printList(newHead);

	}
	
	public static ListNode reverseRec(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode reversed = reverseRec(head.next);
		head.next.next = head;
		head.next = null;
		return reversed;
	}
	
	public static ListNode reverseItr(ListNode head) {
		if (head == null || head.next == null) return head;
		
		// init the porinters
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = cur.next;
		
		while (cur != null) {
			cur.next = prev;
			
			if (next == null) break;
			prev = cur;
			cur = next;
			next = next.next;
		}
		
		return cur;
	}
}
