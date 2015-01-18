package com.topcoder.recursion;

public class QuickSums {
	public static void main(String[] args) {
		QuickSums qs = new QuickSums();
		System.out.println(qs.minSums("9230560001", 71));
	}
	
	public int minSums(String numbers, int sum) {
		int len = numbers.length();
		if (len <= 3 && Integer.parseInt(numbers) == sum) return 0;
		
		if (len == 1) {
			return -1;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i=len -1; i>0; i--) {
			int last_num = Integer.parseInt(numbers.substring(i, len));
			if (last_num <= sum ) {
				int minSums_subseq = minSums(numbers.substring(0, i), sum-last_num);
				if (minSums_subseq == -1) continue;
				if (min > minSums_subseq + 1) {
					min = minSums_subseq + 1;
				}
			}
		}
		
		return min < Integer.MAX_VALUE ? min : -1;
	}
	
}
