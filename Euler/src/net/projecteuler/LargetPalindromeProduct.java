package net.projecteuler;

public class LargetPalindromeProduct {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		
		for (int i=999; i>99; i--) {
			for (int j=999; j>99; j--) {
				int prod = i * j;
				if (isPalindrome(prod) && prod > max) {
					max = prod;
					System.out.println(i + " * " + j + " = " + max);
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static boolean isPalindrome(int num) {
		String number = String.valueOf(num);
		int start = 0;
		int end = number.length()-1;
		while (start < end) {
			if (number.charAt(start) != number.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
}

