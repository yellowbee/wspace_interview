package com.leetcode.oj.binarytree;

import java.util.ArrayList;

import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree, find its minimum depth. 
 * The minimum depth is the number of nodes along
 * the shortest path from the root node down to
 * the nearest leaf node.
 * 
 * Example:
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 *       
 * return 3
 * 
 * Category: Binary Tree
 * Solution: Recursion
 */       

public class BTMinDepthOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(11);
		TreeNode n4 = new TreeNode(13);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(1);
		
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.left = n8;
		n5.right = n9;
		
		BTMinDepthOfBinaryTree md = new BTMinDepthOfBinaryTree();
		System.out.println(md.minDepth(root));
	}
	
	public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        if (root.left == null && root.right == null) {
        	return 1;
        }
        
        if (root.left != null && root.right != null) {
        	return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
        }
        else if (root.left == null) {
        	return minDepth(root.right) + 1;
        }
        else {
        	return minDepth(root.left) + 1;
        }
    }
}
