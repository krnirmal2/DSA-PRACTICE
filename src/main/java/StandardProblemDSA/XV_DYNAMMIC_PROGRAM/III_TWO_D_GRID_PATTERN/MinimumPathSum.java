package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.III_TWO_D_GRID_PATTERN;

import StandardProblemDSA.Utility;

public class MinimumPathSum {
  public int minimupathSum(int[][] grid, int intialX, int initialY, int rowSize, int colSize) {
    // base case
    if (grid.length == 0) {
      return 0;
    }
    // proceed further
    return util(grid, intialX, initialY, rowSize, colSize);

    //        if  we want to proceed further with memorisation
    //        int [][] memo = new int[rowSize][colSize];
    //        Arrays.fill(memo, -1);
    // then pass it to the method and
    // checkk if value is doesn't equal to default value
    // then return that value other wise set this i and jth value with
    // recent calculation and then return memeo

  }

  private int util(int[][] grid, int x, int y, int row, int col) {
    // so now i have to minimise the sum at the differenct path
    // i can travel through
    // down and right
    // we have take the current some with the next right or bottom sum which
    // ever minimum

    if (Utility.isReachedLastCornerCell(x, y, row, col)) {
      return grid[x][y];
    }
    // we have to check the boundary
    if (Utility.isBoundaryTouch(x, y, row, col)) {
      return 0;
    }
    int i = grid[x][y] + Math.min(util(grid, x, y + 1, row, col), util(grid, x + 1, y, row, col));
    return i;
  }

  /*MEMOSAITON

  *   public int minPathSum(int[][] grid) {
          int m = grid.length;
          int n = grid[0].length;
          int[][] memo = new int[m][n]; // Memoization array
          for (int[] row : memo) {
              Arrays.fill(row, -1); // Fill memo with -1 to indicate unvisited cells
          }
          return minpath(0, 0, grid, m, n, memo);
      }

      public int minpath(int i, int j, int[][] grid, int m, int n, int[][] memo) {
          // Base case: bottom-right cell
          if (i == m - 1 && j == n - 1) {
              return grid[i][j];
          }

          // Out-of-bounds
          if (i >= m || j >= n) {
              return Integer.MAX_VALUE;
          }

          // Check memo
          if (memo[i][j] != -1) {
              return memo[i][j];
          }

          // Recursively calculate and store in memo
          memo[i][j] = grid[i][j] + Math.min(minpath(i + 1, j, grid, m, n, memo),
                                             minpath(i, j + 1, grid, m, n, memo));
          return memo[i][j];
      }*/

}
