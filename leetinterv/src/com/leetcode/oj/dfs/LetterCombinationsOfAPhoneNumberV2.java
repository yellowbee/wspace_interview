package com.leetcode.oj.dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * This is a code improvement for version 1.
 */

public class LetterCombinationsOfAPhoneNumberV2 {
	public static void main(String[] args) {
		List<String> result = LetterCombinationsOfAPhoneNumberV2.phoneWords("922");
		System.out.println(result);
	}
	
	// telephone words problem
	public static List<String> phoneWords(String phoneNum) {
	    char[] phoneNumber = phoneNum.toCharArray();
	    List<String> result = new ArrayList<String>();
	    StringBuilder sofar = new StringBuilder();
	    
	    helper(phoneNumber, result, sofar, 0);
	    
	    return result;
	}

	public static void helper(char[] phoneNumber, List<String> result, StringBuilder sofar, int depth) {
	    // get letter for the current phone digit
	    char[] letters = getLetters(phoneNumber[depth]);
	    
	    for (int i=0; i<letters.length; i++) {
	        sofar.append(letters[i]);
	        if (depth == phoneNumber.length - 1) {
	            result.add(sofar.toString());
	        }
	        else {
	            helper(phoneNumber, result, sofar, depth+1);
	        }
	        sofar.deleteCharAt(sofar.length()-1);
	    }

	}
	
	public static char[] getLetters(char digit) {
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
