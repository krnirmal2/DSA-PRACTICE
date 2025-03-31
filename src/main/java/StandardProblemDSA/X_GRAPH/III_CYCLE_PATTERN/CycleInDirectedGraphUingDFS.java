package StandardProblemDSA.X_GRAPH.III_CYCLE_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraphUingDFS {}

class GfG {

  // Utility function to detect cycle in a directed graph
  private static boolean isCyclicUtil(
      List<List<Integer>> adj, int src, boolean[] visited, boolean[] recStack) {

    // If already present in the recursion call
    // stack, then there is a cycle
    if (recStack[src] == true) return true;

    recStack[src] = true;
    visited[src] = true;

    for (int next : adj.get(src)) {
      if (!visited[next] && isCyclicUtil(adj, next, visited, recStack)) return true;
      else if (recStack[next]) return true;
    }

    recStack[src] = false;
    return false;
  }

  // Function to detect cycle in a directed graph
  public static boolean isCyclic(List<List<Integer>> adj) {

    int V = adj.size();
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];

    // Check each unvisited node to detect cycles
    for (int i = 0; i < V; i++) {
      if (!visited[i] && isCyclicUtil(adj, i, visited, recStack)) return true;
    }

    return false;
  }

  // Driver function
  public static void main(String[] args) {
    int V = 4;
    List<List<Integer>> adj = new ArrayList<>();

    // Initialize adjacency list
    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

    // Adding edges to the graph
    adj.get(0).add(1);
    adj.get(0).add(2);
    adj.get(1).add(2);
    adj.get(2).add(0);
    adj.get(2).add(3);
    adj.get(3).add(3);

    // Function call to check for cycle
    if (isCyclic(adj)) System.out.println("Contains cycle");
    else System.out.println("No Cycle");
  }
}
