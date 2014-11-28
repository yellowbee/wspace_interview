package com.leetcode.oj.dp;

/*
 * Given two words word1 and word2, find the minimum number of
 * steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:

	a) Insert a character
	b) Delete a character
	c) Replace a character
 * 
 * [解题思路]
		刚看到这个题的时候，首先想到的是求最大公共子串，然后用最长字符串的长度减去最大公共子串长度
		并写了code，但是随后测试case的时候，发现有问题。
		比如A= “ab”， B="bc"， 最大子串为“b”， 长度为1。但是如果把A转成B，需要2步，减a加c。
		可见，最长子串并没有考虑到子串的差异，有可能带来多个操作。
		解法仍然是二维DP，只不过转换方程有变化。
		如果是求最长子串，方程是：
		                    
		dp[i][j] =  dp[i-1][j-1] +1  if (A[i] == B[j])
		           or = max(dp[i][j-1], dp[i-1][j]);
		初始条件： dp[0][j] = 0, dp[i][0] = 0
		
		但对于编辑距离的话，当我们要计算d(i,j)时，即计算A(i)到B(j)之间的编辑距离，此时
		设A(i)形式是somestr1c；B(i)形如somestr2d的话，
		      将somestr1变成somestr2的编辑距离已知是d(i-1,j-1)
		将somestr1c变成somestr2的编辑距离已知是d(i,j-1)
		将somestr1变成somestr2d的编辑距离已知是d(i-1,j)
		那么利用这三个变量，就可以递推出d(i,j)了：
		如果c==d，显然编辑距离和d(i-1,j-1)是一样的
		如果c!=d，情况稍微复杂一点，
		如果将c替换成d，编辑距离是somestr1变成somestr2的编辑距离 + 1，也就是d(i-1,j-1) + 1
		如果在c后面添加一个字d，编辑距离就应该是somestr1c变成somestr2的编辑距离 + 1，也就是d(i,j-1) + 1
		如果将c删除了，那就是要将somestr1编辑成somestr2d，距离就是d(i-1,j) + 1
		那最后只需要看着三种谁最小，就采用对应的编辑方案了。
		递推公式出来了：
		dp[i][j] =  dp[i-1][j-1]   if (A[i] == B[j])
           or = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) +1;
      	初始条件： dp[0][j] = j and dp[i][0] = i   
      

 * Solutiion: 2-D DP
 * Let D[i,j] be the minimum distance to convert from A[i] to B[j]
 * D[i,j] = D[i-1,j-1] if A[i] = B[j]
 *         or min{ D[i-1,j-1] + 1,  ----- replace
 *                 D[i,j-1] + 1,    ----- insert
 *                 D[i-1,j] + 1,    ----- delete
 *               }
 *
 */

public class EditDistance {
	public int minDistance(String word1, String word2) {
        char[] W1 = word1.toCharArray();
        char[] W2 = word2.toCharArray();
        int[][] D = new int[W1.length+1][W2.length+1];
        
        for (int i=0; i<W1.length+1; i++) {
        	for (int j=0; j<W2.length+1; j++) {
        		D[i][j] = Integer.MAX_VALUE;
        	}
        }
        
        for (int i=0; i<W1.length+1; i++) {
        	D[i][0] = i;
        }
        for (int j=0; j<W2.length+1; j++) {
        	D[0][j] = j;
        }       
        for (int i=1; i<W1.length+1; i++) {
        	for (int j=1; j<W2.length+1; j++) {
        		if (W1[i-1] == W2[j-1]) { // if char at W1.i is the same as char at W1.j
        			D[i][j] = D[i-1][j-1];
        		}
        		else { // otherwise
        			int min=Integer.MAX_VALUE;
        			if (D[i-1][j]+1 < min) {
        				min = D[i-1][j]+1;
        			}
        			if (D[i][j-1]+1 < min) {
        				min = D[i][j-1]+1;
        			}
        			if (D[i-1][j-1]+1 < min) {
        				min = D[i-1][j-1]+1;
        			}
        			D[i][j] = min;
        		}
        	}
        }
        return D[W1.length][W2.length];
    }
}
