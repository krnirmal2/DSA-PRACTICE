package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.IV_MEDIAN_TRACKING;

import java.util.*;

public class MedianInSortedArrays {
  /* 💡 Core Idea:
  We simulate the process of merging both arrays into a single sorted stream and at each step, we maintain the two heaps such that:
  maxHeap contains the smaller half of numbers.
  minHeap contains the larger half.
  We ensure the size of maxHeap is equal to or 1 more than minHeap.
  This balance allows us to get the median in constant time.*/
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // left
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // right

    for (int num : nums1) {
      addNumber(num, maxHeap, minHeap);
    }
    for (int num : nums2) {
      addNumber(num, maxHeap, minHeap);
    }

    // Now get the median from the balanced heaps
    /*  🔍 Final Step (Get the Median):
    If both heaps are equal in size → median = (maxHeap.peek() + minHeap.peek()) / 2.0
    If maxHeap is larger → median = maxHeap.peek()*/
    if (maxHeap.size() == minHeap.size()) {
      return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    } else {
      return maxHeap.peek(); // maxHeap always has more if odd
    }
  }

  private void addNumber(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
    /*2. Insert Elements One by One:
    From both arrays (nums1 and nums2), insert elements one by one using the helper method addNumber(num):
    Inside addNumber(num):
    If maxHeap is empty or num <= maxHeap.peek(), push into maxHeap.
    Else push into minHeap.*/
    if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
      maxHeap.offer(num);
    } else {
      minHeap.offer(num);
    }

    // 3. Balance the Heaps:
    // If maxHeap.size() > minHeap.size() + 1 → move top from maxHeap to minHeap.
    // If minHeap.size() > maxHeap.size() → move top from minHeap to maxHeap.
    // Ensures size difference is at most 1.
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.offer(maxHeap.poll());
    }

    if (minHeap.size() > maxHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
  }

  /*      | Step | Inserted Number | Action Taken             | `maxHeap` (left side) | `minHeap` (right side) | Balancing Performed? |
            | ---- | --------------- | ------------------------ | --------------------- | ---------------------- | -------------------- |
            | 1    | 1               | Add to `maxHeap` (empty) | [1]                  | []                    | ❌                    |
            | 2    | 2               | Add to `minHeap`         | [1]                  | [2]                   | ❌                    |
            | 3    | 3               | Add to `minHeap`         | [1]                  | [2, 3]                | ✅ Move 2 → `maxHeap` |
            |      |                 | After balance            | [2, 1]               | [3]                   |                      |
            | 4    | 4               | Add to `minHeap`         | [2, 1]               | [3, 4]                | ❌                    |
            | 5    | 5               | Add to `minHeap`         | [2, 1]               | [3, 4, 5]             | ✅ Move 3 → `maxHeap` |
            |      |                 | After balance            | [3, 1, 2]            | [4, 5]                |                      |
            | 6    | 6               | Add to `minHeap`         | [3, 1, 2]            | [4, 5, 6]             | ✅ Move 4 → `maxHeap` |
  */
  public static void main(String[] args) {
    MedianInSortedArrays finder = new MedianInSortedArrays();
    int[] nums1 = {1, 2, 3};
    int[] nums2 = {4, 5, 6};
    System.out.println("Median: " + finder.findMedianSortedArrays(nums1, nums2)); // Output: 2.0
  }
}
