package StandardProblemDSA.X_GRAPH.VI_DISJOIN_SET;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
  /*
  Problem Statement:
  ------------------
  Given a weighted, undirected, and connected graph with V vertices and E edges, find the sum of
  weights of the edges of the Minimum Spanning Tree (MST).
  In some variations, the MST itself (list of edges {u, v}) may also be required.

  Examples:
  ---------
  Input:
  V = 5, edges = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}}
  Output: 16
  Explanation: MST = {(0, 1), (0, 3), (1, 2), (1, 4)}

  Input:
  V = 5, edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}
  Output: 5
  Explanation: MST = {(0, 2), (1, 2), (2, 3), (3, 4)}

  Approach:
  ---------
  - Build an adjacency list to represent the undirected graph.
  - Use **Prim's Algorithm**:
    1. Start with any node (here, node 0) and push it into a min-heap (priority queue) with weight 0.
    2. Use a `vis[]` array to track visited nodes.
    3. Extract the minimum-weight edge from the priority queue.
    4. If the node is unvisited, add its weight to the MST sum and mark it visited.
    5. Push all unvisited neighbors into the queue.
    6. Repeat until all vertices are included.

  Pattern:
  --------
  - **Minimum Spanning Tree (MST)**
  - **Greedy Algorithm**
  - **Graph Traversal with Priority Queue**
  - **Prim’s Algorithm**

  Time & Space Complexity:
  ------------------------
  - Time Complexity: O(E * log V)
    - Each edge insertion/extraction in the priority queue takes O(log V).
  - Space Complexity: O(V + E)
    - For adjacency list and auxiliary structures (visited array, priority queue).

  Related LeetCode / Practice Problems:
  -------------------------------------
  - 1584. Min Cost to Connect All Points
  - 1135. Connecting Cities With Minimum Cost
  - 1168. Optimize Water Distribution in a Village
  - 1489. Find Critical and Pseudo-Critical Edges in MST

  Follow-ups:
  -----------
  1. Can you modify Prim's algorithm to also **return the actual MST edges**, not just the total weight?
  2. Compare **Prim's Algorithm vs Kruskal's Algorithm** – when is each preferable?
  3. How would you handle **disconnected graphs** (returning an MST forest)?
  4. Can you implement **Prim's algorithm using a simple array (O(V²))** for dense graphs?


    */
  static class Pair {
    int v;
    int wt;

    Pair(int v, int wt) {
      this.v = v;
      this.wt = wt;
    }
  }

  // lets say the spanningtree give that is
  static int spanningTree(int V, int E, int[][] edges) {
    // store the eges and graph to the Adj list
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    // iterate over the edge and collect the vertices and nodes
    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      adj.get(u).add(new Pair(v, wt));
      adj.get(v).add(new Pair(u, wt));
    }
    // now add all this so now use priority queue and bfs to hadle the prims total mst
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt); // sort by wt

    // inset the first element v in the node
    pq.add(new Pair(0, 0));

    // track for the visited  node
    int[] vis = new int[V];
    int sum = 0;
    while (!pq.isEmpty()) {
      // take the first node
      Pair node = pq.poll();
      int v = node.v;
      int wt = node.wt;
      if (vis[v] == 1) continue;
      // now add the summ
      sum += wt;
      // mark that node as visited
      vis[node.v] = 1;
      // iterate over the adja
      for (Pair neighbor : adj.get(v)) {
        if (vis[neighbor.v] == 0) {
          pq.add(new Pair(neighbor.v, neighbor.wt));
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    int[][] graph = new int[][] {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};

    // Function call
    System.out.println(spanningTree(3, 3, graph));
  }
}
