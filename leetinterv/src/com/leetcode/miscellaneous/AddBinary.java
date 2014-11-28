package com.leetcode.miscellaneous;

import java.util.Stack;

/*
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * Test cases: 
 * "1001101" + "10010"
 * "11111" + "111"
 */

public class AddBinary {
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("1001101", "10010"));
	}
	
	public String addBinary(String a, String b) {
		Stack<Character> result = new Stack<Character>();
		Stack<Character> A = new Stack<Character>();
		Stack<Character> B = new Stack<Character>();
		
		int carry = 0;
		
		for (int i=0; i<a.length(); i++) {
			A.push(a.charAt(i));
		}
		for (int j=0; j<b.length(); j++) {
			B.push(b.charAt(j));
		}
		
		char aa;
		char bb;
		while (!A.isEmpty() && !B.isEmpty()) {
			aa = A.pop();
			bb = B.pop();
			if (aa == '0') {
				if (bb == '0' && carry == 0) {
					result.push('0');
					carry = 0;
				}
				else if (bb == '0' && carry == 1) {
					result.push('1');
					carry = 0;
				}
				else if (bb == '1' && carry == 0) {
					result.push('1');
					carry = 0;
				}
				else {
					result.push('0');
					carry = 1;
				}
			}
			else if (aa == '1') {
				if (bb == '0' && carry == 0) {
					result.push('1');
					carry = 0;
				}
				else if (bb == '0' && carry == 1) {
					result.push('0');
					carry = 1;
				}
				else if (bb == '1' && carry == 0) {
					result.push('0');
					carry = 1;
				}
				else {
					result.push('1');
					carry = 1;
				}
			}
		}
		
		Stack<Character> more = null;
		if (!A.isEmpty()) {
			more = A;
		}
		else if (!B.isEmpty()) {
			more = B;
		}
		
		if (more != null) {
			while (!more.isEmpty()) {
				bb = more.pop();
				if (bb == '0' && carry == 0) {
					result.push('0');
					carry = 0;
				}
				else if (bb == '0' && carry == 1) {
					result.push('1');
					carry = 0;
				}
				else if (bb == '1' && carry == 0) {
					result.push('1');
					carry = 0;
				}
				else if (bb == '1' && carry == 1) {
					result.push('0');
					carry = 1;
				}
			}
		}
		
		if (carry == 1) {
			result.push('1');
		}
		
		StringBuilder sb = new StringBuilder();
		while (!result.isEmpty()) {
			sb.append(result.pop());
		}
		
		return sb.toString();
	}
}
