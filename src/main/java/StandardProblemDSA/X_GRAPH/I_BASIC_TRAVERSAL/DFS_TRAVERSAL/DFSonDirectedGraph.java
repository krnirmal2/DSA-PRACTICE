package StandardProblemDSA.X_GRAPH.I_BASIC_TRAVERSAL.DFS_TRAVERSAL;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nirma
 */
public class DFSonDirectedGraph {

  public static void main(String[] args) {
    // create five node directed graph
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
      GraphUtility.addDirectedEdge(graph, e[0], e[1]);
    }
    dfsOnDirectedGraph(graph, vertex);
  }

  private static void dfsOnDirectedGraph(List<List<Integer>> graph, int vertex) {
    // create the boolean vistied
    boolean[] visted = new boolean[vertex];
    // loop through each vertex not on each adjacencey list
    for (int i = 0; i < vertex; i++) {
      if (!visted[i]) {
        GraphUtility.dfs(i, graph, visted);
      }
    }
  }
}
