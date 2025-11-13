package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS;

import StandardProblemDSA.X_GRAPH.GraphUtility;

public class MaxIsland {
  /*
  🧠 Problem:
  Given a 2D grid (0 = water, 1 = land), find the area of the largest island.
  An island is formed by connected 1s (4-directionally connected).

  🚀 Approach: DFS
  1. Traverse the entire grid.
  2. When an unvisited land cell (`1`) is found, start DFS to explore the full island.
  3. Count all connected cells recursively and mark them visited.
  4. Keep track of the maximum area across all islands.

  🔁 Pattern:
  - Classic "connected components" problem.
  - DFS/BFS flood-fill pattern.

  ⏱️ Time Complexity: O(m × n)
  - Each cell is visited at most once.

  📦 Space Complexity: O(m × n)
  - For the `visited[][]` array and recursion stack.

  ⚠️ Edge Cases:
  - All water grid (max area = 0).
  - Entire grid is land (max area = m × n).
  - Multiple small islands.

  ✅ Related Problems:
  - 695. Max Area of Island (LeetCode)
  - 200. Number of Islands
  - 733. Flood Fill
  */

  // Main function to test the solution
  public static void main(String[] args) {
    MaxIsland solution = new MaxIsland();

    // Example grid
    int[][] grid = {
      {0, 0, 1, 0, 0},
      {1, 1, 1, 0, 0},
      {0, 1, 0, 1, 1},
      {0, 0, 0, 1, 0}
    };

    // Call the maxAreaOfIsland function and print the result
    System.out.println("Max area of an island: " + solution.maxAreaOfIsland(grid));
  }

  public int maxAreaOfIsland(int[][] grid) {
    // Find the size of the grid
    int row = grid.length;
    int column = grid[0].length;
    boolean[][] visited = new boolean[row][column];
    int max = 0; // Initialize max area as 0

    // Iterate over each cell in the grid
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        // If the cell is land and not visited, explore the island
        if (grid[r][c] == 1 && !visited[r][c]) {
          int area = dfs(grid, visited, r, c); // Find the area of this island
          max = Math.max(max, area); // Update the max area
        }
      }
    }
    return max;
  }

  public int dfs(int[][] grid, boolean[][] visited, int r, int c) {
    int[] dr = {-1, 1, 0, 0}; // Row movement
    int[] dc = {0, 0, -1, 1}; // Column movement
    int area = 1; // Initialize the current area as 1 (current cell)

    visited[r][c] = true;

    // Explore all four directions
    for (int d = 0; d < 4; d++) {
      int nr = r + dr[d];
      int nc = c + dc[d];
      // Check bounds and if the neighbor is land and not visited
      if (GraphUtility.checkFourBoundaryOfMatrixWithOne(grid, nr, nc) && !visited[nr][nc]) {
        area += dfs(grid, visited, nr, nc); // Recur for the neighbor and accumulate area
      }
    }
    return area;
  }
}
