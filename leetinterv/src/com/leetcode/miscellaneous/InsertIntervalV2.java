package com.leetcode.miscellaneous;

import java.util.LinkedList;
import java.util.List;

import com.leetcode.oj.common.Interval;

/*
 * Test cases:
 * [[1,5]], [5,7]
 * [[1,3]], [5,7]
 * [[1,5]], [1,7]
 * [[1,5]], [0,0]
 * [[1,5],[6,8]], [5,6]
 * [[2,5],[6,7],[8,9]], [0,1]
 * [[2,4],[5,7],[8,10],[11,13]], [3,8]
 * [[0,0],[1,4],[6,8],[9,11]], [0,9]
 * [[0,7],[8,8],[9,11]], [4,13]
 * [[1,5],[6,8]], [0,9]
 * [[2,7],[8,8],[10,10],[12,13],[16,19]], [9,17]
 * [[0,0],[1,3],[5,8],[9,14],[15,17],[19,21]], [10,18]
 */

/*
 * Given a set of non-overlapping intervals, insert a new interval into
 * the intervals (merge if necessary). You may assume that the intervals
 * were initially sorted according to their start times.
 */

/*
 * Analysis:
 * In other words, the questions gives a new interval, the task is to insert
 * this new interval into an ordered non-overlapping intervals. Consider the merge case.
 * Idea to solve this problem is quite straight forward:
 * 1. Insert the new interval according to the start value.
 * 2. Scan the whole intervals, merge two intervals if necessary.
 */
public class InsertIntervalV2 {
	public static void main(String[] args) {
		InsertIntervalV2 ii = new InsertIntervalV2();
		List<Interval> intervals = new LinkedList<Interval>();
		intervals.add(new Interval(0,0));
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(5,8));
		intervals.add(new Interval(9,14));
		intervals.add(new Interval(15,17));
		intervals.add(new Interval(19,21));
		Interval newInterval = new Interval(10,18);
		
		System.out.println(ii.insert(intervals, newInterval));
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return intervals;
		}
		
		// insert the new interval to its proper position in the interval list
		if (newInterval.start >= intervals.get(intervals.size()-1).start) {
			intervals.add(newInterval);
		}
		else {
			for (int i=0; i<intervals.size(); i++) {
				if (newInterval.start < intervals.get(i).start) {
					intervals.add(i, newInterval);
					break;
				}
			}
		}
		
		int cur = 0;
		while (true) {
			// if there's overlapping
			if (cur < intervals.size()-1 && intervals.get(cur).end >= intervals.get(cur+1).start) {
				int newStart = Math.min(intervals.get(cur).start, intervals.get(cur+1).start);
				int newEnd = Math.max(intervals.get(cur).end, intervals.get(cur+1).end);
				Interval mergedInterval = new Interval(newStart, newEnd);
				intervals.remove(cur);
				intervals.remove(cur);
				intervals.add(cur, mergedInterval);
			}
			// if the last interval in intervals
			else if (cur == intervals.size()-1) {
				break;
			}
			else {
				cur++;
			}
		}
		
		return intervals;
	}
}
