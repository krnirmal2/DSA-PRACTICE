package StandardProblemDSA.XI_GREEDYALGO.II_ONE_PASS_LOCAL_OPTIMISATION;

public class BestTimeToBuyAndSellStockI {
  /*
  Problem:
      You’re given an array where prices[i] is the stock price on day i.
      Find the maximum profit you can achieve by buying once and selling once.
      If no profit is possible, return 0.

  Approach:
      - Track the minimum price so far (minPrice) while iterating.
      - For each price, compute potential profit = price - minPrice.
      - Update maxProfit if this profit is greater.
      - Update minPrice if current price is lower.

  Pattern:
      - **Single Pass Greedy** (track running minimum and max difference).

  LeetCode:
      - LeetCode 121: Best Time to Buy and Sell Stock.

  Time Complexity:
      - O(n) (single pass over prices).
  Space Complexity:
      - O(1) extra space.

  Follow-up:
      - Variants: multiple transactions (Stock II), cooldowns, transaction fees,
        at most k transactions.
  */
}
