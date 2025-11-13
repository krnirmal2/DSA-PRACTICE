package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS.MULTISOURCE_BFS;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixNearestDistanceOfZeroFromOne {

  /*
    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
    The distance between two cells sharing a common edge is 1.
    Example 1:
    Input: mat = [[0,0,0],
                  [0,1,0],
                  [0,0,0]]
    Output: [[0,0,0],
             [0,1,0],
             [0,0,0]]
    Example 2:
    Input: mat = [[0,0,0],
                  [0,1,0],
                  [1,1,1]]
    Output: [[0,0,0],
             [0,1,0],
             [1,2,1]]
    Constraints:
    m == mat.length
    n == mat[i].length
    1 <= m, n <= 104
    1 <= m * n <= 104
    mat[i][j] is either 0 or 1.
    There is at least one 0 in mat.


  🚀 Approach: Multi-Source BFS (Shortest Path from All Zeros)
  1. Enqueue all positions where mat[i][j] == 0.
  2. Mark all mat[i][j] == 1 as -1 to indicate they are unvisited.
  3. Use BFS:
     - For each dequeued cell, visit its 4 neighbors.
     - If the neighbor is unvisited (-1), update its distance to `current + 1` and enqueue it.

  ⏱️ Time Complexity: O(m × n)
  - Each cell is enqueued and processed once.

  📦 Space Complexity: O(m × n)
  - Queue may store all cells in worst case.

  ✅ LeetCode Problem:
  - 542. 01 Matrix

  🔁 Pattern:
  - Multi-Source BFS
  - Grid traversal with distance propagation

  🧩 Utility Methods Used:
  - `GraphUtility.getFourDirection()` → returns {{-1,0}, {1,0}, {0,-1}, {0,1}}
  - `GraphUtility.setNewX(dir, x)` → returns x + dir[0]
  - `GraphUtility.setNewY(dir, y)` → returns y + dir[1]
  - `GraphUtility.checkFourBoundaryOfMatrix(...)` → checks bounds and if cell is unvisited

  🔍 Optimization Tip:
  - Use `mat[i][j] == -1` as visited flag to avoid separate `visited[][]` array.
  */
  public int[][] updateMatrix(int[][] mat) {
    Queue<int[]> queue = new LinkedList<>();
    int row = mat.length;
    int col = mat[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 0) {
          queue.offer(new int[] {i, j});
        }
        if (mat[i][j] == 1) {
          mat[i][j] = -1;
        }
      }
    }
    // Step 2: Define directions for moving in 4 possible directions (Up, Down, Left, Right)
    int[][] directions = GraphUtility.getFourDirection();
    while (!queue.isEmpty()) {
      // take the element from the queue which contain array of index of x and y
      int[] cell = queue.poll();
      int x = cell[0];
      int y = cell[1];
      for (int[] dir : directions) {
        int newX = GraphUtility.setNewX(dir, x);
        int newY = GraphUtility.setNewY(dir, y);
        // step checking boundaries
        if (GraphUtility.checkFourBoundaryOfMatrix(mat, newX, newY, row, col)) {
          mat[newX][newY] = mat[x][y] + 1; // Update distance
          queue.offer(new int[] {newX, newY}); // Add new cell to queue
        }
      }
    }
    return mat;
  }
}
