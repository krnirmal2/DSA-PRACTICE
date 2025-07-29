package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS.MULTISOURCE_BFS;

import StandardProblemDSA.X_GRAPH.GraphUtility;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclavesMultiSourceBFS {
  /*
  🧠 Problem:
  Count land cells (`1`s) in a grid that cannot reach the boundary.
  - Any land connected to the boundary (directly or indirectly) is not enclosed.

  🔍 Approach: Multi-Source BFS
  1. **Eliminate all boundary-connected land**:
     - Traverse first & last rows and columns.
     - For each `1`, run BFS to mark all connected land as water (`0`).
  2. **Count remaining land cells**:
     - After BFS, any `1` is enclosed and part of the answer.

  ⏱️ Time Complexity:
  - O(m × n): Each cell is visited at most once.

  📦 Space Complexity:
  - O(m × n): Queue can hold all land cells in the worst case.

  📘 Similar LeetCode Problem:
  - 1020. Number of Enclaves

  🔁 Pattern:
  - Multi-Source BFS / DFS.
  - Boundary marking + counting enclosed components.

  🔄 Follow-up:
  - Solve with DFS for recursive style.
  - Optimize space by reusing `grid` without extra `visited` array.
  */

  public int numEnclaves(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();

    // Step 1: Remove all boundary-connected land using BFS
    for (int i = 0; i < rows; i++) {
      if (grid[i][0] == 1) {
        bfs(grid, i, 0);
      }
      if (grid[i][cols - 1] == 1) {
        bfs(grid, i, cols - 1);
      }
    }

    for (int j = 0; j < cols; j++) {
      if (grid[0][j] == 1) {
        bfs(grid, 0, j);
      }
      if (grid[rows - 1][j] == 1) {
        bfs(grid, rows - 1, j);
      }
    }

    // Step 2: Count remaining enclosed land
    int count = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          count++;
        }
      }
    }

    return count;
  }

  private void bfs(int[][] grid, int row, int col) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {row, col});
    grid[row][col] = 0; // Mark as visited by converting to water

    int[][] directions = GraphUtility.getFourDirection();
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      for (int[] dir : directions) {
        int newRow = cell[0] + dir[0];
        int newCol = cell[1] + dir[1];

        if (GraphUtility.checkFourBoundaryOfMatrixWithOne(grid, newRow, newCol)) {
          queue.offer(new int[] {newRow, newCol});
          grid[newRow][newCol] = 0; // Mark as visited
        }
      }
    }
  }

  // Main Method to Test
  public static void main(String[] args) {
    NumberOfEnclavesMultiSourceBFS sol = new NumberOfEnclavesMultiSourceBFS();
    int[][] grid = {
      {0, 0, 0, 0},
      {1, 0, 1, 0},
      {0, 1, 1, 0},
      {0, 0, 0, 0}
    };
    System.out.println(sol.numEnclaves(grid)); // Output: 3
  }
}
