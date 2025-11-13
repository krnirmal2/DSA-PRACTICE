package StandardProblemDSA.X_GRAPH.IV_SHORETEST_PATH_MOVE_TIME_PATTEN.SINGLE_SOURCE_MULTIPLE_DESTINATION.DIJKSTRA;

import StandardProblemDSA.X_GRAPH.Pair;
import java.util.*;

/*
Problem Statement:
Given a weighted graph with V vertices and E edges, find the shortest distance from a source vertex to all other vertices
using Dijkstra’s algorithm. The graph has non-negative edge weights.
You are provided with:
- Number of vertices V.
- A list of edges with weights.
- A source vertex.

Dijkstra’s Algorithm:
- Uses a greedy approach to find the shortest path.
- Maintains a priority queue (min-heap) to pick the next vertex with the smallest known distance.
- Updates distances of adjacent vertices if a shorter path is found.

Key Points:
- Works only with non-negative weights.
- Time Complexity: O((V + E) * log V) using a priority queue.
- Space Complexity: O(V + E) for adjacency list and distance array.

Example:
Input:
V = 9
Edges = [
  (0,1,4), (0,7,8), (1,2,8), (1,7,11),
  (2,3,7), (2,8,2), (2,5,4), (3,4,9),
  (3,5,14), (4,5,10), (5,6,2), (6,7,1),
  (6,8,6), (7,8,7)
]
src = 0
Output:
Shortest distances from source: [0, 4, 12, 19, 21, 11, 9, 8, 14]
Approach:
---------
- Use a Min-Heap (PriorityQueue) to always pick the next node with the smallest tentative distance.
- Maintain a distance array initialized to infinity; set the source distance to 0.
- For each extracted node, relax all its neighbors:
  if current distance + edge weight < neighbor distance, update and push into PQ.
- Continue until PQ is empty.

Pattern:
--------
- **Graph Traversal with Greedy + Priority Queue (Min-Heap)**.
- Relies on **Relaxation Technique** and is part of **Single-Source Shortest Path** algorithms.
- Often used in **shortest path in weighted graphs** problems.

Complexity:
-----------
- Time: O((V + E) log V), where V = number of vertices, E = number of edges.
- Space: O(V + E) for adjacency list and O(V) for distance array.

Related LeetCode Questions:
---------------------------
- 743. Network Delay Time
- 1514. Path with Maximum Probability
- 1631. Path With Minimum Effort
- 1976. Number of Ways to Arrive at Destination
- 882. Reachable Nodes In Subdivided Graph

Follow-ups:
------------
1. How would you modify this if negative edge weights were allowed?
   → Use Bellman-Ford algorithm instead.
2. How to handle dynamic edge updates (e.g., new edges added frequently)?
   → Consider using **dynamic Dijkstra** or **A\*** for repeated queries.
3. How to find not just shortest distances but also the **number of shortest paths**?
   → Maintain a count array alongside the distance array.
4. How to reconstruct the actual shortest path(s)?
   → Maintain a `parent[]` array to trace back from destination to source.
*/

class Dijekstra {
  private final int V;
  private final List<List<Pair>> adj;

  Dijekstra(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }

  public static void main(String[] args) {
    int V = 9;
    Dijekstra g = new Dijekstra(V);

    g.addEdge(0, 1, 4);
    g.addEdge(0, 7, 8);
    g.addEdge(1, 2, 8);
    g.addEdge(1, 7, 11);
    g.addEdge(2, 3, 7);
    g.addEdge(2, 8, 2);
    g.addEdge(2, 5, 4);
    g.addEdge(3, 4, 9);
    g.addEdge(3, 5, 14);
    g.addEdge(4, 5, 10);
    g.addEdge(5, 6, 2);
    g.addEdge(6, 7, 1);
    g.addEdge(6, 8, 6);
    g.addEdge(7, 8, 7);

    g.shortestPath(0);
  }

  void addEdge(int u, int v, int w) {
    adj.get(u).add(new Pair(v, w));
    adj.get(v).add(new Pair(u, w));
  }

  void shortestPath(int src) {
    // Priority queue to extract the minimum distance each time
    PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));
    // Array for distances of each node
    int[] dist = new int[V];
    // Fill every node with infinite value
    Arrays.fill(dist, Integer.MAX_VALUE);
    // Insert source into priority queue with distance as 0
    pq.add(new Pair(0, src));
    // Set source distance to zero
    dist[src] = 0;

    while (!pq.isEmpty()) {
      int u = pq.poll().weight; // Remove the vertex with minimum distance
      for (Pair v : adj.get(u)) { // Check the adjacent nodes of the current node
        if (dist[v.vertex]
            > dist[u]
                + v.weight) { // If the distance of node v is greater than distance of node u +
          // distance of edge from u to v
          dist[v.vertex] = dist[u] + v.weight; // Update the distance of node v
          pq.add(
              new Pair(
                  dist[v.vertex],
                  v.vertex)); // Add the updated distance of node v to the priority queue
        }
      }
    }

    System.out.println("Vertex Distance from Source");
    for (int i = 0; i < V; i++) {
      System.out.println(i + "\t\t" + dist[i]);
    }
  }
}
