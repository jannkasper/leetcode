package com.leetcode.graph;

import java.util.LinkedList;

public class Graph {
    int v;
    boolean isUndirected = false;
    LinkedList<Integer>[] adj;

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

    void addEdge(int v, int w) {
        adj[v].add(w);
        if (isUndirected) {
            adj[w].add(v);
        }
    }
}
