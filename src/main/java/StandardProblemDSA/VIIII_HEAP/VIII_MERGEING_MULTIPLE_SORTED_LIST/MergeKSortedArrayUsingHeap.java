package StandardProblemDSA.VIIII_HEAP.VIII_MERGEING_MULTIPLE_SORTED_LIST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrayUsingHeap {
  // Define the ListNode for the heap entries.
  static class Element {
    int value;
    int arrayIndex;
    int elementIndex;

    // Constructor to initialize element
    Element(int value, int arrayIndex, int elementIndex) {
      this.value = value;
      this.arrayIndex = arrayIndex;
      this.elementIndex = elementIndex;
    }
  }

  public List<Integer> mergeKSortedArrays(int[][] arrays) {
    // Min heap to store the first element of each array
    PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

    // Add the first element of each array to the priority queue
    for (int i = 0; i < arrays.length; i++) {
      if (arrays[i].length > 0) {
        pq.offer(new Element(arrays[i][0], i, 0));
      }
    }

    List<Integer> result = new ArrayList<>();

    // Process the priority queue until it's empty
    while (!pq.isEmpty()) {
      // Get the smallest element from the heap
      Element current = pq.poll();
      result.add(current.value);

      // If there is another element in the same array, add it to the heap
      if (current.elementIndex + 1 < arrays[current.arrayIndex].length) {
        pq.offer(
            new Element(
                arrays[current.arrayIndex][current.elementIndex + 1],
                current.arrayIndex,
                current.elementIndex + 1));
      }
    }

    return result;
  }

  public static void main(String[] args) {
    MergeKSortedArrayUsingHeap solution = new MergeKSortedArrayUsingHeap();
    int[][] arrays = {
      {1, 4, 7},
      {2, 5, 8},
      {3, 6, 9}
    };

    List<Integer> mergedList = solution.mergeKSortedArrays(arrays);
    System.out.println(mergedList); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
  }
}
