package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.BinaryArray;

public class MaximieNoOf0sByFilpSubArray {
  /*
  Problem Statement:
  You are given a binary array (containing only 0s and 1s).
  You are allowed to flip exactly one contiguous subarray —
  a flip operation changes all 0s to 1s and all 1s to 0s.
  Your task is to maximize the total number of 0s in the final array.

  Example 1:
  Input:  arr = {0, 1, 0, 0, 1, 1, 0}
  Output: 6
  Explanation:
  - Original zeros = 4
  - Best subarray to flip = [1,1] (indices 4 and 5)
  - After flipping: 0,1,0,0,0,0,0 → total zeros = 6.

  Example 2:
  Input:  arr = {0, 0, 0, 1, 0, 1}
  Output: 5
  Explanation:
  - Original zeros = 4
  - Flip subarray [1] (index 5), total zeros = 5.

  ---

  Approach 1 (Brute Force, O(n²)):
  - Try all subarrays and calculate (count of 1s - count of 0s) for each.
  - Keep track of the maximum such difference (`max_diff`).
  - Answer = original number of 0s + `max_diff`.

  Approach 2 (Optimized, Kadane’s Algorithm, O(n)):
  - Instead of nested loops, convert the problem:
    - Treat 1 as +1 (flipping 1 to 0 increases zeros).
    - Treat 0 as -1 (flipping 0 to 1 decreases zeros).
  - Now find the subarray with the maximum sum using Kadane’s algorithm.
  - Answer = original number of 0s + maximum sum found.

  Time Complexity:
  - Brute Force: O(n²)
  - Optimized Kadane’s Algorithm: O(n)

  Space Complexity:
  - O(1), only a few variables used.

  Follow-up Questions:
  1. What if we can flip at most K subarrays?
  2. How to handle streaming data where the array is too large to fit into memory?

  Similar Problems:
  - Maximum Subarray Sum (Kadane’s Algorithm).
  - Flip Bits to Maximize Ones.
  - LeetCode 1004: Max Consecutive Ones III.
  */

  public class MaximizeNoOf0sByFlipSubArray {
    public static int findMaxZeroCount(int[] arr, int n) {
      int orig_zero_count = 0;
      for (int value : arr) {
        if (value == 0) orig_zero_count++;
      }

      // Transform array: 1 -> +1, 0 -> -1
      int max_diff = Integer.MIN_VALUE, current_sum = 0;
      for (int value : arr) {
        int transformed = (value == 1) ? 1 : -1;
        current_sum = Math.max(transformed, current_sum + transformed);
        max_diff = Math.max(max_diff, current_sum);
      }

      return orig_zero_count + max_diff;
    }

    public static void main(String[] args) {
      int[] arr = {0, 1, 0, 0, 1, 1, 0};
      System.out.println(findMaxZeroCount(arr, arr.length)); // Output: 6
    }
  }

  // Java code for Maximize number of 0s by flipping
  // a subarray

  // A Kadane's algorithm based solution to find maximum
  // number of 0s by flipping a subarray.
  public static int findMaxZeroCount(int[] arr, int n) {
    // Initialize max_diff = maximum of (Count of 0s -
    // count of 1s) for all subarrays.
    int max_diff = 0;

    // Initialize count of 0s in original array
    int orig_zero_count = 0;

    // Consider all Subarrays by using two nested two
    // loops
    for (int i = 0; i < n; i++) {
      // Increment count of zeros
      if (arr[i] == 0) orig_zero_count++;

      // Initialize counts of 0s and 1s
      int count1 = 0, count0 = 0;

      // Consider all subarrays starting from arr[i]
      // and find the difference between 1s and 0s.
      // Update max_diff if required
      for (int j = i; j < n; j++) {
        if (arr[j] == 1) count1++;
        else count0++;
        max_diff = Math.max(max_diff, count1 - count0);
      }
    }

    // Final result would be count of 0s in original
    // array plus max_diff.
    return orig_zero_count + max_diff;
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 0, 1, 1, 0};

    System.out.println(findMaxZeroCount(arr, arr.length));
  }
}
    /* Driver program to test above function *//*


                                               Output
                                               6
                                               Time Complexity: O(n2)

                                               Auxiliary Space: O(1)

                                               As constant extra space is used.

                                               Method 2 (Efficient : O(n)): This problem can be reduced to largest subarray sum problem. The idea is to consider every 0 as -1 and every 1 as 1, find the sum of largest subarray sum in this modified array. This sum is our required max_diff ( count of 0s – count of 1s in any subarray). Finally we return the max_diff plus count of zeros in original array.




                                               // Java code for Maximize number of 0s by
                                               // flipping a subarray
                                               class GFG {

                                                   // A Kadane's algorithm based solution to find maximum
                                                   // number of 0s by flipping a subarray.
                                                   public static int findMaxZeroCount(int arr[], int n)
                                                   {
                                                       // Initialize count of zeros and maximum difference
                                                       // between count of 1s and 0s in a subarray
                                                       int orig_zero_count = 0;

                                                       // Initiale overall max diff for any subarray
                                                       int max_diff = 0;

                                                       // Initialize current diff
                                                       int curr_max = 0;

                                                       for (int i = 0; i < n; i ++)
                                                       {
                                                           // Count of zeros in original array (Not related
                                                           // to Kadane's algorithm)
                                                           if (arr[i] == 0)
                                                               orig_zero_count ++;

                                                           // Value to be considered for finding maximum sum
                                                           int val = (arr[i] == 1)? 1 : -1;

                                                           // Update current max and max_diff
                                                           curr_max = Math.max(val, curr_max + val);
                                                           max_diff = Math.max(max_diff, curr_max);
                                                       }
                                                       max_diff = Math.max(0, max_diff);

                                                       return orig_zero_count + max_diff;
                                                   }

                                                   *//* Driver program to test above function *//*
                                                                                                                                                   public static void main(String[] args)
                                                                                                                                                   {

                                                                                                                                                       System.out.println(findMaxZeroCount(arr, arr.length));
                                                                                                                                                   }
                                                                                                                                               }
                                                                                                                                               // This code is contributed by Arnav Kr. Mandal.
                                                                                                                                               Output
                                                                                                                                               6
                                                                                                                                               Time Complexity: O(n)

                                                                                                                                               Auxiliary Space: O(1)

                                                                                                                                               As constant extra space is used.*/
