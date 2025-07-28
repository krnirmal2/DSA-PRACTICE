package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.ZERO_ONE_KNAPSACK;

import java.util.HashMap;
import java.util.Map;

/**/
/*494. Target Sum
Solved
        Medium
Topics
        Companies
You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
        Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
        -1 + 1 + 1 + 1 + 1 = 3
        +1 - 1 + 1 + 1 + 1 = 3
        +1 + 1 - 1 + 1 + 1 = 3
        +1 + 1 + 1 - 1 + 1 = 3
        +1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
Constraints:

        1 <= nums.length <= 20
        0 <= nums[i] <= 1000
        0 <= sum(nums[i]) <= 1000
        -1000 <= target <= 1000

  Key Idea:
- For each number, we have **two choices**: add or subtract.
- We need to count all valid ways where sum of expressions = target.
- Essentially, this is a variation of the **subset sum problem**.

Approaches:
1. **Recursion with memoization:**
    - State: (index, target) → number of ways to reach target using elements from `index` onwards.
    - Choices: `+nums[index]` or `-nums[index]`.
    - Time: O(n * totalSum), Space: O(n * totalSum).

2. **Transform to Subset Sum Count:**
    - Let `P` = sum of numbers assigned '+', `N` = sum of numbers assigned '-'.
    - We need `P - N = target` and `P + N = totalSum`.
    - Solving: `P = (target + totalSum) / 2`.
    - Now count subsets of `nums` that sum to `P`.
    - Time: O(n * P), Space: O(P).

Edge Cases:
- If `target` is greater than `totalSum` or `(target + totalSum)` is odd → return 0.
- If nums contains zeros, adding/subtracting zero leads to duplicate ways (handle carefully).

Similar Problems:
- Subset Sum Count
- Partition Equal Subset Sum (LC 416)
- Minimum Subset Sum Difference
- Expression Add Operators (LC 282)
*/
public class TargetSum {

  public int findTargetSumWays(int[] nums, int target) {
    // Memoization map to store results of subproblems
    Map<String, Integer> memo = new HashMap<>();
    return findWays(nums, 0, target, memo); // Start from index 0 and target sum
  }

  private int findWays(int[] nums, int index, int target, Map<String, Integer> memo) {
    // Base case: If we've processed all elements
    if (index == nums.length) {
      // If the remaining target is 0, it's a valid way
      return target == 0 ? 1 : 0;
    }

    // Create a unique key for the current state (index and target)
    String key = index + "," + target;

    // Check if this state has been calculated before
    if (memo.containsKey(key)) {
      return memo.get(key); // Return the cached result
    }

    // Recursive case: Include the current number with both + and - signs
    int add = findWays(nums, index + 1, target - nums[index], memo);
    int subtract = findWays(nums, index + 1, target + nums[index], memo);

    // Store the result in the memoization table
    memo.put(key, add + subtract);

    // Return the total number of ways from both choices
    return memo.get(key);
  }
}
