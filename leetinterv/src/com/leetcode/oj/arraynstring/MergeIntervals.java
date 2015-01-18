package com.leetcode.oj.arraynstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

 * Note: Though the following solution passed the test, the time consumed is
 * quite long compared to most of other solutions in leetcode.
 * TOO SLOW!
 */

//Definition for an interval.
class Interval implements Comparable<Interval> {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	
	@Override
	public String toString() {
		return new String("[" + start + "," + end + "]");
	}
	
	@Override
	public int compareTo(Interval interval) {
		if (this.start > interval.start) return 1;
		if (this.start < interval.start) return -1;
		return 0;
	}
}

public class MergeIntervals {
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2,3));
		intervals.add(new Interval(4,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,9));
		intervals.add(new Interval(1,10));
		/*intervals.add(new Interval(1,4));
		intervals.add(new Interval(0,5));*/
		
		System.out.println(MergeIntervals.merge(intervals));
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) return result;
        Collections.sort(intervals);

        result.add(intervals.get(0));
        for (int i=1; i<intervals.size(); i++) {
        	
        	Interval last = result.get(result.size()-1);
        	Interval cur = intervals.get(i);
        	
        	if (last.end < cur.start) {// no overlapping
        		result.add(cur);
        	}
        	// overlapping
        	else if (last.end >= cur.start && last.end <= cur.end) {
        		Interval merged = new Interval(result.get(result.size()-1).start, cur.end);
        		result.remove(result.size()-1);
        		result.add(merged);
        	}
        }
        
        return result;
    }
}
