package com.leetcode.oj.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtility {
	public static void printTreeInOrder(TreeNode root) {
		if (root == null) return;
		
		printTreeInOrder(root.left);
		System.out.print(root.val + " ");
		printTreeInOrder(root.right);
	}
	
	public static void printTreeInSequence(TreeNode root) {
		if (root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		System.out.println();
		while (!q.isEmpty()) {
			TreeNode cur = q.remove();
			if (cur.val != -1) {
				System.out.print(cur.val + ",");
				if (cur.left != null) {
					q.add(cur.left);
				}
				else {
					q.add(new TreeNode(-1));
				}
				if (cur.right != null) {
					q.add(cur.right);
				}
				else {
					q.add(new TreeNode(-1));
				}
			}
			else {
				System.out.print("#,");
			}
		}
		System.out.println();
	}
}
