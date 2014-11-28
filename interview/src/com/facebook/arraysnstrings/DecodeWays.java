package com.facebook.arraysnstrings;

/*
 * The same as DecodeWays@Leetcode
 * 
 * Test cases:
 * 11810291346, 11452039826859386538638638638634863510894583168368461,
 * 1145203982685785581517242756417654652894652349756239763462385295724958723985723957239578217654127126595623952346956236938683693463948639669786937846985683493865386863863864863510894583168368461
 */

public class DecodeWays {
	public static void main(String[] args) {
		System.out.println(DecodeWays.decodeWays("1145203982685785581517242756417654652894652349756239763462385295724958723985723957239578217654127126595623952346956236938683693463948639669786937846985683493865386863863864863510894583168368461"));
	}
	
	public static int decodeWays(String s) {
		int len = s.length();
	    int[] C = new int[len];
	    
	    // init start
	    if (s.charAt(0) != '0') {
	    	C[0] = 1;
	    }
	    else {
	    	C[0] = 0;
	    }
	    
	    if (s.charAt(1) != '0') {
	    	if (Integer.parseInt(s.substring(0,2)) <= 26) {
	    		C[1] = 2;
	    	}
	    	else {
	    		C[1] = 1;
	    	}
	    }
	    else if (s.charAt(1) == '0' && Integer.parseInt(s.substring(0,2)) <= 26){
	    	C[1] = 1;
	    }
	    else {
	    	C[1] = 0;
	    }
	    // init end
	    
	    for (int i=2; i<len; i++) {
	    	if (s.charAt(i-1) == '0' && s.charAt(i) == '0') {
	    		return 0;
	    	}
	    	if (s.charAt(i) == '0' && Integer.parseInt(s.substring(i-1,i+1)) > 26) {
	    		return 0;
	    	}
	    	
	        if (s.charAt(i) == '0') {
	            C[i] = C[i-2];
	        }
	        else if (s.charAt(i-1) == '0') {
	            C[i] = C[i-1];
	        }
	        else if (Integer.parseInt(s.substring(i-1,i+1)) <= 26) {
	            C[i] = C[i-2] + C[i-1];
	        }
	        else {
	            C[i] = C[i-1];
	        }
	    
	    }
	    
	    return C[len-1];
	}
}
