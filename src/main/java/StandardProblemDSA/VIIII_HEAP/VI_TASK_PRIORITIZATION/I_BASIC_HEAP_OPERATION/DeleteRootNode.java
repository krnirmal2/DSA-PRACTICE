package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.I_BASIC_HEAP_OPERATION;

import static StandardProblemDSA.VIIII_HEAP.HeapUtility.printHeap;

import StandardProblemDSA.VIIII_HEAP.HeapUtility;

public class DeleteRootNode {

  // Function to delete the root from Heap
  static int deleteRoot(int[] arr, int n) {
    // Get the last element
    int lastElement = arr[n - 1];

    // Replace root with first element
    arr[0] = lastElement;

    // Decrease size of heap by 1
    n = n - 1;

    // heapify the root node from top
    HeapUtility.heapifyTopToBottom(arr, n, 0);

    // return new size of Heap
    return n;
  }

  // Driver Code
  public static void main(String[] args) {
    // Array representation of Max-Heap
    // 10
    //    /  \
    // 5    3
    //  / \
    // 2   4
    int[] arr = {10, 5, 3, 2, 4};

    int n = arr.length;

    n = deleteRoot(arr, n);

    printHeap(arr, n);
  }
}
