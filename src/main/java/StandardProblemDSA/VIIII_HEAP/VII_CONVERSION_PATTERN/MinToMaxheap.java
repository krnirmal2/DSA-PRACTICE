package StandardProblemDSA.VIIII_HEAP.VII_CONVERSION_PATTERN;

/*Understanding The Problem
Problem Description

Given array representation of min Heap , write a program to convert it to max Heap . The expected time complexity is O(n).

Example

Input: A[] = [3 5 9 6 8 20 10 12 18 9]
        3
        /     \
        5       9
        /   \    /  \
        6     8  20   10
        /  \   /
        12   18 9
Output: A[] = [20 18 10 12 9 9 3 5 6 8] or any Max Heap formed from input elements*/
public class MinToMaxheap {
  /*Solution steps
  Convert the given array of elements into an almost complete binary tree.
  Ensure that the tree is a max heap.
  Check that every non-leaf node contains a greater or equal value element than its child nodes.
  If there exists any node that does not satisfy the ordering property of max heap, swap the elements.
  Start checking from a non-leaf node with the highest index (bottom to top and right to left).*/

  /* void MaxHeapify(int arr[], int i, int n)
  {
      left = 2*i + 1
      right = 2*i + 2
      largest = i
      if (left < n and arr[left] > arr[i])
      largest = left
      if (right < n and arr[right] > arr[largest])
      largest = right
      if (largest != i)
      {
          swap(arr[i], arr[largest])
          MaxHeapify(arr, largest, n)
      }
  }

  void convertMaxHeap(int arr[], int n)
  {
      // Start from bottommost and rightmost
      // internal mode and heapify all internal
      // modes in bottom up way
      for (int i = (n-2)/2 to i >= 0)
      MaxHeapify(arr, i, n)
  }*/
  //    https://afteracademy.com/blog/convert-a-min-heap-to-a-max-heap/
}
