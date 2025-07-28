package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.UNBOUND_KNAPSACK;

import java.util.Arrays;

public class CoinChangeII {
  /*
  518. Coin Change II
  -------------------
  Problem Statement:
  You are given `amount` and an array `coins[]` representing coin denominations.
  Return the number of combinations that make up that amount.
  You have unlimited supply of each coin and order of coins doesn’t matter.

  Pattern:
  - **Unbounded Knapsack** DP (counting combinations).
  - State: dp[i][j] = number of ways to make amount `j` using first `i` coins.
  - Transition:
        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        (exclude + include current coin)
  - Base case:
        dp[i][0] = 1 for all i (1 way to make amount 0: use no coins).

  Approaches:
  1. **Recursion (brute force):** Try including and excluding each coin.
     Time Complexity: O(2^n), exponential.
  2. **Top-down DP (Memoization):** Cache `(index, amount)` to avoid recomputation.
  3. **Bottom-up DP (Tabulation):** Iteratively fill dp table; 1D array optimization possible.
  4. **Edge cases:**
     - amount = 0 → always 1 way (no coins).
     - coins empty and amount > 0 → return 0.

  Similar / Follow-up Problems:
  - LC 322: Coin Change (minimum number of coins).
  - LC 377: Combination Sum IV (order matters; count ordered combinations).
  - LC 494: Target Sum (subset sum count variation).
  */

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
