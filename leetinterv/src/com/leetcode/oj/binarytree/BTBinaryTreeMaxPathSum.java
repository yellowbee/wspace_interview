package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;

/*
 * Category: Binary Tree, recursion
 */

public class BTBinaryTreeMaxPathSum {
	public int maxV;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		
		BTBinaryTreeMaxPathSum btp = new BTBinaryTreeMaxPathSum();
		System.out.println(btp.maxPathSum(root));
	}
	
	public int maxPathSum(TreeNode root) {
        maxV = (root == null) ? 0 : root.val;
        findMax(root);
        return maxV;
    }
	
	public int findMax(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int left = Math.max(findMax(node.left), 0);
		int right = Math.max(findMax(node.right), 0);
		maxV = Math.max(maxV, node.val + left + right);
		
		return Math.max(node.val + left, node.val + right);
	}
}