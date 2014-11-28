package com.leetcode.oj.llist;

/*
 * Given a list, rotate the list to the right by k places,
 * where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * Solution: the key is to find the (k+1)th node from the end
 * of list;
 */

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

public class RotateList {
	public static void main(String[] args) {
		int[] arr = {1,2};
		ListNode head = ListUtilities.arrayToList(arr);
		ListNode result = new RotateList().rotateRight(head, 3);
		ListUtilities.printList(result);
	}
	
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		
		int len = 0;
		ListNode ptr = head;
		while (ptr != null) {
			len++;
			ptr = ptr.next;
		}
		
		int k = n%len;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        int count = 1;
        while (count <= k && ptr2 != null) {
        	ptr2 = ptr2.next;
        	count++;
        }
        
        while (ptr2 != null && ptr2.next != null) {
        	ptr1 = ptr1.next;
        	ptr2 = ptr2.next;
        }
        
        if (ptr2 == null) {
        	return head;
        }
        
        ptr2.next = head;
        head = ptr1.next;
        ptr1.next = null;
        
        return head;
    }
}
