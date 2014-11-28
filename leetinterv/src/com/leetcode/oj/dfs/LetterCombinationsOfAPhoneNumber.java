package com.leetcode.oj.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations
 * that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons)
 * is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Solution: typical DFS
 */

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
		List<String> result = lc.letterCombinations("922");
		System.out.println(result);
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		
		if (digits.length() == 0) {
			result.add("");
			return result;
		}
		
		
		StringBuffer cur = new StringBuffer();
		char[] letters = getLetters(digits.charAt(0));
		for (int i=0; i<letters.length; i++) {
			helper(digits, cur, result, 0, letters[i]);
		}
		return result;
    }
	
	public void helper(String digits, StringBuffer cur, List<String> result, int level, char ch) {
		if (level > digits.length()-1) return;
		
		cur.append(ch);
		
		if (level == digits.length()-1) {
			result.add(cur.toString());
			cur.deleteCharAt(cur.length()-1);
			return;
		}
		
		level++;
		char[] letters = getLetters(digits.charAt(level));
		for (int i=0; i<letters.length; i++) {
			helper(digits, cur, result, level, letters[i]);
		}
		
		//reset
		cur.deleteCharAt(cur.length()-1);
	}
	
	public char[] getLetters(char digit) {
		if (digit == '2') {
			return new char[]{'a', 'b', 'c'};
		}
		else if (digit == '3') {
			return new char[]{'d', 'e', 'f'};
		}
		else if (digit == '4') {
			return new char[]{'g', 'h', 'i'};
		}
		else if (digit == '5') {
			return new char[]{'j', 'k', 'l'};
		}
		else if (digit == '6') {
			return new char[]{'m', 'n', 'o'};
		}
		else if (digit == '7') {
			return new char[]{'p', 'q', 'r', 's'};
		}
		else if (digit == '8') {
			return new char[]{'t', 'u', 'v'};
		}
		else if (digit == '9') {
			return new char[]{'w', 'x', 'y', 'z'};
		}
		else {
			return null;
		}
	}
}
