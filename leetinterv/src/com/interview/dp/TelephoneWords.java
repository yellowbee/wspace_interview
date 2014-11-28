package com.interview.dp;

import java.util.ArrayList;

/*
 * Problem: Given a telephone number print or produce all the
 * possible telephone words or combinations of letters that can
 * represent the given telephone number. Solution: O(3 ^ n)
 * (approximately - since there are 2 digits that have 4 letters)
 * 
 * Discussion:
 * If a problem asks to give all possibilities/combinations, mostly
 * likely it can be solved using DFS.
 * 
 *         7 4 0 3 3 1 1 7 6 6
 *         ^ |_______________|
 *         a)        b)
 * a) for each possible letter, add it to the partial word
 * b) call dfs recursively on this part; for each partial word generated
 *    a new one will be obtained by putting a possible letter from '7' at
 *    the beginning.
 * The same process will happen recursively.
 *         
 */

public class TelephoneWords {

	public void dfs(String s, int start, StringBuilder cur, ArrayList<String> result) {
		if (start >= s.length()) {
			result.add(cur.toString());
			return;
		}
		
		char digit = s.charAt(start);
		char[] letters = getLetters(digit);
		for (int i=0; i<letters.length; i++) {
			int oldlen = cur.length();
			Character ch = new Character(letters[i]);
			cur.append(ch.toString());
			
			dfs(s, start+1, cur, result);
			
			// clear the cur for the current loop
			cur.delete(oldlen, cur.length());
		}
	}
	
	/*
	 * helper function to return all letters associated
	 * with a digit
	 */
	public char[] getLetters(char digit) {

		switch(digit) {
		case '1': return new char[]{'1'};
		case '0': return new char[]{'0'};
		case '2': return new char[]{'a', 'b', 'c'};
		case '3': return new char[]{'d', 'e', 'f'};
		case '4': return new char[]{'g', 'h', 'i'};
		case '5': return new char[]{'j', 'k', 'l'};
		case '6': return new char[]{'m', 'n', 'o'};
		case '7': return new char[]{'p', 'q', 'r', 's'};
		case '8': return new char[]{'t', 'u', 'v'};
		case '9': return new char[]{'w', 'x', 'y', 'z'};
		}
		return new char[]{};
	}
	
	public static void main(String[] args) {
		TelephoneWords tw = new TelephoneWords();
		StringBuilder cur = new StringBuilder();
		ArrayList<String> result = new ArrayList<String>();
		tw.dfs("129", 0, cur, result);
		for (String str : result) {
			System.out.println(str);
		}
	}
}
