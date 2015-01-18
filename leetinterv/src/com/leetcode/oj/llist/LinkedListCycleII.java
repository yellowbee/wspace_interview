package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;

/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * Solution:
 * Note: TOO SLOW!
 */

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        
        while (first != null && second != null) {
        	first = first.next;
        	second = second.next;
        	if (second != null) {
        		second = second.next;
        	}
        	if (first == second) break;
        }
        
        if (second == null) return null;
        
        first = head;
        while (first != second) {
        	first = first.next;
        	second = second.next;
        }
        
        return second;
    }
}
