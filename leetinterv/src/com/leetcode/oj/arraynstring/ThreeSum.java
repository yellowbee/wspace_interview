package com.leetcode.oj.arraynstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c
 * in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

public class ThreeSum {
	public static void main(String[] args) {
		//int[] num = {-1, 0, 1, 2, -1, -4};
		int[] num = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		List<List<Integer>> result = threeSum(num);
		System.out.println(result);
	}
	
	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
        int len = num.length;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0; i<len-2; i++) {
            if (i==0 || num[i]>num[i-1]) {
            	int j = i + 1;
            	int k = len - 1;
            	int twosum = 0 - num[i];
            	while (j < k) {
            		if (num[k] > (twosum-num[j])) {
            			k--;
            		}
            		else if (num[k] < (twosum-num[j])) {
            			j++;
            		}
            		else {
            			List<Integer> triplet = new ArrayList<Integer>();
            			triplet.add(num[i]);
            			triplet.add(num[j]);
            			triplet.add(num[k]);
            			if (!result.contains(triplet)) {
            				result.add(triplet);
            			}
            			k--;
            			j++;
            			while (j<k && num[j]==num[j-1]) j++;
            		    while (j<k && num[k]==num[k+1]) k--;
            		}
            	}
            }
        }
        
        return result;
    } 
}
