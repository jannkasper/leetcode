package com.leetcode.graph;

/** Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. */
public class HamiltonianCycle {

    // Time complexity: O(V!)
    // Space complexity: O(V) path + O(V) recursion -> O(V)
    static boolean hamiltonianCycle(int[][] graph, int[] path, int pos) {
        if (pos == graph.length) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < graph.length; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamiltonianCycle(graph, path, pos+1) == true) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }

    static void hamiltonianCycle(int[][] graph) {
        int[] path = new int[graph.length];
        for (int idx = 0; idx < path.length; idx++) {
            path[idx] = -1;
        }

        path[0] = 0;

        if (hamiltonianCycle(graph, path, 1)) {
            printSolution(path);
        } else {
            System.out.println("\nSolution does not exist");
        }
        return;
    }

    static boolean isSafe (int v, int[][] graph, int[] path, int pos) {
        if (graph[path[pos-1]][v] == 0) return false;

        for (int idx = 0; idx < path.length; idx++) {
            if (path[idx] == v) return false;
        }

        return true;
    }

    static void printSolution(int path[])
    {
        System.out.println("Solution Exists: Following is one Hamiltonian Cycle");
        for (int i = 0; i < path.length; i++)
            System.out.print(" " + path[i] + " ");

        // Let us print the first vertex again to show the
        // complete cycle
        System.out.println(" " + path[0] + " ");
    }

    public static void main (String[] args) {
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int graph1[][] = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        hamiltonianCycle(graph1);


        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        hamiltonianCycle(graph2);
    }
}
