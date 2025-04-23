package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumValueInSubarrayOfSizeK {
  /*⚡
         🚀 Optimal Approach (Deque / Sliding Window Max)
  1️⃣   Initialize Deque<Integer> dq to store indices (not values).
  2️⃣   Initialize result = [].
  3️⃣   Loop i from 0 to n - 1:
  4️⃣     Remove indices out of current window → while !dq.isEmpty() and dq.peekFirst() <= i - k → dq.pollFirst().
  5️⃣     Remove all smaller elements from back → while !dq.isEmpty() and arr[dq.peekLast()] < arr[i] → dq.pollLast().
  6️⃣     Add current index i to deque → dq.offerLast(i).
  7️⃣     If window has hit size k, add arr[dq.peekFirst()] to result.
  8️⃣   Return result.
  🕒   Time: O(n) 📦 Space: O(k) (for deque + output)
  */
  // ---------------------------------------------------
  // 2. Find Largest Element in Each Sliding Window
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given an array and a window size k, for each window (of size k), find the largest element.

    Brute Force Approach:
       - For each window, iterate over k elements to find the maximum.
       - Time Complexity: O(n*k)

    Optimal Approach:
       - Use a deque to maintain the indices of useful elements.
       - The deque always contains indices in decreasing order of values.
       - Time Complexity: O(n)

    Example:
       Input: arr = [1,3,-1,-3,5,3,6,7], k = 3
       Output: [3,3,5,5,6,7]
  */
  public static int[] maxSlidingWindow(int[] arr, int k) {
    if (arr == null || k <= 0) {
      return new int[0];
    }
    int n = arr.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      // Remove indices that are out of this window.
      if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }
      // Remove elements smaller than the current element.
      while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      // Starting index for result after we have a full window.
      if (i >= k - 1) {
        result[i - k + 1] = arr[deque.peekFirst()];
      }
    }
    return result;
  }
}
