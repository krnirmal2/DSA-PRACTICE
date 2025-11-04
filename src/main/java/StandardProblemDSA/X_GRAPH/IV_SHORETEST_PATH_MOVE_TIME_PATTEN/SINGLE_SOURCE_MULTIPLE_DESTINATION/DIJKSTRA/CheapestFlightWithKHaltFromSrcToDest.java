package StandardProblemDSA.X_GRAPH.IV_SHORETEST_PATH_MOVE_TIME_PATTEN.SINGLE_SOURCE_MULTIPLE_DESTINATION.DIJKSTRA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.


You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
---
🔑 Approach:
- Use **modified BFS (level-order traversal)** with a queue of `(stops, node, cost)`.
- Keep a `dist[]` array storing min cost to reach each city.
- For each node, explore neighbors:
    - If `cost + edgeWeight < dist[neighbor]` and stops ≤ K, update and enqueue.
- If `stops > K`, skip further exploration.
- Finally, return `dist[dst]` or `-1` if not reachable.

---
⏱️ Complexity:
- Time: **O(E × K)** (E = no. of flights, K = max stops)
- Space: **O(V + E)** for adjacency list and distance array.

---
📦 Pattern:
- BFS with state `(node, stops, cost)`; similar to **Dijkstra** but bounded by stops.
- Often used in **K-stop flight routing problems**.

---
📌 Similar LeetCode Questions:
1. **LC 787** - Cheapest Flights Within K Stops *(this problem)*
2. **LC 743** - Network Delay Time *(Dijkstra’s algorithm)*
3. **LC 1514** - Path with Maximum Probability *(variation with probabilities)*
4. **LC 1631** - Path With Minimum Effort *(minimize maximum edge weight)*
5. **LC 864** - Shortest Path to Get All Keys *(BFS with state tracking)*
*/
public class CheapestFlightWithKHaltFromSrcToDest {
  public static int CheapestFLight(int n, int[][] flights, int src, int dst, int K) {
    // Create the adjacency list to depict airports and flights in
    // the form of a graph.
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    int m = flights.length;
    for (int i = 0; i < m; i++) {
      adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
    }

    // Create a queue which stores the node and their distances from the
    // source in the form of {stops, {node, dist}} with ‘stops’ indicating
    // the no. of nodes between src and current node.
    Queue<Tuple> q = new LinkedList<>();

    q.add(new Tuple(0, src, 0));
    // Distance array to store the updated distances from the source.
    int[] dist = new int[n];
    for (int i = 0; i < n; i++) {
      dist[i] = (int) (1e9);
    }
    dist[src] = 0;
    // Iterate through the graph using a queue like in Dijkstra with
    // popping out the element with min stops first.
    while (!q.isEmpty()) {
      Tuple it = q.peek();
      q.remove();
      int stops = it.first;
      int node = it.second;
      int cost = it.third;

      // We stop the process as soon as the limit for the stops reaches.
      if (stops > K) continue;
      for (Pair iter : adj.get(node)) {
        int adjNode = iter.first;
        int edW = iter.second;

        // We only update the queue if the new calculated dist is
        // less than the prev and the stops are also within limits.
        if (cost + edW < dist[adjNode] && stops <= K) {
          dist[adjNode] = cost + edW;
          q.add(new Tuple(stops + 1, adjNode, cost + edW));
        }
      }
    }
    // If the destination node is unreachable return ‘-1’
    // else return the calculated dist from src to dst.
    if (dist[dst] == (int) (1e9)) return -1;
    return dist[dst];
  }

  public static void main(String[] args) {

    int n = 4, src = 0, dst = 3, K = 1;
    int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
    int ans = CheapestFLight(n, flights, src, dst, K);

    System.out.print(ans);
    System.out.println();
  }
}

class Pair {
  int first;
  int second;

  public Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }
}

class Tuple {
  int first, second, third;

  Tuple(int first, int second, int third) {
    this.first = first;
    this.second = second;
    this.third = third;
  }
}
