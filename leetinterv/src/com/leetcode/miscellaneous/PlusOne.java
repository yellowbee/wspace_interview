package com.leetcode.miscellaneous;

import java.util.Stack;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */

public class PlusOne {
	public int[] plusOne(int[] digits) {
		Stack<Integer> stack = new Stack<Integer>();
		int carry = 1;
		int cur_sum = 0;
        for (int i=digits.length-1; i>=0; i--) {
        	cur_sum = digits[i] + carry;
        	if (cur_sum > 9) {
        		carry = 1;
        		stack.push(0);
        	}
        	else {
        		carry = 0;
        		stack.push(cur_sum);
        	}
        }
        int[] result;
        if (carry == 1) {
        	result = new int[stack.size()+1];
        	result[0] = 1;
	        for (int i=1; i<result.length; i++) {
	        	result[i] = stack.pop().intValue();
	        }
        }
        else {
        	result = new int[stack.size()];
	        for (int i=0; i<result.length; i++) {
	        	result[i] = stack.pop().intValue();
	        }
        }
        return result;
    }
}
