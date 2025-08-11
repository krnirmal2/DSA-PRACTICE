package StandardProblemDSA.X_GRAPH.IV_SHORETEST_PATH_MOVE_TIME_PATTEN.SINGLE_SOURCE_MULTIPLE_DESTINATION.DIJKSTRA;

import java.util.*;

public class MaximumShortestPathTimeInNetworkDelayTime {
    /**
     * Calculates the minimum time for all nodes to receive the signal sent from the source. Uses
     * Dijkstra's algorithm to find the shortest path from the source to all other nodes.
     *
     * @param times Edge list where each edge is [u, v, w] meaning u -> v takes w units of time
     * @param n     Total number of nodes
     * @param src   Starting node (1-indexed in problem, adjusted internally to 0-indexed)
     * @return The time it takes for the signal to reach all nodes, or -1 if some nodes cannot be
     * reached
     */
    public static int networkDelayTime(int[][] times, int n, int src) {
        // Step 1: Build adjacency list for the graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Convert 1-indexed input nodes to 0-indexed
        for (int[] time : times) {
            int u = time[0] - 1; // source node
            int v = time[1] - 1; // destination node
            int w = time[2]; // time taken
            adj.get(u).add(new Pair(v, w));
        }

        // Step 2: Initialize distance array with infinity (unknown distances)
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src - 1] = 0; // Distance to source node is 0

        // Step 3: Use a priority queue (min-heap) for Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Pair(src - 1, 0)); // Start with source node and cost 0

        // Step 4: Process the priority queue
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int time = current.cost;

            // Skip if we already found a shorter path to this node
            if (time > dist[node]) continue;

            // Explore neighbors
            for (Pair neighbor : adj.get(node)) {
                int newTime = time + neighbor.cost;
                // Relaxation step: Update if we found a shorter path
                if (newTime < dist[neighbor.node]) {
                    dist[neighbor.node] = newTime;
                    pq.add(new Pair(neighbor.node, newTime));
                }
            }
        }

        // Step 5: Find the maximum time it takes to reach all nodes
        int maxTime = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) {
                // If any node is unreachable, return -1
                return -1;
            }
            maxTime = Math.max(maxTime, d);
        }

        // The maximum distance among all shortest paths is the network delay time
        return maxTime;
    }

    /*ou are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
      We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
      Example 1:
      Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
      Output: 2
      Example 2:
      Input: times = [[1,2,1]], n = 2, k = 1
      Output: 1
      Example 3:


      Input: times = [[1,2,1]], n = 2, k = 2
      Output: -1
      Constraints:

      1 <= k <= n <= 100
      1 <= times.length <= 6000
      times[i].length == 3
      1 <= ui, vi <= n
      ui != vi
      0 <= wi <= 100
      All the pairs (ui, vi) are unique. (i.e., no multiple edges.)


     Approach:
    ---------
    - Represent the graph using an adjacency list.
    - Apply **Dijkstra’s Algorithm** to find the shortest time to all nodes from the source.
    - Use a min-heap (priority queue) to always pick the node with the smallest current travel time.
    - After processing all nodes, the answer is the **maximum shortest path** in the distance array;
      if any node is unreachable (distance remains infinite), return -1.

    Pattern:
    --------
    - **Graph Traversal + Greedy + Priority Queue (Min-Heap)**.
    - Follows **Single-Source Shortest Path** pattern.
    - Uses **Relaxation Technique** to update shortest times.

    Complexity:
    -----------
    - Time Complexity: O((V + E) log V), where V = number of nodes, E = number of edges.
    - Space Complexity: O(V + E) for adjacency list and O(V) for distance array.

    Related LeetCode Questions:
    ---------------------------
    - 743. Network Delay Time (this problem)
    - 1631. Path With Minimum Effort
    - 1514. Path with Maximum Probability
    - 1976. Number of Ways to Arrive at Destination
    - 882. Reachable Nodes in Subdivided Graph

    Follow-ups:
    ------------
    1. How to handle **negative edge weights**?
       → Use Bellman-Ford algorithm.
    2. How to handle **dynamic edge updates** (frequent additions/removals)?
       → Consider **dynamic shortest path algorithms** or run Dijkstra selectively.
    3. How to **reconstruct the path(s)**?
       → Maintain a `parent[]` array during relaxation.
    4. How to extend this to **find the k-shortest paths** instead of just the shortest?
       → Use a modified Dijkstra with path tracking. */
    // Helper class to represent an edge in the graph: (node, cost to reach)
    static class Pair {
        int node, cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
    }
  }
}
/*Let’s dry run your code step by step with an example:

Input
times = [[2,1,1], [2,3,1], [3,4,1]]
n = 4
src = 2

Step 1: Build adjacency list
We have n = 4 → create adj = [ [], [], [], [] ] (0-indexed).
Now process times (convert to 0-indexed):
	• 2 -> 1 (1) → adj[1]? No, src 2-1 = 1 → adj[1]? Wait, correction:
Actually:
	• For [2,1,1]: u = 2-1 = 1, v = 1-1 = 0, w = 1 → adj[1].add((0,1))
	• For [2,3,1]: u = 1, v = 2, w = 1 → adj[1].add((2,1))
	• For [3,4,1]: u = 2, v = 3, w = 1 → adj[2].add((3,1))
Final adjacency list:
0: []
1: [(0,1), (2,1)]
2: [(3,1)]
3: []

Step 2: Initialize distances
dist = [∞, ∞, ∞, ∞]
dist[src - 1] = dist[1] = 0

Step 3: Priority Queue initialization
pq = [(0, 1)] // (time, node)

Step 4: Dijkstra’s Algorithm Processing
        Step	Pop from PQ     	Update distances	                                Push to PQ
        1	(0, 1)              	Neighbors: (0,1) → dist[0] = 1(2,1) → dist[2] = 1	PQ: [(1,0), (1,2)]
        2	(1,0)	                No neighbors	                                     PQ: [(1,2)]
        3	(1,2)	                Neighbors: (3,1) → dist[3] = 2	                        PQ: [(2,3)]
        4	(2,3)	                No neighbors	                                    PQ: []
Final distances:
dist = [1, 0, 1, 2]

Step 5: Compute maximum distance
maxTime = max(1, 0, 1, 2) = 2
Result: 2

Would you like me to create a table format dry run (iteration by iteration) that you can quickly write in an interview, showing PQ, dist[], and actions?

From <https://chatgpt.com/c/6879f6df-ecf8-8004-b438-45ba2528b261>
*/
