package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined
 * as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * 
 * Category: Binary Tree
 * Solution: Recursion
 */

public class BTBalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (depth(root) == -1) {
			return false;
		}
		return true;
    }
	
	public int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int ldepth = depth(node.left);
		if (ldepth == -1) return -1;
		int rdepth = depth(node.right);
		if (rdepth == -1) return -1;
		
		// if the depth of one subtree is greater than the depth
		// of another subtree by more than 1
		if (Math.abs(ldepth - rdepth) > 1) {
			return -1;
		}
		
		// return the greater depth of two subtrees plus one
		// which is supposed to be the depth of the current node
		return Math.max(ldepth + 1, rdepth + 1);
	}
}
