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

    // TODO: step1 create the graph and add between them with weight
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

    // TODO step2 create a visited array and intialise with large value
    for (int i = 0; i < V; i++) {
      key[i] = Integer.MAX_VALUE;
      mstSet[i] = false;
    }

    key[0] = 0;
    parent[0] = -1;
    // TODO : Step 3 create priority queue and insert the 1st node of graph
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.offer(new Pair(0, 0));

    while (!pq.isEmpty()) {
      Pair min = pq.poll();
      int u = min.vertex;

      if (mstSet[u]) // if already visited
      continue;

      mstSet[u] = true;

      ArrayList<Pair> neighbors = adjList.get(u);
      for (Pair neighbor : neighbors) {
        int v = neighbor.vertex;
        int weight = neighbor.weight;

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

// public class PrimsAlgorithm {
//
//    public static List<Edge> findMinimumSpanningTree(Graph graph) {
//        List<Edge> minimumSpanningTree = new ArrayList<>();
//        PriorityQueue<Edge> edgeHeap = new
// PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
//        boolean[] visited = new boolean[graph.getNumVertices()];
//        visited[0] = true;
//        for (Edge edge : graph.getEdges(0)) {
//            edgeHeap.offer(edge);
//        }
//        while (!edgeHeap.isEmpty()) {
//            Edge minEdge = edgeHeap.poll();
//            if (visited[minEdge.getTo()]) {
//                continue;
//            }
//            minimumSpanningTree.add(minEdge);
//            visited[minEdge.getTo()] = true;
//            for (Edge edge : graph.getEdges(minEdge.getTo())) {
//                if (!visited[edge.getTo()]) {
//                    edgeHeap.offer(edge);
//                }
//            }
//        }
//        return minimumSpanningTree;
//    }
// }
//
// class Graph {
//    private final int numVertices;
//    private final List<List<Edge>> adjacencyList;
//
//    public Graph(int numVertices) {
//        this.numVertices = numVertices;
//        adjacencyList = new ArrayList<>(numVertices);
//        for (int i = 0; i < numVertices; i++) {
//            adjacencyList.add(new ArrayList<>());
//        }
//    }
//
//    public void addEdge(int from, int to, int weight) {
//        adjacencyList.get(from).add(new Edge(from, to, weight));
//        adjacencyList.get(to).add(new Edge(to, from, weight));
//    }
//
//    public List<Edge> getEdges(int vertex) {
//        return adjacencyList.get(vertex);
//    }
//
//    public int getNumVertices() {
//        return numVertices;
//    }
// }
//
// class Edge {
//    private final int from;
//    private final int to;
//    private final int weight;
//
//    public Edge(int from, int to, int weight) {
//        this.from = from;
//        this.to = to;
//        this.weight = weight;
//    }
//
//    public int getFrom() {
//        return from;
//    }
//
//    public int getTo() {
//        return to;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
// }
//
//

// public class Prims {
//    class Pair{
//        int node;
//        int weight;
//        Pair(int n, int w){
//            this.node = n;
//            this.weight = w;
//        }
//    }
//
//    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
//        ArrayList<Pair>[] graph = new ArrayList[A+1];
//        for(int i=0; i<=A; i++){
//            graph[i] = new ArrayList<>();
//        }
//
//        for(int i=0; i<B.size(); i++){
//            ArrayList<Integer> row = B.get(i);
//            graph[row.get(0)].add(new Pair(row.get(1), row.get(2)));
//            graph[row.get(1)].add(new Pair(row.get(0), row.get(2)));
//        }
//
//        boolean[] vst = new boolean[A+1];
//        vst[1] = true;
//
//        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
//            public int compare(Pair p1, Pair p2){
//                return p1.weight-p2.weight;
//            }
//        });
//
//        for(Pair p: graph[1]){
//            queue.add(p);
//        }
//
//        int minCost = 0;
//        while(!queue.isEmpty()){
//            Pair top = queue.remove();
//            if(!vst[top.node]){
//                minCost += top.weight;
//                vst[top.node] = true;
//                minCost %= 1000000007;
//            }
//
//            for(Pair p: graph[top.node]){
//                if(!vst[p.node]){
//                    queue.add(p);
//                }
//            }
//        }
//        return minCost;
//    }
// }

// import java.util.*;

// class Prim {
//    public static void main(String[] args) {
//        // tODO : STEP 1 CREATE THE GRAPH USING ADJACENCY LIST
//        int V = 5; // Number of vertices
//        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
//        for (int i = 0; i < V; i++) {
//            adjList.add(new ArrayList<Pair>());
//        }
//
//        // Adding edges to the adjacency list
//        addEdge(adjList, 0, 1, 2);
//        addEdge(adjList, 0, 3, 6);
//        addEdge(adjList, 1, 2, 3);
//        addEdge(adjList, 1, 3, 8);
//        addEdge(adjList, 1, 4, 5);
//        addEdge(adjList, 2, 4, 7);
//        addEdge(adjList, 3, 4, 9);
//
//        int[] parent = new int[V];
//        int[] key = new int[V];
//        boolean[] mstSet = new boolean[V];
//
//        for (int i = 0; i < V; i++) {
//            key[i] = Integer.MAX_VALUE;
//            mstSet[i] = false;
//        }
//
//        key[0] = 0;
//        parent[0] = -1;
//
//        for (int i = 0; i < V - 1; i++) {
//            int minKey = minKey(key, mstSet);
//            mstSet[minKey] = true;
//
//            ArrayList<Pair> neighbors = adjList.get(minKey);
//            for (Pair neighbor : neighbors) {
//                int j = neighbor.vertex;
//                int weight = neighbor.weight;
//                if (!mstSet[j] && weight < key[j]) {
//                    parent[j] = minKey;
//                    key[j] = weight;
//                }
//            }
//        }
//
//        System.out.println("Edge \tWeight");
//        for (int i = 1; i < V; i++) {
//            System.out.println(parent[i] + " - " + i + "\t" + key[i]);
//        }
//    }
//
//    public static void addEdge(ArrayList<ArrayList<Pair>> adjList, int u, int v, int w) {
//        adjList.get(u).add(new Pair(v, w));
//        adjList.get(v).add(new Pair(u, w));
//    }
//
//    public static int minKey(int[] key, boolean[] mstSet) {
//        int min = Integer.MAX_VALUE;
//        int minIndex = -1;
//
//        for (int i = 0; i < key.length; i++) {
//            if (!mstSet[i] && key[i] < min) {
//                min = key[i];
//                minIndex = i;
//            }
//        }
//
//        return minIndex;
//    }
//
//    static class Pair {
//        int vertex;
//        int weight;
//
//        Pair(int v, int w) {
//            vertex = v;
//            weight = w;
//        }
//    }
// }
