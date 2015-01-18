package com.common.trie;

/*
 * Basic TRIE node definition; to be used as a super
 * class for TRIE variant of different applications.
 */

public abstract class BasicTrieNode {
	public static int ASCII_A = 65;
	public int words;
	public int prefixes;
	
	public BasicTrieNode() {
		this.words = 0;
		this.prefixes = 0;
	}
}
