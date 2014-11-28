package com.leetcode.oj.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *  return its level order traversal as:
 *  [
 *  	[3],
 *  	[9,20],
 *  	[15,7]
 *  ]
 *  
 *  Category: Binary Tree
 *  Solution: BFS
 */

public class BTBinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> level = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> cur_level = new LinkedList<TreeNode>();
		Queue<TreeNode> next_level = new LinkedList<TreeNode>();
		Queue<TreeNode> temp = null;
		cur_level.add(root);
		while (!cur_level.isEmpty()) {
			TreeNode node = cur_level.remove();
			level.add(new Integer(node.val));
			
			if (node.left != null) {
				next_level.add(node.left);
			}
			if (node.right != null) {
				next_level.add(node.right);
			}
			
			if (cur_level.isEmpty()) {
				result.add(level);
				level = new ArrayList<Integer>();
				temp = cur_level;
				cur_level = next_level;
				next_level = temp;
			}
		}
		return result;
    }
}
