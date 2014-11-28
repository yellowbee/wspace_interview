package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * Solution: Its simple version is to decide whether two strings are anagrams.
 * To do that, we can create a hash table for one string, with key being the char,
 * and value being the frequency of the char in that string. Then scan the other
 * string. Once a char is met, reduce the frequency. By the end, if the hash table
 * is reduced to empty, we know the two strings are anagrams; otherwise, they are
 * not.
 * 
 * The method is awkward for the current problem at hand, if not impossible.
 * The solution here is to sort the all the characters in each string. If
 * two strings are anagrams, they would end up with the same sorted char array.
 * Using a hash table, we can catch all the strings that are anagrams.
 * The sorting is implemented using QuickSort.
 */

public class Anagrams {
	public static void main(String[] args) {
		String[] strs = {"hello", "llohe", "world", "dworl", "worll"};
		Anagrams ana = new Anagrams();
		System.out.println(ana.anagrams(strs));
	}
	
	
	// implementation of QuickSort
	private int partition(char[] A, int l, int r) {
		char temp;
		char p = A[r];
		int i = l - 1;
		for (int j=l; j<r; j++) {
			if (A[j] <= p) {
				temp = A[j];
				i++;
				A[j] = A[i];
				A[i] = temp;
			}
		}
		temp = A[r];
		A[r] = A[i+1];
		A[i+1] = temp;
		return i+1;
	}
	
	private void quickSort(char[] A, int l, int r) {
		if (l < r) {
			int pivot = partition(A, l, r);
			quickSort(A, l, pivot-1);
			quickSort(A, pivot+1, r);
		}
	}
	
	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i=0; i<strs.length; i++) {
			char[] char_arr = strs[i].toCharArray();
			quickSort(char_arr, 0, char_arr.length-1);
			String sorted_char_arr = Arrays.toString(char_arr);
			if (map.containsKey(sorted_char_arr)) {
				map.get(sorted_char_arr).add(strs[i]);
			}
			else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(sorted_char_arr, list);
			}
		}
		
		for (String str : map.keySet()) {
			List<String> list = map.get(str);
			if (list.size() > 1) {
				result.addAll(list);
			}
		}
		return result;
    }
}
