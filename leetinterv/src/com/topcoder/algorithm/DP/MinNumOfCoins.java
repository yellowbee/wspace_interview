package com.topcoder.algorithm.DP;

/*
 * For a set of coin values, give the minimum
 * number of coins that makes up a sum. For example,
 * given coin values {1, 3, 5}, give the min number of
 * coins needed to make up 11.
 * 
 * Discussion:
 * Let M(i) be the minimum number of coins needed for sum i.
 *     V(j) be the coin value Vj.
 * If we know the result from M(1) up to M(i-1), we can get M(i) by
 * M(i) = min{ M(i-V(1))+1, M(i-V(2))+1, ..., M(i-V(n))+1}, for each V(j)<=i
 * 
 */


public class MinNumOfCoins {
	
	public static void main(String[] args) {
		int[] coins = {1, 3, 5};
		MinNumOfCoins mnc = new MinNumOfCoins();
		mnc.numOfCoins(11, coins);
	}
	// return the minimum number of coins
	// that make the sum
	public void numOfCoins(int sum, int[] coins) {
		int minNum[] = new int[sum + 1];
		int kinds = coins.length;
		
		minNum[0] = 0;
		for (int i=1; i<=sum; i++) {
			minNum[i] = Integer.MAX_VALUE;
			for (int j=0; j<kinds; j++) {
				int residue = i - coins[j];
				if (residue >= 0 && (minNum[residue] + 1) < minNum[i]) {
					minNum[i] = minNum[residue] + 1;
				}
			}
		}
		printResult(minNum);
	}
	
	public void printResult(int[] m) {
		for (int i=0; i<m.length; i++) {
			if (m[i] < Integer.MAX_VALUE) {
				System.out.print(m[i] + " ");
			}
			else {
				System.out.print(-1 + " ");
			}
		}
		System.out.println();
	}
}
