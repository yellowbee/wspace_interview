package com.leetcode.miscellaneous;

/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Solution:
 * I(1), V(5), X(10), L(50), C(100), D(500), M(1000)
 */

public class RomanToInteger {
	public int romanToInt(String s) {
        int result = 0;
        int pre = 0;
        
        for (int i=0; i<s.length(); i++) {
        	
        	if (s.charAt(i) == 'M' && s.charAt(pre) != 'C') result += 1000;
        	if (s.charAt(i) == 'M' && s.charAt(pre) == 'C') result += 800;
        	if (s.charAt(i) == 'C' && s.charAt(pre) != 'X') result += 100;
        	if (s.charAt(i) == 'C' && s.charAt(pre) == 'X') result += 80;
        	if (s.charAt(i) == 'X' && s.charAt(pre) != 'I') result += 10;
        	if (s.charAt(i) == 'X' && s.charAt(pre) == 'I') result += 8;
        	
        	if (s.charAt(i) == 'D' && s.charAt(pre) != 'C') result += 500;
        	if (s.charAt(i) == 'D' && s.charAt(pre) == 'C') result += 300;
        	if (s.charAt(i) == 'L' && s.charAt(pre) != 'X') result += 50;
        	if (s.charAt(i) == 'L' && s.charAt(pre) == 'X') result += 30;
        	if (s.charAt(i) == 'V' && s.charAt(pre) != 'I') result += 5;
        	if (s.charAt(i) == 'V' && s.charAt(pre) == 'I') result += 3;
        	
        	if (s.charAt(i) == 'I') result += 1;
        	
        	pre = i;
        }
        
        return result;
    }
}
