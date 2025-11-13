package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.III_TWO_D_GRID_PATTERN;

import StandardProblemDSA.Utility;

public class UniquePathsII {
  /*Medium
  You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
  An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
  Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
  The testcases are generated so that the answer will be less than or equal to 2 * 109.

  Example 1:

  Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
  Output: 2
  Explanation: There is one obstacle in the middle of the 3x3 grid above.
  There are two ways to reach the bottom-right corner:
  1. Right -> Right -> Down -> Down
  2. Down -> Down -> Right -> Right
  Example 2:

  Input: obstacleGrid = [[0,1],[0,0]]
  Output: 1

  Constraints:
  	• m == obstacleGrid.length
  	• n == obstacleGrid[i].length
  	• 1 <= m, n <= 100
  obstacleGrid[i][j] is 0 or 1.*/
  private int noOfUniquePathsWithObstacles(int[][] grid, int x, int y) {
    // as we discovered we can either go
    // right or  down
    // and if we able to reach m-1 and n-1 then we will need
    // give the distinct path at the end of the
    // use the
    if (grid.length == 0) return 0;
    int n = Utility.getRowLength(grid);
    int m = Utility.getColumnLength(grid);
    return util(grid, x, y, n, m);
  }

  private int util(int[][] grid, int row, int col, int n, int m) {
    // base case with obstacles we need to return 0 when there is some path
    if (Utility.isBoundaryTouch(row, col, n, m) || grid[row][col] == 1) {
      return 0;
    }
    if (Utility.isReachedLastCornerCell(row, col, n, m)) {
      return 1;
    }
    // hypothesis
    int right = util(grid, row, col + 1, n, m);
    int down = util(grid, row + 1, col, n, m);
    // return
    return right + down + 1;
  }

  public static void main(String args[]) {
    UniquePathsII obj = new UniquePathsII();
    int n = 3;
    int m = 4;
    int x = 0, y = 0;
    int[][] grid = new int[n][m];
    System.out.println(obj.noOfUniquePathsWithObstacles(grid, x, y));
  }

  /*class Solution {
      public int uniquePathsWithObstacles(int[][] obstacleGrid) {
          int n = obstacleGrid.length;
          int m = obstacleGrid[0].length;

          // Memoization table: -1 means not calculated yet
          int[][] dp = new int[n][m];
          for (int[] row : dp)
              Arrays.fill(row, -1);

          return util(obstacleGrid, 0, 0, dp);
      }

      private int util(int[][] grid, int row, int col, int[][] dp) {
          int n = grid.length;
          int m = grid[0].length;

          // Out of bounds or obstacle
          if (row >= n || col >= m || grid[row][col] == 1) return 0;

          // Reached destination
          if (row == n - 1 && col == m - 1) return 1;

          // Already computed
          if (dp[row][col] != -1) return dp[row][col];

          // Explore right and down
          int right = util(grid, row, col + 1, dp);
          int down = util(grid, row + 1, col, dp);

          dp[row][col] = right + down;
          return dp[row][col];
      }
  }
  */
}
