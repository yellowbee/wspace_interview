package com.leetcode.oj.dfs;

import com.leetcode.oj.common.TreeNode;

public class SumRootToLeafNumbers2ndV {
	public int sumNumbers(TreeNode root) {
		int[] sum = {0};
		helper(root, 0, sum);
		return sum[0];
    }
	
	public void helper(TreeNode node, int so_far, int[] sum) {
		if (node == null) {
			return;
		}
		
		if (node.left != null) {
			helper(node.left, so_far*10+node.val, sum);
		}
		if (node.right != null) {
			helper(node.right, so_far*10+node.val, sum);
		}
		if (node.left == null && node.right == null) {
			sum[0] += so_far * 10 + node.val;
		}
	}
}
