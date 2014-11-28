package com.rubyquiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistinctSets {
	public static void main(String[] args) {
		List<Set<Character>> start = new ArrayList<Set<Character>>();
		start.add(new HashSet<Character>(Arrays.asList('D','E','G')));
		start.add(new HashSet<Character>(Arrays.asList('C','J','K','M')));
		start.add(new HashSet<Character>(Arrays.asList('K','M')));
		start.add(new HashSet<Character>(Arrays.asList('H')));
		start.add(new HashSet<Character>(Arrays.asList('D','H','L','R')));
		start.add(new HashSet<Character>(Arrays.asList('G','L')));
		
		DistinctSets ds = new DistinctSets();
		List<Set<Character>> result = ds.merge(start);
		System.out.println(result);
	}
	
	public List<Set<Character>> merge(List<Set<Character>> start) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		// init the boolean array that indicates which set has been merged so far
		boolean[] merged = new boolean[start.size()];
		boolean[] to_remove = new boolean[start.size()];
		for (int i=0; i<merged.length; i++) {
			merged[i] = false;
			to_remove[i] = false;
		}
		
		
		
		for (int i=0; i<start.size(); i++) {
			if (!merged[i]) { // if the current set has not been merged yet
				Set<Character> cur_set = start.get(i);
				List<Integer> idx_to_merge = new ArrayList<Integer>();// stores the set labels to be merged
				
				for (Character ch : cur_set) {
					if (map.containsKey(ch)) {// if appears in some set
						idx_to_merge.add(map.get(ch));
						merged[map.get(ch)] = true;
					}
				}
				
				if (idx_to_merge.size()>0) { // if there are sets to merge
					idx_to_merge.add(i);
					for (int s=1; s<idx_to_merge.size(); s++) { // merge
						start.get(idx_to_merge.get(0)).addAll(start.get(idx_to_merge.get(s)));
						to_remove[idx_to_merge.get(s)] = true;
					}
					for (Character ch : start.get(idx_to_merge.get(0))) { // update the map
						map.put(ch, idx_to_merge.get(0));
					}
				}
				else {
					for (Character ch : cur_set) {
						map.put(ch, i);
					}
				}
			}
		}
		List<Set<Character>> result = new ArrayList<Set<Character>>();
		for (int i=0; i<to_remove.length; i++) {
			if (!to_remove[i]) {
				result.add(start.get(i));
			}
		}
		return result;
	}
}
