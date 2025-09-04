package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XI_STOCK_PATTERN;

import java.util.Arrays;

public class BASS_AT_MOST_TWO_TRANSACTION_3D_DP {
    /*You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 105

Similar Questions
Best Time to Buy and Sell Stock
Easy
Best Time to Buy and Sell Stock II
Medium
Best Time to Buy and Sell Stock IV
Hard
Maximum Sum of 3 Non-Overlapping Subarrays
Hard
Maximum Profit From Trading Stocks
Medium
Maximize Win From Two Segments*/

    public int maxProfit(int[] prices) {
        // We want to maximize profit by buying and selling stocks any number of times.
        // This time, we add MEMOIZATION to optimize the recursion.
        // Idea: Use a 2D DP array where:
        //   dp[i][canBuy] = maximum profit starting from day i,
        //                   given canBuy (0 = we can buy, 1 = we must sell).
        int canBuy = 0; // initially we are allowed to buy
        int initialIndex = 0;
        // Create DP array (n x 2), initialized with -1 (uncomputed states).
        int[][][] dp = new int[prices.length][2][3];
        for (int row = 0; row < prices.length; row++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[row][j], -1);
            }
        }
        // Start recursion with memoization
        return utility(initialIndex, canBuy, prices.length, prices, dp, 2);
    }

    private int utility(int i, int canBuy, int lengthOfArray, int[] prices, int[][][] dp, int transaction) {
        // Base case: if we reach beyond the last day, profit is 0
        if (i == lengthOfArray || transaction == 0) {
            return 0;
        }
        // If already computed, just return cached value
        if (dp[i][canBuy][transaction] != -1) {
            return dp[i][canBuy][transaction];
        }
        int profit;
        // Case 1: Allowed to BUY
        if (canBuy == 0) {
            // Option 1: Buy stock today → profit decreases by prices[i],
            // then move to next day where we must sell (canBuy = 1).
            int buy = -prices[i] + utility(i + 1, 1, lengthOfArray, prices, dp, transaction);
            // Option 2: Skip buying today → profit stays the same,
            // move to next day still allowed to buy (canBuy = 0).
            int notBuy = utility(i + 1, 0, lengthOfArray, prices, dp, transaction);
            // Take max of both choices
            profit = Math.max(buy, notBuy);
        }
        // Case 2: Must SELL (because we have already bought before)
        else {
            // Option 1: Sell stock today → profit increases by prices[i],
            // then move to next day with ability to buy again (canBuy = 0).
            int sell = prices[i] + utility(i + 1, 0, lengthOfArray, prices, dp, transaction - 1);
            // Option 2: Skip selling today → profit stays same,
            // move to next day still waiting to sell (canBuy = 1).
            int notSell = utility(i + 1, 1, lengthOfArray, prices, dp, transaction);
            // Take max of both choices
            profit = Math.max(sell, notSell);
        }
        // Save result into memo table before returning
        dp[i][canBuy][transaction] = profit;
        return profit;
    }
    /*Time Complexity: O(N*2*3)
Reason: There are N*2*3 states therefore at max ‘N*2*3’ new problems will be solved.
Space Complexity: O(N*2*3) + O(N)
Reason: We are using a recursion stack space(O(N)) and a 3D array ( O(N*2*3)).
*/
}
