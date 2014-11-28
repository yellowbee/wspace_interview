package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

/*
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		int[] arr1 = {2,3,4,6,7};
		int[] arr2 = {1,2,4,5};
		ListNode l1 = ListUtilities.arrayToList(arr1);
		ListNode l2 = ListUtilities.arrayToList(arr2);
		MergeTwoSortedLists ml = new MergeTwoSortedLists();
		ListNode result = ml.mergeTwoLists(l1, l2);
		ListUtilities.printList(result);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		
        ListNode head = new ListNode(0); // create a dummy node
        ListNode ptr1 = l1; // points to the node to compare in list 1
        ListNode ptr2 = l2; // points to the node to compare in list 2
        ListNode eol = head; // points to the end of the merged list
        ListNode temp = null;
        
        while (ptr1 != null && ptr2 != null) {
	        if (ptr1.val < ptr2.val) {
	        	eol.next = ptr1; // let the end of merged list point to the smaller one 
	        	eol = ptr1;
	        	ptr1 = ptr1.next;
	        }
	        else {
	        	eol.next = ptr2;
	        	eol = ptr2;
	        	ptr2 = ptr2.next;
	        }
        }
        
        if (ptr1 == null) {
        	eol.next = ptr2;
        }
        else {
        	eol.next = ptr1;
        }
        
        return head.next;
    }
}
