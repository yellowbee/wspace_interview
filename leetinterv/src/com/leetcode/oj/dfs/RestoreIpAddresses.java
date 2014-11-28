package com.leetcode.oj.dfs;

import java.util.ArrayList;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


 */

public class RestoreIpAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (s.equals("")) {
        	return result;
        }
        
        StringBuilder sofar = new StringBuilder();
		helper(sofar, s, result, 1);
		return result;
    }
	
	private void helper(StringBuilder sofar, String remain, ArrayList<String> result, int count) {
		// if it is the last(4th) part of the ip address
		if (count == 4) {
			if (isValid(remain)) {
				int oldlen = sofar.length();
				sofar.append(remain);
				result.add(sofar.toString());
				sofar.delete(oldlen, sofar.length());
			}
		}
		else {
			for (int i=1; i<=3; i++) {
				if (remain.length() < i) {
					break;
				}
				String substr = remain.substring(0, i);
				if (isValid(substr)) {
					int oldlen = sofar.length();
					sofar.append(substr + ".");
					helper(sofar, remain.substring(i), result, count+1);
					sofar.delete(oldlen, sofar.length());
				}
			}
		}
	}
	
	private boolean isValid(String str) {
		if (str.equals("") || str.length()>3) {
			return false;
		}
		if (str.charAt(0) == '0') return str.equals("0");
		int num = Integer.parseInt(str);
		return num <= 255 && num > 0;
	}
}
