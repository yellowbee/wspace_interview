package com.leetcode.oj.search;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	private static final int BLOCKLEN = 3;
	
	public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<board.length; i++) {
        	for (int j=0; j<board[0].length; j++) {
        		if (!checkValidity(board, i, j)) {
        			return false;
        		}
        	}
        }
        return true;
    }
	
	// check the validity of the board status
	public static boolean checkValidity(char[][] board, int i, int j) {
		Set<Character> set = new HashSet<Character>();
		
		// check row
		set.clear();
		for (int col=0; col<board[0].length; col++) {
			if (board[i][col] != '.') {
				if (set.contains(board[i][col])) {
					return false;
				}
				else {
					set.add(board[i][col]);
				}
			}
		}
		// check col
		set.clear();
		for (int row=0; row<board.length; row++) {
			if (board[row][j] != '.') {
				if (set.contains(board[row][j])) {
					return false;
				}
				else {
					set.add(board[row][j]);
				}
			}
		}
		// check local block
		set.clear();
		int row_upperleft = i - (i % BLOCKLEN);
		int col_upperleft = j - (j % BLOCKLEN);
		for (int row=row_upperleft; row<row_upperleft+BLOCKLEN; row++) {
			for (int col=col_upperleft; col<col_upperleft+BLOCKLEN; col++) {
				if (board[row][col] != '.') {
					if (set.contains(board[row][col])) {
						return false;
					}
					else {
						set.add(board[row][col]);
					}
				}
			}
		}
		
		return true;
	}
}
