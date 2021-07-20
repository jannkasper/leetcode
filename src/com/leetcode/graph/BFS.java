package com.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    static Graph graph = null;

    // Time complexity: O(V) * (O(1) + O(Enj)) -> 0(V) + O(V)*O(Enj) -> 0(V) + O(E) -> O(V+E)
    // Space complexity: O(V)

    // Time complexity: O(b^d)
    // Space complexity: O(b^d)
    // b: branching factor; d: depth of the shallowest goal
    public static void BFSUtil(int idx) {
        boolean[] visited = new boolean[graph.v];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(idx);
        visited[idx] = true;

        while(!queue.isEmpty()) {
            int root = queue.poll();
            System.out.print(root + " ");

            for (int node : graph.adj[root]) {
                if (visited[node] == true) continue;
                queue.add(node);
                visited[node] = true;
            }
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

        BFSUtil(2);
    }
}
