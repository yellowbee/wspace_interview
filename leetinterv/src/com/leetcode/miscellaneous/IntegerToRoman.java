package com.leetcode.miscellaneous;

public class IntegerToRoman {
	public static void main(String[] args) {
		for (int i=1; i<=3999; i++) {
			System.out.print(IntegerToRoman.intToRoman(i) + " ");
			if (i % 10 == 0) System.out.println();
		}
	}
	public static String intToRoman(int num) {
        int thousands = 0;
        int hundreds = 0;
        int tens = 0;
        int ones = 0;
        
        thousands = num / 1000;
        hundreds = (num - thousands*1000) / 100;
        tens = (num - thousands*1000 - hundreds*100) / 10;
        ones = num - thousands*1000 - hundreds*100 - tens*10;
        
        StringBuffer sb = new StringBuffer();
        // THOUSANDS
        while (thousands > 0) {
        	sb.append("M");
        	thousands--;
        }
        
        // HUNDREDS
        if (hundreds >= 9) {
        	sb.append("CM");
        }
        else if (hundreds <= 8 && hundreds >= 5) {
        	sb.append("D");
        	hundreds -= 5;
        	while (hundreds > 0) {
        		sb.append("C");
        		hundreds--;
        	}
        }
        else if (hundreds == 4) {
        	sb.append("CD");
        }
        else {
        	while (hundreds > 0) {
        		sb.append("C");
        		hundreds--;
        	}
        }
        
        // TENS
        if (tens >= 9) {
        	sb.append("XC");
        }
        else if (tens <= 8 && tens >=5) {
        	sb.append("L");
        	tens -= 5;
        	while (tens > 0) {
        		sb.append("X");
        		tens--;
        	}
        }
        else if (tens == 4) {
        	sb.append("XL");
        }
        else {
        	while (tens > 0) {
        		sb.append("X");
        		tens--;
        	}
        }
        
        // ONES
        if (ones >= 9) {
        	sb.append("IX");
        }
        else if (ones <=8 && ones >= 5) {
        	sb.append("V");
        	ones -= 5;
        	while (ones > 0) {
        		sb.append("I");
        		ones--;
        	}
        }
        else if (ones == 4) {
        	sb.append("IV");
        }
        else {
        	while (ones > 0) {
        		sb.append("I");
        		ones--;
        	}
        }
        
        return sb.toString();
    }
}
