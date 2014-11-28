package com.leetcode.miscellaneous;

/*
 * Category: Unknown
 */

import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i=triangle.size()-1; i>0; i--) {
        	for (int j=0; j<triangle.get(i).size()-1; j++) {
        		
        		int max = triangle.get(i).get(j).intValue() < triangle.get(i).get(j+1).intValue() ? triangle.get(i).get(j).intValue() : triangle.get(i).get(j+1).intValue();
        		int sum = max + triangle.get(i-1).get(j).intValue();
        		triangle.get(i-1).set(j, new Integer(sum));
        	}
        }
        
        return triangle.get(0).get(0).intValue();
    }
}
