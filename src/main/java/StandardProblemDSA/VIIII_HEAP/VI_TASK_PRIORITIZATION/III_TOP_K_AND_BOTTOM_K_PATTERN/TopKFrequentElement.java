package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.III_TOP_K_AND_BOTTOM_K_PATTERN;

import java.util.*;

public class TopKFrequentElement {
  // ---------------------------------------------------
  // 3. Top K Frequent Elements in an Array
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given an array, return the K most frequent elements.

    Brute Force Approach:
       - Count frequencies, then sort the keys by frequency.
       - Time Complexity: O(n log n)

    Optimal Approach:
       - Use a HashMap to count frequencies.
       - Use a min-heap (size K) to keep track of the top K frequent elements.
       - Time Complexity: O(n log k)

    Example:
       Input: arr = [1,1,1,2,2,3], k = 2
       Output: [1, 2]
  */
  public static List<Integer> topKFrequent(int[] arr, int k) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : arr) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    // sort the map with the frequency of each element in decreasing order
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

    // iterate over the Map and check if the minheap size is less than k then we will add
    // other wise we check if the peek element value<  and current hasmap entry value then we will
    // poll the element from the minheap and  put the new map entry in the heap
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(entry);
      } else if (entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }

    List<Integer> result = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : minHeap) {
      result.add(entry.getKey());
    }
    return result;
  }
}
