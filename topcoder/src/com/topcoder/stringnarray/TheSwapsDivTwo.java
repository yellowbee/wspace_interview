package com.topcoder.stringnarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem Statement for TheSwapsDivTwo


Problem Statement
    	John has a sequence of integers. Brus is going to choose two different positions in John's sequence and swap the elements at those positions. (The two swapped elements may have the same value.) Return the number of different sequences Brus can obtain after he makes the swap.
 
Definition
    	
Class:	TheSwapsDivTwo
Method:	find
Parameters:	int[]
Returns:	int
Method signature:	int find(int[] sequence)
(be sure your method is public)
    
 
Constraints
-	sequence will contain between 2 and 47 elements, inclusive.
-	Each element of sequence will be between 1 and 47, inclusive.
 
Examples
0)	
    	
{4, 7, 4}
Returns: 3
If Brus swaps elements 0 and 1 (0-based indices), the sequence will change to {7, 4, 4}. If he swaps elements 1 and 2 instead, the sequence will change to {4, 4, 7}. Finally, if the swaps elements 0 and 2, the sequence will remain {4, 7, 4}. These three outcomes are all distinct.
1)	
    	
{1, 47}
Returns: 1
Brus has to swap the only two elements, producing the sequence {47, 1}. Note that Brus has to make the swap, he cannot keep the original sequence.
2)	
    	
{9, 9, 9, 9}
Returns: 1
Regardless of which two elements Brus swaps, the resulting sequence will always be {9, 9, 9, 9}.
3)	
    	
{22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37}
Returns: 319
 */

public class TheSwapsDivTwo {
	public static void main(String[] args) {
		int[] sequence = {4,7,4};
		System.out.println(TheSwapsDivTwo.find(sequence));
	}
	
	public static int find(int[] sequence) {
		int LEN = sequence.length;
		Set<int[]> result = new HashSet<int[]>();
		List<Integer> first = new ArrayList<Integer>();
		for (int i=0; i<LEN; i++) {
			first.add(sequence[i]);
		}
		result.add(sequence);
		
		for (int i=0; i<LEN; i++) {
			for (int j=i+1; j<LEN; j++) {
				if (sequence[i] != sequence[j]) {
					int[] newSeq = Arrays.copyOf(sequence, LEN);
					int temp = newSeq[i];
					newSeq[i] = newSeq[j];
					newSeq[j] = temp;
					if (!result.contains(newSeq)) {
						result.add(newSeq);
					}
				}
			}
		}
		
		return result.size();
	}

}
