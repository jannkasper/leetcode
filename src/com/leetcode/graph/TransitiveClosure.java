package com.leetcode.graph;

public class TransitiveClosure {

    // Time complexity: O(V^2) + O(V^3) -> O(V^3)
    // Space complexity: O(V^2)
    public static void transitiveClosure(int graph[][]) {
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
                    if (result[i][j] == 0 && result[i][k] != 0 &&  result[k][j] != 0) {
                        result[i][j] = 1;
                    }
                }
            }
        }

        printSolution(result);
    }

    static void printSolution(int reach[][])
    {
        System.out.println("Following matrix is transitive closure"+
                " of the given graph");
        for (int i = 0; i < reach.length; i++)
        {
            for (int j = 0; j < reach.length; j++) {
                if ( i == j)
                    System.out.print("1 ");
                else
                    System.out.print(reach[i][j]+" ");
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

        int graph[][] = new int[][]{
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };


        transitiveClosure(graph);
    }
}
