package StandardProblemDSA.X_GRAPH.III_CYCLE_PATTERN;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraphUingDFS {}

class GfG {

  /*
  🧠 Problem:
  Detect if a **directed graph** contains a cycle.

  🔑 Approach: DFS + Recursion Stack
  - Maintain two arrays:
      - `visited[]` → marks nodes we’ve fully processed.
      - `recStack[]` → tracks the nodes in the **current DFS path**.
  - For each unvisited node:
      - Perform DFS.
      - Mark node as visited and add to `recStack`.
      - If any neighbor is:
          - Not visited → recursively DFS.
          - Already in `recStack` → **cycle detected** (back edge).
      - Remove node from `recStack` when DFS unwinds.

  🌐 Why `recStack[]`?
  - In directed graphs, revisiting a node in the same recursion stack means a **back edge** → cycle.

  ⏱️ Time Complexity: **O(V + E)**
  📦 Space Complexity: **O(V)** for `visited`, `recStack`, and recursion stack.

  🔁 Pattern:
  - DFS with recursion stack for cycle detection in **directed graphs**.

  📌 Related Problems:
  - Topological sort (cycle detection as a byproduct).
  - Detecting deadlocks in OS (wait-for graphs).
  - Course Schedule (LeetCode 207).
  */

  // Function to detect cycle in a directed graph
  public static boolean isCyclic(List<List<Integer>> adj) {

    int V = adj.size();
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];

    // Check each unvisited node to detect cycles
    for (int i = 0; i < V; i++) {
      if (!visited[i] && GraphUtility.isCyclicInDirectedGraph(adj, i, visited, recStack))
        return true;
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
