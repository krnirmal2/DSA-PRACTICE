package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION.BACKWARD_DP_PATTERN;

import StandardProblemDSA.Utility;

public class DungeonGame {
  /*
  Problem:
  174. Dungeon Game — Given a grid dungeon[i][j] with positive (healing) and negative (damage) values,
  find the minimum initial health required so that the knight reaches the bottom-right cell alive.

  Pattern:
  - Dynamic Programming (DP) – bottom-up or top-down with memoization.
  - Key idea: Minimum health at each cell = max(1, min(health needed from right, down) - dungeon[i][j]).

  LeetCode Similar:
  - LC 64 (Minimum Path Sum)
  - LC 120 (Triangle)
  - LC 2218 (Maximum Value of K Coins from Piles)

  Follow-ups:
  - Can we do O(n) space using rolling arrays?
  - What if diagonal moves are allowed?

  Time Complexity:
  - O(m × n) time, O(m × n) space.
  */

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
