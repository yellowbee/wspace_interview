package com.common.tree;

public class TreeNode {
	public char val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(char x) {
		val = x;
		left = null;
		right = null;
	}
	
	@Override
	public String toString() {
		return String.valueOf(val);
	}
}
