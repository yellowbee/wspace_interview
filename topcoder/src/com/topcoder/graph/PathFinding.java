package com.topcoder.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Constraints
- board will contain between 2 and 20 elements, inclusive.
- Each element of board will contain between 2 and 20 characters, inclusive.
- Each element of board will contain the same number of characters.
- Each element of board will consist of only the characters '.', 'X'. 'A', and 'B'.
- board will contain exactly one 'A' and exactly one 'B'.
Examples
0)  
{"....",
 ".A..",
 "..B.",
 "...."}
Returns: 2
There are many ways to switch positions in two turns. For example, on turn one, player A could move right while player B moves up-right. Then, on turn two, player A could move down while player B stays where he is. It is illegal for the players to switch positions in a single turn. Therefore, the method returns 2.

1)  
{"XXXXXXXXX",
 "A...X...B",
 "XXXXXXXXX"}
Returns: -1
Since the players cannot reach each other, they obviously cannot switch positions.

2)    
{"XXXXXXXXX",
 "A.......B",
 "XXXXXXXXX"}
Returns: -1
Even though the players can reach each other, there is still no way for player B to ever get on the left side of player A.

3)    
{"XXXXXXXXX",
 "A.......B",
 "XXXX.XXXX"}
Returns: 8
Players A and B spend the first three turns moving towards each other. On turn four, player A moves down-right while player B moves left. On turn five, player A moves up-right while player B moves left. It then takes three more turns of the players moving away from each other before they have switched positions, for a total of 8 turns.

4)
{"...A.XXXXX.....",
 ".....XXXXX.....",
 "...............",
 ".....XXXXX.B...",
 ".....XXXXX....."}
Returns: 13

5)    
{"AB.................X",
 "XXXXXXXXXXXXXXXXXXX.",
 "X..................X",
 ".XXXXXXXXXXXXXXXXXXX",
 "X..................X",
 "XXXXXXXXXXXXXXXXXXX.",
 "X..................X",
 ".XXXXXXXXXXXXXXXXXXX",
 "X..................X",
 "XXXXXXXXXXXXXXXXXXX.",
 "X..................X",
 ".XXXXXXXXXXXXXXXXXXX",
 "X..................X",
 "XXXXXXXXXXXXXXXXXXX.",
 "X..................X",
 ".XXXXXXXXXXXXXXXXXXX",
 "X..................X",
 "XXXXXXXXXXXXXXXXXXX.",
 "...................X",
 ".XXXXXXXXXXXXXXXXXXX"}
Returns: 379
 */
class Node {
	public int ax;
	public int ay;
	public int bx;
	public int by;
	public int turns;
	
	public Node(int ax, int ay, int bx, int by, int turns) {
		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
		this.turns = turns;
	}
}

public class PathFinding {
	public static void main(String[] args) {
		PathFinding pf = new PathFinding();
		String[] board ={"....",
				 ".A..",
				 "..B.",
				 "...."};
		
		System.out.println(pf.minTurns(board));
	}
	
	public int minTurns(String[] board) {
		int ROW = board.length;
		int COL = board[0].length();
		
		Queue<Node> q = new LinkedList<Node>();
		boolean[][][][] visited = new boolean[ROW][COL][ROW][COL];
		int a_init_x = -1;
		int a_init_y = -1;
		int b_init_x = -1;
		int b_init_y = -1;
		
		for (int i=0; i<ROW; i++) {
			for (int j=0; j<COL; j++) {
				for (int k=0; k<ROW; k++) {
					for (int l=0; l<COL; l++) {
						visited[i][j][k][l] = false;
					}
				}
			}
		}

		// looking for A, B in the beginning
		for (int i=0; i<ROW; i++) {
			for (int j=0; j<COL; j++) {
				if (board[i].charAt(j) == 'A') {
					a_init_x = i;
					a_init_y = j;
				}
				else if (board[i].charAt(j) == 'B') {
					b_init_x = i;
					b_init_y = j;
				}
				if (a_init_x != -1 && b_init_x != -1) break;
			}
			if (a_init_x != -1 && b_init_x != -1) break;
		}
		
		Node start_node = new Node(a_init_x, a_init_y, b_init_x, b_init_y, 0);
		q.add(start_node);
		visited[a_init_x][a_init_y][b_init_x][b_init_y] = true;
		
		while (!q.isEmpty()) {
			Node cur_node = q.remove();
			if (cur_node.ax == b_init_x && cur_node.ay == b_init_y && cur_node.bx == a_init_x && cur_node.by == a_init_y) {// target status found
				return cur_node.turns;
			}
			
			for (int a_delta_x=-1; a_delta_x<=1; a_delta_x++) {
				for (int a_delta_y=-1; a_delta_y<=1; a_delta_y++) {
					for (int b_delta_x=-1; b_delta_x<=1; b_delta_x++) {
						for (int b_delta_y=-1; b_delta_y<=1; b_delta_y++) {
							// get the next node/status
							int ax = cur_node.ax + a_delta_x;
							int ay = cur_node.ay + a_delta_y;
							int bx = cur_node.bx + b_delta_x;
							int by = cur_node.by + b_delta_y;
							
							// check if it's a valid candidate for next node/status
							if (ax < 0 || ax >= ROW || ay < 0 || ay >= COL || bx < 0 || bx >= ROW || by < 0 || by >= COL) continue;
							if (ax == bx && ay == by) continue;
							if (visited[ax][ay][bx][by]) continue;
							if (board[ax].charAt(ay) == 'X' || board[bx].charAt(by) == 'X') continue; 
							if (ax == cur_node.bx && ay == cur_node.by && bx == cur_node.ax && by == cur_node.ay) continue;
							
							
							// it is valid
							q.add(new Node(ax, ay, bx, by, cur_node.turns+1));
							visited[ax][ay][bx][by] = true;
						}
					}
				}
			}
			
		}
		
		return -1;
	}
}
