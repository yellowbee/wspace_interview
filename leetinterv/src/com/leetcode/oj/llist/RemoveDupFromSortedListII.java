package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;

public class RemoveDupFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		ListNode pre = dummy;
		ListNode cur = dummy.next;
		
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				int dup = cur.val;
				while (cur != null && cur.val == dup) {
					cur = cur.next;
				}
				pre.next = cur;
			}
			else {
				cur = cur.next;
				pre = pre.next;
			}
		}
		
		head = head.next;
		return head;
    }
}
