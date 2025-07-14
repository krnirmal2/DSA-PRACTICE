package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.I_BASIC_DP;

import StandardProblemDSA.Utility;

public class ClimbingStairs {
  /*70. Climbing Stairs
  You are climbing a staircase. It takes n steps to reach the top.
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you
  climb to the top?

  Example 1:
  Input: n = 2
  Output: 2
  Explanation: There are two ways to climb to the top.
  1. 1 step + 1 step
  2. 2 steps
  Example 2:
  Input: n = 3
  Output: 3
  Explanation: There are three ways to climb to the top.
  1. 1 step + 1 step + 1 step
  2. 1 step + 2 steps
  3. 2 steps + 1 step

  Constraints:
  	• 1 <= n <= 45



  */
  public int climbStairs(int n) {
    // Initialize the memo array dynamically based on n
    int[] memo = Utility.linearArrayMemo(n);
    return helper(n, memo);
  }

  private int helper(int n, int[] memo) {
    // Return the result if already computed
    if (memo[n] != -1) return memo[n];
    // Base cases
    if (n == 0) return memo[0] = 0;
    if (n == 1) return memo[1] = 1;
    if (n == 2) return memo[2] = 2;
    // Compute the result recursively and store in memo
    // it will give no of path through wise we can reached the top
    memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
    return memo[n];
  }
}
