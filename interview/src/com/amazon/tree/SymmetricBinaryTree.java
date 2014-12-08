package com.amazon.tree;

import com.leetcode.oj.binarytree.BTBinaryTreeFromInNPreOrder;
import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

public class SymmetricBinaryTree {
	public static void main(String[] args) {
		int[] preorder = {5,3,2,9,4,3,4,2,9};
		int[] inorder = {9,2,3,4,5,4,3,2,9};
		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(preorder, inorder);
		TreeUtility.printTreeInSequence(root);
		System.out.println();
		System.out.println(isSymmetric(root));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isMirror(root.left, root.right);
	}
	
	private static boolean isMirror(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) return true;
		if (root1 == null && root2 != null || root1 != null && root2 == null) return false;
		if (root1.val != root2.val) return false;
		
		return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}
}
