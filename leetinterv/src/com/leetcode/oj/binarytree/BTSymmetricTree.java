package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3    3
 *     Note:
 *     Bonus points if you could solve it both recursively and iteratively.
 *     
 * Category: Binary Tree
 * Solution: Recursion
 * Note: This problem can also be solved using a non-recursive/iterative
 * (using level order) algorithm.
 */

public class BTSymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
    }
	
	// recursive helper method to decide whether two (sub)trees are symmetric
	public boolean helper(TreeNode ltree, TreeNode rtree) {
		// check if both roots are null
		if (ltree == null) {
			return (rtree == null);
		}
		if (rtree == null) {
			return (ltree == null);
		}
		
		// if neither root is null, check if they have the same value
		if (ltree.val != rtree.val) {
			return false;
		}
		
		// recursively call to decide if
		// 1. the left subtree of the left subtree is symmetric with the right subtree of the right subtree
		// 2. the right subtree of the left subtree is symmetric with the left subtree of the right subtree
		return helper(ltree.left, rtree.right) && helper(ltree.right, rtree.left);
	}
}
