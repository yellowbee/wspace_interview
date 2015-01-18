package com.leetcode.miscellaneous;

public class ReverseInteger {
	public static void main(String[] args) {
		int i = 2147483647;
		int j = -12345;

		System.out.println(ReverseInteger.reverse(214748364));
	}
	
	public static int reverse(int x) {
		long result = 0;
		int cur_digit = 0;
		
		while (x != 0) {
			cur_digit = x % 10;
			result = result * 10 + cur_digit;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				return 0;
			}
			x = x / 10;
		}
        return (int)result;
    }
}
