package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.I_BASIC_HEAP_OPERATION;

public class BuildHeapFromArray {
  // To heapify a subtree rooted with node i which is
  // an index in arr[].Nn is size of heap
  public static void heapifyBottomToTop(int[] arr, int N, int i) {
    int rootAti = i; // Initialize rootAti as root
    int leftChild = 2 * i + 1; // left = 2*i + 1
    int rightChild = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (leftChild < N && arr[leftChild] > arr[rootAti]) rootAti = leftChild;

    // If right child is larger than rootAti so far
    if (rightChild < N && arr[rightChild] > arr[rootAti]) rootAti = rightChild;

    // If rootAti is not root
    if (rootAti != i) {
      int swap = arr[i];
      arr[i] = arr[rootAti];
      arr[rootAti] = swap;

      // Recursively heapify the affected sub-tree
      heapifyBottomToTop(arr, N, rootAti);
    }
  }

  // Function to build a Max-Heap from the Array
  static void buildHeap(int[] arr, int N) {
    // Index of last non-leaf node
    int startIdx = (N / 2) - 1;

    // Perform reverse level order traversal
    // from last non-leaf node and heapify
    // each node
    for (int i = startIdx; i >= 0; i--) {
      heapifyBottomToTop(arr, N, i);
    }
  }

  // A utility function to print the array
  // representation of Heap
  static void printHeap(int[] arr, int N) {
    System.out.println("Array representation of Heap is:");

    for (int i = 0; i < N; ++i) System.out.print(arr[i] + " ");

    System.out.println();
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
    printHeap(arr, N);
  }
}
