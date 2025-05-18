package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.I_BASIC_DP;

import StandardProblemDSA.Utility;

public class ClimbingStairs {
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
