package StandardProblemDSA.X_GRAPH;

import java.util.*;

public class GraphUtility {
  // Build an adjacency list for an unweighted directed graph

  // Approach
  // 1. take the matrix fo the  graph
  // 2. iterate over the no of vertex and create adjaccency list of each vertex
  // 3. now for edges graph from one vertext to aother which is given in the graph
  // int[] edges = means we iterate over each
  List<List<Integer>> buildGraph(int n, int[][] edges) {
    /*
        int n = 4;
        int[][] edges = {{0, 1},{0, 2},
                {1, 2},
                {2, 3}
        };
    */
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge :
        edges) { // iterate over each element of 2D array which is 1d array and inside that
      // one element present the dirction of edges 0 --> 1 and 0-->1 and 1 --> 2 and 2 --> 3
      // For directed graph: edge[0] -> edge[1] == > edge[0] represent first element of the 1d array
      // and
      // edge[1] == > second elementof the 1d array element
      graph.get(edge[0]).add(edge[1]);
    }
    return graph;
  }

  //    Adjacency Matrix Template (Java)

  // Build an adjacency matrix for an unweighted directed graph
  int[][] buildGraphMatrix(int n, int[][] edges) {
    int[][] matrix = new int[n][n];
    for (int[] edge : edges) {
      // For directed graph: edge[0] -> edge[1]
      matrix[edge[0]][edge[1]] = 1;
    }
    return matrix;
  }

  /*   2. Breadth-First Search (BFS)
  What It Covers:
  1.Level-order traversal
  2.Shortest path in unweighted graphs
  3.Flood fill, multi-source expansion*/

  public void bfs(int start, List<List<Integer>> graph) {
    //        Approach
    int n = graph.size();
    boolean[] visited =
        new boolean[n]; // 1. Create a boolean array visited[] and initialize all entries as false.
    Queue<Integer> queue =
        new LinkedList<>(); // 2. Create a queue (FIFO) and enqueue the starting vertex.
    queue.add(start); // add the starting vertex to the queue
    visited[start] = true; // 3. Mark the starting vertex as visited.
    while (!queue
        .isEmpty()) { // 4. While the queue is not empty, dequeue a vertex from the queue and print
      // it.
      int node = queue.poll();
      // Process node (e.g., print, count, etc.)
      for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
          queue.add(neighbor); // 5. For every adjacent vertex of the dequeued vertex, if it is not
          // visited, enqueue it and mark it visited.
          visited[neighbor] = true;
        }
      }
      // 6. Repeat steps 4-5 until the queue is empty.
    }
  }

  /*Problems Using BFS (with small modifications):
  Number of Provinces (LeetCode) – Use BFS to count connected components.
  Rotten Oranges – Multi-source BFS to spread rot in a grid.
  0/1 Matrix (BFS Problem) – Modified BFS with 0/1 cost.
  Shortest Path in UG with Unit Weights – Standard BFS for unweighted graphs.*/

  /*
      3. Depth-First Search (DFS)
      What It Covers:

      Graph traversal (recursive or iterative)

      Flood fill (matrix problems)

      Finding connected components

      Cycle detection

      Common Template:
  */
  public void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    visited[node] = true;
    // Process node (e.g., add to component list)
    for (int neighbor : graph.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, graph, visited);
      }
    }
  }

  /* Problems Using DFS (with small modifications):

      Connected Components Problem in Matrix – DFS for each unvisited cell.

      Flood Fill – DFS in a grid (with bounds checking).

      Surrounded Regions – DFS from borders to mark safe regions.

      Number of Distinct Islands – DFS for island discovery with shape encoding.

              Bipartite Graph (DFS) – DFS with color assignment.

      Cycle Detection in Directed Graph (DFS) – DFS with recursion stack (graph coloring).

      Cycle Detection in Undirected Graph (DFS) – DFS with parent tracking.

              4. Cycle Detection in Graphs
      What It Covers:

      Detecting cycles using either DFS (with recursion stack) or BFS (using Kahn’s algorithm for directed graphs)

      DFS (Graph Coloring) Template:
  */
  // 0: unvisited, 1: visiting, 2: visited (safe)
  private boolean isCyclic(int node, List<List<Integer>> graph, int[] state) {
    if (state[node] == 1) return true; // cycle found
    if (state[node] == 2) return false; // already processed, safe

    state[node] = 1; // mark as visiting
    for (int neighbor : graph.get(node)) {
      if (isCyclic(neighbor, graph, state)) return true;
    }
    state[node] = 2; // mark as safe
    return false;
  }

  //    BFS (Kahn's Algorithm) Cycle Check Template:

  public boolean hasCycle(int n, List<List<Integer>> graph) {
    int[] indegree = new int[n];
    for (List<Integer> neighbors : graph) {
      for (int v : neighbors) {
        indegree[v]++;
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) queue.add(i);
    }
    int count = 0;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      count++;
      for (int neighbor : graph.get(node)) {
        if (--indegree[neighbor] == 0) queue.add(neighbor);
      }
    }
    return count != n; // cycle exists if count != total nodes
  }

  /*
      Problems Using Cycle Detection:

      Cycle Detection in Undirected Graph (BFS/DFS)

      Cycle Detection in Directed Graph (DFS)

      Course Schedule - I (Cycle detection with BFS/DFS)
  */

  /*
  5. Topological Sorting
      What It Covers:

      Linear ordering of vertices in a Directed Acyclic Graph (DAG)

      Used in scheduling problems and dependency resolution

      DFS-Based Topo Sort Template:
  */

  public void topoSortDFS(
      int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
      if (!visited[neighbor]) {
        topoSortDFS(neighbor, graph, visited, stack);
      }
    }
    stack.push(node);
  }

  //    Kahn's Algorithm (BFS-Based) Template:
  public List<Integer> topoSortBFS(int n, List<List<Integer>> graph) {
    int[] indegree = new int[n];
    for (List<Integer> neighbors : graph) {
      for (int neighbor : neighbors) indegree[neighbor]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) queue.add(i);
    }
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      int node = queue.poll();
      result.add(node);
      for (int neighbor : graph.get(node)) {
        if (--indegree[neighbor] == 0) queue.add(neighbor);
      }
    }
    return result;
  }

  /*   Problems Using Topo Sort:

  Topo Sort

  Kahn's Algorithm

  Course Schedule - II (Return valid order)

  Find Eventual Safe States (can be solved with reverse graph and topological ordering)

  Alien Dictionary (build graph from characters then topo sort)*/

  /*
  6. Shortest Path Algorithms
      What It Covers:

      Finding the shortest distance/path in graphs (weighted or unweighted)

      BFS for Unweighted Graphs:
  */

  public int[] shortestPathBFS(int start, List<List<Integer>> graph) {
    int n = graph.size();
    int[] dist = new int[n];
    Arrays.fill(dist, -1);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    dist[start] = 0;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int neighbor : graph.get(node)) {
        if (dist[neighbor] == -1) {
          dist[neighbor] = dist[node] + 1;
          queue.add(neighbor);
        }
      }
    }
    return dist;
  }

  //    Dijkstra's Algorithm Template (for Weighted Graphs):

  public int[] dijkstra(int src, List<List<int[]>> graph, int n) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[] {src, 0});

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int node = curr[0], d = curr[1];
      if (d > dist[node]) continue;
      for (int[] neighbor : graph.get(node)) {
        int next = neighbor[0], weight = neighbor[1];
        if (dist[node] + weight < dist[next]) {
          dist[next] = dist[node] + weight;
          pq.add(new int[] {next, dist[next]});
        }
      }
    }
    return dist;
  } /*
        Other Variants:

        Bellman-Ford for negative weights

        Floyd Warshall for all-pairs shortest path

        Problems Using Shortest Path Templates:

        Shortest Path in UG with Unit Weights – BFS

        Shortest Path in DAG – Can be solved using DP on a topologically sorted order

        Dijkstra's Algorithm

        Shortest path in a binary maze

        Path with Minimum Effort

        Cheapest Flights Within K Stops

        Network Delay Time

        Number of Ways to Arrive at Destination

        Minimum Steps with Multiplication & Mod Operations

        Bellman Ford Algorithm

        Floyd Warshall Algorithm

        Find the City with the Smallest Number of Neighbors in a Threshold Distance
    */

  /*
  7. Minimum Spanning Tree (MST) & Disjoint Set (Union-Find)
      What It Covers:

      Connecting all vertices with the minimum total edge weight

      Cycle detection in undirected graphs
  */

  //    Kruskal's Algorithm with Union-Find Template:
  class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
      if (parent[x] != x) parent[x] = find(parent[x]);
      return parent[x];
    }

    public boolean union(int x, int y) {
      int rootX = find(x), rootY = find(y);
      if (rootX == rootY) return false;
      if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
      else if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
      else {
        parent[rootY] = rootX;
        rank[rootX]++;
      }
      return true;
    }
  }

  //    Prim's Algorithm Template:
  public int primMST(int n, List<List<int[]>> graph) {
    boolean[] inMST = new boolean[n];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.add(new int[] {0, 0}); // {node, weight}
    int mstCost = 0, count = 0;

    while (!pq.isEmpty() && count < n) {
      int[] curr = pq.poll();
      int node = curr[0], weight = curr[1];
      if (inMST[node]) continue;
      inMST[node] = true;
      mstCost += weight;
      count++;
      for (int[] neighbor : graph.get(node)) {
        if (!inMST[neighbor[0]]) {
          pq.add(new int[] {neighbor[0], neighbor[1]});
        }
      }
    }
    return count == n ? mstCost : -1;
  }

  /*  Problems Using MST/Union-Find Templates:

      Minimum Spanning Tree

      Prim's Algorithm

      Kruskal's Algorithm

      Disjoint Set [Union by Rank / Union by Size]

      Number of Operations to Make Network Connected

      Most Stones Removed with Same Rows or Columns

      Accounts Merge

      Number of Island II

      Making a Large Island

      Swim in Rising Water
  */
  /*
  8. Other Advanced Graph Algorithms
      What It Covers:

      Finding bridges and articulation points

      Strongly connected components

      Bridges in Graph Template (DFS):
  */

  int time = 0;

  public void dfs(
      int node,
      int parent,
      List<List<Integer>> graph,
      int[] disc,
      int[] low,
      List<List<Integer>> bridges) {
    disc[node] = low[node] = ++time;
    for (int neighbor : graph.get(node)) {
      if (neighbor == parent) continue;
      if (disc[neighbor] == -1) {
        dfs(neighbor, node, graph, disc, low, bridges);
        low[node] = Math.min(low[node], low[neighbor]);
        if (low[neighbor] > disc[node]) {
          bridges.add(Arrays.asList(node, neighbor));
        }
      } else {
        low[node] = Math.min(low[node], disc[neighbor]);
      }
    }
  }

  //    Articulation Points Template (DFS):

  public void dfsAP(
      int node, int parent, List<List<Integer>> graph, int[] disc, int[] low, boolean[] ap) {
    disc[node] = low[node] = ++time;
    int children = 0;
    for (int neighbor : graph.get(node)) {
      if (disc[neighbor] == -1) {
        children++;
        dfsAP(neighbor, node, graph, disc, low, ap);
        low[node] = Math.min(low[node], low[neighbor]);
        if (parent != -1 && low[neighbor] >= disc[node]) ap[node] = true;
      } else if (neighbor != parent) {
        low[node] = Math.min(low[node], disc[neighbor]);
      }
    }
    if (parent == -1 && children > 1) ap[node] = true;
  }

  //    Kosaraju's Algorithm Template (for Strongly Connected Components):
  // First DFS: fill stack by finish time
  public void fillOrder(
      int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
      if (!visited[neighbor]) fillOrder(neighbor, visited, stack, graph);
    }
    stack.push(node);
  }

  // Reverse the graph
  public List<List<Integer>> reverseGraph(List<List<Integer>> graph) {
    int n = graph.size();
    List<List<Integer>> revGraph = new ArrayList<>();
    for (int i = 0; i < n; i++) revGraph.add(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      for (int neighbor : graph.get(i)) {
        revGraph.get(neighbor).add(i);
      }
    }
    return revGraph;
  }
  /*  Problems Using Advanced Algorithms:

  Bridges in Graph

  Articulation Point

  Kosaraju's Algorithm*/
}
