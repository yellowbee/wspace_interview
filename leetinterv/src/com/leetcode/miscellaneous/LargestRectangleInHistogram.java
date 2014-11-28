package com.leetcode.miscellaneous;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();
		int[] histos = {2,1,5,6,2,3};
		System.out.println(lrh.largestRectangleArea(histos));
		
	}
	public int largestRectangleArea(int[] histos) {
		// create two stacks for the heights and indexes of the histograms
        Stack<Integer> heights = new Stack<Integer>();
        Stack<Integer> indexes = new Stack<Integer>();
        
        int maxSize = 0;
        
        for (int i=0; i<histos.length; i++) {
        	// case 1: if current bar height is larger than top of stack,
        	//         which is the height of the previous bar
        	if (heights.empty() || histos[i] > heights.peek()) {
        		heights.push(histos[i]);
        		indexes.push(i);
        	}
        	// case 3: if current bar is shorter than top of stack
        	else if (histos[i] < heights.peek()) {
        		// keep popping out heights until a shorter bar is met
        		int lastIndex = i;
        		while (!heights.isEmpty() && histos[i] < heights.peek()) {
        			lastIndex = indexes.pop();
        			int tempSize = heights.pop() * (i - lastIndex);
        			if (maxSize < tempSize) {
        				maxSize = tempSize;
        			}
        		}
        		
        		// Insert a merged big bar here
        		heights.push(histos[i]);
        		indexes.push(lastIndex);
        	}
        }
        
        // After the histograms has been processed, the heights stack may not be empty
        // Needs to be processed.
        while (!heights.isEmpty()) {
        	int tempSize = heights.pop() * (histos.length - indexes.pop());
        	if (maxSize < tempSize) {
        		maxSize = tempSize;
        	}
        }
        
        return maxSize;
    }
}
