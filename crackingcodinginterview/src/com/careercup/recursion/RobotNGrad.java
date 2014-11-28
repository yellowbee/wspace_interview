package com.careercup.recursion;

public class RobotNGrad {
	public static void main(String[] args) {
		System.out.println(RobotNGrad.numPaths(10));
	}
	
	public static int numPaths(int n) {
	    return helper(0, 0, n);
	}

	// (x, y) is the starting cell
	private static int helper(int x, int y, int LEN) {
		if (x == LEN - 1 && y == LEN - 1) return 1;
		
	    int num_down = 0;
	    int num_right = 0;
	    
	    if (x+1 < LEN) { // downward
	        num_down = helper(x+1, y, LEN);
	    }
	    if (y+1 < LEN) { // rightward
	        num_right = helper(x, y+1, LEN);
	    }
	    
	    return num_down + num_right;
	}
}
