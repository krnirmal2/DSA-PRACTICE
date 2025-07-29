package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS;

import StandardProblemDSA.X_GRAPH.GraphUtility;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsUsingDFS {
  // create a graph class for constract graph
  /*
  🧠 Problem:
  Find the number of connected components in an undirected graph.

  🚀 Approach: DFS (Depth-First Search)
  1. Maintain a `visited[]` array to track visited nodes.
  2. For each vertex `v`:
     - If not visited, increment `count` (new component found).
     - Perform DFS from `v` to visit all vertices in that component.
  3. Return `count`.

  🔁 Pattern:
  - Standard DFS for connected components.
  - For disconnected graphs, we need to start DFS from every unvisited vertex.

  ⏱️ Time Complexity: O(V + E)
  - V = vertices, E = edges; each vertex and edge visited once.

  📦 Space Complexity: O(V)
  - For visited array + recursion stack.

  ⚠️ Edge Case:
  - Graph with no edges (V components).
  - Fully connected graph (1 component).

  ✅ Related Problems:
  - 323. Number of Connected Components in an Undirected Graph
  - 200. Number of Islands (grid version of the same problem)
  */

  private static int countConnectedComponents(List<List<Integer>> graph, int vertex) {
    boolean[] visited = new boolean[vertex];
    int count = 0;
    // as we need to apply dfs in each node beacuse we don't the graph is conected that is why
    // we have to check each of the vertex other wise if we only one that there is noly one
    // commponent
    // then only we iterate over the neighbors of the src node
    // it will give us everything
    for (int v = 0; v < vertex; v++) {
      if (!visited[v]) {
        // count here
        count++;
        GraphUtility.dfs(v, graph, visited);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int vertex = 6; // Change to 6 to match example
    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < vertex; i++) {
      graph.add(new ArrayList<>());
    }

    int[][] edges = {
      {0, 1}, {1, 2}, {3, 4} // Example edges from connected components problem
    };

    for (int[] e : edges) {
      GraphUtility.addUndirectedEdge(graph, e[0], e[1]);
    }

    System.out.println(
        "Number of connected components: " + countConnectedComponents(graph, vertex));
  }
}
