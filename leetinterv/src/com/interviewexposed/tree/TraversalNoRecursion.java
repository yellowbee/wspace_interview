package com.interviewexposed.tree;

import java.util.Stack;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

public class TraversalNoRecursion {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		
		/*
		 *               1
		 *              / \
		 *            2     3
		 *                 / \
		 *                4   5
		 */
		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n2.right = n4;
		
		TraversalNoRecursion nr = new TraversalNoRecursion();
		nr.preorder(root);
		TreeUtility.printTreeInSequence(root);
		
	}
	
	public void preorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) return;
		stack.push(root);
		
		while (!stack.empty()) {
			TreeNode cur = stack.pop();
			System.out.print(cur.val + " ");
			if (cur.right != null) stack.push(cur.right);
			if (cur.left != null) stack.push(cur.left);
		}
	}
}
