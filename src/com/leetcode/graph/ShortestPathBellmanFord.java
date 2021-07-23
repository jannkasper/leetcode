package com.leetcode.graph;

public class ShortestPathBellmanFord {

    static Graph graph;

    // Time complexity: O(V) + O(VE) + O(E) -> O(VE)
    // Space complexity: O(V) key
    static void shortestPath(int nodeIdx) {
        int[] key = new int[graph.v];

        for (int idx = 0; idx < key.length; idx++) {
            key[idx] = Integer.MAX_VALUE;
        }

        key[nodeIdx] = 0;

        for (int idx = 1; idx < graph.v; idx++) {
            for (int edgeIdx = 0; edgeIdx < graph.edges.length; edgeIdx++) {
                int x = graph.edges[edgeIdx].src;
                int y = graph.edges[edgeIdx].dest;
                int weight = graph.edges[edgeIdx].weight;
                if (key[x] != Integer.MAX_VALUE && key[x] + weight < key[y]) {
                    key[y] = key[x] + weight;
                }
            }
        }

        for (int edgeIdx = 0; edgeIdx < graph.edges.length; edgeIdx++) {
            int x = graph.edges[edgeIdx].src;
            int y = graph.edges[edgeIdx].dest;
            int weight = graph.edges[edgeIdx].weight;
            if (key[x] != Integer.MAX_VALUE && key[x] + weight < key[y]) {
                System.out.println("Graph contains negative weight cycle");
                return;
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

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        graph = new Graph(5,6);
        graph.addEdge(0,1,-1);
        graph.addEdge(0,2,4);
        graph.addEdge(1,2,3);
        graph.addEdge(1,3,2);
        graph.addEdge(1,4,2);
        graph.addEdge(3,2,5);
        graph.addEdge(3,1,1);
        graph.addEdge(4,3,-3);


        shortestPath(0);
    }
}
