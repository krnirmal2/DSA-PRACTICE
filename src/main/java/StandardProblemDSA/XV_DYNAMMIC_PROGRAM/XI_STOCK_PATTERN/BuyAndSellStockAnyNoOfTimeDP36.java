package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XI_STOCK_PATTERN;

import java.util.Arrays;
import java.util.Vector;

public class BuyAndSellStockAnyNoOfTimeDP36 {

  /*
      122. Best Time to Buy and Sell Stock II – Any Number of Transactions

      Problem:
      --------
      You are given an array prices where prices[i] is the price of a stock on day i.
      You may complete as many transactions as you like (buy → sell), but you must sell before you buy again.
      You can also buy and sell on the same day.

      Goal: Maximize total profit.

      Examples:
      ---------
      Input: prices = [7,1,5,3,6,4]
      Output: 7
      Explanation:
          Buy at 1, sell at 5 → profit = 4
          Buy at 3, sell at 6 → profit = 3
          Total profit = 7

      Input: prices = [1,2,3,4,5]
      Output: 4
      Explanation:
          Buy at 1, sell at 5 → profit = 4

      Input: prices = [7,6,4,3,1]
      Output: 0 (No profitable transactions)

      Why Important?
      --------------
      • Classic DP stock trading problem.
      • Tests understanding of "state machine" DP: (day, buy/sell state).
      • Builds foundation for harder problems (at most k transactions, cooldown, with transaction fees).

      Pattern:
      --------
      • DP with states:
          dp[i][buy]:
              → Maximum profit on day i with "buy" state.
              → buy = 0 → we can buy.
              → buy = 1 → we can sell.
          Transition:
              If buy == 0:
                  profit = max(skip, -price[i] + dp[i+1][1])
              If buy == 1:
                  profit = max(skip, price[i] + dp[i+1][0])

      Follow-ups:
      -----------
      1. Can we optimize space to O(1)?
      2. Can we do greedy? (Yes: sum of all positive differences).
      3. How to handle cooldown days or transaction fees?
      4. Extend to “Best Time to Buy and Sell Stock III/IV” (at most k transactions).

      Complexities:
      -------------
      Recursive + Memoization:
          Time: O(n × 2) = O(n)
          Space: O(n × 2) + O(n) recursion stack
      Greedy:
          Time: O(n)
          Space: O(1)

      Related Problems:
      -----------------
      • LeetCode 122 – Best Time to Buy and Sell Stock II
      • LeetCode 121 – Best Time to Buy and Sell Stock (1 transaction)
      • LeetCode 123 – Best Time to Buy and Sell Stock III (2 transactions)
      • LeetCode 188 – Best Time to Buy and Sell Stock IV (k transactions)
      • LeetCode 309 – Best Time to Buy and Sell Stock with Cooldown
      • LeetCode 714 – Best Time to Buy and Sell Stock with Transaction Fee
  */

  // Recursive function to calculate the maximum profit
  static long getMaximumProfitUtil(long[] Arr, int ind, int buy, int n, Vector<Vector<Long>> dp) {
    // Base case
    if (ind == n) return 0;

    // If the result is already computed, return it
    if (dp.get(ind).get(buy) != -1) return dp.get(ind).get(buy);

    long profit = 0;

    if (buy == 0) { // We can buy the stock
      profit =
          Math.max(
                  getMaximumProfitUtil(Arr, ind + 1, 0, n, dp),
              -Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp));
    }

    if (buy == 1) { // We can sell the stock
      profit =
          Math.max(
                  getMaximumProfitUtil(Arr, ind + 1, 1, n, dp),
              Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp));
    }

    // Store the result in the dp table and return it
    dp.get(ind).set(buy, profit);
    return profit;
  }

  // Function to calculate the maximum profit
  static long getMaximumProfit(long[] Arr, int n) {
    // Create a 2D vector for memoization (dp)
    Vector<Vector<Long>> dp = new Vector<>(n);
    for (int i = 0; i < n; i++) {
      Vector<Long> row = new Vector<>(2);
      row.addAll(Arrays.asList(-1L, -1L));
      dp.add(row);
    }

    // Base case: If n is 0, return 0 profit
    if (n == 0) return 0;

    // Calculate the maximum profit using the recursive function
    long ans = getMaximumProfitUtil(Arr, 0, 0, n, dp);
    return ans;
  }

  public static void main(String[] args) {
    int n = 6;
    long[] Arr = {7, 1, 5, 3, 6, 4};

    // Calculate and print the maximum profit
    System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
  }

  class StockProfit {
    // Function to calculate the maximum profit
    static long getMaximumProfit(long[] Arr, int n) {
      // Create arrays 'ahead' and 'cur' to store the maximum profit ahead and current profit
      long[] ahead = new long[2];
      long[] cur = new long[2];

      // Base condition: If we have no stocks to buy or sell, profit is 0
      ahead[0] = ahead[1] = 0;

      long profit = 0;

      // Iterate through the array in reverse to calculate the maximum profit
      for (int ind = n - 1; ind >= 0; ind--) {
        for (int buy = 0; buy <= 1; buy++) {
          if (buy == 0) { // We can buy the stock
            profit = Math.max(ahead[0], -Arr[ind] + ahead[1]);
          }

          if (buy == 1) { // We can sell the stock
            profit = Math.max(ahead[1], Arr[ind] + ahead[0]);
          }
          cur[buy] = profit;
        }

        // Update the 'ahead' array with the current profit values
        System.arraycopy(cur, 0, ahead, 0, 2);
      }
      return cur[0]; // The maximum profit is stored in 'cur[0]'
    }

    public static void main(String[] args) {
      int n = 6;
      long[] Arr = {7, 1, 5, 3, 6, 4};

      // Calculate and print the maximum profit
      System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
    }
  }
}
