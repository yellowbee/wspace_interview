package com.google.string;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
	public static int ASCII_A = 65;
	public TrieNode[] children;
	public int words;
	
	public TrieNode() {
		this.words = 0;
		this.children = new TrieNode[26];
		for (int i=0; i<26; i++) {
			children[i] = null;
		}
	}
}

public class StringAutoComplete {
	public static void main(String[] args) {
		TrieNode tn = new TrieNode();
		StringAutoComplete.addWord(tn, "HELLO");
		StringAutoComplete.addWord(tn, "HELLOHA");
		StringAutoComplete.addWord(tn, "HELLNO");
		StringAutoComplete.addWord(tn, "WORLD");
		StringAutoComplete.addWord(tn, "BYE");
		StringAutoComplete.addWord(tn, "HEL");
		List<String> result = StringAutoComplete.getListWithPrefix(tn, "HEL");
		System.out.println(result);
	}
	
	public static void addWord(TrieNode tn, String word) {
		if (word.equals("")) {
			tn.words++;
		}
		else {
			char ch = word.charAt(0);
			if (tn.children[ch-TrieNode.ASCII_A] == null) {
				tn.children[ch-TrieNode.ASCII_A] = new TrieNode();
			}
			addWord(tn.children[ch-TrieNode.ASCII_A], word.substring(1));
		}
	}
	
	public static int countWords(TrieNode tn, String word) {
		if (word.equals("")) {
			return tn.words;
		}
		char ch = word.charAt(0);
		if (tn.children[ch-TrieNode.ASCII_A] != null) {
			return countWords(tn.children[ch-TrieNode.ASCII_A], word.substring(1));
		}
		else {
			return 0;
		}
	}
	
	// return the list of word having the specified prefix
	public static List<String> getListWithPrefix(TrieNode tn, String prefix) {
		TrieNode nptr = tn;
		int count = 0;
		for (int i=0; i<prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (nptr.children[ch-TrieNode.ASCII_A] == null) {
				break;
			}
			count++;
			nptr = nptr.children[ch-TrieNode.ASCII_A];
		}
		
		List<String> result = new ArrayList<String>();
		if (count < prefix.length()) return result;
		StringBuffer sofar = new StringBuffer();
		traverse(nptr, prefix, sofar, result);
		
		return result;
	}
	
	private static void traverse(TrieNode tn, String prefix, StringBuffer sofar, List<String> result) {
		if (tn.words > 0) {
			result.add(prefix + sofar.toString());
		}
		for (int i=0; i<26; i++) {
			if (tn.children[i] != null) {
				sofar.append((char)(TrieNode.ASCII_A + i));
				traverse(tn.children[i], prefix, sofar, result);
				sofar.deleteCharAt(sofar.length()-1);
			}
		}
	}
}
