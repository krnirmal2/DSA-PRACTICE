package StandardProblemDSA.X_GRAPH.VIIII_ARTICULATION_AND_BRIDGE_IN_GRPAH;

import java.util.ArrayList;

import static Graph.IsBridgePresentOrNot.Graphs.*;

/*
🧩 Problem Statement:
---------------------
Given an **undirected graph**, determine if there exists at least one **bridge (cut edge)**.
A **bridge** is an edge which, if removed, increases the number of connected components in the graph.

📘 Example:
----------
Graph:
0 -- 1 -- 2
|      \
3        4

- Removing edge (1, 2) will disconnect vertex 2 from the graph.
- Hence, the graph contains a bridge.

🎯 Approach:
------------
**Brute Force Method**:
1. For every edge (u, v):
   - Temporarily remove the edge.
   - Run a DFS or BFS to check if the graph remains connected.
   - Reinsert the edge.
2. If removing any edge makes the graph disconnected → that edge is a bridge.

📌 Pattern:
-----------
- Graph Traversal (DFS/BFS)
- Connectivity Check
- Brute-force edge removal

🕒 Time Complexity:
-------------------
- **O(E × (V + E))**:
  For each edge, we run DFS (O(V + E)) to check connectivity.

🧠 Space Complexity:
--------------------
- **O(V + E)** for adjacency list and visited array.

⚡ Optimized Approach:
----------------------
Use **Tarjan’s Algorithm** for finding all bridges in **O(V + E)** time:
- Maintain `disc[]` and `low[]` arrays similar to articulation points.
- An edge (u, v) is a bridge if `low[v] > disc[u]`.

🔗 Related LeetCode Problems:
-----------------------------
- 1192. Critical Connections in a Network (Bridge finding)
- 310. Minimum Height Trees (graph connectivity concepts)

💡 Follow-up Questions:
-----------------------
1. Can you list all bridges instead of just checking existence?
2. How would the approach change for **directed graphs**?
3. Can we avoid re-running DFS for each edge?
4. What are real-world applications of bridge detection (e.g., network resilience)?

*/

public class IsBridgePresentOrNot {
  static ArrayList<ArrayList<Integer>> adjcencyList;

  public static void main(String[] args) {
    int noOfVertices = 5;
    ArrayList<ArrayList<Integer>> adjcencyList = new ArrayList<>();

    for (int i = 0; i < noOfVertices; i++) adjcencyList.add(new ArrayList<>());
    // Adding edges one by one
    addEdge(adjcencyList, 0, 1);
    addEdge(adjcencyList, 0, 4);
    addEdge(adjcencyList, 1, 2);
    addEdge(adjcencyList, 1, 3);
    addEdge(adjcencyList, 1, 4);
    addEdge(adjcencyList, 2, 3);
    addEdge(adjcencyList, 3, 4);

    // iterate over each node and remove each edge and dfs apply and then add the edges back to it
    for (int i = 0; i < noOfVertices; i++) {
      for (int j = i + 1; j < noOfVertices; j++) {
        // remove edge
        removeEdge(adjcencyList, i, j);
        // now call the dfs to check the conectividyt
        isConnected();
        // add back the edge again to the graph
        addEdge(adjcencyList, i, j);
      }
    }
  }

  // Two way
  //  brute force
  //       1.remove each edge and check  if graph is connected or not and then again add the edge
  static class Graphs {
    static int noOfVertices;

    // list of adjcencyListancy
    /* public Graphs(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adjcencyListcencyList = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++) {
            adjcencyListcencyList.add(new ArrayList<>());
        }
    }*/

    static void addEdge(ArrayList<ArrayList<Integer>> adjcencyList, int u, int v) {
      adjcencyList.get(u).add(v);
      adjcencyList.get(v).add(u);
    }

    static void removeEdge(ArrayList<ArrayList<Integer>> adjcencyList, int src, int dest) {
      adjcencyList.get(src).remove(dest);
      adjcencyList.get(dest).remove(src);
    }

    public static boolean isConnected() {
      boolean[] visited = new boolean[noOfVertices];
      dfs(0, visited);
      for (boolean v : visited) {
        if (!v) {
          return false;
        }
      }
      return true;
    }

    private static void dfs(int i, boolean[] visited) {
      visited[i] = true;
      for (int u : adjcencyList.get(i)) {
        if (!visited[u]) {
          dfs(i, visited);
        }
      }
    }
  }
}
