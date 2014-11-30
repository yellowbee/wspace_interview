package com.amazon.llist;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

public class ReverseLinkedList {
	public static void main(String[] args) {
		
		
		int[] arr = {1,2,3,4,5,6};
		ListNode head = ListUtilities.arrayToList(arr);
		ListUtilities.printList(head);
		
		ListNode newHead = reverse(head);
		ListUtilities.printList(newHead);

	}
	
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode reversed = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return reversed;
	}
}
