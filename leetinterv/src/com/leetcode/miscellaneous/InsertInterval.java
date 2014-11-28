package com.leetcode.miscellaneous;

import java.util.ArrayList;
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

public class InsertInterval {
	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		List<Interval> intervals = new ArrayList<Interval>();
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
		List<Interval> result = new ArrayList<Interval>();
		if (intervals.isEmpty()) {
			result.add(newInterval);
			return result;
		}
		if (newInterval.start<=intervals.get(0).start && newInterval.end>=intervals.get(intervals.size()-1).end) {
			result.add(newInterval);
			return result;
		}
		
		boolean merged = false;
		int merged_start = -1;
		
		for (int i=0; i<intervals.size(); i++) {
			int cur_start = intervals.get(i).start;
			int cur_end = intervals.get(i).end;
			
			int next_start = -1;
			if (i<intervals.size()-1) {
				next_start = intervals.get(i+1).start;
			}
			else {
				next_start = Integer.MAX_VALUE;
			}
			
			if (cur_end < newInterval.start || cur_start > newInterval.end) { // if current interval has no overlap with new interval
				if (!merged && newInterval.end < cur_start) {                 // need to take care 
					if (merged_start != -1) {
						result.add(new Interval(merged_start,newInterval.end));
					}
					else {
						result.add(newInterval);
					}
					merged = true;
				}
				result.add(intervals.get(i));
				if (!merged && newInterval.start > cur_end && newInterval.end < next_start) {
					result.add(newInterval);
					merged = true;
				}
			}
			else {
				if (merged_start == -1) {
					
					if (newInterval.start < cur_start) {
						merged_start = newInterval.start;
						if (newInterval.end <= cur_end) {
							result.add(new Interval(merged_start, cur_end));
							merged = true;
						}
						else if (newInterval.end >= cur_end && newInterval.end < next_start) {
							result.add((new Interval(merged_start, newInterval.end)));
							merged = true;
						}
						else if (newInterval.end < cur_start) {
							result.add(newInterval);
							result.add(intervals.get(i));
							merged = true;
						}
						else if (newInterval.end == cur_start) {
							result.add(new Interval(newInterval.start, cur_end));
							merged = true;
						}
					}
					else if (newInterval.start >= cur_start && newInterval.start <= cur_end) { // if newInterval's start falls btw cur_start and cur_end, 
						if (newInterval.end <= cur_end) {                                      // inclusively
							result.add(new Interval(cur_start, cur_end));
							merged = true;
						}
						else if (newInterval.end >= cur_end && newInterval.end < next_start) {
							result.add(new Interval(cur_start, newInterval.end));
							merged = true;
						}
						else {
							merged_start = cur_start;
						}
					}
					else if (newInterval.start >= cur_end && newInterval.end <= next_start) { // if both newInterval's start and end fall btw cur_end and next_start
						result.add(new Interval(merged_start, newInterval.end));
						merged = true;
					}
				}
				else {
					if (newInterval.end < cur_start) {
						result.add(new Interval(merged_start, newInterval.end));
						result.add(intervals.get(i));
						merged = true;
					}
					else if (newInterval.end >= cur_start && newInterval.end <= cur_end){ // if newInterval's end falls btw current start and current end
						result.add(new Interval(merged_start, cur_end));
						merged = true;
					}
					else if (i==intervals.size()-1) {
						result.add(new Interval(merged_start, newInterval.end));
					}
				}
			}
		}
		return result;
    }
}