package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.BinaryArray;

public class MaxConsecutiveOnesAtmostOneZeroReplacing {
  /*
  Problem Statement:
  You are given a binary array consisting only of 0s and 1s.
  You can replace at most one 0 with 1.
  Find the maximum number of consecutive 1s that can be obtained after performing this operation.

  Example:
  Input:  nums = [1, 0, 1, 1, 0]
  Output: 4
  Explanation:
  - Replace the first 0 → [1, 1, 1, 1, 0] → max consecutive ones = 4
  - Replace the second 0 → [1, 0, 1, 1, 1] → max consecutive ones = 4
  - Answer = 4

  Approach:
  1. **Brute Force (O(N²)):**
     - For each 0 in the array, temporarily replace it with 1 and count consecutive 1s.
     - Track the maximum over all positions.
     - Inefficient for large arrays.

  2. **Optimized Approach (Sliding Window, O(N)):**
     - Maintain a window [left, right] that contains at most one 0.
     - Use `zeroCount` to track the number of 0s in the current window.
     - Expand `right` pointer to include new elements.
     - If `zeroCount > 1`, move `left` pointer until the window contains at most one 0.
     - Update `maxOnes` as the maximum window size encountered.

  Pattern:
  - Variable-size sliding window with a constraint (at most k zeros).

  Time Complexity:
  - O(N), as each element is visited at most twice (once by right and once by left pointer).

  Space Complexity:
  - O(1), as we only use a few variables.

  Follow-up Questions:
  1. How would you solve if you are allowed to replace at most `k` zeros with ones?
  2. What if the array is infinite and you are receiving the stream in real-time?

  Similar Problems:
  - LeetCode 1004: Max Consecutive Ones III.(done)
  - LeetCode 487: Max Consecutive Ones II.
  */

  public static int findMaxConsecutiveOnes(int[] nums) {
    int left = 0, right = 0, zeroCount = 0, maxOnes = 0;

    while (right < nums.length) {
      if (nums[right] == 0) {
        zeroCount++;
      }

      // If more than one zero, shrink window
      while (zeroCount > 1) {
        if (nums[left] == 0) {
          zeroCount--;
        }
        left++; // Move left pointer
      }

      // Update max consecutive ones
      maxOnes = Math.max(maxOnes, right - left + 1);
      right++; // Expand window
    }

    return maxOnes;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 0, 1, 1, 0, 1, 1, 1};
    System.out.println(findMaxConsecutiveOnes(nums)); // Output: 6
  }
}
