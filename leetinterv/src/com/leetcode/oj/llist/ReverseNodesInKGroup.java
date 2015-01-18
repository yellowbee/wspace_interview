package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		ListNode head = ListUtilities.arrayToList(arr);
		ListUtilities.printList(head);
		
		ListNode result = ReverseNodesInKGroup.reverseKGroup(head, 1);
		/*ListNode left = head;
		ListNode right = head.next.next.next.next;*/
		//ListNode right = null;
		
		//System.out.println(ReverseNodesInKGroup.reverse(left, right).val);
		ListUtilities.printList(result);
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) return head;
		
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode left = dummy;
        ListNode right = dummy;
        int count = 0;
        while (left != null && right != null) {
        	right = right.next;
        	count++;
        	if (count % k == 0) {
        		if (right == null) break;
        		right = right.next;
        		left = reverse(left, right);
        		right = left;
        	}
        }
        
        return dummy.next;
    }
	
	// reverse range
	// input :  ... left -> 2 -> 3 -> 4 -> right ...
	// results: ... left -> 4 -> 3 -> 2 -> right
	// output : reference to '2'
	public static ListNode reverse(ListNode left, ListNode right) {
		ListNode last = left.next;
		
		ListNode prev = left.next;
		ListNode cur = prev.next;
		ListNode next = cur.next;
		
		while (cur != right) {
			cur.next = prev;
			prev = cur;
			cur = next;
			if (cur != null) {
				next = cur.next;
			}
		}
		
		left.next.next = right;
		left.next = prev;
		
		return last;
	}
}
