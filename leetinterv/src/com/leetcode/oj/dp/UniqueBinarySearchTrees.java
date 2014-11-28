package com.leetcode.oj.dp;

/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   Category: DP
 *
 *   这题想了好久才想清楚。其实如果把上例的顺序改一下，就可以看出规律了。
   1                1                      2                       3             3
    \                 \                 /      \                  /              / 
      3               2                 1       3                2               1
    /                   \                                       /                  \
 2                       3                                     1                    2

比如，以1为根的树有几个，完全取决于有二个元素的子树有几种。同理，2为根的子树取决于一个元素的子树有几个。以3为根的情况，则与1相同。

定义Count[i] 为以[0,i]能产生的Unique Binary Tree的数目，

如果数组为空，毫无疑问，只有一种BST，即空树，
Count[0] =1

如果数组仅有一个元素{1}，只有一种BST，单个节点
Count[1] = 1

如果数组有两个元素{1,2}， 那么有如下两种可能
1                       2
  \                    /
    2                1
Count[2] = Count[0] * Count[1]   (1为根的情况)
                  + Count[1] * Count[0]  (2为根的情况。

再看一遍三个元素的数组，可以发现BST的取值方式如下：
Count[3] = Count[0]*Count[2]  (1为根的情况)
               + Count[1]*Count[1]  (2为根的情况)
               + Count[2]*Count[0]  (3为根的情况)

所以，由此观察，可以得出Count的递推公式为
Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1
问题至此划归为一维动态规划。

[Note]
这是很有意思的一个题。刚拿到这题的时候，完全不知道从那下手，因为对于BST是否Unique，很难判断。最后引入了一个条件以后，立即就清晰了，即
当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。
 */

public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
		System.out.println(ubst.numTrees(3));
	}
	
	public int numTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        
        // init to zeros
        for (int i=2; i<=n; i++) {
        	count[i] = 0;
        }
        // count[i] = Sum{count[j]*count[i-j-1]}, 0<=j<=i-1
        for (int i=2; i<=n; i++) {
        	for (int j=0; j<=i-1; j++) {
        		count[i] += count[j]*count[i-j-1];
        	}
        }
        
        return count[n];
    }
}
