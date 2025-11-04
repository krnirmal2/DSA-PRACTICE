package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.Min_MaxWithSumConst;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarrayEasy {
  /*
  ------------------------------------------------------
  Question (Interviewer-style)
  ------------------------------------------------------
  "Given an array A of positive integers and an integer B,
   find the maximum possible sum of a contiguous subarray
   such that the sum is less than or equal to B."

  Example:
  Input:
    A = [2, 1, 3, 4, 5], B = 12
  Output:
    12
  Explanation:
    The subarray [2, 1, 3, 4, 2] gives the maximum sum ≤ 12.

  Constraints:
  - 1 <= A <= 10^5  (array size)
  - 1 <= B <= 10^9
  - 1 <= C[i] <= 10^3

  ------------------------------------------------------
  Pattern
  ------------------------------------------------------
  Pattern Name: Variable Size Sliding Window (Positive Integers Only)
  - Since all numbers are positive, we can use a sliding window.
  - Expand the window by adding elements to the sum.
  - If the sum exceeds B, shrink the window from the left.
  - Track the maximum sum ≤ B during traversal.

  ------------------------------------------------------
  Approach Explanation
  ------------------------------------------------------
  1. Initialize:
     - i = 0 (window start), j = 0 (window end), sum = 0, max = 0.
  2. Expand window:
     - While sum + C[j] ≤ B, add C[j] to sum, update max, and move j forward.
  3. Shrink window:
     - If sum + C[j] > B, subtract C[i] and move i forward until sum ≤ B.
  4. Edge case:
     - If a single element C[j] > B, skip it by moving both i and j forward and resetting sum.
  5. Continue until j reaches the end.

  ------------------------------------------------------
  Follow-up Questions
  ------------------------------------------------------
  1. What if the array contains negative numbers?
     - Sliding window breaks; need prefix sums + TreeSet (or binary search) for O(n log n) solution.
  2. How to find the actual subarray instead of just the sum?
     - Track start and end indices when updating max.
  3. Can this be extended to find "sum closest to B but not exceeding" in any integer array?
     - Yes, use prefix sums + ordered map to handle negative numbers.

  ------------------------------------------------------
  Similar LeetCode Problems
  ------------------------------------------------------
  - LeetCode 209 – Minimum Size Subarray Sum (reverse logic, ≥ target) DONE
  - LeetCode 325 – Maximum Size Subarray Sum Equals k (prefix sum)
  - LeetCode 560 – Subarray Sum Equals K

  ------------------------------------------------------
  Time & Space Complexity
  ------------------------------------------------------
  - Time: O(n) – each element is processed at most twice.
  - Space: O(1) – constant extra space.
  */

  public static int maxSubarray(int B, ArrayList<Integer> C) {
    int i = 0, j = 0, sum = 0, max = 0;
    while (j < C.size()) {
      // Step 1:Expanding the window till we not
      if (sum + C.get(j) <= B) {
        // safe to include C[j]
        sum += C.get(j);
        max = Math.max(max, sum);
        j++;
      } else if (i < j) {
        // Step 2: shrink from left until it fits
        sum -= C.get(i);
        i++;
      } else {
        // Step 3: if condition satisfy
        // i == j and C[j] alone > B: skip this element
        i++;
        j++;
        sum = 0;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>(List.of(2, 1, 3, 4, 5));
    maxSubarray(12, a);
  }
}
