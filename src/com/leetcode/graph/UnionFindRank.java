package com.leetcode.graph;

public class UnionFindRank {

    static boolean isCycle(int[][] graph) {
        int[] parent = new int[graph.length];
        int[] rank = new int[graph.length];

        for (int idx = 0; idx < parent.length; idx++) {
            parent[idx] = idx;
        }

        for (int src = 0; src < graph.length; src++) {
            for (int dest = src+1; dest < graph.length; dest++) {
                if (graph[src][dest] == 0) continue;

                int x = find(parent, src);
                int y = find(parent, dest);

                if (x == y) return true;

                union(parent, rank, x, y);
            }
        }

        return false;
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
