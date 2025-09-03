package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XI_STOCK_PATTERN;

import java.util.Arrays;

public class BASSAnyNoOfTimeOnlySingleStockHold_maximiseProfitDP36 {

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

  // NOTE : DP FOR MEMOISATION
  // for memoisation we need a two D db of size[n][2] ;
  // n : input array , which means index will remain inside 0 to n
  // 2 : the buy variable has two vvalue either true and false;
  // we initailsed the dp with -1;
  // and we have to set the value in each of the ceill with price value and buy variable
  // Whenever we want to find the answer to particular parameters (say f(ind, buy)), we first check whether
  // the answer is already calculated using the dp array(i.e dp[ind][buy]!= -1 ). If yes, simply return the value
  // from the dp array

  // If not, then we are finding the answer for the given value for the first time, we will use the
  // recursive relation as usual but before returning from the function, we will set dp[ind][buy]
  // to the solution we get.
  public int maxProfit(int[] prices) {
    // We want to maximize profit by buying and selling stocks any number of times.
    // This time, we add MEMOIZATION to optimize the recursion.
    // Idea: Use a 2D DP array where:
    //   dp[i][canBuy] = maximum profit starting from day i,
    //                   given canBuy (0 = we can buy, 1 = we must sell).

    int canBuy = 0;   // initially we are allowed to buy
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
      int sell = prices[i] + utility(i + 1, 0, lengthOfArray, prices, dp);

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
 /* Time Complexity: O(N*2)
  Reason: There are N*2 states therefore at max ‘N*2’ new problems will be solved and we are running a for loop for ‘N’ times to calculate the total sum
  Space Complexity: O(N*2) + O(N)
  Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*2)).*/


}

/*class StockProfit {
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
  }*/