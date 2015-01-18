package com.leetcode.bitoperation;

import java.util.ArrayList;
import java.util.List;

/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the
 * sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * Solution: We can get some thoughts by an example
 * 000
 * 001
 * 011
 * 010
 * 110
 * 111
 * 101
 * 100
 * 
 * For n = 1, the elements are 0 and 1; for n = 2, get the reverse order of the previous elements
 * and set the highest bit to 1; keep doing this for n = 3, 4 ...
 * 
 * ith Gray element can also be obtained by (i >> 1) ^ i
 */

public class GrayCode {
	public static void main(String[] args) {
		System.out.println(GrayCode.grayCode(4));
	}
	
	public static List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		if (n == 1) return result;
		
		for (int i=2; i<=n; i++) {
			int len = result.size() - 1;
			for (int j=len; j>=0; j--) {
				int code = result.get(j);
				int highbit = 1 << (i-1);
				code += highbit;
				result.add(code);
			}
		}
		
		return result;
    }
}
