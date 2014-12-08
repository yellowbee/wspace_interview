package com.amazon.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

public class DeSerialization {
	public static void main(String[] args) {
		int[] serialized = {5,3,3,2,4,4,2,9,0,0,0,0,0,0,9,0,0,0,0};
		TreeNode root = deserialize(serialized);
		TreeUtility.printTreeInSequence(root);
	}
	
	public static TreeNode deserialize(int[] serialized) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(serialized[0]);
		queue.add(root);
		
		int n = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (serialized[n] != 0) {
				node.left = new TreeNode(serialized[n]);
				queue.add(node.left);
			}
			else {
				node.left = null;
			}
			n++;
			if (serialized[n] != 0) {
				node.right = new TreeNode(serialized[n]);
				queue.add(node.right);
			}
			else {
				node.right = null;
			}
			n++;
		}
		
		return root;
	}
	
	
}
