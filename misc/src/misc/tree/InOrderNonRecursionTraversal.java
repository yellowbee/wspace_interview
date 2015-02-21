package misc.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.common.tree.TreeNode;
import com.common.tree.TreeUtility;

public class InOrderNonRecursionTraversal {
	public static void main(String[] args) {
		InOrderNonRecursionTraversal bt = new InOrderNonRecursionTraversal();
		char[] serialized = {'5','3','8','1','4','6','9','#','#','#','#','#','#','#','#',};
		TreeNode root = TreeUtility.deserialize(serialized);
		bt.recoverTree(root);
	}
	
	public void recoverTree(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        // in-order traversal of the tree
        while (cur != null || !stack.isEmpty()) {
           if (cur != null) {// looking for the leftmost node
               stack.push(cur);
               cur = cur.left;
           }
           else if (!stack.isEmpty()) {// left subtree is done
               cur = stack.pop();
               System.out.print(cur.val + " ");
               cur = cur.right;
           }
        }
    }
}
