package com.topcoder.tree;

public class TrafficCongestionDivTwo {
	public static void main(String[] args) {
		System.out.println(TrafficCongestionDivTwo.theMinCars(60));
	}
	
	public static long theMinCars(int treeHeight) {
		if (treeHeight == 1) return 1;
		if (treeHeight == 2) return 3;
		
		long result = 0;
		int h = treeHeight - 1;
		while (h >= 1) {
			result += 1L << h;
			h -= 2;
		}
		
		return result + 1;
	}
}
