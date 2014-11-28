package com.leetcode.miscellaneous;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = {"helloabc", "hellodef", "helloghi"};
		System.out.println(lcp.longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix(String[] strs) {
		if (strs == null) {
			return null;
		}
		if (strs.length == 0) {
		    return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		
        int char_idx = 0;
        boolean done = false;
        
        while (true) { // you don't know how long you may go through each string
        	char cur_ch;
        	if (strs[0].length() > char_idx) {
        		cur_ch = strs[0].charAt(char_idx);
        	}
        	else {
        		done = true;
        		break;
        	}
        	
        	for (int j=1; j<strs.length; j++) {
        		if (strs[j].length() > char_idx) {
        			if (strs[j].charAt(char_idx) != cur_ch) {
        				done = true;
        				break;
        			}
        		}
        		else {
        			done = true;
        			break;
        		}
        	}
        	if (done) {
        		break;
        	}
        	char_idx++;
        }
        
        return strs[0].substring(0, char_idx);
    }
}
