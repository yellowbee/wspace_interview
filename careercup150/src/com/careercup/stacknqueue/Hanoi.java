package com.careercup.stacknqueue;

public class Hanoi {
	public static void main(String[] args) {
		Hanoi.hanoiMove(10, "A", "C", "B");
	}
	
	public static void hanoiMove(int n, String start, String end, String temp) {
		if (n == 1) {
			System.out.println(start + " -> " + end);
			return;
		}
		
		hanoiMove(n-1, start, temp, end);
		System.out.println(start + " -> " + end);
		hanoiMove(n-1, temp, end, start);
	}
}
