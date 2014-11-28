package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;

/*
 * Category: Binary Tree
 * 
 * Given a binary tree and a sum, determine if the tree has a
 * root-to-leaf path such that adding up all the values along
 * the path equals the given sum.
 * 
 * Solution: Recursion
 */

public class BTPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        return pathSumHelper(root, sum, 0);
    }
	
	public boolean pathSumHelper(TreeNode node, int sum, int soFar) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) { // if node is a leaf
			if ((node.val + soFar) == sum) {
				return true;
			}
			else {
				return false;
			}
		}
		
		if (pathSumHelper(node.left, sum, node.val + soFar)) {
			return true;
		}
		else {
			return pathSumHelper(node.right, sum, node.val + soFar);
		}
	}
}
