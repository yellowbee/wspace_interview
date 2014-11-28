package com.topcoder.algorithm.tournaments;

/* 2004 TCCC Online Round 4
 * There are two main cases:
 * 1. include donations index 0; as a result the last element will be excluded.
 * 2. exclude donations index 1; as a result the last element can be included.
 * For either case, the maximum can be obtained by
 * M[i] = max{M[i-1], M[i-2] + donations[i]}
*/

public class BadNeighbors {
	public static void main(String[] args) {
		int[] donations = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		BadNeighbors bn = new BadNeighbors();
		System.out.println(bn.maxDonations(donations));
	}
	
	public int maxDonations(int[] donations) {
		
		if (donations.length == 1) {
			return donations[0];
		}
		else if (donations.length == 2) {
			return donations[0] > donations[1] ? donations[0] : donations[1];
		}
		
		// starting from index 0 of donations
		int[] M_c0 = new int[donations.length-1];
		M_c0[0] = donations[0];
		M_c0[1] = donations[0] > donations[1] ? donations[0] : donations[1];
		for (int i=2; i<donations.length-1; i++) {
			M_c0[i] = M_c0[i-1] > (M_c0[i-2]+donations[i]) ? M_c0[i-1] : (M_c0[i-2]+donations[i]);
		}
		
		// starting from index 1 of donations
		int[] M_c1 = new int[donations.length];
		M_c1[0] = 0;
		M_c1[1] = donations[1];
		M_c1[2] = donations[1] > donations[2] ? donations[1] : donations[2];
		for (int i=3; i<donations.length; i++) {
			M_c1[i] = M_c1[i-1] > (M_c1[i-2]+donations[i]) ? M_c1[i-1] : (M_c1[i-2]+donations[i]);
		}
		
		return M_c0[M_c0.length-1] > M_c1[M_c1.length-1] ? M_c0[M_c0.length-1] : M_c1[M_c1.length-1];
	}
}
