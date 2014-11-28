package com.leetcode.oj.common;

public class ListUtilities {
	public static ListNode arrayToList(int[] arr) {
		if (arr.length == 0) {
			return null;
		}
		
		ListNode head = new ListNode(arr[0]);
		ListNode ptr_cur = head;
		for (int i=1; i<arr.length; i++) {
			ptr_cur.next = new ListNode(arr[i]);
			ptr_cur = ptr_cur.next;
		}
		return head;
	}
	
	public static void printList(ListNode list) {
		ListNode cur = list;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}
}
