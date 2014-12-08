package com.amazon.misc;

public class NumberOfBits {
	public static void main(String[] args) {
		System.out.println(countBits(25));
	}
	
	public static int countBits(int num) {
		int counts = 0;
		
		while (num >= 1) {
			num = num/2;
			counts++;
		}
		
		return counts;
	}
}
