package com.leetcode.oj.binarytree;

import java.util.Stack;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

/*
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and
 * uses O(h) memory, where h is the height of the tree.
 */

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	private TreeNode prev = null;

	public BSTIterator(TreeNode root) {
        if (root != null) {
        	stack.push(root);
        }
    }

	public static void main(String[] args) {
		int[] serialized = {10,6,15,5,8,12,18,0,0,0,9,0,0,0,0,0,0};
		TreeNode root = TreeUtility.deserialize(serialized);
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println();
	}
	
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty()) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = stack.pop();
    	if (prev == null) { // looking for the 1st node of the iteration
    		while (node.left != null) {
    			if (node.right != null) {
    				this.stack.push(node.right);
    			}
    			
    			this.stack.push(node);
    			node = node.left;
    		}
    		if (node.right != null) {
    			this.stack.push(node.right);
    		}
    		this.prev = node;
			return this.prev.val;
    	}
    	else {
    		if (node == this.prev.right) {// current is predecessor's right child
    			while (node.left != null) {
        			if (node.right != null) {
        				this.stack.push(node.right);
        			}
        			
        			this.stack.push(node);
        			node = node.left;
        		}
        		if (node.right != null) {
        			this.stack.push(node.right);
        		}
        		this.prev = node;
    			return this.prev.val;
    		}
    		else {// otherwise
    			this.prev = node;
    			return this.prev.val;
    		}
    	}
    }
}
