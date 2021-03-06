package com.expedia.arraysnstrings;

import java.util.Arrays;

public class Merge {
	public static void main(String[] args) {
		int[] arr1 = new int[9];
		arr1[0] = 2;
		arr1[1] = 5;
		arr1[2] = 6;
		arr1[3] = 19;
		arr1[4] = 20;
		
		int[] arr2 = {1, 18, 22, 29};
		Merge merge = new Merge();
		merge.merge(arr1, 5, arr2);
		System.out.println(Arrays.toString(arr1));
	}
	
	public void merge(int[] arr1, int num, int[] arr2) {
		if (arr1.length < (num + arr2.length)) return;
		
		int ptr1 = num - 1; // pointing to the last element of the 1st arr
		int ptr2 = arr2.length - 1;
		int cur = arr1.length - 1; // pointing to the current position to insert
		
		while (ptr1 >=0 && ptr2 >=0) {
			if (arr1[ptr1] > arr2[ptr2]) {
				arr1[cur] = arr1[ptr1];
				cur--;
				ptr1--;
			}
			else {
				arr1[cur] = arr2[ptr2];
				cur--;
				ptr2--;
			}
		}
		
		if (ptr1 < 0) {
			while (ptr2 >= 0) {
				arr1[cur] = arr2[ptr2];
				cur--;
				ptr2--;
			}
		}
	}
}
