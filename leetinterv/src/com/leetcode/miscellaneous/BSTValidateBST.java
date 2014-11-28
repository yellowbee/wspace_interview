package com.leetcode.miscellaneous;

import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Category: BST
 * Solution: Recursion
 * Recursively check each node to see if its value is between min and max
 * 1. if the node is the left tree of its parent, max = parent.val, min = parent's min
 * 2. if the node if the right tree of its parent, max = parent's max, min = parent.val
 */

public class BSTValidateBST {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	public boolean helper(TreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.val <= min || node.val >= max) {
			return false;
		}
		
		return helper(node.left, min, node.val) && helper(node.right, node.val, max);
	}
}
