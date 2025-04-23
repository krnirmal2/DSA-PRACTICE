package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION.BACKWARD_DP_PATTERN;

import java.util.Arrays;

public class DungeonGame {
  class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
      int m = dungeon.length;
      int n = dungeon[0].length;
      int[][] dp = new int[m][n]; // Memoization table
      for (int[] row : dp) {
        Arrays.fill(row, -1); // Initialize dp table with -1
      }
      return dfs(0, 0, dungeon, m, n, dp);
    }

    private int dfs(int i, int j, int[][] dungeon, int m, int n, int[][] dp) {
      if (i >= m || j >= n) return Integer.MAX_VALUE; // Out of bounds
      if (i == m - 1 && j == n - 1) { // Base case
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
}
