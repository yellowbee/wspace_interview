package com.topcoder.trie;

import com.common.trie.BasicTrieNode;

class IndexedTrieNode extends BasicTrieNode {
	public int first_occur;
	public IndexedTrieNode[] children;
	
	IndexedTrieNode() {
		super();
		this.first_occur = -1;
		
		this.children = new IndexedTrieNode[26];	
		for (int i=0; i<26; i++) {
			children[i] = null;
		}
	}
	
	public static void addWord(IndexedTrieNode tn, String word, int first_occur) {
		if (word.equals("")) {
			tn.words++;
			if (tn.first_occur == -1) {
				tn.first_occur = first_occur;
			}
		}
		else {
			tn.prefixes++;
			
			char ch = word.charAt(0);
			if (tn.children[ch-ASCII_A] == null) {
				tn.children[ch-ASCII_A] = new IndexedTrieNode();
			}			
			addWord(tn.children[ch-ASCII_A], word.substring(1, word.length()), first_occur);
		}	
	}
	
	public static int findWord(IndexedTrieNode tn, String word) {
		if (word.equals("")) {
			return tn.first_occur;
		}
		else {
			char ch = word.charAt(0);
			if (tn.children[ch-ASCII_A] == null) {
				return -1;
			}
			else {
				return findWord(tn.children[ch-ASCII_A], word.substring(1, word.length()));
			}
		}
	}
}

public class SearchBox {
	public static void main(String[] args) {
		IndexedTrieNode root = new IndexedTrieNode();
		
		String s = "WE DONT NEED NO THOUGHT CONTROL THOUGHT    ";
		int start = 0;
		int end = -1;
		while (start < s.length()) {
			start = end + 1;
			while (start < s.length() && s.charAt(start) == ' ') { // looking for the start of a word
				start++;
			}
			end = start;
			while (end < s.length() && s.charAt(end) != ' ') {
				end++;
			}
			if (start < s.length()) {
				IndexedTrieNode.addWord(root, s.substring(start, end), start);
			}
		}
		
		System.out.println(IndexedTrieNode.findWord(root, "THOUGH"));
	}
}
