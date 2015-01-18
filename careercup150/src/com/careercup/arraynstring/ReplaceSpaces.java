package com.careercup.arraynstring;

import java.util.Arrays;

/*
 * Replace every space in a string with "%20"
 */

public class ReplaceSpaces {
	public static void main(String[] args) {
        String s = "hello world              !";
        char[] str = s.toCharArray();
        ReplaceSpaces.ReplaceFun(str, 11);
        System.out.println(Arrays.toString(str));
    }
    
    // replace each space in the string with "%20"
    // suppose length is large enough
    public static void ReplaceFun(char[] str, int length) {
        if (length == 0) return;
        int spaces = 0;
        // count the number of spaces in the string
        for (int i=0; i<length; i++) {
            if (str[i] == ' ') spaces++;
        }
        
        int newLen = length + (spaces)*2;
        int tail = newLen - 1;
        for (int i=length-1; i>=0; i--) {
            if (str[i] != ' ') {
                str[tail] = str[i];
                tail--;
            }
            else {
                str[tail] = '0';
                str[tail-1] = '2';
                str[tail-2] = '%';
                tail = tail - 3;
            }
        }
    }
}
