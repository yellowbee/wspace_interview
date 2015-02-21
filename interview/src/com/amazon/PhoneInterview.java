package com.amazon;

import java.util.Arrays;
import java.util.Random;

public class PhoneInterview {
	public static void main(String[] args) {
		/*for (int i=0; i<52; i++) {
			System.out.print(randomBetween(52) + " ");
			if (i % 10 == 0) System.out.println();
		}*/
		char[] cards = {'1','2','3','4','5','6','7','8','9','0','J','Q','K','A'};
		PhoneInterview.shuffle(cards);
		System.out.println(Arrays.toString(cards));
	}
	
	public static void shuffle(char[] cards) {
		int LEN = cards.length;
		
		for (int i=LEN-1; i>0; i--) {
			// generate a random int between 0 and i inclusively
			int random_pos = randomBetween(i);
			char temp = cards[i];
			cards[i] = cards[random_pos];
			cards[random_pos] = temp;
		}
	}
	
	private static int randomBetween(int i) {
		Random ran = new Random();
		return (int)(i*ran.nextDouble());
	}
}
