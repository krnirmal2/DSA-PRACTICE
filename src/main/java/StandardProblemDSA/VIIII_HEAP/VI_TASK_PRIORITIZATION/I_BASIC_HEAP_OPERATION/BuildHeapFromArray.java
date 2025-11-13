package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.I_BASIC_HEAP_OPERATION;

import StandardProblemDSA.VIIII_HEAP.HeapUtility;

public class BuildHeapFromArray {
  /*Case 1: Inserting elements one by one (using offer() or add())
  Each insertion into a heap takes O(log n) (heapify-up).
  So, inserting n elements one by one takes:
  🔸 Total Time = O(n log n)
  🔹 Case 2: Heapify all at once (using heapify() or constructor in Java)*/

  // Function to build a Max-Heap from the Array
  static void buildHeap(int[] arr, int N) {
    // Index of last non-leaf node
    // 🔑 Why start from n/2 - 1?
    // 👉 Because nodes from n/2 to n-1 are all leaf nodes.
    // Leaves are already heaps (a single node is trivially a heap).
    // Only non-leaf nodes can violate the heap property (because they have children).
    // So, we only need to call heapify() on internal nodes, starting from the last non-leaf node,
    // which is at index n/2 - 1.
    int startIdx = (N / 2) - 1;

    // Perform reverse level order traversal
    // from last non-leaf node and heapify
    // each node
    for (int i = startIdx; i >= 0; i--) {
      HeapUtility.heapifyTopToBottom(arr, N, i);
    }
  }

  // Driver Code
  public static void main(String[] args) {
    // Binary Tree Representation
    // of input array
    //            1
    //         /      \
    //       3        5
    //     /   \       / \
    //  4       6  13 10
    // / \    /  \
    // 9  8  15   17
    int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
    int N = arr.length;

    buildHeap(arr, N);
    HeapUtility.printHeap(arr, N);
  }
}
