package com.leetcode.oj.llist;

/*
 * Discussion:
 * 1. Insert the copy of each node
 * 2. Duplicate the random pointer
 * 3. Split the two lists
 * 
 * Category: Linked List
 */

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		/*if (head.next == null) {
			RandomListNode result = new RandomListNode(head.label);
			result.next = head.next;
			result.random = head.random;
			return result;
		}*/
		
		// Insert the copy of each node
		RandomListNode ptr1 = head;
		while (ptr1 != null) {
			RandomListNode copy = new RandomListNode(head.label);
			copy.next = ptr1.next;
			ptr1.next = copy;
			ptr1 = ptr1.next.next;
		}
		
		// Duplicate the random pointer
		RandomListNode ptr2 = head;
		while (ptr2 != null) {
			if (ptr2.random == null) {
				ptr2.next.random = null;
			}
			else {
				ptr2.next.random = ptr2.random.next;
			}
			ptr2 = ptr2.next.next;
		}
		
		// Detach the list copy from the original list
		RandomListNode head_copy = head.next;
		RandomListNode ptr_orig = head;
		RandomListNode ptr_copy = head_copy;
		while (ptr_copy != null) {
			if (ptr_copy.next == null) {
				ptr_orig.next = null;
			}
			else {
				ptr_orig.next = ptr_copy.next;
				ptr_copy.next = ptr_copy.next.next;
				
				ptr_orig = ptr_orig.next;
				ptr_copy = ptr_copy.next;
			}
		}
		
		return head_copy;
    }
	
	private static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {
			this.label = x;
			next = null;
			random = null;
		}
	}
}
