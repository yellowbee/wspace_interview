package com.leetcode.miscellaneous;

/*
 * Determine whether an integer is a palindrome. Do this WITHOUT extra space.
 * click to show spoilers.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * There is a more generic way of solving this problem.
 */

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(PalindromeNumber.isPalindrome(123454321));
	}
	
	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
		
        int len = 0;
        int number = x;
        while (number > 0) {
        	number /= 10;
        	len += 1;
        }
        
        int left = len - 1;
        int right = 0;
        while (left > right) {
        	int right_digit = x / (int)Math.pow(10, right) % 10;
        	int left_digit = x / (int)Math.pow(10, left) % 10;
        	if (left_digit != right_digit) return false;
        	left--;
        	right++;
        }
        
        return true;
    }
}
