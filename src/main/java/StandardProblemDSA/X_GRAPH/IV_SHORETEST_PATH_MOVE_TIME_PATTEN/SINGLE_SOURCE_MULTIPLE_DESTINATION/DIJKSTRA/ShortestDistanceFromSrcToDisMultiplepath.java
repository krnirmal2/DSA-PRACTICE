package StandardProblemDSA.X_GRAPH.IV_SHORETEST_PATH_MOVE_TIME_PATTEN.SINGLE_SOURCE_MULTIPLE_DESTINATION.DIJKSTRA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestDistanceFromSrcToDisMultiplepath {
  /*
  Problem Statement:
  ------------------
  You are given an undirected weighted graph with `n` nodes and an array `roads` where
  `roads[i] = [u, v, time]` indicates there is a road between `u` and `v` taking `time` units.
  You start at node `0` and want to reach node `n-1`.
  Return the number of **distinct shortest paths** from node `0` to node `n-1`.
  Since the answer may be very large, return it modulo 10^9 + 7.

  Approach:
  ---------
  - Build an adjacency list to represent the graph.
  - Use **Dijkstra’s Algorithm** to find the shortest distance from node `0` to all nodes.
  - Maintain:
    - `dist[]`: the shortest distance to each node.
    - `ways[]`: the number of distinct shortest paths to each node.
  - When a better distance is found for a node, update both `dist[]` and `ways[]`.
  - When another path with the same shortest distance is found, increment `ways[]` modulo 10^9 + 7.
  - Finally, `ways[n - 1]` gives the number of shortest paths from `0` to `n-1`.

  Pattern:
  --------
  - **Graph Traversal + Single-Source Shortest Path + Path Counting**
  - Uses **Dijkstra with Path Count Augmentation**.

  Complexity:
  -----------
  - Time Complexity: O((V + E) log V), where V = number of nodes and E = number of edges.
  - Space Complexity: O(V + E) for the adjacency list and O(V) for `dist[]` and `ways[]`.

  Related LeetCode Questions:
  ---------------------------
  - 1976. Number of Ways to Arrive at Destination (this problem)
  - 743. Network Delay Time
  - 1514. Path with Maximum Probability
  - 1631. Path With Minimum Effort

  Follow-ups:
  ------------
  1. How to handle **negative edge weights**?
     → Use Bellman-Ford algorithm with path counting.
  2. How to find **all actual shortest paths**, not just count them?
     → Store parent lists for each node and backtrack from `n-1`.
  3. How to handle **dynamic graphs** where edges are frequently updated?
     → Consider dynamic shortest path algorithms or recompute selectively.
  4. How to modify it for **k-shortest paths**?
     → Use a modified Dijkstra/K-shortest paths algorithm.
  */

  static class Pair {
    // node: The destination node for an edge.
    // time: The weight of the edge, i.e., the travel time to reach the destination node.

    int node;
    int time;

    Pair(int node, int time) {
      this.node = node;
      this.time = time;
    }
  }

  public int countPaths(int n, int[][] roads) {
    final int MOD = (int) 1e9 + 7;

    // Step 1: Build adjacency list with Pair class
    List<List<Pair>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>()); // create n no. of adjacency list empty
    }
    for (int[] edge : roads) { // create the edge connection between each node
      int u = edge[0],
          v = edge[1],
          time = edge[2]; // inside each array at index 0 represent src, 1 represent destination , 2
      // represent time
      graph.get(u).add(new Pair(v, time)); // for each src add the new pair of destination adn time
      graph
          .get(v)
          .add(
              new Pair(
                  u, time)); // similarliy from destination to src , Reverse as it is undirected
    }

    // Step 2: Dijkstra setup
    int[] dist =
        new int[n]; // dist[] array: This array stores the shortest time to reach each node starting
    // from node 0. Initially, all values are set to Integer.MAX_VALUE (representing
    // infinity), except for dist[0], which is set to 0 because the starting node is
    // already at distance 0.
    int[] ways =
        new int
            [n]; // ways[] array: This array stores the number of distinct shortest paths to reach
    // each node. Initially, we set ways[0] = 1, as there is exactly one way to reach
    // node 0, which is to start there.
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;
    ways[0] = 1;

    PriorityQueue<Pair> pq =
        new PriorityQueue<>(
            (a, b) ->
                a.time - b.time); // This priority queue is used to always process the node with the
    // smallest travel time (time). The queue stores Pair objects, where
    // the priority is based on the time value.
    pq.offer(new Pair(0, 0)); // start from node 0 with time 0

    // Step 3: Run Dijkstra
    while (!pq.isEmpty()) {
      Pair current = pq.poll();
      int u = current.node;
      int time = current.time;

      if (time > dist[u]) continue; // skip if already found better time

      for (Pair neighbor : graph.get(u)) {
        int v = neighbor.node;
        int edgeTime = neighbor.time;

        if (time + edgeTime < dist[v]) {
          dist[v] = time + edgeTime;
          ways[v] = ways[u]; // new shortest path
          pq.offer(new Pair(v, dist[v]));
        } else if (time + edgeTime == dist[v]) {
          ways[v] = (ways[v] + ways[u]) % MOD; // same time, add ways
        }
      }
    }

    return ways[n - 1];
  }
  /* ou are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

  You are given an integer n and a 2D integer array ‘roads’ where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

  Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

  Example 1:



  Input:
  n=7, m=10
  edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
  Output:
          4
  Explanation:
  The four ways to get there in 7 minutes (which is the shortest calculated time) are:
          - 0  6
          - 0  4  6
          - 0  1  2  5  6
          - 0  1  3  5  6
  Example 2:



  Input:
  n=6, m=8
  edges= [[0,5,8],[0,2,2],[0,1,1],[1,3,3],[1,2,3],[2,5,6],[3,4,2],[4,5,2]]
  Output:
          3
  Explanation:
  The three ways to get there in 8 minutes (which is the shortest calculated time) are:
          - 0  5
          - 0  2  5
          - 0  1  3  4  5
  Solution

  Disclaimer: Don’t jump directly to the solution, try it out yourself first.

  Practice:
  Solve Problem
  Problem Link

  Note: In case any image/dry run is not clear please refer to the video attached at the bottom.

  Intuition: Since there can be many paths to reach a destination node from the given source node, in this problem, we have to find all those paths that are the shortest in order to reach our destination. For an easier understanding of this particular problem, we can say that we can divide the problem into partitions such as illustrated below :


  From the above picture, we may assume that there will be 3 shortest paths to the destination node. But that may not be the case every time. Let us understand how - We assume the total number of ways in which the destination node is reachable by the shortest possible distance be ways[node] where ‘node’ depicts the destination node and node1, node2 and node3 are the three nodes which act as intermediate nodes that provide shortest paths to the destination. We can say :

  ways[node] = ways[node1] + ways[node2] + ways[node3]
  Where, ways[node1], ways[node2], and ways[node3] are the number of shortest paths possible to node1, node2, and node3 respectively from the source node, the sum of which is the total possible shortest paths and that can be hence greater than 3.

  Approach:

  This problem is based on Dijkstra's Algorithm where we count all the possible shortest paths from the source to the destination node.

  Initial configuration:

  Priority Queue: Define a Priority Queue which would contain pairs of the type {dist, node }, where ‘dist’ indicates the currently updated value of the shortest dist taken to reach from source to the current ‘node’.
  Distance Array: Define a distance array that would contain the minimum distance from the start node to the current node. If a cell is marked as ‘infinity’ then it is treated as unreachable/ unvisited.
  Source Node: Define the start node from where we have to calculate the total number of shortest paths.
  Ways Array: Define a ways array which would contain the number of possible shortest ways/paths for each node. Eventually, we would want to return ways[n-1] where n= Number of nodes.
  The Algorithm consists of the following steps :

  Start by creating an adjacency list, a priority queue that stores the dist-node pairs in the form {dist, node} and a dist array with each node initialized with a very large number ( to indicate that the nodes have not been visited initially).
  In addition to the standard configuration of Dijkstra’s algorithm, we have one more array in this problem by the name ‘ways’ which is initialized to ‘0’ for every node when they’re unvisited (so the number of ways is 0).
  Now, we push the start node to the queue along with its distance marked as ‘0’ and ways marked as ‘1’ initially because we’ve just started the algorithm.
  Pop the element from the front of the queue and look out for its adjacent nodes.
  If the current dist value for a number is better than the previous distance indicated by the distance array, we update the distance in the array and push it to the queue. Now, here side by side we also keep the number of ways to the ‘node’ the same as before.
  If the current dist value is the same as the previously stored dist value at the same index, increment the number of ways by 1 at that index.
  We repeat the above steps until the queue becomes empty or till we reach the destination.
  Return the ways[n-1] modulo 10^9+7 when the queue becomes empty.
          Here’s a quick demonstration of the Algorithm’s 1st iteration for example 1 stated above ( all the further iterations would be done in a similar way ) :


  Note: If you wish to see the dry run of the above approach, you can watch the video attached to this article*/
}
