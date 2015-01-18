package com.topcoder.binarysearch;

/*
 *  Single Round Match 169 Round 1 - Division I, Level Two 
    Single Round Match 169 Round 1 - Division II, Level Three
 */

import java.util.Arrays;

/*
 * Constraints
 * -	folders will contain between 2 and 15 elements, inclusive
 * -	Each element of folders will be between 1 and 1000, inclusive
 * -	workers will be between 1 and the number of elements in folders, inclusive
 * 
 * 0)	
 * { 10, 20, 30, 40, 50, 60, 70, 80, 90 }
 * 3
 * Returns: 170
 * 
 * 2)
 * { 568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782 }
 * 4
 * Returns: 1785
 * 
 * 3)
 * { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000 }
 * 2
 * Returns: 1000
 * 
 * 4)
 * { 50, 50, 50, 50, 50, 50, 50 }
 * 2
 * Returns: 200
 * 
 * 5)
 * {1,1,1,1,100}
 * 5
 * Returns: 100
 * 
 * 6)
 * { 950, 650, 250, 250, 350, 100, 650, 150, 150, 700 }
 * 6
 * Returns: 950
 */

public class FairWorkLoad {
	private static int UPPER_BOUND = 15 * 1000;
	
	public static void main(String[] args) {
		FairWorkLoad fw = new FairWorkLoad();
		int[] folders = { 950, 650, 250, 250, 350, 100, 650, 150, 150, 700 };
		//System.out.println(fw.canDo(folders, 2, 109));
		System.out.println(fw.getMostWork(folders, 6));
	}

	public int getMostWork(int[] folders, int workers) {
		int left = 0;
		int right = UPPER_BOUND;
		int mid = UPPER_BOUND;
		
		while (left <= right) {
			mid = (left + right) / 2;
			if (canDo(folders, workers, mid)) {
				if (!canDo(folders, workers, mid-1)) break;
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		
		return mid;
	}
	
	public boolean canDo(int[] folders, int workers, int max) {
		int[] assignment = new int[workers];
		Arrays.fill(assignment, 0);
		int cur_worker = 0;
		
		for (int i=0; i<folders.length; i++) {
			if (folders[i] + assignment[cur_worker] <= max) {
				assignment[cur_worker] += folders[i];
			}
			else if (cur_worker < workers-1) {
				cur_worker++;
				if (assignment[cur_worker] + folders[i] <= max) {
					assignment[cur_worker] = folders[i];
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
}
