package StandardProblemDSA.GRAPH;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectWithDFS {

    // DFS to detect cycle in an undirected graph
    public static boolean dfs(List<List<Integer>> graph, boolean[] visited, int s, int parent) {
        visited[s] = true;

        // Traverse all adjacent nodes
        for (int i : graph.get(s)) {
            if (!visited[i]) {
                if (dfs(graph, visited, i, s)) {
                    return true; // Cycle detected
                }
            }
            // If visited and not parent, it's a cycle
            else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    public static void addUndirectedEdge(List<List<Integer>> adjList, int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // Since it's an undirected graph
    }

    public static void main(String[] args) {
        int vertex = 5;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1} // Adding cycle (4 -> 1)
        };

        for (int[] e : edges) {
            addUndirectedEdge(graph, e[0], e[1]);
        }

        System.out.println(dfsOnUndirectedGraph(graph, vertex) ? "Contains Cycle" : "No Cycle");
    }

    private static boolean dfsOnUndirectedGraph(List<List<Integer>> graph, int vertex) {
        boolean[] visited = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, i, -1)) { // -1 as no parent for root
                    return true;
                }
            }
        }
        return false;
    }

    private static void dfsOnDirectedGraph(List<List<Integer>> graph, int vertex) {
        // create the boolean vistied
        boolean[] visted = new boolean[vertex];
        // loop through each vertex not on each adjacencey list
        for (int i = 0; i < vertex; i++) {
            if (!visted[i]) {
                dfs(graph, visted, i, -1);
            }
        }
    }
}
