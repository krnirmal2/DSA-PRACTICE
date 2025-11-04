package StandardProblemDSA.X_GRAPH.ii_SHORTEST_PATH_ALGORTHIMS;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import StandardProblemDSA.X_GRAPH.Tuple;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMazeWithFromSourceToDest {
  /* Problem Statement:
    Given an n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.
    If the path is not possible between the source cell and the destination cell, then return -1.
    Note: You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of four directions, Up, Down, Left, and Right.
            Examples:
    Example 1:
    Input:
    grid[][] =
       {{1, 1, 1, 1},
        {1, 1, 0, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 0},
        {1, 0, 0, 1}}
    source = {0, 1}
    destination = {2, 2}
    Output:
            3
    Explanation:

            1 1 1 1
            1 1 0 1
            1 1 1 1
            1 1 0 0
            1 0 0 1
    The highlighted part in the above matrix denotes the shortest path from source to destination cell.

    Example 2:

    Input:
    grid[][] = {{1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0},
        {1, 0, 1, 0, 1}}
    source = {0, 0}
    destination = {3, 4}
    Output:
            -1
    Explanation:
    Since, there is no path possible between the source cell and the destination cell, hence we return -1.
    Solution

    🔑 Approach: BFS (Breadth-First Search)
  - We need the shortest number of steps, and BFS guarantees shortest path in an unweighted grid.
  - We'll maintain a `dist[][]` matrix to track the shortest distance to each cell.
  - Start BFS from `source`, push (distance = 0, row, col) to queue.
  - For each cell, check its 4 neighbors:
    - If the neighbor cell has value 1 and new distance < old distance:
      - Update distance and push it to queue.
    - If the neighbor is the `destination`, return `distance + 1` immediately.
  - If BFS ends and destination not reached → return -1.

  ⚡ Optimization:
  - We don't need a `visited[][]`; using `dist[][]` initialized to large values works the same.
  - Early exit when destination is reached improves performance.

  ⏱️ Time Complexity:
  - O(n * m) because each cell is visited at most once.

  📦 Space Complexity:
  - O(n * m) for `dist[][]` and BFS queue.

  ⚠️ Edge Cases:
  - `source == destination` → return 0.
  - No path exists due to walls (0s).
  - Grid has only one cell.

  🔁 Pattern:
  - Multi-source BFS and shortest path in unweighted grid.

  📌 Related Problems:
  - Zero-One Matrix (distance to nearest 0)
  - Rotten Oranges (time for infection)
  - Minimum Effort Path (Dijkstra’s variant)
  - Word Ladder (shortest transformation path)*/
  int shortestPath(int[][] grid, int[] source, int[] destination) {

    // Edge Case: if the source is only the destination.
    if (source[0] == destination[0] && source[1] == destination[1]) return 0;

    // Create a queue for storing cells with their distances from source
    // in the form {dist,{cell coordinates pair}}.
    Queue<Tuple> q = new LinkedList<>();
    int n = grid.length;
    int m = grid[0].length;

    // Create a distance matrix with initially all the cells marked as
    // unvisited and the source cell as 0.
    int[][] dist = GraphUtility.initaliseMatrixWithLargeValue(n, m);
    dist[source[0]][source[1]] = 0;
    q.add(new Tuple(0, source[0], source[1]));

    // The following delta rows and delts columns array are created such that
    // each index represents each adjacent node that a cell may have
    // in a direction.
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    // Iterate through the maze by popping the elements out of the queue
    // and pushing whenever a shorter distance to a cell is found.
    while (!q.isEmpty()) {
      Tuple it = q.peek();
      q.remove();
      int dis = it.distance;
      int r = it.row;
      int c = it.col;

      // Through this loop, we check the 4 direction adjacent nodes
      // for a shorter path to destination.
      for (int i = 0; i < 4; i++) {
        int newr = r + dr[i];
        int newc = c + dc[i];

        // Checking the validity of the cell and updating if dist is shorter.
        if (GraphUtility.checkFourBoundaryOfMatrixWithOne(grid, newr, newc)
            && dis + 1 < dist[newr][newc]) {
          dist[newr][newc] = 1 + dis;

          // Return the distance until the point when
          // we encounter the destination cell.
          if (newr == destination[0] && newc == destination[1]) return dis + 1;
          q.add(new Tuple(1 + dis, newr, newc));
        }
      }
    }
    // If no path is found from source to destination.
    return -1;
  }
}
