package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along
 * the longest path from the root node down to the farthest leaf node.
 * 
 * Category: BT
 * Solution: Recursion
 */

public class BTMaximumDepthOfBT {
	public int maxDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        int ldep = maxDepth(root.left);
        int rdep = maxDepth(root.right);
        return Math.max(ldep+1, rdep+1);
    }
}
