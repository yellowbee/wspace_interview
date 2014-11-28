package com.leetcode.miscellaneous;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        String ss = s.toLowerCase();
        int left = 0;
        int right = ss.length() - 1;
        while (left < right) {
        	while (!isAlphanumeric(ss.charAt(left)) && left < right) left++;
        	while (!isAlphanumeric(ss.charAt(right)) && left < right) right--;
        	if (ss.charAt(left) != ss.charAt(right)) {
        		return false;
        	}
        	left++;
        	right--;
        }
        return true;
    }
	
	public boolean isAlphanumeric(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return true;
		}
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vp.isAlphanumeric('a'));
		System.out.println(vp.isAlphanumeric('1'));
		System.out.println(vp.isAlphanumeric('+'));
	}
}
