package com.topcoder.maths;

import java.util.Arrays;

public class Primes {
	public static void main(String[] args) {
		boolean[] primes = Primes.getPrimes(10000);
		for (int i=0; i<primes.length; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	// return all primes no larger than n
	public static boolean[] getPrimes(int n) {
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		int m = (int)Math.sqrt(n);
		for (int i=2; i<=m; i++) {
			if (isPrime[i]) {
				for (int j=i+i; j<=n; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		return isPrime;
	}
}
