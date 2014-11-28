package com.leetcode.oj.llist;

/*
 * Category: Singly Linked List
 * 
 * Discussion:
 * Solution is put into 3 steps
 * 1) split the original list into two halves
 * 2) reverse the second half
 * 3) merge the two lists
 */

public class ReorderList {
	
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(7);
		list1.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		ListNode list2 = new ListNode(7);
		ListNode n7 = new ListNode(8);
		ListNode n8 = new ListNode(9);
		list2.next = n7;
		n7.next = n8;

		ReorderList rl = new ReorderList();
		//ReorderList.printList(rl.merge(list2, list1));

		//ReorderList.printList(rl.split(list1));
		//ReorderList.printList(list1);
		rl.reorderList(list1);
	}
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode head1 = split(head);
		//ReorderList.printList(head);
		//ReorderList.printList(head1);
		
		ListNode reversed_head1 = reverse(head1);
		//ReorderList.printList(reversed_head1);
		
		merge(head, reversed_head1);
		//ReorderList.printList(head);
    }
	
	public ListNode split(ListNode list) {
		if (list == null || list.next == null) {
			return list;
		}
		ListNode slow = list;
		ListNode fast = list.next;
		while (fast.next!= null) {
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
			}
			slow = slow.next;
		}
		ListNode temp = slow;
		slow = slow.next;
		temp.next = null;
		return slow;
	}
	
	/*
	 * This method reverses a singly linked list.
	 */
	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode cur = head;
		ListNode pre = cur.next;
		cur.next = null;
		while (pre != null) {
			ListNode temp = pre.next;
			pre.next = cur;
			cur = pre;
			pre = temp;
		}
		return cur;
	}
	
	/*
	 * This method merge two singly linked lists alternatively
	 * with the first node of the first list as the first node
	 * of the new merged list.
	 */
	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode first = list1;
		ListNode second = list2;
		ListNode temp = null;
		
		while (second != null) {
			// if the last node of the 1st list is met
			if (first.next == null) {
				first.next = second;
				return list1;
			}
			
			temp = second.next;
			second.next = first.next;
			first.next = second;
			first = second.next;
			second = temp;
		}
		return list1;
	}
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static void printList(ListNode node) {
		ListNode cur = node;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();
	}
}
