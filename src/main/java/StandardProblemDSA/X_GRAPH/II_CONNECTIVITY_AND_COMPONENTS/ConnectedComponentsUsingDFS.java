package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsUsingDFS {
  // create a graph class for constract graph

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
