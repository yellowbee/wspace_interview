package com.interviewexposed.arraynstring;

import java.util.Arrays;

/*
 * Solution 1: Using a pointer to indicate which row the current character belongs
 * to; make sure to change the moving direction of the pointer once it
 * hits the first row and or the last row. This version implements solution 1.
 * 
 * Solution 2: Take every (n+1)th element and repeat until no more elements left;
 * For example, if nRows = 3, starting from S[0], take every 4th element and put it
 * in sequence; when running out, starting from S[1], S[2], S[3];
 * 
 */

public class ZigZagConversion {
	public static void main(String[] args) {
		System.out.println(ZigZagConversion.convert("POSI", 5));
	}
	
	public static String convert(String s, int nRows) {
		if (nRows == 1 || nRows >= s.length()) return s;
		
        StringBuffer[] rows = new StringBuffer[nRows];
        Arrays.fill(rows, null);
        
        int rowNum = -1;
        int step = 1;
        for (int i=0; i<s.length(); i++) {
        	rowNum += step;
        	if (rowNum == nRows) {
        		rowNum -= 2;
        		step = 0 - step;
        	}
        	else if (rowNum == -1) {
        		rowNum += 2;
        		step = 0 - step;
        	}

        	if (rows[rowNum] == null) {
        		rows[rowNum] = new StringBuffer();
        	}
        	rows[rowNum].append(s.charAt(i));
        }
        
        StringBuffer result = new StringBuffer();
        for (int i=0; i<rows.length; i++) {
        	result.append(rows[i]);
        }
        
        return result.toString();
    }
}
