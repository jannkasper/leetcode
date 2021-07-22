package com.leetcode.graph;

public class UnionFind {

    static boolean isCycle(int[][] graph) {
        int[] parent = new int[graph.length];

        for (int idx = 0; idx < parent.length; idx++) {
            parent[idx] = -1;
        }

        for (int src = 0; src < graph.length; src++) {
            for (int dest = src+1; dest < graph.length; dest++) {
                if (graph[src][dest] == 0) continue;

                int x = find(parent, src);
                int y = find(parent, dest);

                if (x == y) return true;

                union(parent, x, y);
            }
        }

        return false;
    }

    static int find(int[] parent, int idx) {
        if (parent[idx] == -1) return idx;
        return find(parent, parent[idx]);
    }

    static void union(int[] parent, int x, int y) {
        parent[x] = y;
    }

    public static void main(String[] args) {

        int graph[][] = new int[][] {
                { 0, 1, 1, 0 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 0 },
                { 0, 1, 0, 0 } };

        if (isCycle(graph)) {
            System.out.println( "graph contains cycle" );
        } else {
            System.out.println( "graph doesn't contain cycle" );
        }

        int graph2[][] = new int[][] {
                { 0, 1, 1, 0 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 0, 1, 1, 0 } };

        if (isCycle(graph2)) {
            System.out.println( "graph contains cycle" );
        } else {
            System.out.println( "graph doesn't contain cycle" );
        }
    }
}
