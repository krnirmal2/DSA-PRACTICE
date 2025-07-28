package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.III_TWO_D_GRID_PATTERN;

import StandardProblemDSA.Utility;

public class UniquePaths {
  /*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
    Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    The test cases are generated so that the answer will be less than or equal to 2 * 109.
  /*
  62. Unique Paths
  ----------------
  Problem Statement:
  A robot is located at the top-left corner of an m x n grid.
  It can move only **right** or **down** at any step.
  Find the total number of unique paths to reach the bottom-right cell `(m-1, n-1)`.

  Pattern:
  - Grid-based DP (classic combinatorial path counting).
  - State: dp[row][col] = number of paths to reach (row, col).
  - Transition:
        dp[row][col] = dp[row-1][col] + dp[row][col-1]
  - Base case: First row and first column cells have exactly 1 way.

  Approach:
  1. **Recursion:** Explore all paths (right and down).
  2. **Memoization:** Cache results to avoid recomputation.
  3. **Tabulation:** Build bottom-up DP table.
  4. **Combinatorial math:** Paths = C(m+n-2, m-1) (choose positions for downs).
  5. Time Complexity: O(m × n), Space: O(m × n); can optimize to O(n).

  Similar / Follow-up Problems:
  - LC 63: Unique Paths II (grid with obstacles, blocked cells)
  - LC 64: Minimum Path Sum (minimize cost instead of counting paths)
  - LC 120: Triangle Minimum Path Sum (triangle structure, minimize path)
  - LC 931: Minimum Falling Path Sum (matrix, minimize with diagonal moves)   */

  private int noOfUniquePaths(int[][] grid, int x, int y) {
    // as we discovered we can either go
    // right or  down
    // and if we able to reach m-1 and n-1 then we will need
    // give the distinct path at the end of the
    // use the
    int n = Utility.getRowLength(grid);
    int m = Utility.getColumnLength(grid);
    return util(grid, x, y, n, m);
  }

  private int util(int[][] grid, int row, int col, int n, int m) {
    // base case
    if (Utility.isReachedLastCornerCell(row, col, n, m)) {
      return 1;
    }
    if (Utility.isBoundaryTouch(row, col, n, m)) {
      return 0;
    }

    // hypothesis
    int right = util(grid, row, col + 1, n, m);
    int down = util(grid, row + 1, col, n, m);
    // return
    return right + down + 1;
  }

  public static void main(String[] args) {
    UniquePaths obj = new UniquePaths();
    int n = 3;
    int m = 4;
    int x = 0, y = 0;
    int[][] grid = new int[n][m];
    System.out.println(obj.noOfUniquePaths(grid, x, y));
  }
}
/*
as it taking memo which square of n as 2D space

space = squere n;
time co = as it iterate over each cel so no. of cell square of n






public int uniquepath(int m, int n){
  // check the base case
  int[][] dp = new int [m][n];
  for(int[] row :dp){
    Arrays.fill(row, -1);

  }
  ///  pass the intitail path of the robot

}
private int countPaths(int i,int j, int row, int col, int[][] memo){
  if(i==m -1 && j==n-1) meansreached to the last column
  {
    return 1;
  }
  // also check out of boud
  if(i>=m && j>>=n){
    return 0;
  }
  fi(dp[i][j] !=-1)return dp[i][j] ;

  // recursiv e
  dp[i][j] = countPaths(i, j+1,m,n,dp) + countPaths(i+1,j, m,n, dp);
  return dp[i][j] ; // last value of the dp[i][j]
}
*/
