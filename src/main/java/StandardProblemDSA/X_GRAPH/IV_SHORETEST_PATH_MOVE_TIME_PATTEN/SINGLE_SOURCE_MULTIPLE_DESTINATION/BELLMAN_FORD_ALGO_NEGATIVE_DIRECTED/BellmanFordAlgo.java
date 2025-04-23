package StandardProblemDSA.X_GRAPH.IV_SHORETEST_PATH_MOVE_TIME_PATTEN.SINGLE_SOURCE_MULTIPLE_DESTINATION.BELLMAN_FORD_ALGO_NEGATIVE_DIRECTED;

import java.util.*;

public class BellmanFordAlgo {
  // NOTE: FOR BELLMAN FORD
  // Negative edge, // if after n-1 iteration in the last iteration still reduce
  // the value of distance array then there must be a negative edge
  // directed graph
  // negative cycle detected
  // Relax all the edges n-1 times sequentially(Beacuase it helps to complete
  // to coumpute the shortest distance of all the node of distance array at the end

  /*Problem Statement: Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertices from the source vertex S.

  Note: If the Graph contains a negative cycle then return an array consisting of only -1.

  Example 1:

  Input Format:
  V = 6,
  E = [[3, 2, 6], [5, 3, 1], [0, 1, 5], [1, 5, -3], [1, 2, -2], [3, 4, -2], [2, 4, 3]],
  S = 0


  Result: 0 5 3 3 1 2
  Explanation: Shortest distance of all nodes from the source node is returned.
  Example 2:

  Input Format: V = 2, E = [[0,1,9]],  S = 0*/
  class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
      int[] dist = new int[V];
      for (int i = 0; i < V; i++) dist[i] = (int) (1e8);
      dist[S] = 0;
      // V x E
      for (int i = 0; i < V - 1; i++) {
        for (ArrayList<Integer> it : edges) {
          int u = it.get(0);
          int v = it.get(1);
          int wt = it.get(2);
          if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
          }
        }
      }
      // Nth relaxation to check negative cycle
      for (ArrayList<Integer> it : edges) {
        int u = it.get(0);
        int v = it.get(1);
        int wt = it.get(2);
        if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
          int temp[] = new int[1];
          temp[0] = -1;
          return temp;
        }
      }
      return dist;
    }
  }

  public class tUf {
    public static void main(String[] args) {
      int V = 6;
      int S = 0;
      ArrayList<ArrayList<Integer>> edges =
          new ArrayList<>() {
            {
              add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
              add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
              add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
              add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
              add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
              add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
              add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
          };

      int[] dist = Solution.bellman_ford(V, edges, S);
      for (int i = 0; i < V; i++) {
        System.out.print(dist[i] + " ");
      }
      System.out.println("");
    }
  }
}
