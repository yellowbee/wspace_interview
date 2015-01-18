package com.carrercup.linkedlist;

import com.leetcode.oj.common.ListNode;

public class RemoveDupsInALinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		LinkedListUtil.appendToTail(head, 1);
		LinkedListUtil.appendToTail(head, 3);
		LinkedListUtil.appendToTail(head, 2);
		LinkedListUtil.appendToTail(head, 2);
		LinkedListUtil.appendToTail(head, 4);
		LinkedListUtil.printList(head);
		
		RemoveDupsInALinkedList.deleteDups2(head);
		LinkedListUtil.printList(head);
	}
	
	public static void deleteDups2(ListNode head) {
        // corner cases
        if (head == null || head.next == null) return;
        
        // tail points to the last node in the processed sub list
        ListNode tail = head;
        // current pointing to the node currently to process, after which
        // the next node is to insert
        ListNode current = head.next;
        while (current != null) {
            // check goes through all nodes that are already processed
            ListNode check = head;
            while (check != tail) {
                if (check.val == current.val) {
                    break;
                }
                check = check.next;
            }
            // only when check moves all the way to tail and
            // check.val is not equal to tail.val
            if (check == tail) {
                if (tail.val != current.val) {
                    tail.next = current;
                    tail = tail.next;
                }
            }
            current = current.next;
        }
        tail.next = null;
    }
}
