package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Category: Binary Tree, Traversal
 * Solution: Recursion
 * Given the inorder and postorder sequences of a BT, firstly get the root at the
 * end of the postorder sequence; find the position of the root in the inorder sequence;
 * separate the left subtree sequence and right subtree sequence in the inorder sequence;
 * Construct the left subtree and right subtree recursively.
 * 
 */

public class BTBinaryTreeFromInNPostOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length != postorder.length) {
			return null;
		}
		if (inorder.length == 0 || postorder.length == 0) {
			return null;
		}
        return buildTreeHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        
    }
	
	public TreeNode buildTreeHelper(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {
		if (in_start > in_end || post_start > post_end) {
			return null;
		}
		
		// The last element of the post order sequence is the root.
		int root_value = postorder[post_end];
		TreeNode root = new TreeNode(root_value);
		
		// looking for the position of the root in inroder sequence
		int idx_root = 0;
		for (int i=in_start; i<=in_end; i++) {
			if (inorder[i] == root_value) {
				idx_root = i;
				break;
			}
		}
		int len_ltree = idx_root - in_start;
		int len_rtree = in_end - idx_root;
		
		TreeNode ltree = buildTreeHelper(inorder, in_start, idx_root-1, postorder, post_start, post_start+len_ltree-1);
		TreeNode rtree = buildTreeHelper(inorder, idx_root+1, in_end, postorder, post_start+len_ltree, post_end-1);
		
		root.left = ltree;
		root.right = rtree;
		return root;
	}
}
