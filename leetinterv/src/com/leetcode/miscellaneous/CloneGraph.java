package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		if (node == null) {
			return null;
		}
		
		LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> nodemap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		
		q.add(node);
		UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
		nodemap.put(node, dup);
		
		while (!q.isEmpty()) {
			UndirectedGraphNode cur = q.removeFirst();
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (!nodemap.containsKey(neighbor)) { // This conditional branch corresponds to a graph traversal, plus some operations
													  // addressing the problem at hand
					UndirectedGraphNode dup_nei = new UndirectedGraphNode(neighbor.label);
					nodemap.get(cur).neighbors.add(dup_nei);
					nodemap.put(neighbor, dup_nei);
					q.add(neighbor);
				}
				else { // This branch is omitted in a pure traversla algorithm
					nodemap.get(cur).neighbors.add(nodemap.get(neighbor));
				}
			}

		}
		
		return dup;
    }
	
	private static class UndirectedGraphNode {
		public int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}
}
