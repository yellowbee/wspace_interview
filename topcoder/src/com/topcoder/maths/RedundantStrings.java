package com.topcoder.maths;

import java.util.ArrayList;
import java.util.List;

public class RedundantStrings {
	public static void main(String[] args) {
		RedundantStrings rs = new RedundantStrings();
		System.out.println(rs.howMany(2));
	}
	
	public int howMany(int length) {
		if (length == 1) return 0;
		
		int result = 0;
		// the largest possible length of a root
		int LEN = length / 2;
		for (int i=1; i<=LEN; i++) {
			if (length % i == 0) {
				result += (1 << i) - howMany(i);
			}
		}
		
		return result;
	}
}
