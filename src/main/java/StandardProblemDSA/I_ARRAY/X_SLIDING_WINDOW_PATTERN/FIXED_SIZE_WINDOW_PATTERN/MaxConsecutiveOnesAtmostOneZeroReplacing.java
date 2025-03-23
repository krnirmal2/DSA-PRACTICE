package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

public class MaxConsecutiveOnesAtmostOneZeroReplacing {
  /* Problem Statement
      You are given a binary array (0s and 1s). You can replace at most one 0 with 1. Find the maximum consecutive 1s that can be obtained after performing this operation.

  Approach
     Brute Force (O(N²))
      For each 0, replace it with 1 and count the max consecutive 1s.
              Inefficient for large arrays.

     Optimized Approach (Sliding Window O(N))
      Maintain a window with at most one 0.
      Use two pointers (left and right) to expand the window.
      Keep track of zeroCount to ensure only one 0 is flipped.
      If zeroCount > 1, move left pointer to maintain the constraint
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
