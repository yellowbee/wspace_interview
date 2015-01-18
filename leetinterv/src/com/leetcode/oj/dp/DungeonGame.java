package com.leetcode.oj.dp;

/*
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	   -10	1
10	    30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 *
 * 
 * Solution:
 * Define M[i][j] as the minimum health value needed before entering dungeon[i][j].
 * The observation is that M[i][j] is decided by the smaller of the two health values needed to enter
 * either the right or the down room. This indicates that we need to compute from bottom-right to
 * top-left;
 */

public class DungeonGame {
	public static void main(String[] args) {
		int[][] dungeon = {{-2, -3, 3},
						   {-5, -10, 1},
						   {10, 30, -5}};
		System.out.println(DungeonGame.calculateMinimumHP(dungeon));
	}
	
	public static int calculateMinimumHP(int[][] dungeon) {
        int RLEN = dungeon.length;
        int CLEN = dungeon[0].length;
        int[][] M = new int[RLEN][CLEN];
        
        M[RLEN-1][CLEN-1] = 1 - dungeon[RLEN-1][CLEN-1];
        M[RLEN-1][CLEN-1] = M[RLEN-1][CLEN-1] > 0 ? M[RLEN-1][CLEN-1] : 1;
        
        // init the last row
        for (int j=CLEN-2; j>=0; j--) {
        	M[RLEN-1][j] = M[RLEN-1][j+1] - dungeon[RLEN-1][j];
        	M[RLEN-1][j] = M[RLEN-1][j] > 0 ? M[RLEN-1][j] : 1;
        }
        
        // init the last col
        for (int i=RLEN-2; i>=0; i--) {
        	M[i][CLEN-1] = M[i+1][CLEN-1] - dungeon[i][CLEN-1];
        	M[i][CLEN-1] = M[i][CLEN-1] > 0 ? M[i][CLEN-1] : 1;
        }
        
        for (int i=RLEN-2; i>=0; i--) {
        	for (int j=CLEN-2; j>=0; j--) {
        		int right = M[i][j+1] - dungeon[i][j];
        		right = right > 0 ? right : 1;
        		int down = M[i+1][j] - dungeon[i][j];
        		down = down > 0 ? down : 1;
        		M[i][j] = right < down ? right : down;
        	}
        }
        
        return M[0][0];
    }
}
