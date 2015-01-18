package com.amazon.recursion;

/*
 * Play a game that always starts from you. Each time you can
 * only pick up 1 or 3 or 4 coins from the table. Who leaves
 * the enemy with no coins to pick up wins the game. Assume
 * that your enemy is super intelligent that if there is a way
 * he/ she can win, he/ she wins. Question: Write a function to
 * return if you will win or lose the game say given n coins on the table.
 * 
 * Solution: recursion
 */

public class PickCoin {
	public static void main(String[] args) {
		System.out.println(pick(2));
	}
	
	public static boolean pick(int n) {
		if (n == 1 || n == 3 || n == 4) return true;
		boolean win = true;
		
		int[] A = {1, 3, 4};
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A.length; j++) {
				if (n - A[i] - A[j] > 0) {
					if (!pick(n-A[i]-A[j])) {
						win = false;
					}
				}
				else if (n - A[i] - A[j] ==  0) {
					win = false;
				}
			}
			if (win) return win;
		}
		
		return false;
	}
}
