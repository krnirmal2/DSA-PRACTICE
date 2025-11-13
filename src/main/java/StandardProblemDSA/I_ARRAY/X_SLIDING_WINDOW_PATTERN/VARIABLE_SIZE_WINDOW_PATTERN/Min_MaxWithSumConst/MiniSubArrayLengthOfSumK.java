package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.Min_MaxWithSumConst;

public class MiniSubArrayLengthOfSumK {
  /*
  ------------------------------------------------------
  Question (Interviewer-style)
  ------------------------------------------------------
  "Given an array of positive integers `arr` and a positive integer `target`,
   return the minimal length of a contiguous subarray of which the sum is greater
   than or equal to `target`.
   If there isn’t such a subarray, return 0."

  Example 1:
    Input: arr = [2,3,1,2,4,3], target = 7
    Output: 2
    Explanation: Subarray [4,3] has sum ≥ 7 and minimal length = 2.

  Example 2:
    Input: arr = [1,4,4], target = 4
    Output: 1

  Example 3:
    Input: arr = [1,1,1,1,1,1,1,1], target = 11
    Output: 0

  Constraints:
  - 1 <= arr.length <= 10^5
  - 1 <= arr[i] <= 10^4
  - 1 <= target <= 10^9

  ------------------------------------------------------
  Pattern
  ------------------------------------------------------
  Pattern Name: Sliding Window (Variable Size Window)
  - Used when we need to find the smallest or largest contiguous subarray
    meeting a sum or product condition.
  - Window expands when sum < target and shrinks when sum ≥ target.

  ------------------------------------------------------
  Approach Explanation
  ------------------------------------------------------
  1. Initialize two pointers `left = 0`, `right = 0` and `sum = 0`.
  2. Expand the window by adding elements from the right until `sum >= target`.
  3. Once the sum ≥ target:
     - Update `minLength = min(minLength, right - left)`.
     - Shrink the window from the left (subtract arr[left], move `left++`).
  4. Continue until the right pointer reaches the end of the array.
  5. If `minLength` was never updated, return 0.

  Key Insight:
  - All numbers are positive → window sum only increases when right moves
    and decreases when left moves, ensuring O(n) complexity.

  ------------------------------------------------------
  Follow-up Questions
  ------------------------------------------------------
  1. What if negative numbers are allowed in the array?
     - Sliding window no longer works reliably; prefix sums + binary search or
       two-pass methods are needed.
  2. What if we need to return the actual subarray?
     - Track start and end indices when updating `minLength`.
  3. Can this be adapted for "maximum length subarray with sum ≤ k"?
     - Yes, using a similar window but different conditions.

  ------------------------------------------------------
  Similar LeetCode Problems
  ------------------------------------------------------
  - LeetCode 209 – Minimum Size Subarray Sum (exact problem)
  - LeetCode 325 – Maximum Size Subarray Sum Equals k
  - LeetCode 713 – Subarray Product Less Than K

  ------------------------------------------------------
  Time & Space Complexity
  ------------------------------------------------------
  - Time: O(n) – each element is visited at most twice.
  - Space: O(1) – no extra data structures used.
  */

  public static int minSubArrayLen(int[] arr, int target) {
    int minLength = Integer.MAX_VALUE;
    int sum = 0;
    int left = 0;
    int right = 0;
    int first = 0, second = 0;
    while (left < arr.length) {
      if (sum >= target) {
        // store the current minimal length
        minLength = Math.min(minLength, (right - left));
        // shrink the window:
        // (1) subtract the value at left idx
        // (2) move the left panel one index further to the right
        sum -= arr[left];
        left++;
      } else if (sum < target && right < arr.length) {
        // expand the window:
        // (1) sum up the current value
        // (2) move the right panel one index further to the right
        sum += arr[right];
        right++;
      } else break;
    }

    return (minLength == Integer.MAX_VALUE ? 0 : minLength);
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 2, 4, 3};
    int target = 6;
    System.out.println(minSubArrayLen(arr, target));
  }
}
