package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.UNBOUND_KNAPSACK;

import java.util.Arrays;

/*322. Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
        • 1 <= coins.length <= 12
        • 1 <= coins[i] <= 231 - 1
        0 <= amount <= 104

 Pattern:
- **Unbounded Knapsack** DP (minimization problem).
- State: `dp[i]` = minimum number of coins required to make amount `i`.
- Transition:
      dp[i] = min(dp[i - coin] + 1) for each coin where i - coin >= 0
- Base case: dp[0] = 0.

Approaches:
1. **Recursion (brute force):** Try all coins; explore all possibilities.
   Time Complexity: O(n^amount), Space: O(amount) due to recursion depth.
2. **Top-down DP (Memoization):** Cache results for subproblems `(amount)` to avoid recomputation.
3. **Bottom-up DP (Tabulation):** Iteratively build dp[0...amount].
4. **Edge cases:**
   - amount = 0 → return 0
   - if coins cannot sum to amount → return -1

Similar / Follow-up Problems:
- LC 518: Coin Change II (count combinations, not min coins)
- LC 279: Perfect Squares (minimum perfect squares summing to n)
- LC 139: Word Break (similar DP state filling)
- LC 377: Combination Sum IV (count ordered combinations)       */
public class CoinChange {
  class Solution {
    public int coinChange(int[] coins, int amount) {
      // so this is unbound knapsack which allows no. of time of input
      // implies it has n choice of target achievement
      // recursion tree will n to the power amount
      int result = helper(coins, amount);
      return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int helper(int[] coins, int amount) {
      // base case for return
      if (amount == 0) return 0; // as we got the result
      if (amount < 0) return Integer.MAX_VALUE;
      // mincoins
      int minCoins = Integer.MAX_VALUE;
      // iterate over each element and find the solution
      for (int coin : coins) {
        int result = helper(coins, amount - coin);
        if (result != Integer.MAX_VALUE) {
          minCoins = Math.min(minCoins, 1 + result);
        }
      }
      return minCoins;
    }
    /*vAt each recursive call, you try all n coins.

    You make recursive calls decreasing amount by up to coin[i], and it can go up to amount levels deep.

    So, in the worst case:

    T(amount) = n recursive calls per level × amount levels deep

    ➤ Time Complexity = O(n^amount)*/
  }

  public int coinChange(int[] coins, int amount) {
    // Step 1: Create a memoization array initialized to -1
    int[] memo = new int[amount + 1];
    Arrays.fill(memo, -1);
    // Step 2: Compute the result using the helper function
    int result = helper(coins, amount, memo);
    // Step 3: If result is Integer.MAX_VALUE, return -1 (not possible)
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private int helper(int[] coins, int amount, int[] memo) {
    // Base Case 1: If amount == 0, no coins are needed
    if (amount == 0) return 0;
    // Base Case 2: If amount < 0, it's not possible to make up the amount
    if (amount < 0) return Integer.MAX_VALUE;
    // If the result for this amount is already computed, return it
    if (memo[amount] != -1) return memo[amount];
    int minCoins = Integer.MAX_VALUE;
    // Try each coin and compute the minimum coins required
    for (int coin : coins) {
      int result = helper(coins, amount - coin, memo);
      if (result != Integer.MAX_VALUE) {
        minCoins = Math.min(minCoins, 1 + result);
      }
    }
    // Store the computed result in the memo array
    memo[amount] = minCoins;
    return memo[amount];
  }
  /*To bring it down to polynomial time, you must use memoization (Top-Down DP) or tabulation (Bottom-Up DP).
  With DP:
  Time Complexity becomes: O(n * amount)
  Space Complexity becomes: O(amount) (or O(n * amount) with 2D DP)*/
}
