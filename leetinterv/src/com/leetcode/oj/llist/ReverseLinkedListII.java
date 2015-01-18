package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

/*
 * Using a dummy node in linked list algorithm sometimes
 * can simplify the problem at hand a lot.
 */

public class ReverseLinkedListII {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		ListNode head = ListUtilities.arrayToList(arr);
		ListNode newhead = ReverseLinkedListII.reverseBetween(head, 2, 5);
		ListUtilities.printList(newhead);
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		// use a dummy head node
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		
        ListNode left = head;
        ListNode prev = null;
        ListNode cur = null;
        ListNode next = null;
        
        // immediately to the left of the mth node
        for (int i=1; i<=m-1; i++) {
        	left = left.next;
        }
        
        cur = left.next;       
        next = cur.next;
        for (int i=1; i<=(n-m); i++) {
        	prev = cur;
        	cur = next;
        	next = cur.next;
        	
        	cur.next = prev;
        }
     
        left.next.next = next;
    	left.next = cur;
        
        return head.next;
    }
}
