package com.careercup.arraynstring;

public class CheckForAnagrams {
	public static void main(String[] args) {
        System.out.println(CheckForAnagrams.areAnagrams("he llo", "oll eh"));
    }
    
    public static boolean areAnagrams(String s1, String s2) {
        // corner cases
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;
        
        // each element counts the number of corresponding char in s1
        int[] char_set = new int[256];
        // number of unique chars in s1
        int unique_chars = 0;
        for (int i=0; i<s1.length(); i++) {
            if (char_set[s1.charAt(i)] == 0) {
                unique_chars++;
            }
            char_set[s1.charAt(i)]++;
        }
        
        // count the number of unique chars that have been matched
        int completed_chars = 0;
        for (int i=0; i<s2.length(); i++) {
            if (char_set[s2.charAt(i)] <= 0) return false;
            char_set[s2.charAt(i)]--;
            
            if (char_set[s2.charAt(i)] == 0) {
                completed_chars++;
            }
        }
        
        if (completed_chars != unique_chars) return false;
        return true;
    }
}
