package com.leetcode.graph;

import java.util.Arrays;

public class TransitiveClosure2 {
    static Graph graph = null;

    // Time complexity: O(V+E) * O(V) -> O(V*(V+E))
    // Space complexity: O(V^2) matrix + 0(V) recursion -> O(V^2)
    public static void transitiveClosure() {
        int[][] result = new int[graph.v][graph.v];

        for (int vector = 0; vector < graph.v; vector++) {
            DFSUtil(vector, -1, result);
        }

        for (int i = 0; i < graph.v; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
    public static void DFSUtil(int source, int idx, int[][] result) {
        if (idx == -1) {
            idx = source;
        } else {
            result[source][idx] = 1;
        }

        for (int index : graph.adj[idx]) {
            if (result[source][index] == 1) continue;
            DFSUtil(source, index, result);
        }

    }

    public static void main(String[] args) {
        graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        transitiveClosure();
    }
}
