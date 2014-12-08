package com.amazon.tree;

import com.leetcode.oj.binarytree.BTBinaryTreeFromInNPreOrder;
import com.leetcode.oj.common.TreeNode;

/*
 * Justify if a tree is balanced or not
 */

public class BalancedTree {
	public static void main(String[] args) {
		int[] pre = {4,2,1,0,3,5};
		int[] in = {0,1,2,3,4,5};
		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(pre, in);
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		
		int left = depth(root.left);
		int right = depth(root.right);
		
		if (Math.abs(left - right) <= 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int depth(TreeNode root) {
		if (root == null) return 0;
		
		int left = depth(root.left);
		int right = depth(root.right);
		
		return Math.max(left, right) + 1;
	}
}
