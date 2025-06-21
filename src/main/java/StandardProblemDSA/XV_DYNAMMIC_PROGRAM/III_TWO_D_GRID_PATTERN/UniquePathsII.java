package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.III_TWO_D_GRID_PATTERN;

import StandardProblemDSA.Utility;

public class UniquePathsII {
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
    if (Utility.isReachedLastCornerCell(row, col, n, m) && grid[row][col] == 1) {
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

  public static void main(String args[]) {
    UniquePathsII obj = new UniquePathsII();
    int n = 3;
    int m = 4;
    int x = 0, y = 0;
    int[][] grid = new int[n][m];
    System.out.println(obj.noOfUniquePathsWithObstacles(grid, x, y));
  }
}
