package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION.BACKWARD_DP_PATTERN;

import StandardProblemDSA.Utility;

public class DungeonGame {
  public int calculateMinimumHP(int[][] dungeon) {
    int m = Utility.getRowLength(dungeon);
    int n = Utility.getColumnLength(dungeon);
    int[][] dp = Utility.twoDimensionalMemo(m, n);
    return dfs(0, 0, dungeon, m, n, dp);
  }

  private int dfs(int i, int j, int[][] dungeon, int m, int n, int[][] dp) {
    if (i >= m || j >= n) return Integer.MAX_VALUE; // Out of bounds
    if (Utility.isReachedLastCornerCell(i, j, m, n)) { // Base case
      return dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
    }

    // If already computed, return the value
    if (dp[i][j] != -1) return dp[i][j];

    // Recursively calculate the health required for the next cells
    int healthFromNextCell =
        Math.min(dfs(i + 1, j, dungeon, m, n, dp), dfs(i, j + 1, dungeon, m, n, dp));
    dp[i][j] = Math.max(1, healthFromNextCell - dungeon[i][j]);
    return dp[i][j];
  }
}
