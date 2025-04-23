package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.IV_MEDIAN_TRACKING;

import java.util.*;

public class TwoHeapsMedianSolutions {

  // ============================================================
  // Main method for demonstration.
  // ============================================================
  public static void main(String[] args) {
    // Part 1: Data Stream Median Finder
    System.out.println("----- Data Stream Median Finder -----");
    MedianFinder mf = new MedianFinder();
    int[] stream = {1, 5, 2, 10, 3};
    for (int num : stream) {
      mf.addNum(num);
      System.out.println("Added: " + num + ", current median: " + mf.findMedian());
    }
    // Expected medians:
    // After 1 -> 1.0, after 5 -> 3.0, after 2 -> 2.0, after 10 -> 3.5, after 3 -> 3.0

    // Part 2: Sliding Window Median
    System.out.println("\n----- Sliding Window Median -----");
    int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    SlidingWindowMedian swm = new SlidingWindowMedian();
    List<Double> medians = new ArrayList<>();

    // Initialize first window.
    for (int i = 0; i < k; i++) {
      swm.addNum(arr[i]);
    }
    medians.add(swm.getMedian());
    // Slide the window.
    for (int i = k; i < arr.length; i++) {
      swm.addNum(arr[i]);
      swm.removeNum(arr[i - k]);
      medians.add(swm.getMedian());
    }
    System.out.println("Sliding window medians: " + medians);
    // Expected output for the example: [1.0, -1.0, -1.0, 3.0, 5.0, 6.0] (may vary based on input)
  }

  // ============================================================
  // Part 1: Median Finder for a Data Stream Using Two Heaps
  // ============================================================
  /*
    Problem Statement:
       Design a data structure that supports adding numbers from a data stream
       and can return the median of all numbers seen so far.

    Brute Force Approach:
       - Store numbers in a list and sort it every time a median is needed (O(n log n)).

    Optimal Approach:
       - Use two heaps:
           * A max-heap (leftHeap) for the lower half.
           * A min-heap (rightHeap) for the upper half.
       - Maintain the invariant that the sizes differ at most by 1.
       - The median is the top of the heap that is larger (or the average if sizes are equal).
       - Insertion is O(log n), median query is O(1).

    Example:
       Data stream: [1, 5, 2, 10, 3]
       Medians evolve as: 1.0, 3.0, 2.0, 3.5, 3.0.
  */
  public static class MedianFinder {
    private PriorityQueue<Integer> leftHeap; // Max-heap for lower half
    private PriorityQueue<Integer> rightHeap; // Min-heap for upper half

    public MedianFinder() {
      leftHeap = new PriorityQueue<>(Collections.reverseOrder());
      rightHeap = new PriorityQueue<>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
      // Add to max-heap by default.
      if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
        leftHeap.offer(num);
      } else {
        rightHeap.offer(num);
      }
      // Rebalance the heaps if necessary.
      if (leftHeap.size() > rightHeap.size() + 1) {
        rightHeap.offer(leftHeap.poll());
      } else if (rightHeap.size() > leftHeap.size() + 1) {
        leftHeap.offer(rightHeap.poll());
      }
    }

    // Returns the median of all elements so far.
    public double findMedian() {
      if (leftHeap.size() == rightHeap.size()) {
        if (leftHeap.isEmpty()) {
          return 0.0;
        }
        return (leftHeap.peek() + rightHeap.peek()) / 2.0;
      } else if (leftHeap.size() > rightHeap.size()) {
        return leftHeap.peek();
      } else {
        return rightHeap.peek();
      }
    }
  }

  // ============================================================
  // Part 2: Dynamic Median Calculation in a Sliding Window
  // ============================================================
  /*
    Problem Statement:
       Given an array (or stream) and a window size k, for each sliding window,
       find the median of the elements in the window.

    Brute Force Approach:
       - For each window, sort the k elements and then pick the median. (O(k log k) per window)

    Optimal Approach:
       - Use two heaps (as in MedianFinder) to maintain the current window's numbers.
       - To support removals (when the window slides), use lazy deletion.
       - A HashMap (delayed) tracks elements that should be removed from each heap.
       - Insertion and deletion operations are O(log k) on average.
       - Querying the median is O(1).

    Example:
       Input: arr = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
       Output medians: [1, -1, -1, 3, 5, 6]
  */
  public static class SlidingWindowMedian {
    // Max-heap for lower half, min-heap for upper half.
    private PriorityQueue<Integer> leftHeap;
    private PriorityQueue<Integer> rightHeap;
    // Map to store elements that are marked for lazy deletion.
    private Map<Integer, Integer> delayed;

    public SlidingWindowMedian() {
      leftHeap = new PriorityQueue<>(Collections.reverseOrder());
      rightHeap = new PriorityQueue<>();
      delayed = new HashMap<>();
    }

    // Add a number to the window.
    public void addNum(int num) {
      if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
        leftHeap.offer(num);
      } else {
        rightHeap.offer(num);
      }
      balanceHeaps();
    }

    // Remove a number from the window.
    public void removeNum(int num) {
      // Mark the number for lazy removal.
      delayed.put(num, delayed.getOrDefault(num, 0) + 1);
      // Adjust sizes implicitly by checking which heap contains num.
      if (!leftHeap.isEmpty() && num <= leftHeap.peek()) {
        // Decrement leftHeap size count.
        // Actual removal will happen when top elements are pruned.
        // (We don't maintain explicit sizes; heaps sizes include delayed items.)
        if (num == leftHeap.peek()) {
          prune(leftHeap);
        }
      } else {
        if (!rightHeap.isEmpty() && num == rightHeap.peek()) {
          prune(rightHeap);
        }
      }
      balanceHeaps();
    }

    // Rebalance the two heaps to ensure their sizes differ by at most 1.
    private void balanceHeaps() {
      // If one heap is larger by more than one element, move the top.
      if (leftHeap.size() > rightHeap.size() + 1) {
        rightHeap.offer(leftHeap.poll());
        prune(leftHeap);
      } else if (rightHeap.size() > leftHeap.size() + 1) {
        leftHeap.offer(rightHeap.poll());
        prune(rightHeap);
      }
    }

    // Prune the top of the heap if it is marked for deletion.
    private void prune(PriorityQueue<Integer> heap) {
      while (!heap.isEmpty()) {
        int num = heap.peek();
        if (delayed.containsKey(num)) {
          int count = delayed.get(num);
          if (count == 1) {
            delayed.remove(num);
          } else {
            delayed.put(num, count - 1);
          }
          heap.poll();
        } else {
          break;
        }
      }
    }

    // Returns the median of current window.
    public double getMedian() {
      prune(leftHeap);
      prune(rightHeap);
      if (leftHeap.size() == rightHeap.size()) {
        if (leftHeap.isEmpty()) {
          return 0.0;
        }
        return (leftHeap.peek() + rightHeap.peek()) / 2.0;
      } else if (leftHeap.size() > rightHeap.size()) {
        return leftHeap.peek();
      } else {
        return rightHeap.peek();
      }
    }
  }
}
