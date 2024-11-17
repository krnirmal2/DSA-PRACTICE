package StandardProblemDSA.GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDetectWithDFS {

    // A recursive function that uses visited[] and parent to detect
    // a cycle in the subgraph reachable from vertex currentVertex.
    static boolean isCyclicUtil(char currentVertex, Map<Character, List<Character>> adjacencyList,
                                Map<Character, Boolean> visited, char parentVertex) {

        // Mark the current node as visited
        visited.put(currentVertex, true);

        // Recur for all the vertices adjacent to this vertex
        for (char adjacentVertex : adjacencyList.get(currentVertex)) {

            // If an adjacent vertex is not visited, recur for that adjacent vertex
            if (!visited.getOrDefault(adjacentVertex, false)) {
                if (isCyclicUtil(adjacentVertex, adjacencyList, visited, currentVertex))
                    return true;
            }
            // If an adjacent vertex is visited and is not the parent of the current vertex,
            // then there exists a cycle in the graph
            else if (adjacentVertex != parentVertex) {
                return true;
            }
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false
    static boolean hasCycle(Map<Character, List<Character>> adjacencyList) {

        // Map to keep track of visited vertices
        Map<Character, Boolean> visited = new HashMap<>();

        // Check for cycles in different DFS trees
        for (char vertex : adjacencyList.keySet()) {

            // Skip if the vertex is already visited
            if (!visited.getOrDefault(vertex, false)) {
                if (isCyclicUtil(vertex, adjacencyList, visited, '\0'))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // Create an adjacency list with character vertices
        Map<Character, List<Character>> adjacencyList = new HashMap<>();

        // Initialize the adjacency list for vertices A, B, and C
        adjacencyList.put('A', new ArrayList<>());
        adjacencyList.put('B', new ArrayList<>());
        adjacencyList.put('C', new ArrayList<>());

        // Predefined edges: A-B, B-C, and C-A to create a cycle
        adjacencyList.get('A').add('B');
        adjacencyList.get('B').add('A');

        adjacencyList.get('B').add('C');
        adjacencyList.get('C').add('B');

        adjacencyList.get('C').add('A');
        adjacencyList.get('A').add('C');

        System.out.println(hasCycle(adjacencyList) ? "Contains cycle" : "No Cycle");
    }
}
