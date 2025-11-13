package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.ZERO_ONE_KNAPSACK;

public class KNAPSACK {
  /*
  0/1 Knapsack Problem
  --------------------
  Problem Statement:
  Given `n` items with `weight[i]` and `value[i]`, and a knapsack of capacity `W`,
  find the maximum total value you can put in the knapsack. Each item can be either:
  - taken **once** (0/1 choice), or
  - not taken at all.

  Pattern:
  - **0/1 Knapsack** (classic DP: include or exclude each item).
  - State: dp[i][w] = max value using first i items with capacity w.
  - Transition:
        if (weight[i - 1] <= w)
            dp[i][w] = max(
                 dp[i - 1][w - weight[i - 1]] + value[i - 1] ,
                 dp[i - 1][w])
        else
            dp[i][w] = dp[i - 1][w]
  - Base case:
        dp[0][w] = 0 for all w (no items → no value)
        dp[i][0] = 0 for all i (0 capacity → no value)

  Approaches:
  1. **Recursion (brute force):** At each step, include or exclude item.
     Time: O(2^n), Space: O(n) (stack).
  2. **Top-down DP (Memoization):** Cache `(index, capacity)` states to avoid recomputation.
  3. **Bottom-up DP (Tabulation):** Build dp table of size n × W.
     Time: O(n * W), Space: O(n * W).
  4. **Space-optimized DP:** Use 1D array rolling from high → low capacities.
     Time: O(n * W), Space: O(W).

  Edge Cases:
  - Capacity = 0 → answer is 0.
  - All items heavier than W → answer is 0.
  - Single item exactly equals W → take it.

  Similar / Follow-up Problems:
  - LC 416: Partition Equal Subset Sum. (DONE)
  - LC 494: Target Sum.
  - Unbounded Knapsack (LC 322: Coin Change, LC 518: Coin Change II).
  */

  // so we need to think either take or not take
  // edge case will be
  private int knapSack(int index, int capacity, int[] weight, int[] value) {
    // STEP 1: Edge case EITHER CAPCITY OF THE BAG IS ZERO OR LESS OR WEIGHT OF THE ITEMS ARE LESS
    // OR NO ITEM TO FIT IN THE BAG
    if (capacity <= 0 || index == 0) // means no item to left
    {
      return 0;
    }
    // STEP 2 : induction (weight of the item greater then go for next element)
    if (weight[index] > capacity) {
      // if element can't be fit in the bag
      // just go to the next element and chechh
      return knapSack(index - 1, capacity, weight, value);
    }
    // include and exclude
    int exclude = knapSack(index - 1, capacity, weight, value);
    int include = knapSack(index - 1, capacity - weight[index], weight, value) + value[index];
    return Math.max(exclude, include);
  }
}
