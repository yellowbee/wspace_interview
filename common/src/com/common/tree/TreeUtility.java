package com.common.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtility {
	public static void main(String[] args) {
		char[] serialized = {'*', '1', '-', '#', '#', '5', '8', '#', '#', '#', '#'};
		TreeNode root = TreeUtility.deserialize(serialized);
		TreeUtility.printTreeInSequence(root);
	}
	
	public static void printTreeInOrder(TreeNode root) {
		if (root == null) return;
		
		printTreeInOrder(root.left);
		System.out.print(root.val + " ");
		printTreeInOrder(root.right);
	}
	
	public static void printTreePreOrder(TreeNode root) {
		if (root == null) return;
		
		System.out.print(root.val + " ");
		printTreePreOrder(root.left);
		printTreePreOrder(root.right);
	}
	
	public static void printTreeInSequence(TreeNode root) {
		if (root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		System.out.println();
		while (!q.isEmpty()) {
			TreeNode cur = q.remove();
			if (cur.val != '#') {
				System.out.print(cur.val + ",");
				if (cur.left != null) {
					q.add(cur.left);
				}
				else {
					q.add(new TreeNode('#'));
				}
				if (cur.right != null) {
					q.add(cur.right);
				}
				else {
					q.add(new TreeNode('#'));
				}
			}
			else {
				System.out.print("#,");
			}
		}
		System.out.println();
	}
	
	public static TreeNode deserialize(char[] serialized) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(serialized[0]);
		queue.add(root);
		
		int n = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (serialized[n] != '#') {
				node.left = new TreeNode(serialized[n]);
				queue.add(node.left);
			}
			else {
				node.left = null;
			}
			n++;
			if (serialized[n] != '#') {
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
