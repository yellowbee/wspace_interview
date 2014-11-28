package com.leetcode.oj.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.oj.common.TreeNode;

public class BTZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<ArrayList<Integer>>();
		}
		
        boolean needToReverse = false;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> cur_level = new LinkedList<TreeNode>();
        Queue<TreeNode> next_level = new LinkedList<TreeNode>();
        Queue<TreeNode> temp = null;
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        cur_level.add(root);
        while (!cur_level.isEmpty()) {
        	TreeNode cur_node = cur_level.remove();
        	if (cur_node.left != null) {
        		next_level.add(cur_node.left);
        	}
        	if (cur_node.right != null) {
        		next_level.add(cur_node.right);
        	}
        	
        	level.add(cur_node.val);
        	if (cur_level.isEmpty()) {
        		if (needToReverse) {
        			Collections.reverse(level);
        		}
        		result.add(level);
        		level = new ArrayList<Integer>();
        		needToReverse = !needToReverse;
        		temp = cur_level;
        		cur_level = next_level;
        		next_level = temp;
        	}
        }
        
        return result;
    }
}
