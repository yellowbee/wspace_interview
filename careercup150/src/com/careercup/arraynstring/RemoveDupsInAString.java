package com.careercup.arraynstring;

import java.util.Arrays;

/*
 * corner cases: empty string, string of size 1
 * 
 * Solution: Use three pointers; O(n^2)
 * 
 * Note: The difference from the coding problem of removing
 * duplicates in leetcode is that the array here is not necessarily
 * sorted.
 */

public class RemoveDupsInAString {
	public static void main(String[] args) {
		String s = "abcdabc";
		char[] str = s.toCharArray();
		
		RemoveDupsInAString.removeDuplicates(str);
		System.out.println(Arrays.toString(str));
	}
	
	public static void removeDuplicates(char[] str) {
		int LEN = str.length;
        // corner cases
        if (LEN == 0 || LEN == 1) return;
        
        // tail points to the position that will hold the next qualified char
        int tail = 1;
        for (int i=1; i<LEN; i++) {// check each char in str
            int j = 0;
            for (; j<tail; j++) {// for each in the already completed chars 
                if (str[i] == str[j]) {
                    break;
                }
            }
            if (j == tail) {
                str[tail] = str[i];
                tail++;
            }
        }
        
        if (tail < LEN) {
            str[tail] = '!';
        }
	}
}
