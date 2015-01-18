package com.topcoder.dp;
/*
 * 	 QuickSums	 SRM 197	 06.02.2004	ValD	 Dynamic Programming  div2.level3	 73.08%	
 * 
 * Constraints
-	numbers will contain between 1 and 10 characters, inclusive.
-	Each character in numbers will be a digit.
-	sum will be between 0 and 100, inclusive.
 */
public class QuickSums {
	public static void main(String[] args) {
		QuickSums qs = new QuickSums();
		System.out.println(qs.minSums("0123456789", 45));
	}
	
	public int minSums(String numbers, int sum) {
		int len = numbers.length();
		if (len <=3 && Integer.parseInt(numbers) == sum) return 0;
		
		// M[i][j] is the min sums for numbers[0...i] and sum j
		int[][] M = new int[len][sum+1]; // 
		
		for (int i=0; i<len; i++) {
			for (int j=0; j<sum+1; j++) {
				M[i][j] = -1;
			}
		}
		
		for (int i=0; i<len; i++) {
			if (i>2) break;
			int single_num = Integer.parseInt(numbers.substring(0, i+1));
			if (single_num <= sum) {
				M[i][single_num] = 0;
			}
		}
		
		for (int i=1; i<len; i++) {
			for (int n=0; n<sum+1; n++) {
				if (M[i][n] == 0) continue;
				int min = Integer.MAX_VALUE;
				for (int j=0; j<i; j++) {
					int last_num = Integer.parseInt(numbers.substring(j+1, i+1));
					if (n >= last_num && M[j][n-last_num]!=-1) {
						if (min > M[j][n-last_num] + 1) {
							min = M[j][n-last_num] + 1;
						}
					}
				}
				if (min < Integer.MAX_VALUE) {
					M[i][n] = min;
				}
			}
		}
		
		/*for (int i=0; i<len; i++) {
			for (int j=0; j<=sum; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}*/
		return M[len-1][sum];
	}
}
