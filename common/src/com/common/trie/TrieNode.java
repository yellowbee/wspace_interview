package com.common.trie;

/*
 * This class defines a TRIE node, which is the building
 * block of a trie data structure. TRIE is extremely useful
 * for string search/match.
 */

public class TrieNode extends BasicTrieNode {
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		addWord(root, "HELLO");
		addWord(root, "WORLD");
		addWord(root, "WORLD");
		addWord(root, "HELLO");
		addWord(root, "HELLO");
		addWord(root, "HELLO");
		
		System.out.println(countWords(root, "HELLO"));
	}
	
	public TrieNode[] children;
	
	public TrieNode() {
		super();
		this.children = new TrieNode[26];
		
		for (int i=0; i<26; i++) {
			children[i] = null;
		}
	}
	
	// add word to tn starting from tn's children
	public static void addWord(TrieNode tn, String word) {
		if (word.equals("")) {
			tn.words++;
		}
		else {
			tn.prefixes++;
			char ch = word.charAt(0);
			if (tn.children[ch-ASCII_A] == null) {
				tn.children[ch-ASCII_A] = new TrieNode();
			}
			addWord(tn.children[ch-ASCII_A], word.substring(1, word.length()));
		}
	}
	
	// count the input word starting from tn's children
	public static int countWords(TrieNode tn, String word) {
		if (word.equals("")) {
			return tn.words;
		}
		else {
			char ch = word.charAt(0);
			if (tn.children[ch-ASCII_A] != null) {
				return countWords(tn.children[ch-ASCII_A], word.substring(1, word.length()));
			}
			else {
				return 0;
			}
		}
	}
}
