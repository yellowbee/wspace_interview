package com.leetcode.miscellaneous;

import com.leetcode.oj.common.TreeNode;

/*
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * Category: BST
 * Solution: Recursion
 */

public class BSTConvertSortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		return helper(num, 0, num.length-1);
	}
	
	public TreeNode helper(int[] num, int start, int end) {
		if (start == end) {
			return new TreeNode(num[start]);
		}
		if (start > end) {
			return null;
		}
		
		// break the array into a mid node and two halves
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, start, mid-1);
		root.right = helper(num, mid+1, end);
		
		return root;
	}
}
