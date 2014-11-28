package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

/*
 * Given a linked list, remove the nth node from the end of
 * list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * Solution: adding a dummy head is very helpful.
 */

public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		ListNode list = ListUtilities.arrayToList(arr);
		RemoveNthNodeFromEndOfList rn = new RemoveNthNodeFromEndOfList();
		ListNode result = rn.removeNthFromEnd(list, 1);
		ListUtilities.printList(result);
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        for (int i=0; i<n; i++) {
        	second = second.next;
        }
        
        while (second.next != null) {
        	first = first.next;
        	second = second.next;
        }
        
        first.next = first.next.next;
        
        return dummyHead.next;
    }
}
