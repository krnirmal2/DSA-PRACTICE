package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.III_TOP_K_AND_BOTTOM_K_PATTERN;

import java.util.PriorityQueue;

public class KthlargestElementInStream {
  // ---------------------------------------------------
  // 2. Kth Largest/Smallest Element in a Stream
  // ---------------------------------------------------
  /*
    Problem Statement:
       Design a data structure that continuously accepts numbers (a stream)
       and can return the kth largest (or kth smallest) element at any time.

    Brute Force Approach:
       - Store all elements in a list, sort when queried.
       - Time Complexity: O(n log n) per query.

    Optimal Approach:
       - Maintain a min-heap for kth largest (or max-heap for kth smallest)
         of fixed size k. When a new element comes, update the heap.
       - Time Complexity: O(log k) per insertion.

    Example:
       For kth largest stream: With k = 3, inserting [4, 5, 8, 2] yields kth largest = 4,
       and on inserting 3, kth largest becomes 4.
  */
  public class KthLargestStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestStream(int k, int[] initial) {
      this.k = k;
      minHeap = new PriorityQueue<>(k);
      for (int num : initial) {
        add(num);
      }
    }

    public int add(int num) {
      if (minHeap.size() < k) {
        minHeap.offer(num);
      } else if (num > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(num);
      }
      return minHeap.peek();
    }

    // Return kth largest element
    public int kthLargest() {
      return minHeap.peek();
    }
  }
}
