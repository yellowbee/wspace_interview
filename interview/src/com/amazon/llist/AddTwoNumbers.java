package com.amazon.llist;

import java.util.Stack;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

/*
 * 
 */

public class AddTwoNumbers {
	public static void main(String[] args) {
		int[] a1 = {1};
		int[] a2 = {9,9};
		ListNode l1 = ListUtilities.arrayToList(a1);
		ListNode l2 = ListUtilities.arrayToList(a2);
		
		ListNode result = addTwoNumbers(l1, l2);
		ListUtilities.printList(result);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		
		int carry = 0;
		int sum = 0;
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode result = new ListNode(0);
		ListNode p3 = result;
		
		while (p1 != null && p2 != null) {
			sum = p1.val + p2.val + carry;
			if (sum >= 10) {
				sum = sum - 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			p3.next = new ListNode(sum);
			p3 = p3.next;
			p1 = p1.next;
			p2 = p2.next;
		}
		
		ListNode p4 = null;
		if (p1 != null) {
			p4 = p1;
		}
		else if (p2 != null) {
			p4 = p2;
		}
		
		while (p4 != null) {
			sum = p4.val + carry;
			if (sum >= 10) {
				sum = sum - 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			p3.next = new ListNode(sum);
			p4 = p4.next;
			p3 = p3.next;
		}
		if (carry == 1) {
			p3.next = new ListNode(1);
		}
		
		result = result.next;
		
		return result;
    }
}
