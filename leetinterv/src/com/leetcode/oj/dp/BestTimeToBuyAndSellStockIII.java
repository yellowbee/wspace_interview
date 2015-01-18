package com.leetcode.oj.dp;

public class BestTimeToBuyAndSellStockIII {
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII bts = new BestTimeToBuyAndSellStockIII();
		int[] prices = {2,6,3,8,3,5,1,6,2};
		System.out.println(bts.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
		int LEN = prices.length;
		if (LEN == 0) return 0;
		
		int maxProfit = 0;
		
        maxProfit = maxProfitInPeriod(prices, 0, LEN-1);
        for (int i=1; i<=LEN-3; i++) {
        	int sum_profit = maxProfitInPeriod(prices, 0, i) + maxProfitInPeriod(prices, i+1, LEN-1);
        	maxProfit = maxProfit > sum_profit ? maxProfit : sum_profit; 
        }
        
        return maxProfit;
    }
	
	public int maxProfitInPeriod(int[] prices, int start, int end) {
		int len = end - start;
		if (len == 0) {
			return 0;
		}
		
		int[] M = new int[len];
		int maxProfit = 0;
		
		// M[i] is the minimum stock price from starting day to day i
		M[0] = prices[start];
		for (int i=1; i<len; i++) {
			if (prices[start+i] < M[i-1]) {
				M[i] = prices[start+i];
			}
			else {
				M[i] = M[i-1];
			}
			maxProfit = maxProfit > (prices[start+i]-M[i]) ? maxProfit : (prices[start+i]-M[i]);
		}
		
		return maxProfit;
    }
}
