package StandardProblemDSA.XI_GREEDYALGO;

import java.util.*;

public class MaxStability {

  /*
     * 📝 Problem Description:

  AWS provides a range of servers to meet the deployment needs of its clients. A client wants to choose a set of servers to deploy their application.
  Each server is associated with an availability factor and a reliability factor.
  The client defines the **stability** of a set of servers as the **minimum availability**
  * amongst the servers multiplied by the **sum of reliabilities** of all the servers.
  Given two arrays of integers: `availability[]` and `reliability[]`, where `availability[i]` and `reliability[i]`
  *  represent the availability and reliability factors of the *i-th* server, find the **maximum possible stability** of any **subset of servers**.
  Since the answer can be large, **report the answer modulo (10⁹ + 7).**

  ### Example:
  Consider the set of servers where:
  reliability = [1, 2, 2]
  availability = [1, 1, 3]
  The possible subsets of servers are:

  | Indices    | Stability Calculation                | Result |
  | ---------- | ------------------------------------ | ------ |
  |[0]       | 1* 1                               | 1      |
  |[1]       | 1* 2                               | 2      |
  |[2]       | 3* 2                               | 6      |
  |[0, 1]    | min(1, 1)* (1 + 2) = 1* 3        | 3      |
  |[0, 2]    | min(1, 3)* (1 + 2) = 1* 3        | 3      |
  |[1, 2]    | min(1, 3)* (2 + 2) = 1* 4        | 4      |
  |[0, 1, 2] | min(1, 1, 3)* (1 + 2 + 2) = 1* 5 | 5      |

  Hence, the maximum possible stability is: **6**


     * Each server has availability[i] and reliability[i].
     * The stability of a subset is:
     *     stability = min(availability in subset) * sum(reliability in subset)
     * Return the maximum stability possible among all non-empty subsets, modulo 1e9+7.
     *
     * 📦 Function:
     * Input: int[] reliability, int[] availability
     * Output: int (maximum stability value)
     *
     * 🔍 Question Type:
     * - Greedy
     * - Subset optimization
     *
     * 🧠 Approach:
     * Sort servers by decreasing availability.
     * Maintain running sum of reliability and compute:
     *     current_stability = availability * sum(reliability_so_far)
     * Track the maximum.
     */

  static final int MOD = 1_000_000_007;

  // 🐢 Brute Force (Try all subsets - Not feasible for n > 20)
  public static int getMaxStabilityBF(int[] reliability, int[] availability) {
    int n = reliability.length;
    int max = 0;

    for (int mask = 1; mask < (1 << n); mask++) {
      int minAvail = Integer.MAX_VALUE;
      int sumRel = 0;
      for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) != 0) {
          minAvail = Math.min(minAvail, availability[i]);
          sumRel += reliability[i];
        }
      }
      max = Math.max(max, (int) ((1L * minAvail * sumRel) % MOD));
    }

    return max;
  }

  // 🚀 Optimized Version (O(n log n) sorting + greedy)
  public static int getMaxStabilityOptimized(int[] reliability, int[] availability) {
    int n = availability.length;

    int[][] servers = new int[n][2];
    for (int i = 0; i < n; i++) {
      servers[i][0] = availability[i];
      servers[i][1] = reliability[i];
    }

    Arrays.sort(servers, (a, b) -> Integer.compare(b[0], a[0]));

    long sumReliability = 0;
    long maxStability = 0;

    for (int i = 0; i < n; i++) {
      sumReliability += servers[i][1];
      long stability = (servers[i][0] * sumReliability) % MOD;
      maxStability = Math.max(maxStability, stability);
    }

    return (int) maxStability;
  }

  // ⏱ Time Complexity:
  //     BF: O(2^n)
  //     Optimized: O(n log n)
  //
  // 🧠 Space Complexity:
  //     BF: O(1)
  //     Optimized: O(n)
  public static void main(String[] args) {

    // ------------------------ Test for MaxStability ------------------------
    System.out.println("\n⚙️ Test 2: MaxStability");

    int[] availability = {3, 1, 2};
    int[] reliability = {1, 2, 2};

    int result = MaxStability.getMaxStabilityOptimized(reliability, availability);
    System.out.println("Max Stability: " + result);
  }
}
