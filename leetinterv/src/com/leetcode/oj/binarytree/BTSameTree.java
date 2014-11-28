package com.leetcode.oj.binarytree;

import com.leetcode.oj.common.TreeNode;

/*
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical
 * and the nodes have the same value.
 * 
 * Category: BT
 * Solution: Recursion
 */

public class BTSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
        	return q == null;
        }
        if (q == null) {
        	return p == null;
        }
        
        if (p.val != q.val) {
        	return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
