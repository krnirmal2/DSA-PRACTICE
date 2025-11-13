package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.ZERO_ONE_KNAPSACK;

public class MinimumSubsetSumDifference {
  /* Partition a set into two subsets such that the difference of subset sums is minimum
    Last Updated : 18 Nov, 2024
    Given an array arr[] of size n, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
    If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
            Example:
    Input: arr = [1, 6, 11, 5]
    Output: 1
    Explanation: S1 = [1, 5, 6], sum = 12, S2 = [11], sum = 11, Absolute Difference (12 – 11) = 1
    Input: arr = [1, 5, 11, 5]
    Output: 0
    Explanation: S1 = [1, 5, 5], sum = 11, S2 = [11], sum = 11, Absolute Difference (11 – 11) = 0



    Pattern:
            - **Subset Sum Problem** variation.
  - We try to find the maximum `s1` ≤ totalSum / 2.
            - This is a **0/1 Knapsack**:
    dp[i][t] = max sum possible using first i elements with capacity t.

    Approaches:
            1. **Recursion (brute force):** Explore include/exclude for each element.
    Time: O(2^n), Space: O(n).
            2. **Top-down DP (Memoization):** Cache `(index, target)` to avoid recomputation.
            Time: O(n * target), Space: O(n * target).
            3. **Bottom-up DP (Tabulation):** Fill boolean dp table to find subset sums.
            Time: O(n * target), Space: O(n * target).
            4. **Space-optimized DP:** Use 1D dp array rolling over target.
            Time: O(n * target), Space: O(target).

    Edge Cases:
            - All elements equal → difference = 0.
            - Single element → difference = value itself.
            - Sum of array = 0 → difference = 0.

    Similar / Follow-up Problems:
            - LC 416: Partition Equal Subset Sum.
            - LC 494: Target Sum.
            - Minimum Subset Sum Partition in multi-sets.*/
  public int minMumSubsetSumDifference(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
      totalSum += num;
    }

    // derived formula = totalSum - 2 * subsetSum

    int target = totalSum / 2;
    return totalSum - (2 * util(nums, nums.length - 1, target));
  }

  private int util(int[] nums, int index, int target) {
    // Base cases
    if (target == 0) return 0; // Found a subset with the required sum
    if (index < 0 || target < 0) return 0;
    // include the element and exclude
    int exclude = util(nums, index - 1, target);
    int include = 0;
    if (nums[index] <= target) {
      include = util(nums, index - 1, target - nums[index]) + nums[index];
    }

    return Math.max(include, exclude);
  }

  //    O(N * Target)	O(N * Target)
  public class MinSubsetSumDiff {

    public int minimumSubsetSumDifference(int[] nums) {
      int totalSum = 0;
      for (int num : nums) totalSum += num;

      int n = nums.length;
      int target = totalSum / 2;

      Integer[][] dp = new Integer[n][target + 1];
      int bestSum = memo(nums, n - 1, target, dp);

      return totalSum - 2 * bestSum;
    }

    private int memo(int[] nums, int i, int target, Integer[][] dp) {
      if (target == 0) return 0;
      if (i < 0) return 0;

      if (dp[i][target] != null) return dp[i][target];

      int exclude = memo(nums, i - 1, target, dp);
      int include = 0;
      if (nums[i] <= target) {
        include = memo(nums, i - 1, target - nums[i], dp) + nums[i];
      }

      return dp[i][target] = Math.max(include, exclude);
    }
  }
}
