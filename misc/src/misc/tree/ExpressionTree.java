package misc.tree;

import com.common.tree.TreeNode;
import com.common.tree.TreeUtility;

public class ExpressionTree {
	public static void main(String[] args) {
		char[] serialized = {'*', '1', '-', '#', '#', '5', '8', '#', '#', '#', '#'};
		TreeNode node = TreeUtility.deserialize(serialized);
		System.out.println(ExpressionTree.evaluateExpress(node));
	}
	
	public static int evaluateExpress(TreeNode node) {
		if (node != null && node.val != '-' && node.val != '+' && node.val != '*') {
			return node.val - 48;
		}
		
		int left = evaluateExpress(node.left);
		int right = evaluateExpress(node.right);
		if (node.val == '-') return left - right;
		if (node.val == '+') return left + right;
		return left * right;
	}
}
