package com.leetcode.graph;

import java.util.LinkedList;

public class Graph {
    int v;
    boolean isUndirected = false;
    LinkedList<Integer>[] adj;
    Edge[] edges;
    int countEdge = 0;

    public Graph(int v, boolean isUndirected) {
        this(v);
        this.isUndirected = isUndirected;
    }

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public Graph(int v, int e) {
        this.v = v;
        this.edges = new Edge[e];
    }

    void addEdge(int src, int dest, int weight) {
        if (countEdge == edges.length) return;
        edges[countEdge++] = new Edge(src, dest, weight);
    }


    void addEdge(int v, int w) {
        adj[v].add(w);
        if (isUndirected) {
            adj[w].add(v);
        }
    }

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
