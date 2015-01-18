package com.topcoder.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Problem Statement for SortingGame


Problem Statement
    	In The Sorting Game, you are given a sequence containing a permutation of the integers between 1 and n, inclusive. In one move, you can take any k consecutive elements of the sequence and reverse their order. The goal of the game is to sort the sequence in ascending order. You are given a int[] board describing the initial sequence. Return the fewest number of moves necessary to finish the game successfully, or -1 if it's impossible.
 
Definition
    	
Class:	SortingGame
Method:	fewestMoves
Parameters:	int[], int
Returns:	int
Method signature:	int fewestMoves(int[] board, int k)
(be sure your method is public)
    
 
Constraints
-	board will contain between 2 and 8 elements, inclusive.
-	Each integer between 1 and the size of board, inclusive, will appear in board exactly once.
-	k will be between 2 and the size of board, inclusive.
 
Examples
0)	
    	
{1,2,3}
3
Returns: 0
The sequence is already sorted, so we don't need any moves.
1)	
    	
{3,2,1}
3
Returns: 1
We can reverse the whole sequence with one move here.
2)	
    	
{5,4,3,2,1}
2
Returns: 10
This one is more complex.
3)	
    	
{3,2,4,1,5}
4
Returns: -1
4)	
    	
{7,2,1,6,8,4,3,5}
4
Returns: 7

This problem was used for: 
       Single Round Match 397 Round 1 - Division I, Level One 
       Single Round Match 397 Round 1 - Division II, Level Two
       
   Solution: BFS
 */

public class SortingGame {
	public static void main(String[] args) {
		SortingGame sg = new SortingGame();
		int[] board = {5,4,3,2,1};
		System.out.println(sg.fewestMoves(board, 2));
	}
	
	public int fewestMoves(int[] board, int k) {
		if (isSorted(board)) return 0;
		
		int LEN = board.length;	
		Queue<int[]> cur_level = new LinkedList<int[]>();
		Queue<int[]> next_level = new LinkedList<int[]>();
		Set<String> set = new HashSet<String>();
		
		cur_level.add(board);
		set.add(Arrays.toString(board));
		int level = 1;
		while (!cur_level.isEmpty()) {
			int[] seq = cur_level.remove();
			for (int i=0; i<=LEN-k; i++) {
				int[] newSeq = Arrays.copyOf(seq, LEN);
				reverse(newSeq, i, k);
				if (isSorted(newSeq)) return level;
				String str_newSeq = Arrays.toString(newSeq);
				if (!set.contains(str_newSeq)) {
					set.add(Arrays.toString(newSeq));
					next_level.add(newSeq);
				}
			}
			
			if (cur_level.isEmpty()) {
				Queue<int[]> temp = cur_level;
				cur_level = next_level;
				next_level = temp;
				level++;
				//System.out.println(level + " " + cur_level.size());
			}
		}
		
		return -1;
	}
	
	public void reverse(int[] board, int start, int k) {
		int left = start;
		int right = start + k - 1;
		while (left < right) {
			int temp = board[left];
			board[left] = board[right];
			board[right] = temp;
			left++;
			right--;
		}
	}
	
	public boolean isSorted(int[] board) {
		for (int i=1; i<board.length; i++) {
			if (board[i] < board[i-1]) {
				return false;
			}
		}
		return true;
	}
}
