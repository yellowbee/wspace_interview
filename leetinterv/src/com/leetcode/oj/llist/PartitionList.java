package com.leetcode.oj.llist;

import com.leetcode.oj.common.ListNode;

/*
 * Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each
 * of the two partitions.For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * Solution: Locate the first node (let's call it insertion node) that has a value greater than or equal to x;
 *           Insert all nodes with a value less than x in front of the insertion node.
 */

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if (head == null) {
        	return null;
        }
        
        // add a dummy node at the front of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // find the first node value that's greater than/equal to x
        ListNode ins_pos = dummy;
        while (ins_pos.next != null && ins_pos.next.val < x) {
        	ins_pos = ins_pos.next;
        }
        if (ins_pos.next == null) {
        	return head.next;
        }
        
        // reorder
        ListNode pre = ins_pos.next;
        ListNode cur = pre.next;
        while (pre != null && cur != null) {
        	if (cur.val < x) {
        		// insert the current node after the insert point
        		pre.next = cur.next;
        		cur.next = ins_pos.next;
        		ins_pos.next = cur;
        		ins_pos = ins_pos.next;
        		
        		// move traversal pointers(pre/cur) forward
        		cur = pre.next;
        	}
        	else {
        		// move traversal pointers(pre/cur) forward
        		pre = pre.next;
        		if (pre != null) {
        			cur = pre.next;
        		}
        	}
        }
        
        // remove the dummy node
        head = head.next;
        return head;
    }
}
