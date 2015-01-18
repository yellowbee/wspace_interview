package com.leetcode.oj.dfs;

public class WordSearchV2 {
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
		int LEN_ROW = board.length;
		int LEN_COL;
		if (LEN_ROW == 0) {
			return false;
		}
		else {
			LEN_COL = board[0].length;
		}

		boolean[][] visited = new boolean[LEN_ROW][LEN_COL];
		for (int i=0; i<LEN_ROW; i++) {
			for (int j=0; j<LEN_COL; j++) {
				visited[i][j] = false;
			}
		}
		
		for (int i=0; i<LEN_ROW; i++) {
			for (int j=0; j<LEN_COL; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (existHelper(board, i, j, visited, word)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	// recursive function, called on the board[x][y] with target 'word'
	// compared with version 1, the variable 'depth' is removed. No depth info
	// is needed since the word is one character shorter for each recursion and
	// once this lengh reaches 1, that's the end of the recursion.
	public boolean existHelper(char[][] board, int x, int y, boolean[][] visited, String word) {
	    if (board[x][y] != word.charAt(0)) return false;
	    if (word.length() == 1) return true;
	    
	    visited[x][y] = true;
	    int LEN_ROW = board.length;
	    int LEN_COL = board[0].length;
	    
	    if (x-1 >= 0 && !visited[x-1][y] && board[x-1][y]==word.charAt(1)) {
	        if (existHelper(board, x-1, y, visited, word.substring(1))) return true;
	    }
	    
	    if (x+1 < LEN_ROW && !visited[x+1][y] && board[x+1][y]==word.charAt(1)) {
	        if (existHelper(board, x+1, y, visited, word.substring(1))) return true;
	    }
	    
	    if (y-1 >=0 && !visited[x][y-1] && board[x][y-1]==word.charAt(1)) {
	    	if (existHelper(board, x, y-1, visited, word.substring(1))) return true;
	    }
	    
	    if (y+1 < LEN_COL && !visited[x][y+1] && board[x][y+1]==word.charAt(1)) {
	    	if (existHelper(board, x, y+1, visited, word.substring(1))) return true;
	    }
	    
	    visited[x][y] = false;
	    return false;
	}
}
