package com.topcoder.tree;

import java.util.Stack;

import com.leetcode.oj.binarytree.BTBinaryTreeFromInNPreOrder;
import com.leetcode.oj.common.TreeNode;

/*
 * DFS of a tree using stack without recursion.
 */

public class DfsWithStack {
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		
		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(pre, in);
		DfsWithStack.pre(root);
	}
	
	public static void pre(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		
		TreeNode cur = null;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			System.out.print(cur.val);
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}
}
