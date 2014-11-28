package com.topcoder.graph;

import java.util.Stack;

/*
 * Filling a closed region in a grid.
 * Implementing the DFS of a graph using a stack rather than
 * using recursion.
 */

public class RegionFill {
	private static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		int[][] A = {{1, 0, 0, 0},
					 {0, 1, 0, 1},
					 {0, 1, 0, 1},
					 {0, 0, 1, 0}};
		
		System.out.println(RegionFill.doFill(A, 0, 1));
	}
	
	// A is the grid; (x, y) is the starting cell to fill
	public static int doFill(int[][] A, int x, int y) {
		boolean[][] filled = new boolean[A.length][A.length];
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A.length; j++) {
				filled[i][j] = false;;
			}
		}
		
		int area = 0;
		Stack<Pair> stack = new Stack<Pair>();
		stack.push(new Pair(x, y));
		Pair cur = null;
		
		while (!stack.isEmpty()) {
			cur = stack.pop();
			filled[cur.x][cur.y] = true;
			area++;
			
			if (cur.x-1 >= 0 && A[cur.x-1][cur.y] != 1 && !filled[cur.x-1][cur.y]) {// UP
				stack.push(new Pair(cur.x-1, cur.y));
			}
			if (cur.x+1 < A.length && A[cur.x+1][cur.y] != 1 && !filled[cur.x+1][cur.y]) {// DOWN
				stack.push(new Pair(cur.x+1, cur.y));
			}
			if (cur.y-1 >=0 && A[cur.x][cur.y-1] != 1 && !filled[cur.x][cur.y-1]) {// LEFT
				stack.push(new Pair(cur.x, cur.y-1));
			}
			if (cur.y+1 < A.length && A[cur.x][cur.y+1] != 1 && !filled[cur.x][cur.y+1]) {// RIGHT
				stack.push(new Pair(cur.x, cur.y+1));
			}
		}
		
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A.length; j++) {
				if (filled[i][j]) {
					System.out.print("X ");
				}
				else {
					System.out.print("O ");
				}
			}
			System.out.println();
		}
		return area;
	}
}
