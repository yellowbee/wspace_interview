package com.leetcode.miscellaneous;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		int leftGas = 0;
		int cur_sum = 0;
		int startnode = 0;
		
        int[] diff = new int[len];
        for (int i=0; i<len; i++) {
        	diff[i] = gas[i] - cost[i];
        	leftGas += diff[i];
        	
        	cur_sum += diff[i];
        	if (cur_sum < 0) {
        		cur_sum = 0;
        		startnode = i + 1;
        	}
        }
        
        if (leftGas < 0) {
        	return -1;
        }
        else {
        	return startnode;
        }

    }
}
