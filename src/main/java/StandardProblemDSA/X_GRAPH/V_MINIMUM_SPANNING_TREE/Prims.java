package StandardProblemDSA.X_GRAPH.V_MINIMUM_SPANNING_TREE;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Prim {
  /*
  Problem Statement:
  ------------------
  Given a connected, undirected, weighted graph with V vertices and E edges,
  find a Minimum Spanning Tree (MST) — a subset of edges connecting all vertices
  with minimum total weight and no cycles.

  Approach:
  ---------
  - Use **Prim’s Algorithm** (greedy):
    1. Start from an arbitrary node.
    2. Maintain a priority queue (min-heap) to pick the smallest weight edge leading
       to a node not yet in the MST.
    3. Maintain arrays:
         - key[v]: Minimum weight to connect vertex v.
         - parent[v]: Parent node in MST.
         - mstSet[v]: Whether v is included in MST.
    4. Repeat until all vertices are included.

  Pattern:
  --------
  - **Greedy Algorithm + Min-Heap + Key Array**
  - Always expand the MST by picking the minimum-weight edge.

  Complexity:
  -----------
  - Time Complexity: O(E log V), as each edge can enter the priority queue once.
  - Space Complexity: O(V + E) for the adjacency list, key array, and priority queue.

  Related LeetCode Questions:
  ---------------------------
  - 1584. Min Cost to Connect All Points
  - 1135. Connecting Cities With Minimum Cost
  - 1168. Optimize Water Distribution in a Village

  Follow-ups:
  ------------
  1. What if the graph is disconnected?
     → You can find a Minimum Spanning Forest (MSF) instead of MST.
  2. Compare **Prim’s vs Kruskal’s**:
     → Prim’s is efficient for dense graphs; Kruskal’s for sparse graphs.
  3. Can we implement Prim’s without a priority queue?
     → Yes, using O(V²) adjacency matrix for small graphs.
  4. How to handle dynamically added edges?
     → Consider fully dynamic MST algorithms or recomputation.
  */

  public static void main(String[] args) {

    // step 1 create the graph and add between them with weight
    int V = 5; // Number of vertices
    ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adjList.add(new ArrayList<Pair>());
    }

    // Adding edges to the adjacency list
    addEdge(adjList, 0, 1, 2);
    addEdge(adjList, 0, 3, 6);
    addEdge(adjList, 1, 2, 3);
    addEdge(adjList, 1, 3, 8);
    addEdge(adjList, 1, 4, 5);
    addEdge(adjList, 2, 4, 7);
    addEdge(adjList, 3, 4, 9);

    int[] parent = new int[V];
    int[] key = new int[V];
    boolean[] mstSet = new boolean[V];

    // step 2 create a visited array and intialise with large value
    for (int i = 0; i < V; i++) {
      key[i] = Integer.MAX_VALUE;
      mstSet[i] = false;
    }

    key[0] = 0;
    parent[0] = -1;
    //  Step 3 create priority queue and insert the 1st node of graph
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.offer(new Pair(0, 0));

    while (!pq.isEmpty()) {
      Pair min = pq.poll();
      int u = min.vertex;

      if (mstSet[u]) // if already visited
      continue;
      // if not add that node mstset as true for visited onece
      mstSet[u] = true;

      ArrayList<Pair> neighbors = adjList.get(u);
      for (Pair neighbor : neighbors) {
        int v = neighbor.vertex;
        int weight = neighbor.weight;
        //        This ensures edges forming cycles are skipped,
        //        because if a vertex is already in mstSet, it won’t be considered again.
        if (!mstSet[v] && weight < key[v]) {
          parent[v] = u;
          key[v] = weight;
          pq.offer(new Pair(v, weight));
        }
      }
    }

    System.out.println("Edge \tWeight");
    for (int i = 1; i < V; i++) {
      System.out.println(parent[i] + " - " + i + "\t" + key[i]);
    }
  }

  public static void addEdge(ArrayList<ArrayList<Pair>> adjList, int u, int v, int w) {
    adjList.get(u).add(new Pair(v, w));
    adjList.get(v).add(new Pair(u, w));
  }

  static class Pair implements Comparable<Pair> {
    int vertex;
    int weight;

    Pair(int v, int w) {
      vertex = v;
      weight = w;
    }

    public int compareTo(Pair other) {
      return Integer.compare(weight, other.weight);
    }
  }
}
