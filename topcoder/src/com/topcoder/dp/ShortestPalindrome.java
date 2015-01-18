package com.topcoder.dp;

/*
 * 	 ShortPalindromes	 SRM 165	 09.23.2003	vorthys	 Dynamic Programming, Recursion div2.level3	 9.09%	
 * 
 * Examples
0)	
    	
"RACE"
Returns: "ECARACE"
To make "RACE" into a palindrome, we must add at least three letters.
However, there are eight ways to do this by adding exactly three letters:
    "ECARACE"  "ECRARCE"  "ERACARE"  "ERCACRE"
    "RACECAR"  "RAECEAR"  "REACAER"  "RECACER"
Of these alternatives, "ECARACE" is the lexicographically earliest.
1)	
    	
"TOPCODER"
Returns: "REDTOCPCOTDER"
2)	
    	
"Q"
Returns: "Q"
3)	
    	
"MADAMIMADAM"
Returns: "MADAMIMADAM"
4)	
    	
"ALRCAGOEUAOEURGCOEUOOIGFA"
Returns: "AFLRCAGIOEOUAEOCEGRURGECOEAUOEOIGACRLFA"

 * 
 * shortest(base)
      if base is already a palindrome then
          return base
      if base has the form A...A then
          return A + shortest(...) + A
      if base has the form A...B then
          return min(A + shortest(...B) + A,
                     B + shortest(A...) + B)
                     
 * where min chooses the shorter of the two strings,
 * or the lexicographically earliest if the strings have the same length.
 * 
 * Recursion is a naive implementation of the above rules and
 * is not acceptable; DP is the way to go.
 */

public class ShortestPalindrome {
	public static void main(String[] args) {
		System.out.println(shortest("ALRCAGOEUAOEURGCOEUOOIGFA"));
	}
	
	public static String shortest(String S) {
		int len = S.length();
		String[][] SP = new String[len][len];
		
		for (int i=len-1; i>=0; i--) {
			for (int j=i; j<len; j++) {
				if (i == j) { // A
					SP[i][i] = new Character(S.charAt(i)).toString();
				}
				else if (S.charAt(i) == S.charAt(j)) { // A ... A
					if (j - i == 1) {
						SP[i][j] = S.substring(i, j+1);
					}
					else {
						String both_end = new Character(S.charAt(i)).toString();
						SP[i][j] = both_end + SP[i+1][j-1] + both_end;
					}
				}
				else { // A ... B
					String A = new Character(S.charAt(i)).toString();
					String s1 = A + SP[i+1][j] + A;
					
					String B = new Character(S.charAt(j)).toString();
					String s2 = B + SP[i][j-1] + B;
				
					if (s1.length() < s2.length()) {
						SP[i][j] = s1;
					}
					else if (s1.length() > s2.length()) {
						SP[i][j] = s2;
					}
					else {
						if (S.charAt(i) < S.charAt(j)) {
							SP[i][j] = s1;
						}
						else {
							SP[i][j] = s2;
						}
					}
				}
			}
		}
		
		return SP[0][len-1];
	}
}
