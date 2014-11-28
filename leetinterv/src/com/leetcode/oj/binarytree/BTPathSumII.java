package com.leetcode.oj.binarytree;

import java.util.ArrayList;

import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 *       
 *       return
 *       [
 *       	[5,4,11,2],
 *       	[5,8,4,5]
 *       ]
 *       
 * Category: Binary Tree
 * Solution: DFS, similar to the problem of Telephone Words
 */

public class BTPathSumII {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(11);
		TreeNode n4 = new TreeNode(13);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(1);
		
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.left = n8;
		n5.right = n9;
		
		BTPathSumII ps = new BTPathSumII();
		ArrayList<ArrayList<Integer>> result = ps.pathSum(root, 22);
		System.out.println(result);
		
	}
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<Integer> cur_path = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        pathSumHelper(root, sum, 0, cur_path, result);
        return result;
    }
	
	public void pathSumHelper(TreeNode node, int sum, int soFar, ArrayList<Integer> cur_path, ArrayList<ArrayList<Integer>> result) {
		if (node == null) {
			return;
		}
		
		if (node.left == null && node.right == null) {
			if ((node.val + soFar) == sum) {
				cur_path.add(new Integer(node.val));
				result.add(new ArrayList<Integer>(cur_path));
				cur_path.remove(cur_path.size()-1);
			}
		}
		else {
			cur_path.add(new Integer(node.val));
			pathSumHelper(node.left, sum, soFar+node.val, cur_path, result);
			pathSumHelper(node.right, sum, soFar+node.val, cur_path, result);
			cur_path.remove(cur_path.size()-1);
		}
	}
}
