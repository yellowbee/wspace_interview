package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceV2 {
	public static void main(String[] args) {
		PermutationSequenceV2 ps = new PermutationSequenceV2();
		System.out.println(ps.getPermutation(3, 5));
	}
	
	public String getPermutation(int n, int k) {
		StringBuffer ordered = new StringBuffer();
		for (int i=1; i<=n; i++) {
			ordered.append(i);
		}
		
		int mod = 1;
		for (int i=2; i<=n; i++) {
			mod *= i;
		}
		
		List<Integer> posi = new ArrayList();
		int K = k-1;
		for (int i=1; i<=n; i++) {
			mod = mod / (n-i+1);
			int digit = K / mod;
			posi.add(digit);
			K = K % mod;
		}
		
		StringBuffer res = new StringBuffer();
		for (int i=0; i<posi.size(); i++) {
			res.append(ordered.charAt(posi.get(i)));
			ordered.deleteCharAt(posi.get(i));
		}
		
		return res.toString();
	}
	
	/*public String getPermutation(int n, int k) {
		 
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
 
		// change k to be index
		k--;
 
		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}
 
		String result = "";
 
		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			// update k
			k = k % mod;
 
			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}
 
		return result.toString();
	}*/
}
