package com.leetcode.oj.binarytree;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * category: Binary Tree Operation
 */

public class BTPostorderTraversal {
	private ArrayList<Integer> result = new ArrayList<Integer>();
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		postTraverse(root);
		return result;
    }
	
	private void postTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		
		postTraverse(root.left);
		postTraverse(root.right);
		result.add(new Integer(root.val));
	}
	
	public static void main(String[] args) {
		BTPostorderTraversal btp = new BTPostorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		ArrayList<Integer> result = btp.postorderTraversal(root);
		System.out.println(result.toString());
	}
	/**
	 * Definition for binary tree
	 */ 
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

}
