package com.leetcode.oj.arraynstring;

import java.util.Arrays;

public class TwoSumV2 {
	public static void main(String[] args) {
		int[] numbers = {3,2,4};
		System.out.println(Arrays.toString(TwoSumV2.twoSum(numbers, 6)));
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		Arrays.sort(numbers);
		
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
		    int sum = numbers[left] + numbers[right];
		    if (sum == target) {
		        int[] result = new int[2];
		        result[0] = left;
		        result[1] = right;
		        return result;
		    }
		    else if (sum > target) {
		        right--;
		    }
		    else {
		        left++;
		    }
		}
		
		return null;
    }
}
