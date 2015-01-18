package com.leetcode.oj.arraynstring;

/*
 * Given a string s consists of upper/lower-case alphabets
 * and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        int LEN = s.length();
        if (LEN == 0) return 0;
        
        int begin = LEN-1;
        int end = LEN-1;
        
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) return 0;
        
        begin = end - 1;
        while (begin >=0 && s.charAt(begin) != ' ') {
            begin--;
        }
        
        return end - begin;
    }
}
