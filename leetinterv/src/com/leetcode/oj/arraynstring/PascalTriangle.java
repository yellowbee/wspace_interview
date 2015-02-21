package com.leetcode.oj.arraynstring;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalTriangle {
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		List<Integer> result = pt.getRow(1);
		System.out.println(result);
	}
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if (rowIndex <= 0) return result;
        result.add(1);
        if (rowIndex == 1) {
        	return result;
        }
        
        for (int i=2; i<=rowIndex; i++) {
        	int j = result.size() - 1;
        	result.add(1);
        	while (j > 0) {
        		result.set(j, new Integer(result.get(j)+result.get(j-1)));
        		j--;
        	}
        }
        
        return result;
    }
}
