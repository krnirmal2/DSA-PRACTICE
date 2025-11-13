package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.I_BASIC_HEAP_OPERATION;

import static StandardProblemDSA.VIIII_HEAP.HeapUtility.printHeap;

import StandardProblemDSA.VIIII_HEAP.HeapUtility;

public class HeapSort {

  // Main function to sort an array using Heap Sort
  static void heapSort(int[] arr) {
    int n = arr.length;

    // Step 1: Build a Max Heap
    for (int i = n / 2 - 1; i >= 0; i--) {
      HeapUtility.heapifyTopToBottom(arr, n, i);
    }

    // Step 2: Extract elements from the heap
    for (int i = n - 1; i > 0; i--) {
      // Swap the root (largest) with the last element
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // Heapify the reduced heap
      HeapUtility.heapifyTopToBottom(arr, i, 0);
    }
  }

  // Main function to test the Heap Sort algorithm
  public static void main(String[] args) {
    int[] arr = {12, 11, 13, 5, 6, 7};

    System.out.println("Original array:");
    printHeap(arr, arr.length);

    heapSort(arr);

    System.out.println("Sorted array:");
    printHeap(arr, arr.length);
  }
}
