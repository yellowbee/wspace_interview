package com.leetcode.oj.common;

public class ListUtility {
	
	public static void printList(ListNode node) {
		ListNode cur = node;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}
}
