package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION;

import java.util.Arrays;

public class FrogJump {
    /*
      70. Climbing Stairs
      You are climbing a staircase. It takes n steps to reach the top.
      Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
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


    Pattern:
    - Dynamic Programming (Top-down with memoization).
    - Recurrence: ways(n) = ways(n - 1) + ways(n - 2).

    LeetCode Similar:
    - LC 70 (Climbing Stairs)
    - LC 746 (Min Cost Climbing Stairs)
    - LC 509 (Fibonacci Number)

    Follow-ups:
    - Space optimization to O(1) using two variables.
    - Allow jumps of size k (generalized).

    Time Complexity:
    - O(n) time, O(n) space (memoization).
       */
    public int climbStairs(int n) {
        // Initialize the memo array dynamically based on n
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Fill the memo array with -1
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (memo[n] != -1) return memo[n];
        // Base cases
        if (n == 0) return memo[0] = 0;
        if (n == 1) return memo[1] = 1;
        if (n == 2) return memo[2] = 2;
        // Compute the result recursively and store in memo
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }
}
