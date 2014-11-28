package com.leetcode.oj.sorting;

/*
 * 其实就是桶排序，只不过不许用额外空间。所以，每次当A[i]!= i的时候，将A[i]与A[A[i]]交换，
 * 直到无法交换位置。终止条件是 A[i]== A[A[i]]。
 * 然后i -> 0 到n走一遍就好了
 * 
 * [注意]
 * 题目说清楚了，很简单，但是实现起来还是有些细节比较烦人。首先，不能按照A[i] = i来存，
 * 因为题目要求寻找正数，如果A[0]用来存储0的话，会影响数据处理。比如当A = {1}的时候，
 * 如果A[0] = 0的话，根本没地方存1的值了。所以正确的存储方式应该是A[i]= i+1.
 * 但是由此带来的是，Line 7, 9, 11, 12, 16, 17都需要更改，以反映出这种映射。
 * 还有一点容易遗忘的就是Line18，如果当前数组找不到目标值的话，那么目标值就应该是n+1.这个容易漏了。
 */

public class FirstMissingPositive {
	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		//int[] A = {1,1};
		//int[] A = {1,2,0};
		//int[] A = {3,4,-1,1};
		int[] A = {-1,4,2,1,9,10};
		System.out.println(fmp.firstMissingPositive(A));
	}
	
	public int firstMissingPositive(int[] A) {
		if (A.length == 0) {
			return 1;
		}
		
        for (int i=0; i<A.length; i++) {
        	while (A[i] > 0 && A[i] < A.length && A[i] != A[A[i]-1]) {
	        	int temp = A[i];
	        	A[i] = A[temp-1];
	        	A[temp-1] = temp;
        	}
        }
        
        for (int i=0; i<A.length; i++) {
        	if (A[i] != i+1) {
        		return i+1;
        	}
        }
        
        return A.length + 1;
    }
}
