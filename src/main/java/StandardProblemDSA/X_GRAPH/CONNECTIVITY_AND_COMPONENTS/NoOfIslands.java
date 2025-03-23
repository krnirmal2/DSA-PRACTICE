package StandardProblemDSA.X_GRAPH.CONNECTIVITY_AND_COMPONENTS;

public class NoOfIslands {
  /*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
  Example 1:
  Input: grid = [
          ["1","1","1","1","0"],
          ["1","1","0","1","0"],
          ["1","1","0","0","0"],
          ["0","0","0","0","0"]
          ]*/
  public static int numIslands(char[][] grid) {
    // Find the size of the grid
    int row = grid.length;
    int column = grid[0].length;
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
    int[] dc = {0, 0, -1, 1}; // column movement

    // Explore all four directions
    for (int d = 0; d < 4; d++) {
      int nr = r + dr[d];
      int nc = c + dc[d];

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
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };

    // Call the numIslands function and print the result
    int numberOfIslands = numIslands(grid);
    System.out.println("Number of islands: " + numberOfIslands);
  }
}
