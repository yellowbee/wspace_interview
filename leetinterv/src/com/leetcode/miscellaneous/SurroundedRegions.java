package com.leetcode.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Category: BFS
 * 
 * 		X X X X
 * 		X O O X
 * 		X X O X
 * 		X O X X
 * 
 * 1. 从四条边上的O元素开始BFS，所有相连的O都赋个新值，比如‘Y’
 * 2. 扫描整个数组，所有现存的O元素全部置为X，所有Y元素置为O
 *    打完收工。
 */

public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
		sr.solve(board);
		sr.print2DArray(board);
	}
	
	public void solve(char[][] board) {
		
        int num_rows = board.length;
        if (num_rows == 0) {
        	return;
        }
        int num_cols = board[0].length;
        if (num_cols == 0) {
        	return;
        }
        
        // 1st row
        for (int col=0; col<num_cols; col++) {
        	if (board[0][col]=='O') {
        		bfs(new Node(0, col), board);
        	}
        }
        // last row
        for (int col=0; col<num_cols; col++) {
        	if (board[num_rows-1][col]=='O') {
        		bfs(new Node(num_rows-1, col), board);
        	}
        }
        // 1st col
        for (int row=1; row<num_rows-1; row++) {
        	if (board[row][0]=='O') {
        		bfs(new Node(row, 0), board);
        	}
        }
        // last col
        for (int row=1; row<num_rows-1; row++) {
        	if (board[row][num_cols-1]=='O') {
        		bfs(new Node(row, num_cols-1), board);
        	}
        }
        
        for (int row=0; row<num_rows; row++) {
        	for (int col=0; col<num_cols; col++) {
        		if (board[row][col] == 'Y') {
        			board[row][col] = 'O';
        		}
        		else if (board[row][col] == 'O') {
        			board[row][col] = 'X';
        		}
        	}
        }
    }
	
	public void bfs(Node n, char[][] board) {
		int num_rows = board.length;
        int num_cols = board[0].length;
        
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while (!q.isEmpty()) {
			Node cur_n = q.remove();
			board[cur_n.row][cur_n.col] = 'Y';
			if (cur_n.row-1>0 && board[cur_n.row-1][cur_n.col]=='O') {
				q.add(new Node(cur_n.row-1, cur_n.col));
			}
			if (cur_n.row+1<num_rows && board[cur_n.row+1][cur_n.col]=='O') {
				q.add(new Node(cur_n.row+1, cur_n.col));
			}
			if (cur_n.col-1>0 && board[cur_n.row][cur_n.col-1]=='O') {
				q.add(new Node(cur_n.row, cur_n.col-1));
			}
			if (cur_n.col+1<num_cols && board[cur_n.row][cur_n.col+1]=='O') {
				q.add(new Node(cur_n.row, cur_n.col+1));
			}
		}
	}
	
	private static class Node {
		int row;
		int col;
		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public void print2DArray(char[][] board) {
		for (int row=0; row <board.length; row++) {
			for (int col=0; col<board[0].length; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}
}
