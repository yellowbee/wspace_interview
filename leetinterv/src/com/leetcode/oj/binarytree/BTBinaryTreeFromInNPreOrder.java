package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Category: Binary Tree
 * Solution: Recursion
 * This is similar to the problem of Construct Binary Tree From Postorder and Inorder Traversal
 */

public class BTBinaryTreeFromInNPreOrder {
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		
		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(pre, in);
		TreeUtility.printTreeInSequence(root);
		
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length) {
			return null;
		}
		return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
	
	private static TreeNode helper(int[] preorder, int start_pre, int end_pre, int[] inorder, int start_in, int end_in) {
		if (start_pre > end_pre || start_in > end_in) {
			return null;
		}
		
		int root_value = preorder[start_pre];
		int idx_root = 0;
		for (int i=start_in; i<=end_in; i++) {
			if (root_value == inorder[i]) {
				idx_root = i;
				break;
			}
		}
		int llen = idx_root - start_in;
		int rlen = end_in - idx_root;
		
		TreeNode root = new TreeNode(root_value);
		TreeNode ltree = helper(preorder, start_pre+1, start_pre+llen, inorder, start_in, start_in+llen-1);
		TreeNode rtree = helper(preorder, start_pre+llen+1, end_pre, inorder, idx_root+1, end_in);
		root.left = ltree;
		root.right = rtree;
		return root;
	}
}
