package com.topcoder.stringnarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem Statement for ContestWinner


Problem Statement
    	
Exactly one million contestants, numbered 1 through 1,000,000, took part in a programming contest. The rules of the contest are simple: the winner is the contestant who solves the largest number of tasks. If there are more contestants tied for most tasks solved, the winner is the one who was the first to have all of their tasks solved.

During the contest the judges were keeping a log of all accepted solutions. You are given this log as a int[] events. The i-th element of events is the number of the contestant who submitted the i-th accepted solution (both indices are 0-based).

For example, if events = {4, 7, 4, 1}, this is what happened during the contest:

Contestant 4 solved her first task.
Contestant 7 solved his first task.
Contestant 4 solved her second task.
Contestant 1 solved his first task.
Compute and return the number of the contestant who won the contest.

 
Definition
    	
Class:	ContestWinner
Method:	getWinner
Parameters:	int[]
Returns:	int
Method signature:	int getWinner(int[] events)
(be sure your method is public)
    
 
Constraints
-	events will contain between 1 and 50 elements, inclusive.
-	Each element of events will be between 1 and 1,000,000, inclusive.
 
Examples
0)	
    	
{4,7,4,1}
Returns: 4
Example from the problem statement.
1)	
    	
{10,20,30,40,50}
Returns: 10
2)	
    	
{123,123,456,456,456,123}
Returns: 456
3)	
    	
{1,2,2,3,3,3,4,4,4,4}
Returns: 4

 Single Round Match 546 Round 1 - Division II, Level One
 */

public class ContestWinner {
	public static void main(String[] args) {
		ContestWinner cw = new ContestWinner();
		int[] events = {1,2,2,3,3,3,4,4,4,4};
		System.out.println(cw.getWinner(events));
	}
	
	public int getWinner(int[] events) {
		Map<Integer, Integer> solvedTasks = new HashMap<Integer, Integer>();
		Map<Integer, Integer> timeOfLastTask = new HashMap<Integer, Integer>();
		
		for (int i=0; i<events.length; i++) {
			if (solvedTasks.containsKey(events[i])) {
				solvedTasks.put(events[i], solvedTasks.get(events[i])+1);
			}
			else {
				solvedTasks.put(events[i], 1);
			}
			timeOfLastTask.put(events[i], i);
		}
		
		List<Integer> maxTasks = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		for (Integer key : solvedTasks.keySet()) {
			int value = solvedTasks.get(key);
			if (value > max) {
				max = value; 
				maxTasks.clear();
				maxTasks.add(key);
			}
			else if (value == max) {
				maxTasks.add(key);
			}
		}
		
		if (maxTasks.size() == 1) {
			return maxTasks.get(0).intValue();
		}
		int first = Integer.MAX_VALUE;
		int winner = -1;
		for (Integer key : maxTasks) {
			if (timeOfLastTask.get(key).intValue() < first) {
				first = timeOfLastTask.get(key);
				winner = key;
			}
		}
		return winner;
	}

}
