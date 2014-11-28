package com.tripadvisor;

import java.util.Stack;

import com.leetcode.oj.common.TreeNode;

/*
 * Check if a tree is a symmetric tree, using iteration.
 * A recursive solution is in leetcode package.
 */

public class SymmetricTree {
	
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) return true;

		Stack<TreeNode> stack_left = new Stack<TreeNode>();
		Stack<TreeNode> stack_right = new Stack<TreeNode>();
		
		stack_left.push(root.left);
		stack_right.push(root.right);
		
		while (!stack_left.isEmpty() && !stack_right.isEmpty()) {
			TreeNode left = stack_left.pop();
			TreeNode right = stack_right.pop();
			
			if (left == null && right == null) continue;
			if (left == null || right == null) return false;
			if (left.val != right.val) return false;
			
			stack_left.push(left.left);
			stack_left.push(left.right);
			stack_right.push(right.right);
			stack_right.push(right.left);
		}
		
		return true;
	}
}
