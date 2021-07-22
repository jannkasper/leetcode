package com.leetcode.graph;

import java.util.*;

public class TopologicalSortingKahlAlgorithm {

    static Graph graph = null;

    // Time complexity: O(V*E) + O(V) + O(V*E) -> O(V*E)
    // Space complexity: O(V) + O(V) -> O(V)
    static void topologicalSort() {
        int[] indegree = new int[graph.v];

        for (int idx = 0; idx < graph.v; idx++) {
            for (int node : graph.adj[idx]) {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int idx = 0; idx < graph.v; idx++) {
            if (indegree[idx] == 0) queue.add(idx);
        }

        int  countNode = 0;

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.remove();
            result.add(node);
            countNode++;

            for(int idx : graph.adj[node]) {
                indegree[idx]--;
                if (indegree[idx] == 0) queue.add(idx);
            }
        }

        // Check cycle
        if (countNode != graph.v) {
            System.out.println("There exists a cycle in the graph");
            return;
        }

        System.out.println(result.toString());
        return;
    }

    public static void main(String[] args) {

        graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph");
        // Function Call
        topologicalSort();
    }
}
