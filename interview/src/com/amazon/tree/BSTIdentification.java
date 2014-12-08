package com.amazon.tree;

import com.leetcode.oj.binarytree.BTBinaryTreeFromInNPreOrder;
import com.leetcode.oj.common.TreeNode;

/*
 * Implement a function to validate whether a given binary tree is a BST
 * (i.e. write an isBST() function).
 * 
 * Solution: print out the tree to see if the result is a
 * non-decreasing sequence.
 */

public class BSTIdentification {
	public static void main(String[] args) {
		/*int[] preorder = {4,2,1,3,6,5,0};
		int[] inorder = {1,2,3,4,5,6,0};
		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(preorder, inorder);*/
		int[] serialized = {5,3,7,2,4,6,8,0,0,0,0,0,0,0,0};
		TreeNode root = DeSerialization.deserialize(serialized);
		System.out.println(isBst(root));
	}
	
	public static boolean isBst(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean helper(TreeNode root, int min, int max) {
		if (root == null) return true;
		if (root.val < min || root.val > max) return false;

		return helper(root.left, min, root.val-1) && helper(root.right, root.val+1, max);
	}
}
