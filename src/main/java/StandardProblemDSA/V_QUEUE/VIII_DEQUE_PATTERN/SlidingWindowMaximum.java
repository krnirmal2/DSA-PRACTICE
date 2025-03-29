package StandardProblemDSA.V_QUEUE.VIII_DEQUE_PATTERN;

import java.util.*;

public class SlidingWindowMaximum {
  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || k <= 0) return new int[0];

    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      // Remove elements out of current window
      while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }

      // Remove elements smaller than current element (they won't be needed)
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }

      // Add current element index
      deque.offerLast(i);

      // Store max for window
      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peekFirst()];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    // Output: [3, 3, 5, 5, 6, 7]
  }
}
