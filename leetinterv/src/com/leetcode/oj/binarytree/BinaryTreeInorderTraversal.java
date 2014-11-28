package com.leetcode.oj.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		
		HashSet<TreeNode> set = new HashSet<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode cur = stack.pop();
        	
        	// if cur node is a leaf
        	if (cur.left == null && cur.right == null) {
        		result.add(cur.val);
        		continue;
        	}
        	// if cur node's subtrees have been inserted in the stack
        	if (set.contains(cur)) {
        		result.add(cur.val);
        		continue;
        	}
        	
        	if (cur.right != null) {
        		stack.push(cur.right);
        	}
        	stack.push(cur);
        	if (cur.left != null) {
        		stack.push(cur.left);
        	}
        	set.add(cur);
        }
		return result;
    }
}
