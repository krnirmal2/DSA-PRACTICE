package StandardProblemDSA.X_GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphWithLL {
  public static int V = 0;
  public static LinkedList<Integer>[] adj = new LinkedList[0];

  public GraphWithLL(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  // A utility function to add an edge in an
  // undirected graph
  public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
    // for a directed graph with an edge pointing from u to v,
    // adj.get(u).add(v);
  }

  public static void addEdge(int v, int w) {
    adj[v].add(w);
  }
}
