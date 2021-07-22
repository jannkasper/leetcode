package com.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/** Kruskal’s Minimum Spanning Tree Algorithm | Greedy Algo-2 */
public class MinimumSpanningTreePrimsKruskal {

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

    static void kruskalMST(int[][] graph) {
        int[] parent = new int[graph.length];
        int[] rank = new int[graph.length];
        Edge[] result = new Edge[graph.length-1];

        for (int idx = 0; idx < parent.length; idx++) {
            parent[idx] = idx;
        }

        List<Edge> edges = new ArrayList<>();
        for (int src = 0; src < graph.length; src++) {
            for (int dest = src+1; dest < graph.length; dest++) {
                if (graph[src][dest] == 0) continue;
                edges.add(new Edge(src, dest, graph[src][dest]));
            }
        }
        edges.sort((x,y) -> x.weight - y.weight);

        int edgeIndex = 0;
        int resultIndex = 0;
        while (resultIndex < result.length) {
            Edge nextEdge = edges.get(edgeIndex++);
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[resultIndex++] = nextEdge;
                union(parent, rank, x, y);
            }

        }

        print(result);
        return;
    }

    static int find(int[] parent, int idx) {
        if (parent[idx] != idx) {
            parent[idx] = find(parent, parent[idx]);
        }
        return parent[idx];
    }

    static void union(int[] parent, int[] rank, int x, int y) {

        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }

    static void print(Edge[] result) {
        int minimumCost = 0;
        for (int i = 0; i < result.length; ++i)
        {
            System.out.println(result[i].src + " -- "
                    + result[i].dest
                    + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);

    }

    public static void main(String[] args) {

        int graph[][] = new int[][] {
                { 0, 10, 6, 5 },
                { 10, 0, 0, 15 },
                { 6, 0, 0, 4 },
                { 5, 15, 4, 0 } };

        kruskalMST(graph);
    }
}
