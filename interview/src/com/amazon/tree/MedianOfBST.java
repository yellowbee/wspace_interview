package com.amazon.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.leetcode.oj.common.TreeNode;

/*
 * find the media of BST
 * 
 * Solution:
 * Method 1: get the in-order sequence of the BST in a list, then output the media
 */

public class MedianOfBST {
	public static void main(String[] args) {
		int[] serialized = {4,2,6,1,3,5,7,0,0,0,0,0,0,0,8,0,0};
		TreeNode root = DeSerialization.deserialize(serialized);
		System.out.println(findMedian(root));
	}
	
	public static double findMedian(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		Set<TreeNode> set = new HashSet<TreeNode>(); 
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left == null && node.right == null) {// leaf
				list.add(node);
				continue;
			}
			if (set.contains(node)) {// children already pushed
				list.add(node);
				continue;
			}
			if (node.right != null) {
				stack.push(node.right);
			}
			stack.push(node);
			set.add(node);
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		
		int len = list.size();
		if (len % 2 == 0) {
			return (double)(list.get((len-1)/2).val + list.get((len-1)/2+1).val) / 2;
		}
		else {
			return list.get((len-1)/2).val;
		}
	}
}
