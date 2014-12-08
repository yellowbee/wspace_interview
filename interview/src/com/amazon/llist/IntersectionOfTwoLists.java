package com.amazon.llist;

import com.leetcode.oj.common.ListNode;

public class IntersectionOfTwoLists {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n6;
		n6.next = n7;
		n7.next = null;
		
		n4.next = n5;
		n5.next = n6;
		
		findIntersection(n2, n4);
		
	}
	
	public static void findIntersection(ListNode head1, ListNode head2) {
		int len1 = 1;
		int len2 = 1;
		ListNode p1 = head1;
		ListNode p2 = head2;
		
		while (p1 != null) {
			p1 = p1.next;
			len1++;
		}
		while (p2 != null) {
			p2 = p2.next;
			len2++;
		}
		
		if (len1 > len2) {
			int diff = len1 - len2;
			p1 = head1;
			for (int i=0; i<diff; i++) {
				p1 = p1.next;
			}
			p2 = head2;
		}
		else if (len2 > len1) {
			int diff = len2 - len1;
			p2 = head2;
			for (int i=0; i<diff; i++) {
				p2 = p2.next;
			}
			p1 = head1;
		}
		else {
			p1 = head1;
			p2 = head2;
		}
		
		while (p1 != null) {
			if (p1 == p2) {
				break;
			}
			else {
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		
		System.out.println(p1.val);
	}
}
