package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.ZERO_ONE_KNAPSACK;

public class PartitionEqualSubsetSum {
  /* 416. Partition Equal Subset Sum
    Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
            Example 1:
    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11].
    Example 2:
    Input: nums = [1,2,3,5]
    Output: false
    Explanation: The array cannot be partitioned into equal sum subsets.
            Constraints:
            • 1 <= nums.length <= 200
            1 <= nums[i] <= 100


  Observation:
  - Total sum of array = sum(nums).
  - To partition into 2 equal subsets, `totalSum` must be even.
  - Then we just need to check if there exists a subset with sum = `totalSum / 2`.

  Pattern:
  - **0/1 Knapsack** problem:
      Can we pick some numbers to exactly reach `target = totalSum / 2`?
      State: dp[i][target] → true if using elements up to i, we can form `target`.

  Approaches:
  1. **Recursion (brute force):** Try include/exclude for each number.
     Time: O(2^n), Space: O(n).
  2. **Top-down DP (Memoization):** Cache `(index, target)` to avoid recomputation.
     Time: O(n * target), Space: O(n * target).
  3. **Bottom-up DP (Tabulation):** Build boolean table iteratively.
     Time: O(n * target), Space: O(n * target).
  4. **Space-optimized DP:** Use 1D dp array (rolling target).
     Time: O(n * target), Space: O(target).

  Edge Cases:
  - Total sum odd → always false.
  - Single element array → false unless element = 0.
  - All elements zero → true.

  Similar / Follow-up Problems:
  - LC 698: Partition to K Equal Sum Subsets.
  - Minimum Subset Sum Difference.
  - Target Sum (LC 494).        */
  public boolean canPartition(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
      totalSum += num;
    }

    // If total sum is odd, partitioning is impossible
    if (totalSum % 2 != 0) return false;

    int target = totalSum / 2;
    return canPartitionHelper(nums, nums.length - 1, target);
  }

  private boolean canPartitionHelper(int[] nums, int index, int target) {
    // Base cases
    if (target == 0) return true; // Found a subset with the required sum
    if (index < 0 || target < 0) return false;

    // Include or exclude the current element
    return canPartitionHelper(nums, index - 1, target - nums[index])
        || canPartitionHelper(nums, index - 1, target);
  }
}
