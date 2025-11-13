package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import StandardProblemDSA.Utility;
import java.util.Arrays;

/*
Question:
Implement the Merge Sort algorithm. Given an array of integers, sort it in ascending order
using the divide-and-conquer approach.

Approach:
1. Divide: Recursively split the array into two halves until each subarray has one element.
2. Conquer: Recursively sort the two halves.
3. Combine: Merge the two sorted halves into a single sorted array.
   - Use temporary arrays to hold each half.
   - Compare elements from both halves and copy the smaller one back into the original array.
   - Copy remaining elements, if any.

Pattern:
- Sorting Pattern using Divide & Conquer.
- Recursion-based approach.
- Stable sorting algorithm (preserves order of equal elements).

Time Complexity:
- Best, Average, Worst Case: O(n log n)
Space Complexity:
- O(n) due to temporary arrays used during merge.

Follow-up Questions:
1. Can we implement merge sort iteratively (bottom-up merge sort)?
2. Can we optimize space to O(1) (in-place merge sort)?
3. How does merge sort compare to quicksort for large datasets?
4. Can merge sort be used for linked lists? Why is it preferred over quicksort there?
5. Can we parallelize merge sort for faster execution?

Similar LeetCode Questions:
- LeetCode 912. Sort an Array
- LeetCode 148. Sort List (linked list version)
- LeetCode 493. Reverse Pairs (uses modified merge sort)
*/

public class MergeSort {

  // Function to merge two sorted subarrays
  static void merge(int[] arr, int left, int mid, int right) {
    // Sizes of two subarrays
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // Temporary arrays for the subarrays
    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    // Copy data to temporary arrays
    System.arraycopy(arr, left, leftArray, 0, n1);
    for (int i = 0; i < n2; i++) {
      rightArray[i] = arr[mid + 1 + i];
    }

    // Merge the temporary arrays
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
      if (leftArray[i] <= rightArray[j]) {
        arr[k] = leftArray[i];
        i++;
      } else {
        arr[k] = rightArray[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of leftArray, if any
    while (i < n1) {
      arr[k] = leftArray[i];
      i++;
      k++;
    }

    // Copy remaining elements of rightArray, if any
    while (j < n2) {
      arr[k] = rightArray[j];
      j++;
      k++;
    }
  }

  // Recursive function to sort the array
  static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      // Find the middle point
      int mid = left + (right - left) / 2;

      // Recursively sort the first and second halves
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);

      // Merge the sorted halves
      merge(arr, left, mid, right);

      // Print the array after each merge
      System.out.println("After merging: " + Arrays.toString(arr));
    }
  }

  public static void main(String[] args) {
    int[] arr = Utility.getUnsortedArray();
    System.out.println("Original Array: " + Arrays.toString(arr));
    mergeSort(arr, 0, arr.length - 1);
    System.out.println("Sorted Array: " + Arrays.toString(arr));
  }
}
