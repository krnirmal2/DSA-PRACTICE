package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.III_TOP_K_AND_BOTTOM_K_PATTERN;

import java.util.*;

public class KSelectionOperations {

  // ---------------------------------------------------
  // 1. Find the K Largest/Smallest Elements in an Array (Min/Max Heap)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given an unsorted array, find the K largest or K smallest elements.

    Brute Force Approach:
       - Sort the entire array and then pick the first/last K elements.
       - Time Complexity: O(n log n)

    Optimal Approach:
       - For K largest: Use a min-heap (priority queue) of size K.
         Iterate through the array; if the current element is greater than the heap's top,
         remove the top and add the new element.
       - For K smallest: Use a max-heap similarly.
       - Time Complexity: O(n log k)

    Example:
       Input: arr = [3, 1, 5, 12, 2, 11], k = 3
       Output for largest: [5, 11, 12] (order not necessarily sorted)
  */

  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

  // Similarly, a KthSmallestStream can be implemented using a max-heap.
  //  class TreeNode {
  //    int val;
  //    TreeNode left, right;
  //
  //    TreeNode(int x) {
  //      val = x;
  //      left = right = null;
  //    }
  //  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    /*KSelectionOperations ops = new KSelectionOperations();

    // 1. Find K Largest/Smallest Elements in an Array
    int[] arr = {3, 1, 5, 12, 2, 11};
    int k = 3;
    List<Integer> kLargest = ops.findKLargestElements(arr, k);
    System.out.println(
        "K Largest Elements: " + kLargest); // Example: [5, 11, 12] (order not guaranteed)

    List<Integer> kSmallest = ops.findKSmallestElements(arr, k);
    System.out.println("K Smallest Elements: " + kSmallest); // Example: [1, 2, 3]

    // 2. Kth Largest Element in a Stream
    int[] initialStream = {4, 5, 8, 2};
    KthLargestStream kthStream = ops.new KthLargestStream(3, initialStream);
    System.out.println("Initial kth largest in stream: " + kthStream.kthLargest()); // Expected: 4
    kthStream.add(3);
    System.out.println("After adding 3, kth largest in stream: " + kthStream.kthLargest());

    // 3. Top K Frequent Elements in an Array
    int[] freqArr = {1, 1, 1, 2, 2, 3};
    List<Integer> topKFreq = TopKFrequentElement.topKFrequent(freqArr, 2);
    System.out.println("Top K Frequent Elements: " + topKFreq); // Expected: [1, 2]

    // 4. Kth Largest Element in a BST
    // Build BST manually:
    //        5
    //       / \
    //      3   7
    //     / \   \
    //    2   4   8
    TreeNode root = ops.new TreeNode(5);
    root.left = ops.new TreeNode(3);
    root.right = ops.new TreeNode(7);
    root.left.left = ops.new TreeNode(2);
    root.left.right = ops.new TreeNode(4);
    root.right.right = ops.new TreeNode(8);*/
    //    int kthLargestBST = (root, 2);
    //    System.out.println("2nd Largest Element in BST: " + kthLargestBST); // Expected: 7
  }
}
