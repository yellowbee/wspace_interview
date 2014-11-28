package com.leetcode.miscellaneous;

import java.util.Stack;

/********
 * category: Stack operation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

Algorithm:
while the string has more tokens
	if  current token is a string of numbers
		push it into the stack
	else 
   		pop the top two tokens as operands and perform the operation
   		represented by the current token on the two poped operands
   		push the result into the stack
*********/


public class EvalReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<String>();
        String tok = null;
        
        int len = tokens.length;
        int i = 0;
        while (i < len) {
        	tok = tokens[i];
        	// if string is of all numbers
        	// taking negative integer into consideration
        	if (tok.matches("-{0,1}\\d+")) {
        		s.push(tok);
        	}
        	else {
        		int opn1 = Integer.parseInt(s.pop());
        		int opn2 = Integer.parseInt(s.pop());
        		switch(tok) {
        			case "+" : 	s.push(String.valueOf(opn2 + opn1));
        						break;
        			case "-" : 	s.push(String.valueOf(opn2 - opn1));
								break;
        			case "*" : 	s.push(String.valueOf(opn2 * opn1));
								break;
        			case "/" : 	s.push(String.valueOf(opn2 / opn1));
								break;
        		}
        	}
        	i++;
        }
		return Integer.parseInt(s.pop());
    }
	public static void main(String[] args) {
		EvalReversePolishNotation er = new EvalReversePolishNotation();
		String[] tokens = {"-2", "1", "+", "3", "*"};
		System.out.println(er.evalRPN(tokens));
	}
}
