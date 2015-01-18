package com.careercup.linkedlist;

import com.leetcode.oj.common.ListNode;

public class LinkedListUtil {
	public static void main(String[] args) {
        ListNode head = new ListNode(1);
        LinkedListUtil.appendToTail(head, 2);
        LinkedListUtil.appendToTail(head, 3);
        LinkedListUtil.appendToTail(head, 4);
        LinkedListUtil.appendToTail(head, 5);
        LinkedListUtil.printList(head);
        
        LinkedListUtil.printList(LinkedListUtil.delete(head, 5));
    }
    
    public static void appendToTail(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        ListNode end = head;
        
        while (end.next != null) {
            end = end.next;
        }
        end.next = newNode;
    }
    
    public static void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    
    public static ListNode delete(ListNode head, int x) {
        ListNode n = head;
        if (n == null) return null;
        
        if (n.val == x) {
            return n.next;
        }
        while (n.next != null) {
            if (n.next.val == x) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
