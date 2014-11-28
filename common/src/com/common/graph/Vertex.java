package com.common.graph;

public class Vertex implements Comparable<Vertex> {
	public String name;
	public int value;
	public Vertex prev; // this field is for restoring a shortest path, such as in Dijkstra's algorithm
	public Edge[] adjacencies;
	
	public Vertex(String name, int value) {
		this.name = name;
		this.value = value;
		this.prev = null;
	}
	
	@Override
	public int compareTo(Vertex v) {
		return Integer.compare(this.value, v.value);
	}
}
