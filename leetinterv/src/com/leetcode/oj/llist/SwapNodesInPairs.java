package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify
 * the values in the list, only nodes itself can be changed.
 * 
 * Notes: Often times, in the case of linked list, adding a dummy head node
 * will be very helpful.
 * 
 * dummy_head -> 1 -> 2 -> 3 -> 4 -> null;
 *      ^        ^    ^
 *      |        |    |
 *    prev     first second
 */

public class SwapNodesInPairs {
	public static void main(String[] args) {
		ListNode head = ListUtilities.arrayToList(new int[]{});
		SwapNodesInPairs sn = new SwapNodesInPairs();
		ListNode newHead = sn.swapPairs(head);
		ListUtilities.printList(newHead);
	}
	
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return head;
		}
		else if (head.next == null) {
			return head;
		}
		ListNode dummy_head = new ListNode(0);
		dummy_head.next = head;
		
        ListNode previous = dummy_head;
        ListNode first = previous.next;
        ListNode second = first.next;
        
        while (second != null) {
        	first.next = second.next;
        	second.next = first;
        	previous.next = second;
        	
        	previous = first;
        	first = previous.next;
        	if (first != null) {
        		second = first.next;
        	}
        	else {
        		break;
        	}
        }
        
        return dummy_head.next;
    }
}
