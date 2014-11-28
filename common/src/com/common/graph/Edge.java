package com.common.graph;

public class Edge {
	public Vertex target;
	public int weight;
	
	public Edge(Vertex target, int weight) {
		this.target = target;
		this.weight = weight;
	}
}
