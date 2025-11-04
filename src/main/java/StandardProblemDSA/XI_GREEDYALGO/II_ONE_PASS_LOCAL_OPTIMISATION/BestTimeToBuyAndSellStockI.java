package StandardProblemDSA.XI_GREEDYALGO.II_ONE_PASS_LOCAL_OPTIMISATION;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BestTimeToBuyAndSellStockI {
  /*
    Problem:
        You’re given an array where prices[i] is the stock price on day i.
        Find the maximum profit you can achieve by buying once and selling once.
        If no profit is possible, return 0.

  Example 1:
  Input: prices = [7,1,5,3,6,4]
  Output: 5
  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
  Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

  Example 2:
  Input: prices = [7,6,4,3,1]
  Output: 0
  Explanation: In this case, no transactions are done and the max profit = 0.
  Constraints:
  1 <= prices.length <= 105
  0 <= prices[i] <= 104

    Approach:
        - Track the minimum price so far (minPrice) while iterating.
        - For each price, compute potential profit = price - minPrice.
        - Update maxProfit if this profit is greater.
        - Update minPrice if current price is lower.

    Pattern:
        - **Single Pass Greedy** (track running minimum and max difference).

    LeetCode:
        - LeetCode 121: Best Time to Buy and Sell Stock. done

    Time Complexity:
        - O(n) (single pass over prices).
    Space Complexity:
        - O(1) extra space.

    Follow-up:
        - Variants: multiple transactions (Stock II), cooldowns, transaction fees,
          at most k transactions.
    */
  public static int maxProfit(int[] prices) {

    int max_profit = 0;
    int best_buy = prices[0];
    int size = prices.length;
    for (int i = 1; i < size; i++) { // start from the second element
      best_buy = min(best_buy, prices[i]); // track the minmum price for buying
      if (prices[i] > best_buy) {
        max_profit =
            max(
                max_profit,
                (prices[i] - best_buy)); // and find the maximum profit calculating with each
      }
    }
    return max_profit;
  }

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));
  }
}
