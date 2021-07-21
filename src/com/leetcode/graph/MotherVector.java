package com.leetcode.graph;

public class MotherVector {

    static Graph graph = null;

    public static int findMotherVertex() {
        boolean[] visited = new boolean[graph.v];
        int motherIndex = -1;
        for (int vertex = 0; vertex < graph.v; vertex++) {
            if (visited[vertex] == true) continue;
            motherIndex = vertex;
            DFSUtil(vertex, visited);
        }

        visited = new boolean[graph.v];
        DFSUtil(motherIndex, visited);

        for (boolean flag : visited) {
            if (flag == false) return -1;
        }

        return motherIndex;
    }

    // Time complexity: O(V) * (O(1) + O(Enj)) -> 0(V) + O(V)*O(Enj) -> 0(V) + O(E) -> O(V+E)
    // Space complexity: O(V) + 0(V) -> O(V)

    // Time complexity: O(b^m)
    // Space complexity: O(b*m)
    // b: branching factor; m: maximum depth of search tree
    public static void DFSUtil(int idx, boolean[] visited) {
        visited[idx] = true;

        for (int node : graph.adj[idx]) {
            if (visited[node] == true) continue;

            DFSUtil(node, visited);
        }
    }

    public static void main(String[] args) {
        graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 1);
        graph.addEdge(6, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 2);
        graph.addEdge(6, 0);

        System.out.println("The mother vertex is " + findMotherVertex());
    }
}
