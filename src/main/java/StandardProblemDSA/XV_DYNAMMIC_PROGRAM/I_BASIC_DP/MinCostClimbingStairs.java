package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.I_BASIC_DP;

class MinCostClimbingStaris {
  /**
   * Problem Statement: You are given an integer array cost where cost[i] is the cost of ith step on
   * a staircase. Once you pay the cost, you can either climb one or two steps. You can either start
   * from the step with index 0, or the step with index 1. Return the minimum cost to reach the top
   * of the floor.
   *
   * <p>Example 1: Input: cost = [10, 15, 20] Output: 15 Explanation: Start at index 1, pay 15, and
   * jump directly to the top.
   *
   * <p>Example 2: Input: cost = [1,100,1,1,1,100,1,1,100,1] Output: 6
   */

  /**
   * Approach: 1. The problem is similar to the "minimum path" type problems. 2. We can either reach
   * the top from the last step (n-1) or the second-last step (n-2). 3. We must choose the minimum
   * cost path at each step.
   *
   * <p>Brute Force Approach (Recursion): - Try all possible paths using recursion and return the
   * minimum cost. - Recurrence Relation: minCost(i) = cost[i] + min(minCost(i-1), minCost(i-2)) -
   * This solution has exponential time complexity O(2^n), making it inefficient.
   *
   * <p>Optimal Approach (Dynamic Programming): - Instead of recalculating the same results, we use
   * bottom-up DP. - Use two variables (prev1, prev2) to keep track of the minimum cost up to the
   * previous two steps. - Formula: cost[i] + min(prev1, prev2) - Time Complexity: O(n) - Space
   * Complexity: O(1) (since we use only two variables)
   */
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int prev1 = cost[1]; // Cost to reach step 1
    int prev2 = cost[0]; // Cost to reach step 0

    // Compute the minimum cost from step 2 to n-1
    for (int i = 2; i < n; i++) {
      int curr = cost[i] + Math.min(prev1, prev2);
      // update the prev1 and prev2 or we can directly write i-1 and i-2
      // just sliding the window of two element for
      prev2 = prev1; // previous2 will become prev1 element
      prev1 = curr;
    }

    // Return the minimum cost to reach the top
    return Math.min(prev1, prev2);
  }
  /*Explanation of the Code
  Brute Force Approach: Uses recursion but results in O(2^n) complexity due to redundant calculations.

  Optimal Approach: Uses two variables (prev1 and prev2) to store the last two computed results, reducing space to O(1).

  Time Complexity: O(n), since we iterate over the cost array once.

  Space Complexity: O(1), since we use only two integer variables (prev1 and prev2).*/
}
