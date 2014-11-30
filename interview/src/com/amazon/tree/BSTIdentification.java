package com.amazon.tree;

import com.leetcode.oj.binarytree.BTBinaryTreeFromInNPreOrder;
import com.leetcode.oj.common.TreeNode;

/*
 * Implement a function to validate whether a given binary tree is a BST
 * (i.e. write an isBST() function).
 * 
 * Solution: recursion, or print out the tree to see if the result is a
 * non-decreasing sequence.
 */

public class BSTIdentification {
	public static void main(String[] args) {
		int[] preorder = {4,2,1,3,6,5,0};
		int[] inorder = {1,2,3,4,5,6,0};
		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(preorder, inorder);
		System.out.println(isBst(root));
	}
	
	public static boolean isBst(TreeNode root) {
		if (root == null) return true;

		if (root.left != null && root.val <= root.left.val) {
			return false;
		}
		if (root.right != null && root.val >= root.right.val) {
			return false;
		}
		
		return isBst(root.left) && isBst(root.right);
	}
}
