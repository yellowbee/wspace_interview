package com.topcoder.graph;

import java.util.PriorityQueue;
import java.util.Stack;

import com.common.graph.Edge;
import com.common.graph.Vertex;

public class Dijkstra {
	public static void main(String[] args) {
		Vertex s = new Vertex("S", 0);
		Vertex t = new Vertex("T", Integer.MAX_VALUE);
		Vertex x = new Vertex("X", Integer.MAX_VALUE);
		Vertex y = new Vertex("Y", Integer.MAX_VALUE);
		Vertex z = new Vertex("Z", Integer.MAX_VALUE);
		
		s.adjacencies = new Edge[]{new Edge(t, 10), new Edge(y, 5)};
		t.adjacencies = new Edge[]{new Edge(x, 1), new Edge(y, 2)};
		x.adjacencies = new Edge[]{new Edge(z, 4)};
		y.adjacencies = new Edge[]{new Edge(t, 3), new Edge(x, 9), new Edge(z, 2)};
		z.adjacencies = new Edge[]{new Edge(x, 6), new Edge(s, 7)};
		
		computeShortestPathFrom(s);
		
		Vertex[] graph = {s, t, x, y, z};
		for (Vertex v : graph) {
			System.out.print(v.name + "-" + v.value + ": ");
			printPathTo(v);
		}
	}
	
	public static void computeShortestPathFrom(Vertex source) {
		PriorityQueue<Vertex> heap = new PriorityQueue<Vertex>();
		
		heap.add(source);
		while (!heap.isEmpty()) {
			Vertex cur = heap.poll();
			
			for (Edge e : cur.adjacencies) {
				// relaxation process
				if (e.target.value > cur.value + e.weight) {
					heap.remove(e.target);
					e.target.value = cur.value + e.weight;
					e.target.prev = cur;
					heap.add(e.target);
				}
			}
		}
	}
	
	public static void printPathTo(Vertex target) {
		Vertex v = target;
		Stack<Vertex> stack = new Stack<Vertex>();
		while (v != null) {
			stack.add(v);
			v = v.prev;
		}
		for (int i=stack.size()-1; i>=0; i--) {
			System.out.print(stack.get(i).name + ", ");
		}
		System.out.println();
	}
}
