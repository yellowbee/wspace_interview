package com.topcoder.stringnarray;

/*
 * Single Round Match 595 Round 1 - , Level One
 * Problem Statement for LittleElephantAndBallsAgain


Problem Statement
    	
Little Elephant from the Zoo of Lviv likes balls. He has some balls arranged in a row. Each of those balls has one of three possible colors: red, green, or blue.

You are given a String S. This string represents all the balls that are initially in the row (in the order from left to right). Red, green, and blue balls are represented by characters 'R', 'G', and 'B', respectively. In one turn Little Elephant can remove either the first ball in the row, or the last one.

Little Elephant wants to obtain a row in which all balls have the same color. Return the smallest number of turns in which this can be done.

 
Definition
    	
Class:	LittleElephantAndBallsAgain
Method:	getNumber
Parameters:	String
Returns:	int
Method signature:	int getNumber(String S)
(be sure your method is public)
    
 
Constraints
-	S will contain between 1 and 50 characters, inclusive.
-	S will consist only of characters 'R', 'G' and 'B'.
 
Examples
0)	
    	
"RRGGBB"
Returns: 4
One possible optimal solution is to remove 2 balls from the front and 2 from the back. The total number of turns is 2+2 = 4. After those 4 turns only green balls remained on the table.
1)	
    	
"R"
Returns: 0
You don't need to do any turns in this case, so the answer is 0.
2)	
    	
"RGBRGB"
Returns: 5
In any optimal solution only one of these six balls will remain on the table.
3)	
    	
"RGGGBB"
Returns: 3
4)	
    	
"RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR"
Returns: 46

 * Category: Array/String
 * Solution: find the longest substring consisting of the same character, using TWO POINTERS.
 * Test cases:
 * RRGGBB, returns: 4
 * RGBRGB, returns: 5
 * RGGGBB, returns: 3
 * RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR, returns: 46
 */

public class LittleElephantAndBallsAgain {
	public static void main(String[] args) {
		System.out.println(LittleElephantAndBallsAgain.getNumber("RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR"));
	}
	
	public static int getNumber(String S) {
		int LEN = S.length();
		// takes care of the corner case of S being size of 1
		if (LEN == 1) return 0;
		
		int maxlen = -1;
		int start = 0;
		int end = 0;
		while (start < LEN && end < LEN) {
			int len = 0;
			while (start < LEN && end < LEN) {
				if (S.charAt(end) == S.charAt(start)) {
					len++;
					end++;
				}
				else {
					maxlen = maxlen > len ? maxlen : len;
					start = end;
					break;
				}
			}
		}
		
		return LEN - maxlen;
	}
}
