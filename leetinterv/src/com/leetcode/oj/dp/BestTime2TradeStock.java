package com.leetcode.oj.dp;

/*
 * Say you have an array for which the ith element is the price of a given
 * stock on day i. If you were only permitted to complete at most one
 * transaction (ie, buy one and sell one share of the stock), design an
 * algorithm to find the maximum profit.
 * 
 * This problem can be solved using DP
 * Define M[i] to be the minimum price during day 0 to day i;
 * 
 * Category: DP(optional)
 */

public class BestTime2TradeStock {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len == 0) {
			return 0;
		}
		
		int[] M = new int[len];
		int maxProfit = 0;
		
		M[0] = prices[0];
		for (int i=1; i<len; i++) {
			if (prices[i] < M[i-1]) {
				M[i] = prices[i];
			}
			else {
				M[i] = M[i-1];
			}
			maxProfit = maxProfit > (prices[i]-M[i]) ? maxProfit : (prices[i]-M[i]);
		}
		
		return maxProfit;
    }
}
