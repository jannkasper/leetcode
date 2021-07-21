package com.leetcode.graph;

import java.util.Stack;

/** Topological sorting for Directed Acyclic Graph (DAG) */
public class TopologicalSorting {

    static Graph graph = null;

    // Time complexity: O(V+E)
    // Space complexity: O(V) stack + 0(V) visited + 0(V) recursion -> O(V)
    static void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.v];

        for (int idx = 0; idx < graph.v; idx++) {
            if (visited[idx]) continue;
            DFS(idx, visited, stack);
        }

        while (stack.empty() == false) System.out.print(stack.pop() + " ");
    }

    static void DFS(int idx, boolean[] visited, Stack<Integer> stack) {
        if (visited[idx]) return;

        visited[idx] = true;

        for (int node : graph.adj[idx]) {
            DFS(node, visited, stack);
        }

        stack.push(idx);
    }

    public static void main(String[] args) {

        graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        topologicalSort();
    }
}
