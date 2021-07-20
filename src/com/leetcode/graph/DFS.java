package com.leetcode.graph;

public class DFS {
    static Graph graph = null;

    public static void DFSUtil(int idx) {
        boolean[] visited = new boolean[graph.v];

        DFSUtil(idx, visited);
    }

    // Time complexity: O(V) * (O(1) + O(Enj)) -> 0(V) + O(V)*O(Enj) -> 0(V) + O(E) -> O(V+E)
    // Space complexity: O(V) + 0(V) -> O(V)

    // Time complexity: O(b^m)
    // Space complexity: O(b*m)
    // b: branching factor; m: maximum depth of search tree
    public static void DFSUtil(int idx, boolean[] visited) {
        System.out.print(idx + " ");
        visited[idx] = true;

        for (int node : graph.adj[idx]) {
            if (visited[node] == true) continue;

            DFSUtil(node, visited);
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

        DFSUtil(2);
    }
}
