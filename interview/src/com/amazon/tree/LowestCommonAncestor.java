package com.amazon.tree;

import com.leetcode.oj.binarytree.BTBinaryTreeFromInNPreOrder;
import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

/*
 * Find the lowest common ancestor of two nodes in a tree.
 * Solution: only one traversal is needed if using recursion.
 */

public class LowestCommonAncestor {
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,8,9,3,6,7};
		int[] in = {4,2,8,5,9,1,6,3,7};

		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(pre, in);
		TreeUtility.printTreeInSequence(root);
		
		System.out.println();
		
		TreeNode result = findLCA(root, 8, 9);
		System.out.println(result.val);
	}
	
	public static TreeNode findLCA(TreeNode root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		
		if (root.val == n1 || root.val == n2) {
			return root;
		}
		
		TreeNode left = findLCA(root.left, n1, n2);
		TreeNode right = findLCA(root.right, n1, n2);
		
		if (left != null && right != null) {// n1 and n2 belong to left tree and right tree respectively
			return root;
		}
		
		return left != null ? findLCA(left, n1, n2) : findLCA(right, n1, n2);
	}
}
