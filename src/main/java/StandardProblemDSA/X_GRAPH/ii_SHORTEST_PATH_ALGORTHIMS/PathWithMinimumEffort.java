package StandardProblemDSA.X_GRAPH.ii_SHORTEST_PATH_ALGORTHIMS;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import StandardProblemDSA.X_GRAPH.Tuple;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {
  /*u are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col]
    represents the height of the cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1)
     (i.e.,0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

    A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
    Examples:
    Example 1:
    Input:
    heights = [[1,2,2],[3,8,2],[5,3,5]]
    Output:
    2
    Explanation:

    The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.This is better than the route of [1,2,2,2,5],
    where the maximum absolute difference is 3.

    Example 2:
    Input:
    heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
    Output:
    0
    Explanation:
    The route of [1,1,1,1,1,1,1,1,1,1,1,1,1,1] has a maximum absolute difference of 0 in consecutive cells.
    This is better than the route of [1,1,1,1,1,1,2,1], where the maximum absolute difference is 1.
    Solution

    🔑 Approach: Modified Dijkstra’s Algorithm
  - Treat each cell as a node in a graph.
  - The "cost" to move from one cell to another is the absolute height difference.
            - We want to minimize the *maximum* difference along the path, not the sum.
            - Use a priority queue to always expand the path with the smallest current "effort".
            - Maintain `dist[][]`, where dist[r][c] = minimum effort required to reach (r, c).
            - For each neighbor, the effort is: `max(current effort, |height difference|)`.

    Steps:
            1. Initialize `dist[][]` with ∞, and set dist[0][0] = 0.
            2. Use a min‑heap (priority queue) storing {effort, row, col}.
            3. Extract the cell with the smallest effort.
  4. For each valid 4‑direction neighbor:
            - Calculate newEffort = max(currentEffort, abs(height difference)).
            - If newEffort < dist[newRow][newCol], update and push to heap.
  5. Stop when we pop the destination cell; return its effort.

            ⏱️ Time Complexity:
            - O(n * m * log(n * m)) — each cell pushed to PQ at most once with better effort.

  📦 Space Complexity:
            - O(n * m) for `dist[][]` and PQ.

            ⚠️ Edge Cases:
            - Single cell grid → effort = 0.
            - Flat grid → effort = 0.
            - Steep grid where one big jump dominates.

  🔁 Pattern:
            - Grid graph shortest path (Dijkstra) but minimizing "maximum edge weight".

            ✅ Related Problems:
            - Minimum Path Cost with Constraints
  - Swim in Rising Water
  - Path with Minimum Maximum Value*/

  int MinimumEffort(int[][] heights) {

    // Create a priority queue containing pairs of cells
    // and their respective distance from the source cell in the
    // form {diff, {row of cell, col of cell}}.
    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);

    int n = heights.length;
    int m = heights[0].length;
    // Create a distance matrix with initially all the cells marked as
    int[][] dist = GraphUtility.initaliseMatrixWithLargeValue(n, m);

    dist[0][0] = 0;
    pq.add(new Tuple(0, 0, 0));

    // The following delta rows and delts columns array are created such that
    // each index represents each adjacent node that a cell may have
    // in a direction.
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    // Iterate through the matrix by popping the elements out of the queue
    // and pushing whenever a shorter distance to a cell is found.
    while (pq.size() != 0) {
      Tuple it = pq.peek();
      pq.remove();
      int diff = it.distance;
      int row = it.row;
      int col = it.col;

      // Check if we have reached the destination cell,
      // return the current value of difference (which will be min).
      if (row == n - 1 && col == m - 1) return diff;
      // row - 1, col
      // row, col + 1
      // row - 1, col
      // row, col - 1
      for (int i = 0; i < 4; i++) {
        int newr = row + dr[i];
        int newc = col + dc[i];

        // Checking validity of the cell.
        if (GraphUtility.onlyFourSideCheck(newr, newc, n, m)) {

          // Effort can be calculated as the max value of differences
          // between the heights of the node and its adjacent nodes.
          int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);

          // If the calculated effort is less than the prev value
          // we update as we need the min effort.
          if (newEffort < dist[newr][newc]) {
            dist[newr][newc] = newEffort;
            pq.add(new Tuple(newEffort, newr, newc));
          }
        }
      }
    }
    // If the destination is unreachable.
    return 0;
  }

  public void main(String[] args) {
    int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    int ans = MinimumEffort(heights);
    System.out.print(ans);
    System.out.println();
  }
}
