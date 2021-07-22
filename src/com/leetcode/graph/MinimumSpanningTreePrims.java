package com.leetcode.graph;

/** Prim’s Minimum Spanning Tree (MST) | Greedy Algo-5 */
public class MinimumSpanningTreePrims {

    // Time complexity: O(V^2)
    // Space complexity: O(V) parent + O(V) key + O(V) visited -> O(V)
    static void primMST(int[][] graph) {
        int[] parent = new int[graph.length];
        int[] key = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        for (int idx = 0; idx < key.length; idx++) {
            key[idx] = Integer.MAX_VALUE;
        }

        parent[0] = -1;
        key[0] = 0;

        for (int idx = 0; idx < graph.length - 1; idx++) {
             int keyIndex = minKey(key, visited);
             visited[keyIndex] = true;

             for (int v = 0; v < graph.length; v++) {
                 if (graph[keyIndex][v] != 0 && visited[v] == false && graph[keyIndex][v] < key[v]) {
                     key[v] = graph[keyIndex][v];
                     parent[v] = keyIndex;
                 }
             }
        }

        // print the constructed MST
        printMST(parent, graph);
    }

    static int minKey (int[] key, boolean[] visited) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int idx = 0; idx < key.length; idx++) {
            if (visited[idx] == false && key[idx] < minValue) {
                minValue = key[idx];
                minIndex = idx;
            }
        }

        return minIndex;
    }

    static void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
    /* Let us create the following graph
        (0)--(1)--(2)
        |    / \   |
       6|  8/   \5 |7
        |  /     \ |
        (3)-------(4)
            9         */

        int graph[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        primMST(graph);
    }
}
