package com.leetcode.oj.binarytree;

import java.util.Stack;
import com.leetcode.oj.common.TreeNode;

/*
 * Given a binary tree containing digits from 0-9 only,
 * each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,

    1
   / \
  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 * Category: Binary Tree --> in-order DFS
 * Solution: Recursion
 */

public class BTSumRoottoLeafNumbers {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		
		BTSumRoottoLeafNumbers scr = new BTSumRoottoLeafNumbers();
		System.out.println(scr.sumNumbers(root));
	}
	
	public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        Stack<Integer> s = new Stack<Integer>();
        addRoot2LeafPath(root, s, sum);
        return sum[0];
    }
	
	
	public void addRoot2LeafPath(TreeNode r, Stack<Integer> s, int[] sum) {
		if (r == null) {
			return;
		}
		if (r.left!=null || r.right!=null) {
			s.push(new Integer(r.val));
			addRoot2LeafPath(r.left, s, sum);
			addRoot2LeafPath(r.right, s, sum);
			s.pop();
		}
		else {
			s.push(new Integer(r.val));
			int pSum = 0;
			for (int i=0; i<s.size(); i++) {
				pSum = 10*pSum + s.get(i);
			}
			sum[0] += pSum;
			s.pop();	
		}
	}
}
