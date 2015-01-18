package com.leetcode.oj.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtility;

/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 *
 * Solution: recursion
 *           According to some online resources, DP is also an option.
 */

public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {
		//System.out.println(numTrees(2));
		List<TreeNode> result = generateTrees(10);
		for (int i=0; i<result.size(); i++) {
			TreeUtility.printTreeInSequence(result.get(i));
		}
	}
	
	public static int numTrees(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		int[] N = new int[n+1];
		Arrays.fill(N, 0);
		N[0] = 1;
		N[1] = 1;
		
		for (int i=2; i<=n; i++) {
			for (int k=0; k<=i-1; k++) {
				N[i] += N[k] * N[i-1-k];
			}
		}
		
		return N[n];
	}
	
	public static List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			List<TreeNode> result = new ArrayList<TreeNode>();
			result.add(null);
			return result;
		}
        List<TreeNode> result = helper(1, n);
        return result;
    }
	
	private static List<TreeNode> helper(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		if (start > end) {
			list.add(null);
			return list;
		}
		
		for (int i=start; i<=end; i++) {
			List<TreeNode> leftlist = helper(start, i-1);
			List<TreeNode> rightlist = helper(i+1, end);
			for (int j=0; j<leftlist.size(); j++) {
				for (int k=0; k<rightlist.size(); k++) {
					TreeNode r = new TreeNode(i);
					r.left = leftlist.get(j);
					r.right = rightlist.get(k);
					list.add(r);
				}
			}
		}
		
		return list;
	}
}
