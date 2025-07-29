package StandardProblemDSA.X_GRAPH.III_CYCLE_PATTERN;

import java.util.*;

public class CycleDetectinUndirectedGraphUsingBFS {
  /*
  🧠 Problem:
  Detect if an **undirected graph** contains a cycle using BFS.

  🔑 Approach: BFS with Parent Tracking
  - For each connected component, perform BFS starting from any unvisited node.
  - Maintain a queue of `{node, parent}` pairs.
  - For each neighbor:
    - If not visited → mark visited, push `{neighbor, node}` to queue.
    - If already visited and `neighbor != parent` → cycle detected (return true).

  ⚠️ Why parent tracking?
  - In undirected graphs, every edge appears twice (u ↔ v).
  - Without checking the parent, we might wrongly detect a cycle when visiting the immediate parent.

  🌐 Multiple Components:
  - We run BFS for every unvisited node, as the graph might be disconnected.

  ⏱️ Time Complexity:
  - **O(V + E)** where V = vertices, E = edges (each vertex and edge is processed once).

  📦 Space Complexity:
  - **O(V)** for `visited[]` and BFS queue.

  🔁 Pattern:
  - BFS + parent tracking for cycle detection in undirected graphs.

  📌 Related Problems:
  - Detect cycle in undirected graph (DFS version)
  - Detect cycle in directed graph (Kahn’s algorithm / DFS stack)
  - Connected Components in Graph
  */

  // Function to perform BFS from node start
  static boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {start, -1});
    visited[start] = true;

    while (!q.isEmpty()) {
      int[] front = q.poll();
      int node = front[0];
      int parent = front[1];

      for (int neighbor : adj.get(node)) {

        // If node is not visited,
        // push it into queue.
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          q.add(new int[] {neighbor, node});
        }

        // If node is visited and
        // it is not the parent node.
        else if (neighbor != parent) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
    int n = adj.size();
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {

      // If node is not visited,
      // start BFS from this node.
      if (!visited[i]) {

        // If cycle is found in this
        // component.
        if (bfs(i, adj, visited)) {
          return true;
        }
      }
    }

    // If no cycle is found
    return false;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(0).addAll(Arrays.asList(1, 2, 3));
    adj.get(1).addAll(Arrays.asList(0, 2));
    adj.get(2).addAll(Arrays.asList(0, 1));
    adj.get(3).addAll(Arrays.asList(0, 4));
    adj.get(4).addAll(List.of(3));

    if (isCycle(adj)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
