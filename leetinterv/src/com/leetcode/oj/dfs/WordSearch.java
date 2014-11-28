package com.leetcode.oj.dfs;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.For example, Given board =

	[
  		["ABCE"],
  		["SFCS"],
  		["ADEE"]
	]
	
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
	
 * Solution: depth-first search
 */

public class WordSearch {
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		System.out.println(ws.exist(board, "ABCCED"));
		System.out.println(ws.exist(board, "SEE"));
		System.out.println(ws.exist(board, "ABCB"));
	}
	
	public boolean exist(char[][] board, String word) {
        // create a 2-D array indicating if a corresponding cell is
		// used or not
		int rlen = board.length;
		int clen;
		if (rlen != 0) {
			clen = board[0].length;
		}
		else {
			return false;
		}
		
		// init the mirror array
		boolean[][] mirror = new boolean[rlen][clen];
		for (int r=0; r<rlen; r++) {
			for (int c=0; c<clen; c++) {
				mirror[r][c] = false;
			}
		}
		
		for (int r=0; r<rlen; r++) {
			for (int c=0; c<clen; c++) {
				if (board[r][c] == word.charAt(0)) {
					if (existHelper(board, mirror, word, 0, r, c)) {
						return true;
					}
				}
			}
		}
		
		return false;
    }
	
	private boolean existHelper(char[][] board, boolean[][] mirror, String word, int depth, int cur_row, int cur_col) {
		if (depth == word.length()-1) {
			if (board[cur_row][cur_col]==word.charAt(depth)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			// mark the current cell as used
			mirror[cur_row][cur_col] = true;
			
			// continue to the one on top
			if (cur_row-1>=0 && !mirror[cur_row-1][cur_col] && board[cur_row-1][cur_col]==word.charAt(depth+1)) {
				if (existHelper(board, mirror, word, depth+1, cur_row-1, cur_col )) {
					return true;
				}
			}
			if (cur_row+1<board.length && !mirror[cur_row+1][cur_col] && board[cur_row+1][cur_col]==word.charAt(depth+1)) {
				if (existHelper(board, mirror, word, depth+1, cur_row+1, cur_col )) {
					return true;
				}
			}
			if (cur_col-1>=0 && !mirror[cur_row][cur_col-1] && board[cur_row][cur_col-1]==word.charAt(depth+1)) {
				if (existHelper(board, mirror, word, depth+1, cur_row, cur_col-1)) {
					return true;
				}
			}
			if (cur_col+1<board[0].length && !mirror[cur_row][cur_col+1] && board[cur_row][cur_col+1]==word.charAt(depth+1)) {
				if (existHelper(board, mirror, word, depth+1, cur_row, cur_col+1)) {
					return true;
				}
			}
			
			// mark the current cell as unused
			mirror[cur_row][cur_col] = false;
			return false;
		}
	}
}
