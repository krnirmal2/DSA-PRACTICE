package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumValueInEachSubarrayOfSizeK {
  /*
  Question:
  Given an array arr[] and an integer k, find the maximum element in every contiguous subarray of size k.

  Example:
  Input:  arr = [1,3,-1,-3,5,3,6,7], k = 3
  Output: [3,3,5,5,6,7]
  Explanation:
  - Windows: [1,3,-1] → 3, [3,-1,-3] → 3, [ -1,-3,5] → 5, ...

  Approach:
  1. **Brute Force**:
     - For each window, scan all k elements and find max.
     - Time: O(n*k).

  2. **Optimal (Deque / Sliding Window Max)**:
     - Maintain a deque of indices storing elements in decreasing order.
     - Before adding a new element, remove all elements smaller than it (from the back).
     - Remove indices that fall outside the current window (from the front).
     - The front of the deque always holds the index of the largest element for the current window.
     - Time: O(n), as each index is added and removed at most once.

  Pattern:
  - Fixed-size sliding window + deque for max retrieval.

  Time Complexity:
  - O(n).

  Space Complexity:
  - O(k) for deque, plus O(n-k+1) for result.

  Follow-up Questions:
  1. How would you modify the code to get the minimum in each window?
  2. What happens if k > n or k = 1?
  3. Can this be extended to dynamic window sizes?

  Similar LeetCode/Interview Problems:
  - LeetCode 239. Sliding Window Maximum.
  - Variation: Sliding Window Minimum (just reverse comparison sign).
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
      // CASE 1: EXPAND WINDOW
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

  /*
  i	arr[i]	deque (indices)	deque (values)	action	result[]
  0	  1	    [0]	[1]	Insert 0
  1	  3	    [1]	[3]	Remove 0 (1 < 3), Insert 1
  2	  -1	[1, 2]	[3, -1]	Insert 2	[3]
  3	  -3	[1, 2, 3]	[3, -1, -3]	Insert 3	[3, 3]
  4	  5	    [4]	[5]	Remove 3 (-3 < 5), Remove 2 (-1 < 5), Remove 1 (3 < 5), Insert 4	[3, 3, 5]
  5	  3	    [4, 5]	[5, 3]	Insert 5	[3, 3, 5, 5]
  6	  6	    [6]	[6]	Remove 5 (3 < 6), Remove 4 (5 < 6), Insert 6	[3, 3, 5, 5, 6]
  7	  7	    [7]	[7]	Remove 6 (6 < 7), Insert 7	[3, 3, 5, 5, 6, 7]*/
}
