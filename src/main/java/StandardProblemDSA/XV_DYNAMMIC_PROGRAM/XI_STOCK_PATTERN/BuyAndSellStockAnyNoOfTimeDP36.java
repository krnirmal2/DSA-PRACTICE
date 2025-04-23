package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XI_STOCK_PATTERN;

import java.util.Arrays;
import java.util.Vector;

public class BuyAndSellStockAnyNoOfTimeDP36 {

  /* 122. Best Time to Buy and Sell Stock II
  Medium
          Topics
  Companies
  You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

  On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

  Find and return the maximum profit you can achieve.



  Example 1:

  Input: prices = [7,1,5,3,6,4]
  Output: 7
  Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
  Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
  Total profit is 4 + 3 = 7.
  Example 2:

  Input: prices = [1,2,3,4,5]
  Output: 4
  Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
  Total profit is 4.
  Example 3:

  Input: prices = [7,6,4,3,1]
  Output: 0
  Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


  Constraints:

          1 <= prices.length <= 3 * 104
          0 <= prices[i] <= 104*/

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
              0 + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp),
              -Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp));
    }

    if (buy == 1) { // We can sell the stock
      profit =
          Math.max(
              0 + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp),
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
            profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
          }

          if (buy == 1) { // We can sell the stock
            profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
          }
          cur[buy] = profit;
        }

        // Update the 'ahead' array with the current profit values
        System.arraycopy(cur, 0, ahead, 0, 2);
      }
      return cur[0]; // The maximum profit is stored in 'cur[0]'
    }

    public static void main(String args[]) {
      int n = 6;
      long[] Arr = {7, 1, 5, 3, 6, 4};

      // Calculate and print the maximum profit
      System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
    }
  }
}
