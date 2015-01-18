package com.leetcode.binarysearch;

public class FindPeakElement {
	public static void main(String[] args) {
		int[] num = {3,2,1};
		System.out.println(FindPeakElement.findPeakElement(num));
	}
	
	public static int findPeakElement(int[] num) {
		if (num.length == 1) return 0;
		if (num.length == 2) return num[0] > num[1] ? 0 : 1;
		
		int mid;
		int left = 0;
		int right = num.length - 1;
		while (true) {
			if (right - left == 1) {
				return num[left] > num[right] ? left : right;
			}
			
			mid = (left + right) / 2;
			
			// two corner cases
			if (mid == 0 && num[mid] > num[mid]+1) return mid;
			if (mid == num.length && num[mid] > num[mid-1]) return mid;
			
			if (num[mid] > num[mid-1] && num[mid] > num[mid+1]) {
				return mid;
			}
			
			if (num[mid] < num[mid-1]) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
        
    }
}
