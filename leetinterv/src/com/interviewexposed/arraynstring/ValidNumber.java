package com.interviewexposed.arraynstring;

/*
 * Using a finite state automata is the most graceful way.
 */

public class ValidNumber {
	public static final int INVALID = 0;
	public static final int SPACE = 1;
	public static final int SIGN = 2;
	public static final int DIGIT = 3;
	public static final int DOT = 4;
	public static final int EXPONENT = 5;
	
	public static final int[][] transTable = {
  	
			{-1,  0,  3,  1,  2, -1}, //0 初始无输入或者只有space的状态  
			{-1,  8, -1,  1,  4,  5}, //1 输入了数字之后的状态 
			{-1, -1, -1,  4, -1, -1}, //2 前面无数字，只输入了Dot的状态
			{-1, -1, -1,  1,  2, -1}, //3 输入了符号状态  
			{-1,  8, -1,  4, -1,  5}, //4 前面有数字和有dot的状态
			{-1, -1,  6,  7, -1, -1}, //5 'e' or 'E'输入后的状态
			{-1, -1, -1,  7, -1, -1}, //6 输入e之后输入Sign的状态
			{-1,  8, -1,  7, -1, -1}, //7 输入e后输入数字的状态
			{-1,  8, -1, -1, -1, -1}  //8 前面有有效数输入之后，输入space的状态 
	};
	
	public static void main(String[] args) {
		System.out.println(ValidNumber.isNumber("1 "));
	}
	
	public static boolean isNumber(String s) {
        int input = INVALID;
        int state = 0;
        for (int i=0; i<s.length(); i++) {
        	if (s.charAt(i) == ' ') {
        		input = SPACE;
        	}
        	else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
        		input = SIGN;
        	}
        	else if (Character.isDigit(s.charAt(i))) {
        		input = DIGIT;
        	}
        	else if (s.charAt(i) == '.') {
        		input = DOT;
        	}
        	else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
        		input = EXPONENT;
        	}
        	else {
        		input = INVALID;
        	}
        	
        	state = ValidNumber.transTable[state][input];
        	if (state == -1) return false;
        }
        
        return (state == 1 || state == 4 || state == 7 || state == 8);
    }
}
