package com.leetcode.oj.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.oj.common.TreeLinkNode;

/*
 * Category: BFS on Binary Tree
 * Solution: Using two queues to traverse all nodes
 *           level by level.
 */

public class PopulatingNextRightPointers {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
        Queue<TreeLinkNode> cur_level = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> next_level = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> temp = null;
        cur_level.add(root);
        while (!cur_level.isEmpty()) {
        	TreeLinkNode cur_node = cur_level.remove();
        	cur_node.next = cur_level.peek(); // peek returns null if queue is empty
        	if (cur_node.left != null) {
        		next_level.add(cur_node.left);
        	}
        	if (cur_node.right != null) {
        		next_level.add(cur_node.right);
        	}
        	if (cur_level.isEmpty()) {
        		temp = cur_level;
        		cur_level = next_level;
        		next_level = temp;
        	}
        }
    }
}
