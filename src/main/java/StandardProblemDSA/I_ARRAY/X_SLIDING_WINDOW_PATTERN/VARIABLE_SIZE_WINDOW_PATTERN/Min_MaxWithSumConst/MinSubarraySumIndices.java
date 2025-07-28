package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.Min_MaxWithSumConst;

import java.util.Arrays;

public class MinSubarraySumIndices {
  /*
  -----------------------------------------------------------------------------------
  📌 Question (Modified Version of Mini Subarray Length of Sum ≥ K)
  -----------------------------------------------------------------------------------
  "Given an array of positive integers `A` and a target sum `B`,
   find the **start and end indices** of the first contiguous subarray
   whose sum equals exactly `B` and whose length is minimum."

  If multiple such subarrays exist, return the one that appears **first** (from left).
  If no such subarray exists, return [-1].

  Example 1:
  Input: A = [1, 2, 3, 1, 1, 1, 1], B = 3
  Output: [1, 2]
  Explanation: Subarray A[1..2] = [2, 1] has sum 3, and length 2.

  Example 2:
  Input: A = [1, 2, 1, 1, 1], B = 4
  Output: [1, 3]

  Example 3:
  Input: A = [1, 1, 1, 1], B = 5
  Output: [-1]

  -----------------------------------------------------------------------------------
  🧠 Pattern Used: Sliding Window (Variable Size Window)
  -----------------------------------------------------------------------------------
  - We are given positive integers only → this allows us to use sliding window.
  - Maintain a dynamic window from `left` to `right` that tracks `currentSum`.
  - Expand right to grow the window when sum < B.
  - Shrink from left when sum ≥ B.
  - Whenever sum == B, check and update the minimum length.

  Key Trick:
  ✔️ Use two pointers (`left`, `right`)
  ✔️ Maintain a variable `minLen` to store the shortest valid window
  ✔️ Save `first` and `second` index positions when updating `minLen`

  Loop Condition Detail:
  🧠 `while (right < A.length || (sum >= B && left < A.length))`
  - Because shrinking logic should continue **even after** right has reached the end
  - We must shrink left side to check all minimal length combinations

  -----------------------------------------------------------------------------------
  📦 Time and Space Complexity
  -----------------------------------------------------------------------------------
  Time Complexity: O(N)
  - Each element is visited at most twice (once added, once removed)

  Space Complexity: O(1)
  - Only a few integers and index markers used

  -----------------------------------------------------------------------------------
  🔁 Similar Variants / Follow-up Problems
  -----------------------------------------------------------------------------------
  1️⃣ Leetcode 209 – Minimum Size Subarray Sum (sum ≥ target, return min length)
  2️⃣ Leetcode 76 – Minimum Window Substring (string version with constraints)
  3️⃣ If elements can be negative, sliding window no longer works → use prefix sum + map.

  -----------------------------------------------------------------------------------
  💬 Follow-up Interview Questions
  -----------------------------------------------------------------------------------
  1. What if negative numbers are present in the array?
     🔸 Can't use sliding window → fallback to prefix sum with hashmap.

  2. What if we want the **longest subarray** instead of the shortest?
     🔸 Use max length update logic.

  3. Can this be done for sum ≤ B instead of sum == B?
     🔸 Use cumulative sum with variant logic.

  4. How would you return the actual subarray, not just indices?
     🔸 Extract `A[first..second]` once found.
  */

  public static int[] solve(int[] A, int B) {
    /* this is modification of MiniSubArrayLengthOfSumK , by adding first and second and change Math.min with manual
        condition check
        int minLength = Integer.MAX_VALUE;
    int sum = 0;
    int left = 0, right = 0;
    int first = -1, second = -1;

    while (right < arr.length || (sum >= target && left < arr.length)) {//Loop condition (while (left < arr.length)) is insufficient.
    //This may exit prematurely if right < arr.length and you're still building up the sum.
      if (sum >= target) {
        if (right - left < minLength) {
          minLength = right - left;
          first = left;
          second = right - 1;
        }
        sum -= arr[left];
        left++;
      } else {
        if (right < arr.length) {
          sum += arr[right];
          right++;
        } else {
          break;
        }
      }
    }

    if (first != -1 && second != -1) {
      System.out.println("First Index: " + first + ", Last Index: " + second);
      System.out.println("Length: " + minLength);
    } else {
      System.out.println("No valid window found.");
    }
    */
    /*Question:

    You are given an array of positive integers A and a target integer B.
     Your task is to find the starting and ending indices (inclusive) of the first contiguous
     subarray within A whose sum is equal to B and has the minimum length.
     If multiple such subarrays exist with the same minimum length,
      you should return the indices of the one that appears earliest in the array
       (i.e., has the smallest starting index). If no such subarray exists, return an array containing
       only -1.

    Time and Space Complexity Analysis:*/
    int n = A.length;
    int minLen = Integer.MAX_VALUE; // Initialize minimum length to maximum possible value
    int start = -1; // Initialize start index of the result
    int end = -1; // Initialize end index of the result
    int currentSum = 0; // Initialize the sum of the current window
    int windowStart = 0; // Initialize the starting index of the current window
    /*Time Complexity: O(N)

    The windowEnd pointer iterates through the array A at most once (O(N)).
    The windowStart pointer also moves forward at most N times in total (because it never goes backward).
    Therefore, the overall time complexity of the solve function is linear, O(N), where N is the length of the input array A.*/
    // Iterate through the array using the end of the sliding window
    for (int windowEnd = 0; windowEnd < n; windowEnd++) {
      // Step1. Expanding phase
      currentSum += A[windowEnd]; // Expand the window by adding the current element

      // Step 2 : Shrink the window from the left if the current sum exceeds the target
      while (currentSum > B) {
        currentSum -= A[windowStart];
        windowStart++;
      }

      // step 3:  If the current window sum equals the target
      if (currentSum == B) {
        int currentLen = windowEnd - windowStart + 1; // Calculate the length of the current window
        // If the current length is smaller than the minimum length found so far
        if (currentLen < minLen) {
          minLen = currentLen; // Update the minimum length
          start = windowStart; // Update the start index of the result
          end = windowEnd; // Update the end index of the result
        }
      }
    }

    // If a subarray with sum B was found, return its start and end indices
    if (start != -1) {
      return new int[] {start, end};
    } else {
      // If no such subarray was found, return [-1]
      return new int[] {-1};
    }
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5};
    int B = 5;
    int[] result = solve(A, B);
    System.out.println(Arrays.toString(result)); // Output: [0, 1]

    int[] A2 = {1, 2, 1, 2, 1};
    int B2 = 3;
    int[] result2 = solve(A2, B2);
    System.out.println(Arrays.toString(result2)); // Output: [0, 2]

    int[] A3 = {5, 1, 2, 3};
    int B3 = 5;
    int[] result3 = solve(A3, B3);
    System.out.println(Arrays.toString(result3)); // Output: [0, 0]

    int[] A4 = {1, 2, 3, 4, 5};
    int B4 = 15;
    int[] result4 = solve(A4, B4);
    System.out.println(Arrays.toString(result4)); // Output: [0, 4]

    int[] A5 = {1, 2, 3, 4, 5};
    int B5 = 16;
    int[] result5 = solve(A5, B5);
    System.out.println(Arrays.toString(result5)); // Output: [-1]
  }
}
