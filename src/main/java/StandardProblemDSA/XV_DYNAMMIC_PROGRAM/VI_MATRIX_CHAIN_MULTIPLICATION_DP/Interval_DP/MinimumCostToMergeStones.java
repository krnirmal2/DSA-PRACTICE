package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.VI_MATRIX_CHAIN_MULTIPLICATION_DP.Interval_DP;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class MinimumCostToMergeStones {
  /*Alright, let’s build it from **brute force** to **optimized** so you can see the evolution of the solution.
  # **Step 1: Brute Force Approach**
  ### **Idea**
  * We can merge **any `k` consecutive piles**.
  * After each merge, we create a new array with the merged pile.
  * Recursively try **all possible sequences of merges**.
  * Keep track of the **minimum total cost**.
  ### **Why is it bad?**
  * At each step, we have multiple choices for which `k` piles to merge.
  * The recursion tree grows explosively — complexity is **O(n!)** for large n.
  ### **Brute Force Java Code**
  class Solution {
      public int mergeStones(int[] stones, int K) {
          if ((stones.length - 1) % (K - 1) != 0) return -1;
          return bruteForce(stones, K);
      }

      private int bruteForce(int[] stones, int K) {
          int n = stones.length;
          if (n == 1) return 0; // Already one pile, no cost

          int minCost = Integer.MAX_VALUE;
          // Try merging every K consecutive piles
          for (int i = 0; i + K <= n; i++) {
              int merged = 0;
              for (int j = i; j < i + K; j++) merged += stones[j];

              // Build new array after merge
              int[] next = new int[n - K + 1];
              int idx = 0;
              for (int j = 0; j < i; j++) next[idx++] = stones[j];
              next[idx++] = merged;
              for (int j = i + K; j < n; j++) next[idx++] = stones[j];

              minCost = Math.min(minCost, merged + bruteForce(next, K));
          }

          return minCost;
      }
  }
  **Complexity:** Exponential (**O(k^n)**), too slow for n > 10.
  # **Step 2: Optimize with Observations**

  ### **Observation 1:**
  * Many subproblems repeat.
  * Example: The cost to merge stones\[i..j] into 1 pile is computed multiple times.
  ### **Observation 2:**
  * The problem is about **merging intervals**.
  * We can define:
    dp(i, j, t) = min cost to merge stones[i..j] into t piles
  * Base case: `dp(i, i, 1) = 0` (one pile already).
  ### **Observation 3:**
  * To merge into **1 pile**, we must first merge into **K piles**, then add the sum of stones\[i..j].

  # **Step 3: Memoization (Top-Down DP)**
  We use a **3D memo table**: `dp[i][j][piles]`.
  Transition:
  dp(i, j, t) = min(dp(i, m, 1) + dp(m + 1, j, t - 1))
  * where `m` goes from `i` to `j - 1` in steps of `(K - 1)`.
  If `t == 1`,
  dp(i, j, 1) = dp(i, j, K) + sum(stones[i..j])
  ### **Top-Down DP Code**
  # **Step 4: Why Complexity Drops**
  * Instead of recomputing merges for every path, we cache results.
  * Time Complexity: **O(n³ / k)**.
  * Space: **O(n² \* k)**.
  *?
  */

  /*here are n piles of stones arranged in a row. The ith pile has stones[i] stones.
  A move consists of merging exactly k consecutive piles into one pile, and the cost of this move is equal
   to the total number of stones in these k piles.
  Return the minimum cost to merge all piles of stones into one pile. If it is impossible, return -1.

  Example 1:

  Input: stones = [3,2,4,1], k = 2
  Output: 20
  Explanation: We start with [3, 2, 4, 1].
  We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
  We merge [4, 1] for a cost of 5, and we are left with [5, 5].
  We merge [5, 5] for a cost of 10, and we are left with [10].
  The total cost was 20, and this is the minimum possible.
  Example 2:

  Input: stones = [3,2,4,1], k = 3
  Output: -1
  Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.
  Example 3:

  Input: stones = [3,5,1,2,6], k = 3
  Output: 25
  Explanation: We start with [3, 5, 1, 2, 6].
  We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
  We merge [3, 8, 6] for a cost of 17, and we are left with [17].
  The total cost was 25, and this is the minimum possible.


  Constraints:

  n == stones.length
  1 <= n <= 30
  1 <= stones[i] <= 100
  2 <= k <= 30*/

    int[][][] memo;
    int[] prefix;
    int K;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        K = k;

        // If it's impossible to merge into one pile
        if ((n - 1) % (k - 1) != 0) return -1;

        // Prefix sum for quick range sum queries
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // Initialize memo table
        memo = new int[n][n][k + 1];
        for (int[][] arr2D : memo) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        return dfs(stones, 0, n - 1, 1);
    }

    private int dfs(int[] stones, int i, int j, int piles) {
        if (memo[i][j][piles] != -1) return memo[i][j][piles];

        // Base case: one pile needed, one stone
        if (i == j) {
            return memo[i][j][piles] = (piles == 1 ? 0 : Integer.MAX_VALUE / 2);
        }

        if (piles == 1) {
            int cost = dfs(stones, i, j, K) + getSum(i, j);
            return memo[i][j][piles] = cost;
        }

        int ans = Integer.MAX_VALUE / 2;
        // Try splitting into 1 pile and (piles - 1) piles
        for (int m = i; m < j; m += (K - 1)) {
            int left = dfs(stones, i, m, 1);
            int right = dfs(stones, m + 1, j, piles - 1);
            ans = Math.min(ans, left + right);
        }

        return memo[i][j][piles] = ans;
    }

    private int getSum(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}

class Solution {
    /*Complexity
    Time: O(n^3 / K) (due to interval splits).
    Space: O(n^2 * K).

    */
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1; // impossible case

        // Prefix sums for quick interval sum calculation
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        // Define inside mergeStones method
        IntBinaryOperator sum = (i, j) -> prefix[j + 1] - prefix[i];

        // DP array: dp[i][j][t]
        int[][][] dp = new int[n][n][K + 1];
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, Integer.MAX_VALUE / 2);
            }
        }

        // Base case: cost to merge one pile into one pile is 0
        for (int i = 0; i < n; i++) dp[i][i][1] = 0;

        // Build for increasing interval lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int t = 2; t <= K; t++) { // t = 2..K piles
                    for (int m = i; m < j; m += (K - 1)) { // split interval
                        dp[i][j][t] = Math.min(dp[i][j][t], dp[i][m][1] + dp[m + 1][j][t - 1]);
                    }
                }
                // Now merge K piles into 1 pile, adding interval sum
                dp[i][j][1] = dp[i][j][K] + (prefix[j + 1] - prefix[i]);
            }
        }

        return dp[0][n - 1][1];
    }
}
