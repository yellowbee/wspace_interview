package com.leetcode.oj.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;


public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		RecoverBinarySearchTree bt = new RecoverBinarySearchTree();
		int[] serialized = {5,3,4,1,8,6,9,0,0,0,0,0,0,0,0};
		TreeNode root = TreeUtility.deserialize(serialized);
		TreeUtility.printTreeInOrder(root);
		bt.recoverTree(root);
		System.out.println();
		TreeUtility.printTreeInOrder(root);
	}
	
	public void recoverTree(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode predessor = null;
        
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
        	if (cur.left != null) {
        		pre = cur.left;
        		while (pre.right != null && pre.right != cur) {
        			pre = pre.right;
        		}
        		if (pre.right == null) {// not threaded yet
        			pre.right = cur;
        			cur = cur.left;
        		}
        		else {// threaded already
        			if (predessor != null) {
            			if (predessor.val > cur.val) {
            				list.add(predessor);
            				list.add(cur);
            			}
            		}
            		predessor = cur;
            		pre.right = null;
        			cur = cur.right;
        		}
        		
        	}
        	else {
        		if (predessor != null) {
        			if (predessor.val > cur.val) {
        				list.add(predessor);
        				list.add(cur);
        			}
        		}
        		predessor = cur;
    			cur = cur.right;
        	}
        }
        if (!list.isEmpty()) {
        	int temp = list.get(0).val;
        	list.get(0).val = list.get(list.size()-1).val;
        	list.get(list.size()-1).val = temp;
        }
    }
}
