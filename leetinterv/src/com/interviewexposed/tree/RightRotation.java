package com.interviewexposed.tree;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

public class RightRotation {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		TreeNode n5 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		root.left = n4;
		root.right = n7;
		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
		n2.right = n3;
		
		TreeUtility.printTreeInSequence(root);
		RightRotation rr = new RightRotation();
		TreeNode newRoot = rr.rightRotate(root);
		TreeUtility.printTreeInSequence(newRoot);
	}
	
	public TreeNode rightRotate(TreeNode oldRoot) {
		TreeNode newRoot = oldRoot.left;
		oldRoot.left = newRoot.right;
		newRoot.right = oldRoot;
		return newRoot;
	}
}
