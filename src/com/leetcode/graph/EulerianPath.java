package com.leetcode.graph;

/** Eulerian Path is a path in graph that visits every edge exactly once. */
public class EulerianPath {

    static Graph graph;

    // Time complexity: O(VE)
    // Space complexity: O(V) visited + O(V) recursion -> O(V)
    static void isEulerian() {
        if (isConnected() == false) {
            System.out.println("graph is not Eulerian");
            return;
        }

        int countOdd = 0;
        for (int idx = 0; idx < graph.v; idx++) {
            if (graph.adj[idx].size() % 2 != 0) {
                countOdd++;
            }
        }

        // If odd count is 2, then eulerian path.
        // If odd count is 0, then eulerian cycle
        // Note that odd count can never be 1 for undirected graph
        if (countOdd == 0) System.out.println("graph has a Euler cycle");
        else if (countOdd == 2) System.out.println("graph has a Euler path");
        else System.out.println("graph is not Eulerian");
        return;
    }

    static boolean isConnected () {
        boolean visited[] = new boolean[graph.v];

        int i = 0;
        // Find a vertex with non-zero degree
        for (i = 0; i < graph.v; i++) {
            if (graph.adj[i].size() != 0) break;
        }

        // If there are no edges in the graph, return true
        if (i == graph.v) return true;

        DFSUtil(i, visited);

        for (i = 0; i < graph.v; i++) {
            if (visited[i] == false && graph.adj[i].size() > 0) return false;
        }

        return true;
    }

    static void DFSUtil (int nodeIdx, boolean[] visited) {
        visited[nodeIdx] = true;

        for (int adj : graph.adj[nodeIdx]) {
            if (visited[adj] == true) continue;
            DFSUtil(adj, visited);
        }
    }

    public static void main(String[] args) {
        graph = new Graph(5, true);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        isEulerian();

        graph = new Graph(5, true);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        isEulerian();

        graph = new Graph(5, true);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 3);
        isEulerian();

        // Let us create a graph with 3 vertices
        // connected in the form of cycle
        graph = new Graph(3, true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        isEulerian();
    }
}
