package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XI_STOCK_PATTERN;

import java.util.Arrays;

public class BASS_COOLDOWN_ONE_DAY {
  /*ou are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
  Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
  Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
  Example 1:

  Input: k = 2, prices = [2,4,1]
  Output: 2
  Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
  Example 2:

  Input: k = 2, prices = [3,2,6,5,0,3]
  Output: 7
  Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
  Constraints:
  1 <= k <= 100
  1 <= prices.length <= 1000
  0 <= prices[i] <= 1000*/

  public int maxProfit(int[] prices) {
    // We want to maximize profit by buying and selling stocks any number of times.
    // This time, we add MEMOIZATION to optimize the recursion.
    // Idea: Use a 2D DP array where:
    //   dp[i][canBuy] = maximum profit starting from day i,
    //                   given canBuy (0 = we can buy, 1 = we must sell).

    int canBuy = 0; // initially we are allowed to buy
    int initialIndex = 0;

    // Create DP array (n x 2), initialized with -1 (uncomputed states).
    int[][] dp = new int[prices.length][2];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    // Start recursion with memoization
    return utility(initialIndex, canBuy, prices.length, prices, dp);
  }

  private int utility(int i, int canBuy, int lengthOfArray, int[] prices, int[][] dp) {
    // Base case: if we reach beyond the last day, profit is 0
    if (i >= lengthOfArray) {
      return 0;
    }

    // If already computed, just return cached value
    if (dp[i][canBuy] != -1) {
      return dp[i][canBuy];
    }

    int profit;

    // Case 1: Allowed to BUY
    if (canBuy == 0) {
      // Option 1: Buy stock today → profit decreases by prices[i],
      // then move to next day where we must sell (canBuy = 1).
      int buy = -prices[i] + utility(i + 1, 1, lengthOfArray, prices, dp);

      // Option 2: Skip buying today → profit stays the same,
      // move to next day still allowed to buy (canBuy = 0).
      int notBuy = utility(i + 1, 0, lengthOfArray, prices, dp);

      // Take max of both choices
      profit = Math.max(buy, notBuy);
    }
    // Case 2: Must SELL (because we have already bought before)
    else {
      // Option 1: Sell stock today → profit increases by prices[i],
      // then move to next day with ability to buy again (canBuy = 0).
      int sell =
          prices[i]
              + utility(
                  i + 2,
                  0,
                  lengthOfArray,
                  prices,
                  dp); // NOTE : WHEN SELL IS DONE GIVE ONE DAY EXTRA FOR COOLDOWNL

      // Option 2: Skip selling today → profit stays same,
      // move to next day still waiting to sell (canBuy = 1).
      int notSell = utility(i + 1, 1, lengthOfArray, prices, dp);

      // Take max of both choices
      profit = Math.max(sell, notSell);
    }

    // Save result into memo table before returning
    dp[i][canBuy] = profit;
    return profit;
  }
}
