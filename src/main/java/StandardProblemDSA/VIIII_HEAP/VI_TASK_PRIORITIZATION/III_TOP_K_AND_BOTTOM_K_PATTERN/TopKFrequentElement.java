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
/*

class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    // 1. Build frequency map
    Map<String, Integer> freq = new HashMap<>();
    for (String w : words) {
      freq.put(w, freq.getOrDefault(w, 0) + 1);
    }

    // 2. Use a priority queue (min-heap) keeping size k:
    PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
      int f1 = freq.get(w1);
      int f2 = freq.get(w2);
      if (f1 != f2) {
        // smaller frequency has higher priority to be removed first
        return f1 - f2;
      } else {
        // if same freq, we want lexicographically *larger* word to be removed first
        return w2.compareTo(w1);
      }
    });

    for (String word : freq.keySet()) {
      pq.offer(word);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    // 3. Build result list in reverse order of the heap
    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll());
    }
    Collections.reverse(result);
    return result;
  }
}
*/
