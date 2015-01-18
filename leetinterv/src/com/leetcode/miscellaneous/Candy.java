package com.leetcode.miscellaneous;

/*
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Solution: Greedy
 * 从左到右算一遍，ratings递增时candy也递增，否则都只给一块糖。
 * 再从右到左修正一遍：如果左比右rating高但却没有拿更多的糖，修正。
 */

public class Candy {
	public int candy(int[] ratings) {
        int[] C = new int[ratings.length];
        
        C[0] = 1;
        for (int i=1; i<C.length; i++) {
        	if (ratings[i] > ratings[i-1]) {
        		C[i] = C[i-1] + 1;
        	}
        	else {
        		C[i] = 1;
        	}
        }
        
        for (int i=C.length-2; i>=0; i--) {
        	if (ratings[i] > ratings[i+1] && C[i] <= C[i+1]) {
        		C[i] = C[i+1] + 1;
        	}
        }
        
        int result = 0;
        for (int i=0; i<C.length; i++) {
        	result += C[i];
        }
        
        return result;
    }
}
