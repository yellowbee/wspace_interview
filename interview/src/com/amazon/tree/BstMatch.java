package com.amazon.tree;

import com.leetcode.oj.binarytree.BTBinaryTreeFromInNPreOrder;
import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

/*
 * Given two BSTs, check if they are equal.
 */

public class BstMatch {
	public static void main(String[] args) {
		int[] pre1 = {1,2,4,5,8,9,3,6,7};
		int[] in1 = {4,2,8,5,9,1,6,3,7};
		TreeNode root1 = BTBinaryTreeFromInNPreOrder.buildTree(pre1, in1);
		
		int[] pre2 = {1,2,4,5,8,9,3,6,7,10};
		int[] in2 = {4,2,8,5,9,1,6,3,7,10};
		TreeNode root2 = BTBinaryTreeFromInNPreOrder.buildTree(pre2, in2);
		
		TreeUtility.printTreeInSequence(root1);
		TreeUtility.printTreeInSequence(root2);
		System.out.println();
		System.out.println(isEqual(root1, root2));
	}
	
	public static boolean isEqual(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		
		if (root1 != null && root2 == null || root1 == null && root2 != null) {
			return false;
		}
		
		if (root1.val != root2.val) {
			return false;
		}
		else {
			return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
		}
	}
}
