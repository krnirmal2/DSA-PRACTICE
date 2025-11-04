package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS;

public class NoOfIslands {
  /*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of
     the grid are all surrounded by water.
    Example 1:
    Input: grid = [
            ["1","1","1","1","0"],
            ["1","1","0","1","0"],
            ["1","1","0","0","0"],
            ["0","0","0","0","0"]
            ]

    🚀 Approach: DFS Flood Fill
  1. Traverse each cell in the grid.
  2. When an unvisited land cell ('1') is found, increment the island count.
  3. Perform DFS to mark all connected '1's as visited.
  4. Repeat until the entire grid is explored.

  🔁 Pattern:
  - Connected components in a grid (DFS/BFS flood-fill).

  ⏱️ Time Complexity: O(m × n)
  - Each cell is visited at most once.

  📦 Space Complexity: O(m × n)
  - For the `visited[][]` array and recursion stack.

  ⚠️ Edge Cases:
  - Empty grid (0 islands).
  - All water grid (0 islands).
  - Entire grid is land (1 island).

  ✅ Related Problems:
  - 200. Number of Islands (LeetCode)
  - 695. Max Area of Island
  - 733. Flood Fill
  Surrounded Regions
    Medium
    Walls and Gates
    Medium
    Number of Islands II
    Hard
    Number of Connected Components in an Undirected Graph
    Medium
    Battleships in a Board
    Medium
    Number of Distinct Islands
    Medium
    Max Area of Island
    Medium
    Count Sub Islands
    Medium
    Find All Groups of Farmland
    Medium
    Count Unreachable Pairs of Nodes in an Undirected Graph
    Medium
    Maximum Number of Fish in a Grid
    Medium
    Count Islands With Total Value Divisible by K
    Medium

  */

  public static int numIslands(char[][] grid) {
    // Find the size of the grid
    int row = grid.length; // calculate the row size
    int column = grid[0].length; // calculate the column size
    boolean[][] visited = new boolean[row][column];
    int count = 0;

    // Iterate over each cell in the grid
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        // If the cell is land and not visited, it's a new island
        if (grid[r][c] == '1' && !visited[r][c]) {
          count++;
          visited[r][c] = true;
          dfs(grid, visited, r, c); // explore the island
        }
      }
    }

    return count;
  }

  public static void dfs(char[][] grid, boolean[][] visited, int r, int c) {
    int[] dr = {-1, 1, 0, 0}; // row movement
    int[] dc = {0, 0, 1, -1}; // column movement

    // Explore all four directions
    for (int d = 0; d < 4; d++) { // check all the four direction
      int nr = r + dr[d]; // the new row caluclation using old row and add direction to it
      int nc = c + dc[d]; // the for loop gives the index of the direction and add the value at
      // that index and create new row and column

      // Check bounds and if the neighbor is land and not visited
      if (nr >= 0
          && nr < grid.length
          && nc >= 0
          && nc < grid[0].length
          && grid[nr][nc] == '1'
          && !visited[nr][nc]) {
        visited[nr][nc] = true;
        dfs(grid, visited, nr, nc); // recurse
      }
    }
  }

  // Main function to test the solution
  public static void main(String[] args) {
    NoOfIslands solution = new NoOfIslands();

    // Example grid
    char[][] grid = {
      /*  {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}*/
      {'1', '1', '1', '1', '0'},
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '0', '0'}
    };

    // Call the numIslands function and print the result
    int numberOfIslands = numIslands(grid);
    System.out.println("Number of islands: " + numberOfIslands);
  }
}
