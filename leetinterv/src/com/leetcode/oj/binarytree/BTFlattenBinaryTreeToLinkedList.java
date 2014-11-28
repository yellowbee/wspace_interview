package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;

/*
 * Category: Binary Tree
 * Solution: Recursion
 */

public class BTFlattenBinaryTreeToLinkedList {
	
	public void flatten(TreeNode root) {
        convertToFlat(root);
    }
	
	public TreeNode convertToFlat(TreeNode node) {
		if (node == null) {
			return null;
		}
		if ((node.left==null && node.right==null)) {
        	return node;
        }
		
		TreeNode lhead = convertToFlat(node.left);
		TreeNode lend = null;
		if (lhead != null) {
			lend = lhead;
			while (lend.right != null) {
				lend = lend.right;
			}
		}
		
		TreeNode rhead = convertToFlat(node.right);
		
		node.left = null;
		
		if (lhead != null) {
			node.right = lhead;
			lend.right = rhead;
		}
		else {
			node.right = rhead;
		}
		
		return node;
	}
}
