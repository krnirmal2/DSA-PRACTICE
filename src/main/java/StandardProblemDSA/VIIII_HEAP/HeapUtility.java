package StandardProblemDSA.VIIII_HEAP;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapUtility {

  // To heapify a subtree rooted with node i which is
  // an index in arr[].Nn is size of heap
  public static void heapifyTopToBottom(int[] arr, int N, int i) {
    int rootAti = i; // Initialize rootAti as root
    int leftChild = 2 * i + 1; // left = 2*i + 1
    int rightChild = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (leftChild < N && arr[leftChild] > arr[rootAti]) rootAti = leftChild;

    // If right child is larger than rootAti so far
    if (rightChild < N && arr[rightChild] > arr[rootAti]) rootAti = rightChild;

    // If rootAti is not root
    if (rootAti != i) {
      swap(arr, i, rootAti);
      // Recursively heapify the affected sub-tree
      heapifyTopToBottom(arr, N, rootAti);
    }
  }

  public static void heapifyBottomUpApproach(int[] arr, int capacity, int elementAti) {
    // we need to check if the element at i is less or greater than its parent
    // left = 2*parent+1  => parent = (left -1)/2
    int parent = (elementAti - 1) / 2;
    // we got the elemeent parent by the formula ChileElementIndexAti - 1 and divide the result by 2
    if (parent >= 0) {
      if (arr[elementAti] > arr[parent]) {
        // we will recursivly call the function bottom to up with parent till we are not satisfy
        // heap property
        // swaping by temp variable
        swap(arr, elementAti, parent);
        // recursisvly apply heapify
        heapifyBottomUpApproach(arr, capacity, parent);
      }
    }
  }

  // K Largest Elements using Min Heap
  public static List<Integer> findKLargestElements(int[] arr, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k); // natural order: smallest at top
    kElemenentInHeap(arr, k, minHeap);
    return new ArrayList<>(minHeap);
  }

  public static PriorityQueue<Integer> kElemenentInHeap(
      int[] arr, int k, PriorityQueue<Integer> minHeap) {
    // iterate over the element in the infinite array
    for (int num : arr) {
      // if the minheap size less than k then insert the element
      if (minHeap.size() < k) {
        minHeap.offer(num);
      } else if (num
          > minHeap
              .peek()) { // else check if the num is greater than priority peak then remove peek and
        // insert the no
        minHeap.poll();
        minHeap.offer(num);
      }
    }
    return minHeap;
  }

  // K Smallest Elements using Max Heap
  public List<Integer> findKSmallestElements(int[] arr, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // largest at top
    for (int num : arr) {
      if (maxHeap.size() < k) {
        maxHeap.offer(num);
      } else if (num < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(num);
      }
    }
    return new ArrayList<>(maxHeap);
  }

  private static void swap(int[] arr, int i, int rootAti) {
    int swap = arr[i];
    arr[i] = arr[rootAti];
    arr[rootAti] = swap;
  }

  // A utility function to print the array
  // representation of Heap
  public static void printHeap(int[] arr, int N) {
    System.out.println("Array representation of Heap is:");

    for (int i = 0; i < N; ++i) System.out.print(arr[i] + " ");

    System.out.println();
  }
}
