package com.leetcode.oj.search;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
	private static final int BLOCKLEN = 3;
	
	public static void main(String[] args) {
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
						  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
						  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
						  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
						  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
						  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
						  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
						  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
						  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		
		for (int i=0; i<board.length; i++) {
			System.out.println(board[i]);
		}
		System.out.println();
		SudokuSolver ss = new SudokuSolver();
		
		/*for (char ch='1'; ch<='9'; ch++) {
			System.out.println(ch);
		}*/
		/*board[0][2] = '5';
		System.out.println(ss.checkValidity(board, 0, 0));*/
		
		ss.solveSudoku(board);
		for (int i=0; i<board.length; i++) {
			System.out.println(board[i]);
		}
	}
	
	public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
	
	// (last_row, last_col) is the starting point for searching the next empty cell
	private boolean helper(char[][] board, int last_row, int last_col) {
		int cur_row = -1;
		int cur_col = -1;
		
		int pos = last_row*board[0].length + last_col;
		// looking for the next empty cell(cell with '.')
		boolean cur_found = false;
		for (int i=last_row*board[0].length + last_col; i<board.length*board[0].length; i++) {
			if (board[i/board[0].length][i%board[0].length] == '.') {
				cur_row = i/board[0].length;
				cur_col = i%board[0].length;
				cur_found = true;
				break;
			}
		}

		if (cur_found) {
			for (char ch='1'; ch<='9'; ch++) {
				board[cur_row][cur_col] = ch;
				if (checkValidity(board, cur_row, cur_col)) {
					if (helper(board, cur_row, cur_col)) {
						return true;
					}
				}
			}
			board[cur_row][cur_col] = '.';
			return false;
		}
		else {
			return true;
		}
	}
	
	// check the validity of the board status
	public boolean checkValidity(char[][] board, int i, int j) {
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
