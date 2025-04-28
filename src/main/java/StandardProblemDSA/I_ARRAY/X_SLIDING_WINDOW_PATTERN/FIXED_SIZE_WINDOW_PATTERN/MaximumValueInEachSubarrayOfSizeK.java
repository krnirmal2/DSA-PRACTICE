package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumValueInEachSubarrayOfSizeK {
  /*⚡
         🚀 Optimal Approach (Deque / Sliding Window Max)
  1️⃣   Initialize Deque<Integer> dq to store indices (not values).
  2️⃣   Initialize result = [].
  3️⃣   Loop i from 0 to n - 1:
  4️⃣emove indices out of current window → while !dq.isEmpty() and dq.peekFirst() <= i - k → dq.pollFirst().
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
    // Actully we can't remove the element from the array itself that is the problem
    // so for that we taking help of deque as it only help to enques and deque from both the end

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

  public static void main(String[] args) {
    int n = 8;
    List<Integer> r = new ArrayList<>(List.of(1, 3, -1, -3, 5, 3, 6, 7));
    int k = 3;
    // Convert List<Integer> to int[]
    int[] arr = new int[r.size()];
    for (int i = 0; i < r.size(); i++) {
      arr[i] = r.get(i);
    }

    // Now call the function
    int[] result = maxSlidingWindow(arr, k);
  }

  /*i	arr[i]	deque (indices)	deque (values)	action	result[]
  0	1	[0]	[1]	Insert 0
  1	3	[1]	[3]	Remove 0 (1 < 3), Insert 1
  2	-1	[1, 2]	[3, -1]	Insert 2	[3]
  3	-3	[1, 2, 3]	[3, -1, -3]	Insert 3	[3, 3]
  4	5	[4]	[5]	Remove 3 (-3 < 5), Remove 2 (-1 < 5), Remove 1 (3 < 5), Insert 4	[3, 3, 5]
  5	3	[4, 5]	[5, 3]	Insert 5	[3, 3, 5, 5]
  6	6	[6]	[6]	Remove 5 (3 < 6), Remove 4 (5 < 6), Insert 6	[3, 3, 5, 5, 6]
  7	7	[7]	[7]	Remove 6 (6 < 7), Insert 7	[3, 3, 5, 5, 6, 7]*/
}
