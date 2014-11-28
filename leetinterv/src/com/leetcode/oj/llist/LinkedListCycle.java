package com.leetcode.oj.llist;

/*
 * category: singly linked list
 * Given a linked list, determine if it has a cycle in it.
	Follow up:
	Can you solve it without using extra space?
	
	Discussion: We can have two pointers, let's day one called "slow"
	moves one node at a time, another one called "fast" moves two nodes at a time.
	1) a singly linked list without a cycle
	A -> B -> C -> D -> E -> F -> null
    For this sll without a cycle, the fast will hit the null first.
    
    2) a singly linked list with a cycle
    A -> B -> C -> D -> E -> F
                   ^         |
                   |_________|
    For this sll with a cycle, no pointer will ever hit a null; since once a pointer
    enters a cycle, it will circulate within that cycle, so the fast pointer will
    "catch up" with the slow one and points to the same node that the slow pointer points
    at.
 */

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast != slow) {
        	slow = slow.next;
        	fast = fast.next;
        	
        	// if fast is not null, fast moves one more node
        	if (fast != null) {
        		fast = fast.next;
        	}
        	else {
        		return false;
        	}
        }
        
        if (fast == null) {
        	return false;
        }
        else {
        	return true;
        }
    }
	
	private static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
