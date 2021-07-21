package com.leetcode.graph;

/** Detect Cycle in a Undirected Graph */
public class DetectCycle2 {

    static Graph graph = null;

    // Time complexity: O(V+E)
    // Space complexity: 0(V) visited + 0(V) recursion -> O(V)
    public static boolean isCyclic() {

        boolean[] visited = new boolean[graph.v];
        for (int idx = 0; idx < graph.v; idx++) {
            if (visited[idx]) continue; // Exchangeable with "visited[idx] = false;"
            if (DFS(idx, visited, -1)) return true;
        }
        return false;
    }

    public static boolean DFS (int idx, boolean[] visited, int parent) {
        if (visited[idx]) return true;

        visited[idx] = true;

        for (int node : graph.adj[idx]) {
            if (node == parent) continue;
            if (DFS(node, visited, idx)) return true;
        }

//        visited[idx] = false;  // Exchangeable with "if (visited[idx]) continue;"

        return false;
    }

    public static void main(String[] args) {

        graph = new Graph(5, true);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        if (isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contains cycle");
        }

        graph = new Graph(3, true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        if (isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contains cycle");
        }
    }
}
