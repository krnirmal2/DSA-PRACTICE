package StandardProblemDSA.X_GRAPH.IV_SHORETEST_PATH_MOVE_TIME_PATTEN.MULTIPLE_SOURCE_MULTIPLE_DESTINATION;

import StandardProblemDSA.X_GRAPH.GraphUtility;

public class FloydWarshalAlgo {
  // algo  also handle negative edge
  // go via every vertex to every other
  /*
  🧠 Problem:
  Find shortest paths between all pairs of vertices in a weighted graph (handles negative edges, but not negative cycles).

  🔑 Approach: Dynamic Programming
  - `matrix[i][j]` holds shortest distance from i to j.
  - Initially:
      - Replace `-1` with ∞ (no path).
      - Distance from node to itself = 0.
  - Core idea:
      - Try to improve `dist[i][j]` by checking if path through an intermediate vertex `via` is shorter.
      - Formula: dist[i][j] = min(dist[i][j], dist[i][via] + dist[via][j]).

  ⚠️ Important:
  - Handles negative edge weights.
  - Does not detect negative cycles directly (need extra step: if dist[i][i] < 0 → negative cycle).

  ⏱️ Time Complexity: **O(V³)**
  📦 Space Complexity: **O(1)** (in-place).

  🔁 Pattern:
  - Dynamic programming on graphs.
  - Tries all possible paths by relaxing edges via all vertices.

  📌 Related Problems:
  - Transitive closure of a graph.
  - Minimum cost between all cities.
  - Detecting arbitrage opportunities (currencies).
  */

  public void shortest_distance(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == -1) {
          matrix[i][j] = GraphUtility.infiniteValue();
        }
        if (i == j) matrix[i][j] = 0;
      }
    }

    for (int via = 0; via < n; via++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == GraphUtility.infiniteValue()) {
          matrix[i][j] = -1;
        }
      }
    }
  }

  public void main(String[] args) {
    int V = 4;
    int[][] matrix = new int[V][V];

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        matrix[i][j] = -1;
      }
    }

    matrix[0][1] = 2;
    matrix[1][0] = 1;
    matrix[1][2] = 3;
    matrix[3][0] = 3;
    matrix[3][1] = 5;
    matrix[3][2] = 4;

    shortest_distance(matrix);

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
