package com.leetcode.graph;

/** Detect Cycle in a Directed Graph */
public class DetectCycle {
    static Graph graph = null;

    // Time complexity: O(V+E)
    // Space complexity: O(V) stack + 0(V) visited + 0(V) recursion -> O(V)
    static boolean isCyclic() {
        boolean[] stack = new boolean[graph.v];
        boolean[] visited = new boolean[graph.v];

        for (int idx = 0; idx < graph.v; idx++) {
            if (DFS(idx, stack, visited)){
                return true;
            }
        }

        return false;
    }

    public static boolean DFS(int idx, boolean[] stack, boolean[] visited) {
        if (stack[idx]) return true;
        if (visited[idx]) return false;

        stack[idx] = true;
        visited[idx] = true;

        for (int node : graph.adj[idx]) {
            if (DFS(node, stack, visited)) {
                return true;
            }
        }

        stack[idx] = false;

        return false;
    }

    public static void main(String[] args) {
        graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
