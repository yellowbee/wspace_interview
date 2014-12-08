package com.amazon.tree;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

/*
 * make a function that counts the number of nodes in a tree
 */

public class CountNumOfNode {
	public static void main(String[] args) {
		int[] serialized = {1,2,3,4,0,0,5,0,0,0,0};
		TreeNode root = DeSerialization.deserialize(serialized);
		TreeUtility.printTreeInSequence(root);
		
		System.out.println(countNodes(root));
	}
	
	public static int countNodes(TreeNode root) {
		if (root == null) return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
}
