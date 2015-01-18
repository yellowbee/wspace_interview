package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

public class RemoveDupFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		
		ListNode prev = head;
		ListNode cur = head.next;
		
		while (cur != null) {
			if (prev.val == cur.val) {
				prev.next = cur.next;
				cur = prev.next;
			}
			else {
				prev = cur;
				cur = cur.next;
			}
		}
		
		return head;
    }
}
