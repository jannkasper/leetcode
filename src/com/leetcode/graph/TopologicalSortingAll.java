package com.leetcode.graph;

import java.util.*;

public class TopologicalSortingAll {

    static Graph graph = null;

    // Time complexity: O(V*E) + O(V!) -> O(V!)
    // Space complexity: O(V) list + O(V) recursion -> O(V)
    static void allTopologicalSorts() {
        int[] indegree = new int[graph.v];
        boolean[] visited = new boolean[graph.v];
        List<Integer> list = new ArrayList<>();

        for (int idx = 0; idx < graph.v; idx++) {
            for (int node : graph.adj[idx]) {
                indegree[node]++;
            }
        }

        allTopologicalSorts(list, visited, indegree);
    }

    static void allTopologicalSorts(List list, boolean[] visited, int[] indegree) {

        boolean flag = false;
        for (int idx = 0; idx < graph.v; idx++) {

            if (!visited[idx] && indegree[idx] == 0) {
                flag = true;
                list.add(idx);
                visited[idx] = true;
                for (int adjacent : graph.adj[idx]) {
                    indegree[adjacent]--;
                }

                allTopologicalSorts(list, visited, indegree);

                list.remove(list.size()-1);
                visited[idx] = false;
                for (int adjacent : graph.adj[idx]) {
                    indegree[adjacent]++;
                }

            }
        }

        if (flag == false) {
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }


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
        allTopologicalSorts();
    }
}
