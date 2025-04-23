package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.III_TWO_D_GRID_PATTERN;

public class UniquePaths {
  /*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
  Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
  The test cases are generated so that the answer will be less than or equal to 2 * 109.
   */

  private int noOfUniquePaths(int[][] grid, int x, int y) {
    // as we discovered we can either go
    // right or  down
    // and if we able to reach m-1 and n-1 then we will need
    // give the distinct path at the end of the
    // use the
    int n = grid.length;
    int m = grid[0].length;
    return util(grid, x, y, n, m);
  }

  private int util(int[][] grid, int row, int col, int n, int m) {
    // base case
    if (row == n - 1 && col == m - 1) {
      return 1;
    }
    if (row >= n || col >= m) {
      return 0;
    }

    // hypothesis
    int right = util(grid, row, col + 1, n, m);
    int down = util(grid, row + 1, col, n, m);
    // return
    return right + down + 1;
  }

  public static void main(String args[]) {
    UniquePaths obj = new UniquePaths();
    int n = 3;
    int m = 4;
    int x = 0, y = 0;
    int[][] grid = new int[n][m];
    System.out.println(obj.noOfUniquePaths(grid, x, y));
  }
}
