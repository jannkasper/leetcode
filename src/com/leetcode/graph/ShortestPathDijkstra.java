package com.leetcode.graph;

public class ShortestPathDijkstra {

    // Time complexity: O(V) + O(V*(V+V)) -> O(V^2)
    // Space complexity: O(V) key + O(V) visited -> O(V)
    static void shortestPath(int[][] graph, int nodeIdx) {
        int[] key = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        for (int idx = 0; idx < key.length; idx++) {
            key[idx] = Integer.MAX_VALUE;
        }

        key[nodeIdx] = 0;

        for (int idx = 0; idx < graph.length; idx++) {
            int u = minDistance(key, visited);

            visited[u] = true;

            for (int adj = 0; adj < graph.length; adj++) {
                if (visited[adj] == false && graph[u][adj] != 0 && key[u] + graph[u][adj] < key[adj]) {
                    key[adj] = key[u] + graph[u][adj];
                }
            }
        }

        printSolution(key);
    }

    static void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t\t " + dist[i]);
    }

    static int minDistance(int[] key, boolean[] visited) {
        int minIndex = -1, minValue = Integer.MAX_VALUE;

        for (int idx = 0; idx < key.length; idx++) {
            if (visited[idx] == false && key[idx] < minValue) {
                minIndex = idx;
                minValue = key[idx];
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        shortestPath(graph, 0);
    }
}
