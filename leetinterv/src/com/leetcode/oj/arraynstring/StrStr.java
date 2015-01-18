package com.leetcode.oj.arraynstring;

public class StrStr {
	public static void main(String[] args) {
		System.out.println(StrStr.strStr("mississippi", "pi"));
	}
	
	public static int strStr(String haystack, String needle) {
		if (haystack.equals(needle)) return 0;
		
		int LEN = needle.length();
		
		for (int i=0; i<haystack.length()-LEN+1; i++) {
			if (haystack.substring(i, i+LEN).equals(needle)) {
				return i;
			}
		}
		
		return -1;
    }
}
