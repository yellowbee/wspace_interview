package com.leetcode.miscellaneous;

import java.util.ArrayList;

/*
 * Category: Unknown
 */

public class PascalsTriangle {
	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		System.out.println(pt.generate(5));
	}
	
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if (numRows <= 0) {
        	return new ArrayList<ArrayList<Integer>>();
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> first_row = new ArrayList<Integer>();
        first_row.add(new Integer(1));
        result.add(first_row);
        for (int i=1; i<numRows; i++) {
        	ArrayList<Integer> cur_row = new ArrayList<Integer>();
        	cur_row.add(new Integer(1));
        	for (int j=1; j<i; j++) {
        		int cur_int = result.get(i-1).get(j-1).intValue() + result.get(i-1).get(j).intValue();
        		cur_row.add(new Integer(cur_int));
        	}
        	cur_row.add(new Integer(1));
        	result.add(cur_row);
        }
        
        return result;
    }
}
