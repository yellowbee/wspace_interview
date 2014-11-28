package com.interviewexposed.tree;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

/*
 * 1, 2, 4, 6, 7, 9, 12
 */

public class SortedArrayToBT {
	public static void main(String[] args) {
		int[] A = {1,2,4,6,7,9,12};
		SortedArrayToBT a2b = new SortedArrayToBT();
		TreeNode root = a2b.solve(A, 0, A.length-1);
		TreeUtility.printTreeInOrder(root);
		TreeUtility.printTreeInSequence(root);
	}
	
	public TreeNode solve(int[] A, int start, int end) {
		if (start > end) return null;
		if (start == end) {
			return new TreeNode(A[start]);
		}
		
		if (A.length == 0) {
			return null;
		}
		
		// get the root
		int mid_idx = (start + end) / 2;
		TreeNode root = new TreeNode(A[mid_idx]);
		root.left = solve(A, start, mid_idx-1);
		root.right = solve(A, mid_idx+1, end);
		
		return root;
	}
}
