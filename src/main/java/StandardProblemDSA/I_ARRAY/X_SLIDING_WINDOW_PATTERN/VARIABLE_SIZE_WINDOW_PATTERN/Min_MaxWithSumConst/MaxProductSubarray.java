package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.Min_MaxWithSumConst;

public class MaxProductSubarray {
  /*
  ------------------------------------------------------
  Question (Interviewer-style)
  ------------------------------------------------------
  "Given an integer array `nums`, find the contiguous subarray within the array
   that has the largest product and return the product."

  Example 1:
    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product = 6.

  Example 2:
    Input: nums = [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2 because [-2,-1] is not contiguous.

  Constraints:
  - 1 <= nums.length <= 2 * 10^4
  - -10 <= nums[i] <= 10
  - Product of any subarray fits in 32-bit integer.

  ------------------------------------------------------
  Pattern
  ------------------------------------------------------
  Pattern Name: Dynamic Programming (Kadane’s Algorithm variation for Products)
  - Regular Kadane’s algorithm works for sums but not directly for products because:
    - Negative numbers can flip the product sign.
    - Two negatives can create a larger positive product.
    - Zero resets the product chain.

  ------------------------------------------------------
  Approach Explanation
  ------------------------------------------------------
  1. Maintain:
     - `maxSoFar`: maximum product ending at the current index.
     - `minSoFar`: minimum product ending at the current index (needed because a negative × negative can become max).
     - `result`: global maximum product found so far.

  2. Iterate through the array:
     - If `nums[i]` is negative, swap `maxSoFar` and `minSoFar`.
     - Update `maxSoFar = max(nums[i], maxSoFar * nums[i])`.
     - Update `minSoFar = min(nums[i], minSoFar * nums[i])`.
     - Update `result = max(result, maxSoFar)`.

  3. Return `result`.

  Key Insight:
  - Tracking both maximum and minimum at each step allows handling negatives and zeros correctly.
  - A zero effectively resets both max and min for the next subarray.

  ------------------------------------------------------
  Follow-up Questions
  ------------------------------------------------------
  1. What if we need to return the actual subarray (not just the product)?
     - Track start/end indices when updating `maxSoFar`.
  2. How to handle arrays with all negatives?
     - This approach already covers that; the minimum negative product can flip to maximum.
  3. Can this be extended to K-partition maximum product?
     - Yes, with dynamic programming, but complexity increases.

  ------------------------------------------------------
  Similar LeetCode Problems
  ------------------------------------------------------
  - LeetCode 152 – Maximum Product Subarray (exact problem)
  - LeetCode 53 – Maximum Subarray (Kadane’s algorithm for sum)
  - LeetCode 918 – Maximum Sum Circular Subarray (variation on Kadane’s)

  ------------------------------------------------------
  Time & Space Complexity
  ------------------------------------------------------
  - Time: O(n) – single pass through the array.
  - Space: O(1) – only a few variables needed.
  */
  /*We need to find the maximum product of any contiguous subarray.
  But with multiplication, some tricky things happen:
  A negative number can flip a large product into a negative one.
  But two negative numbers can create a positive product.
  A zero wipes out everything and creates a hard boundary.

  🔥 Realization:
  To handle all cases (positive, negative, zero), we must keep track of:
  maxSoFar: the maximum product ending at current index
  minSoFar: the minimum product ending at current index

  ❗ Why track minSoFar?
  Because a negative number multiplied by the current minSoFar (also negative) can become the next maxSoFar.*/
  public static int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int maxSoFar = nums[0];
    int minSoFar = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int current = nums[i];

      if (current < 0) {
        // Swap max and min when negative
        int temp = maxSoFar;
        maxSoFar = minSoFar;
        minSoFar = temp;
      }

      maxSoFar = Math.max(current, maxSoFar * current);
      minSoFar = Math.min(current, minSoFar * current);

      result = Math.max(result, maxSoFar);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(maxProduct(new int[] {2, 3, -2, 4})); // 6
    System.out.println(maxProduct(new int[] {-2, 0, -1})); // 0
    System.out.println(maxProduct(new int[] {-2, 3, -4})); // 24
    System.out.println(maxProduct(new int[] {1, 2, 3, 4})); // 24
  }
}
