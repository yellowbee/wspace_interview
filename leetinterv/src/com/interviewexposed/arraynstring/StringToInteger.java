package com.interviewexposed.arraynstring;

public class StringToInteger {
	public static void main(String[] args) {
		System.out.println(StringToInteger.atoi("1"));
		System.out.println("absolute MIN_VALUE: " + (0-Integer.MIN_VALUE));
	}
	
	public static int atoi(String str) {
        String trimmed = str.trim(); // remove any leading/trailing whitespaces
        if (trimmed.equals("")) return 0;
                
        long result = 0;
        int ptr = 0;
        boolean positive = true;
        if (trimmed.charAt(0) == '-') {
        	positive = false;
        	ptr += 1;
        }
        else if (trimmed.charAt(0) == '+') {
        	ptr += 1;
        }
        
        while (ptr < trimmed.length() && Character.isDigit(trimmed.charAt(ptr))) {
        	int cur_digit = Character.getNumericValue(trimmed.charAt(ptr));
        	result = result * 10 + cur_digit;
        	if (positive && !(result < Integer.MAX_VALUE)) {
        		return Integer.MAX_VALUE;
        	}
        	else if (!positive && (-result < Math.abs(Integer.MIN_VALUE))){
        		return Integer.MIN_VALUE;
        	}
        	ptr++;
        }
        
        return positive ? (int)result : -(int)result;
    }
}
