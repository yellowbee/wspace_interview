package misc.recursion;


public class TreeMirror {
	/*public static void main(String[] args) {
		int[] preorder = {1, 2, 4, 5, 3, 6};
		int[] inorder = {4, 2, 5, 1, 3, 6};
		TreeNode root = BTBinaryTreeFromInNPreOrder.buildTree(preorder, inorder);
		TreeUtility.printTreeInSequence(root);
		
		TreeNode r = TreeMirror.getMirror(root);
		TreeUtility.printTreeInSequence(r);
	}
	
	// rotate a tree along its root
	// e.g.
	//              1                   1
	//             / \        ===>     / \
	//            2   3               3   2
	public static TreeNode getMirror(TreeNode root) {
		if (root == null) return null;
		
		TreeNode leftMirror = getMirror(root.left);
		TreeNode rightMirror = getMirror(root.right);
		
		root.left = rightMirror;
		root.right = leftMirror;
		
		return root;
	}*/
}
