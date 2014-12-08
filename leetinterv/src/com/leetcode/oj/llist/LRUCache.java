package com.leetcode.oj.llist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 */

public class LRUCache {
	private Map<Integer, Node> hash;
	private List<Node> cache;
	private int capacity;
	
	private class Node {
		int key;
		int value;
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}	
	}
	
	public LRUCache(int capacity) {
		hash = new HashMap<Integer, Node>();
		cache = new LinkedList<Node>();
		this.capacity = capacity;
    }
    
    public int get(int key) {
    	if (hash.containsKey(key)) {
    		return moveToHead(key);
    	}
    	
    	return -1;
    }
    
    public void set(int key, int value) {
        if (!hash.containsKey(key)) {
        	Node node = new Node(key, value);
        	
        	if (cache.size() < this.capacity) {
        		cache.add(0, node);
        		hash.put(key, node);
        	}
        	else {
        		Node removed = cache.remove(cache.size()-1);
        		hash.remove(removed);
        		cache.add(0, node);
        		hash.put(key, node);
        	}
        }
        else {
        	moveToHead(key);
        }
    }
    
    private int moveToHead(int key) {
    	Node node = hash.get(key);
		cache.remove(node);
		cache.add(0, node);
		return node.value;
    }
}
