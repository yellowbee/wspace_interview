package com.amazon.stringnarray;

import java.util.Arrays;

/*
 * “Write a program to reverse the words in a string in place.
 * for eg; " I am sam " --> " sam am I "”
 */

public class ReverseStringInPlace {
	public static void main(String[] args) {
		char[] A = "I am on the top of the world".toCharArray();
		System.out.println(new String(A));
		reverseInPlace(A);
		System.out.println(new String(A));
	}
	
	public static void reverseInPlace(char[] A) {
		reverse(A, 0, A.length-1);
		int wstart = 0;
		int wend = -1;
		while (wstart < A.length && wend < A.length) {
			wstart = wend + 1;
			while (wstart < A.length && A[wstart] == ' ') {
				wstart++;
			}

			wend = wstart;
			while (wend < A.length-1 && A[wend+1] != ' ') {
				wend++;
			}
			
			if (wstart < A.length && wend < A.length) {
				reverse(A, wstart, wend);
			}
		}
	}
	
	private static void reverse(char[] A, int start, int end) {
		int left = start;
		int right = end;
		while (left < right) {
			char temp = A[left];
			A[left] = A[right];
			A[right] = temp;
			left++;
			right--;
		}
	}
}
