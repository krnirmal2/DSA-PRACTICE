package StandardProblemDSA.X_GRAPH.BASIC_TRAVERSAL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nirma
 */
public class DFSonDirectedGraph {

  // now add dfs on the
  public static void dfs(List<List<Integer>> graph, boolean[] visited, int s) {
    // if first time the node is commming then visited that node

    visited[s] = true;
    // now recursively visit all the edges connected that are not visited yet
    for (int i : graph.get(s)) {
      if (!visited[i]) {
        dfs(graph, visited, i);
      }
    }
  }

  public static void addDirectedEdge(List<List<Integer>> adjList, int src, int dest) {
    adjList.get(src).add(dest);
  }

  public static void main(String[] args) {
    // create five node directed grapsh
    int vertex = 5;
    // for each we will create adjacency list
    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      graph.add(new ArrayList<>());
    }

    // we can either create one by one or by a for loop
    //         given the directed node
    int[][] edges = {{1, 2}, {1, 0}, {2, 0}, {2, 3}, {2, 4}};
    // now add them adjacency list
    for (int[] e : edges) {
      // create the method to add each a

      addDirectedEdge(graph, e[0], e[1]);
    }

    dfsOnDirectedGraph(graph, vertex);
  }

  private static void dfsOnDirectedGraph(List<List<Integer>> graph, int vertex) {
    // create the boolean vistied
    boolean[] visted = new boolean[vertex];
    // loop through each vertex not on each adjacencey list
    for (int i = 0; i < vertex; i++) {
      if (!visted[i]) {
        dfs(graph, visted, i);
      }
    }
  }
}
