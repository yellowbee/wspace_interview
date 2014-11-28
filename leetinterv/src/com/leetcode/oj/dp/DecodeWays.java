package com.leetcode.oj.dp;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * Category: 1-D DP
 * Define C[i] to be the number of ways decoding d1,...,di .
 * C[i] =    C[i-1], if d(i-1)d(i) >26 or <1
 *        or C[i-1] + C[i-2], otherwise
 *        
 *
 * 
 * Test cases:
 * 11810291346, 11452039826859386538638638638634863510894583168368461,
 * 1145203982685785581517242756417654652894652349756239763462385295724958723985723957239578217654127126595623952346956236938683693463948639669786937846985683493865386863863864863510894583168368461
 */

public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings("1145203982685785581517242756417654652894652349756239763462385295724958723985723957239578217654127126595623952346956236938683693463948639669786937846985683493865386863863864863510894583168368461"));
	}
	
	public int numDecodings(String s) {
		if (s.length() < 1) return 0;
		
        int[] C = new int[s.length()+1];
        
        // ----- initialization start ---------
        C[0] = 0;
        if (s.charAt(0) == '0') {
        	return 0;
        }
        else {
        	C[1] = 1;
        }    
        if (s.length() >= 2) {
        	String substr = s.substring(0, 2);
        	int val = Integer.parseInt(substr);
        	if (s.charAt(1) != '0') {
        		if (val >=1 && val <= 26) {
        			C[2] = 2;
        		}
        		else {
        			C[2] = 1;
        		}
        	}
        	else {
        		if (val >=1 && val <= 26) {
        			C[2] = 1;
        		}
        		else {
        			return 0;
        		}
        	}
        }
        // -------- initialization end ------------
        
        for (int i=2; i<s.length(); i++) {
        	String substr = s.substring(i-1, i+1);
        	int val = Integer.parseInt(substr);
        	if (s.charAt(i-1) == '0') {
        		if (s.charAt(i) != '0') {
        			C[i+1] = C[i];
        		}
        		else {
        			return 0;
        		}
        	}
        	else if (s.charAt(i) != '0') {
        		if (val >=1 && val <=26) {
        			C[i+1] = C[i] + C[i-1];
        		}
        		else {
        			C[i+1] = C[i];
        		}
        	}
        	else {
        		if (val >=1 && val <=26) {
        			C[i+1] = C[i-1];
        		}
        		else {
        			return 0;
        		}
        	}
        }
		
		return C[s.length()];
    }
}
