package StandardProblemDSA.X_GRAPH.CONNECTIVITY_AND_COMPONENTS.STRIVER;

import java.util.*;

public class NumberOfEnclavesMultiSourceBFS {
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

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      for (int[] dir : directions) {
        int newRow = cell[0] + dir[0];
        int newCol = cell[1] + dir[1];

        if (newRow >= 0
            && newCol >= 0
            && newRow < grid.length
            && newCol < grid[0].length
            && grid[newRow][newCol] == 1) {
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
