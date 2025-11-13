package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XI_STOCK_PATTERN;

import java.util.Arrays;

public class BASS_FEES_ON_EACH_TRANSACTION {
  /*ou are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
  Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
  Note:
  You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
  The transaction fee is only charged once for each stock purchase and sale.
  Example 1:
  Input: prices = [1,3,2,8,4,9], fee = 2
  Output: 8
  Explanation: The maximum profit can be achieved by:
  - Buying at prices[0] = 1
  - Selling at prices[3] = 8
  - Buying at prices[4] = 4
  - Selling at prices[5] = 9
  The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
  Example 2:

  Input: prices = [1,3,7,5,10,3], fee = 3
  Output: 6
  Constraints:

  1 <= prices.length <= 5 * 104
  1 <= prices[i] < 5 * 104
  0 <= fee < 5 * 104*/

  public int maxProfit(int[] prices, int fee) {

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
    return utility(initialIndex, canBuy, prices.length, prices, dp, fee);
  }

  private int utility(int i, int canBuy, int lengthOfArray, int[] prices, int[][] dp, int fee) {
    // Base case: if we reach beyond the last day, profit is 0
    if (i == lengthOfArray) {
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
      int buy = -prices[i] + utility(i + 1, 1, lengthOfArray, prices, dp, fee);

      // Option 2: Skip buying today → profit stays the same,
      // move to next day still allowed to buy (canBuy = 0).
      int notBuy = utility(i + 1, 0, lengthOfArray, prices, dp, fee);

      // Take max of both choices
      profit = Math.max(buy, notBuy);
    }
    // Case 2: Must SELL (because we have already bought before)
    else {
      // Option 1: Sell stock today → profit increases by prices[i],
      // then move to next day with ability to buy again (canBuy = 0).
      int sell =
          prices[i]
              - fee
              + utility(
                  i + 1,
                  0,
                  lengthOfArray,
                  prices,
                  dp,
                  fee); // note only fee is minus from the transaction

      // Option 2: Skip selling today → profit stays same,
      // move to next day still waiting to sell (canBuy = 1).
      int notSell = utility(i + 1, 1, lengthOfArray, prices, dp, fee);

      // Take max of both choices
      profit = Math.max(sell, notSell);
    }

    // Save result into memo table before returning
    dp[i][canBuy] = profit;
    return profit;
  }
}
