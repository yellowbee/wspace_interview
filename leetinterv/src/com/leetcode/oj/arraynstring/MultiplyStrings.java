package com.leetcode.oj.arraynstring;

public class MultiplyStrings {
	public static void main(String[] args) {
		System.out.println(MultiplyStrings.multiply("0", "3525646246224623462362362672672364623462234623562"));
	}
	
	public static String multiply(String num1, String num2) {
        int LEN1 = num1.length();
        int LEN2 = num2.length();
        int[] prod = new int[LEN1 + LEN2];
        
        String nm1 = new StringBuilder(num1).reverse().toString();
        String nm2 = new StringBuilder(num2).reverse().toString();
        for (int i=0; i<LEN1; i++) {
        	for (int j=0; j<LEN2; j++) {
        		prod[i+j] += (nm1.charAt(i) - '0') * (nm2.charAt(j) - '0');
        	}
        }
        
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i=0; i<prod.length; i++) {
        	int sum = prod[i] + carry;
        	int digit = sum % 10;
        	carry = sum / 10;
        	sb.insert(0, digit);
        }
        
        if (carry > 0) {
        	sb.insert(0, carry);
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
        	sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
