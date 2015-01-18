package com.careercup.stacknqueue;

import java.util.Stack;

/*
 * Write a program to sort a stack in ascending order. You should not make any assump-
tions about how the stack is implemented. The following are the only functions that
should be used to write this program: push | pop | peek | isEmpty.
 */

public class SortStack {
	public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(4);
        s.push(2);
        s.push(1);
        s.push(3);
        for (int i=0; i<s.size(); i++) {
            System.out.print(s.get(i) + " ");
        }
        System.out.println();
        
        Stack<Integer> sorted = SortStack.sort(s);
        for (int i=0; i<sorted.size(); i++) {
            System.out.print(sorted.get(i) + " ");
        }
        System.out.println();
    }
    
    // sort a stack into ascending order
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> sorted = new Stack<Integer>();
        
        while (!s.isEmpty()) {
            Integer cur = s.pop();
            while (!sorted.isEmpty() && cur.intValue() < sorted.peek()) {
                s.push(sorted.pop());
            }
            sorted.push(cur);
        }
        
        return sorted;
    }
}
