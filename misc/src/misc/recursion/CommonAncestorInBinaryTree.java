package misc.recursion;

import java.util.ArrayList;
import java.util.List;

import com.common.tree.TreeNode;

public class CommonAncestorInBinaryTree {
	/*public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		
		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(pre, in);
		//TreeUtility.printTreeInSequence(root);
		
		List<TreeNode> path = new ArrayList<TreeNode>();
		CommonAncestorInBinaryTree.getPath(root, new TreeNode(7), path);
		System.out.println(path);
	}
	
	public static boolean getPath(TreeNode root, TreeNode node, List<TreeNode> path) {
	    if (root == null) return false;
	    
	    // end of path found
	    if (root.val == node.val) {
	        path.add(root);
	        return true;
	    }
	    
	    if (getPath(root.left, node, path) || getPath(root.right, node, path)) {
	        path.add(root);
	        return true;
	    }
	    else {
	        return false;
	    }
	}*/
}
