package com.leetcode.graph;

public class FloydWarshallAlgorithm {
    static int INF = Integer.MAX_VALUE;

    // Time complexity: O(V^2) + O(V^3) -> O(V^3)
    // Space complexity: O(V^2)
    public static void floydWarshall(int graph[][]) {
        int v = graph.length;

        int result[][] = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                result[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (result[i][k] == INF || result[k][j] == INF) continue;
                    if (result[i][k] + result[k][j] < result[i][j]) {
                        result[i][j] = result[i][k] + result[k][j];
                    }
                }
            }
        }

        printSolution(result);
    }

    static void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<dist.length; ++i)
        {
            for (int j=0; j<dist.length; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        /* Let us create the following weighted graph
              10
         (0)------->(3)
          |         /|\
        5 |          |
          |          | 1
         \|/         |
         (1)------->(2)
            3           */

        int graph[][] = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };


        floydWarshall(graph);
    }
}
