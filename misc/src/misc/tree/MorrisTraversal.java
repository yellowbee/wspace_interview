package misc.tree;

import com.common.tree.TreeNode;
import com.common.tree.TreeUtility;

public class MorrisTraversal {
	public static void main(String[] args) {
		MorrisTraversal mt = new MorrisTraversal();
		char[] serialized = {'5','3','8','1','4','6','9','#','#','#','#','#','#','#','#'};
		TreeNode root = TreeUtility.deserialize(serialized);
		mt.morrisTraverse(root);
		//TreeUtility.printTreeInSequence(root);
		System.out.println();
		TreeUtility.printTreePreOrder(root);
		System.out.println();
		TreeUtility.printTreeInOrder(root);
	}
	
	public void morrisTraverse(TreeNode node) {
		if (node == null) return;
		
		TreeNode current = node;
		TreeNode pre = null;
		while (current != null) {
			if (current.left != null) {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) { // not threaded yet
					pre.right = current;
					current = current.left;
				}
				else { // already threaded
					System.out.print(current.val + " ");
					pre.right = null; // recover to its original structure
					current = current.right;
				}
			}
			else {
				System.out.print(current.val + " ");
				current = current.right;
			}
		}
	}
	
	// traversing with O(1) space, based on threaded binary tree
	/*public void morrisTraverse(TreeNode node) {
		if (node == null) return;
		
		TreeNode cur = node;
		TreeNode pre = null;
		while (cur != null) {
			if (cur.left != null) {
				pre = cur.left;
				// looking for the rightmost node of the left subtree
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				// threading not done yet
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				}
				// threading already done and left subtree already processed
				else {
					pre.right = null;
					System.out.print(cur.val + " ");
					cur = cur.right;
				}
			}
			else {
				System.out.print(cur.val + " ");
				cur = cur.right;
			}
		}
	}*/
}
