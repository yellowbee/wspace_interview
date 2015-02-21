package com.leetcode.oj.arraynstring;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] num = {1,1,1,0};
		int target = -100;
		System.out.println(ThreeSumClosest.threeSumClosest(num, target));
	}
	public static int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int LEN = num.length;
        int min_diff = Integer.MAX_VALUE;
        int result = 0;
        
        for (int i=0; i<LEN; i++) {
        	int left = i+1;
        	int right = LEN - 1;
        	while (left < right) {
	        	int diff = num[i] + num[left] + num[right] - target;
	        	
	        	if (diff == 0) return target;
	        	
	        	if (Math.abs(diff) < min_diff) {
	        		result = target + diff;
	        		min_diff = Math.abs(diff);
	        	}
	        	if (diff > 0) {
	        		right--;
	        	}
	        	else {
	        		left++;
	        	}
        	}
        }
        
        return result;
    }
}
