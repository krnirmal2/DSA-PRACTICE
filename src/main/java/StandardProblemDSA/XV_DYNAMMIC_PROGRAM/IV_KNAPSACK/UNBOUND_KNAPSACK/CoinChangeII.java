package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.UNBOUND_KNAPSACK;

import java.util.Arrays;

public class CoinChangeII {
  public int change(int amount, int[] coins) {
    int[][] memo = new int[coins.length][amount + 1];
    for (int[] row : memo) {
      Arrays.fill(row, -1); // Initialize memo table with -1
    }
    return countWays(coins, coins.length - 1, amount, memo);
  }

  private int countWays(int[] coins, int index, int amount, int[][] memo) {
    // Base cases
    if (amount == 0) return 1; // There's one way to make amount 0: use no coins
    if (index < 0 || amount < 0) return 0; // No solution possible
    // Check memoization table
    if (memo[index][amount] != -1) return memo[index][amount];
    // Option 1: Include the current coin
    int include = countWays(coins, index, amount - coins[index], memo);
    // Option 2: Exclude the current coin
    int exclude = countWays(coins, index - 1, amount, memo);
    // Store the result and return
    memo[index][amount] = include + exclude;
    return memo[index][amount];
  }
}
