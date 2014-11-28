package com.leetcode.miscellaneous;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.TreeNode;

/*
 * Given a singly linked list where elements are sorted in
 * ascending order, convert it to a height balanced BST.
 * 
 * Category: BST
 * Solution: Recursion, bottom-up
 * If you are given an array, the problem is quite straightforward.
 * But things get a little more complicated when you have a singly
 * linked list instead of an array. Now you no longer have random
 * access to an element in O(1) time. Therefore, you need to create
 * nodes bottom-up, and assign them to its parents. The bottom-up
 * approach enables us to access the list in its order at the same
 * time as creating nodes.
 */

public class BSTConvertSortedListToBST {
	public static ListNode list;
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		
		BSTConvertSortedListToBST csbst = new BSTConvertSortedListToBST();
		//System.out.println(csbst.getLength(head));
		//System.out.println(head.val);
		TreeNode root = csbst.sortedListToBST(head);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}
	
	public TreeNode sortedListToBST(ListNode head) {
        int len = getLength(head);
        list = head;
        return convertHelper(0, len-1);
    }
	
	public int getLength(ListNode node) {
		int len = 0;

		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
	
	public TreeNode convertHelper(int start, int end) {
		if (start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode ltree = convertHelper(start, mid-1);
		TreeNode root = new TreeNode(list.val);
		list = list.next;
		TreeNode rtree = convertHelper(mid+1, end);
		
		root.left = ltree;
		root.right = rtree;
		return root;
	}
}
