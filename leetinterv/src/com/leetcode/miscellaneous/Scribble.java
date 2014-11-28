package com.leetcode.miscellaneous;

import java.util.Stack;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtility;
import com.leetcode.oj.common.TreeNode;

public class Scribble {
	public static void main(String[] args) {
		/*ListNode list1 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(7);
		list1.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		Scribble scr = new Scribble();
		ListUtility.printList(scr.reverseList(list1));*/
		
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		
		Scribble scr = new Scribble();
		Stack<Integer> s = new Stack<Integer>();
		scr.printRoot2LeafPath(root, s);
		
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode cur = head;
		ListNode pre = cur.next;
		ListNode temp = null;
		
		cur.next = null;
		while (pre != null) {
			temp = pre.next;
			pre.next = cur;
			cur = pre;
			pre = temp;
		}
		return cur;
	}
	
	public void printRoot2LeafPath(TreeNode r, Stack<Integer> s) {
		if (r == null) {
			return;
		}
		if (r.left!=null || r.right!=null) {
			s.push(new Integer(r.val));
			printRoot2LeafPath(r.left, s);
			printRoot2LeafPath(r.right, s);
			s.pop();
		}
		else {
			s.push(new Integer(r.val));
			for (int i=0; i<s.size(); i++) {
				System.out.print(s.get(i) + " ");
			}
			System.out.println();
			s.pop();
		}
	}
}
