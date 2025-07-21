package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.Arrays;

public class InversionCount {
  /* 🔹 What is Inversion Count?
      An inversion in an array arr[] is a pair (i, j) such that:
      i < j and arr[i] > arr[j]
      It tells us how far the array is from being sorted.
      If the array is already sorted, the inversion count is 0.
      If the array is sorted in reverse order, the inversion count is maximum.
              🔹 Example
      Example 1

      Input:  arr[] = {1, 20, 6, 4, 5}
      Output: 5
      Explanation:
      The inversion pairs are:
              (20, 6), (20, 4), (20, 5), (6, 4), (6, 5)
      So, Inversion Count = 5.

  🔹 Approach: Merge Sort for Counting Inversions
      Step-by-Step Process
      Divide: Recursively divide the array into two halves.
              Conquer: Count inversions in the left half, the right half, and the merge step.
              Combine: While merging, count how many times an element from the right half
               moves before elements from the left half.*/
  public static int mergeSortAndCount(int[] arr, int left, int right) {
    // Head and tail both recursion is present  Recursion as statment call after recursion is being
    // done
    int count = 0;
    if (left < right) {
      int mid = (left + right) / 2;

      // Count inversions in the left half
      count += mergeSortAndCount(arr, left, mid);

      // Count inversions in the right half
      count += mergeSortAndCount(arr, mid + 1, right);

      // Merge both halves while counting inversions
      count += mergeAndCount(arr, left, mid, right);
    }
    return count;
  }

  private static int mergeAndCount(int[] arr, int left, int mid, int right) {
    int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
    int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
    int i = 0, j = 0, k = left, swaps = 0;
    /*   🔹 Simple Explanation of Inversion Counting in Merge Sort
            When merging two sorted halves, an inversion occurs
            when an element from the right subarray is smaller
            than an element from the left subarray.
    📌 Key Idea:
            If arr[i] > arr[j], then all elements after arr[i] in the left subarray are also
             greater than arr[j] (since the left half is sorted).
    🔹 Simple Understanding Without Formula
            If left element (arr[i]) is smaller → No inversion, move i forward.
            If right element (arr[j]) is smaller →
            It forms an inversion with all remaining elements in the left subarray.
            So, we count all elements left in the left subarray as inversions.
            Move j forward to continue merging.*/
    while (i < leftArr.length && j < rightArr.length) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
        swaps +=
            (leftArr.length - i); // All remaining elements in leftArr are greater than rightArr[j]
      }
    }

    // Copy remaining elements
    while (i < leftArr.length) arr[k++] = leftArr[i++];
    while (j < rightArr.length) arr[k++] = rightArr[j++];

    return swaps;
  }

  public static void main(String[] args) {
    int[] arr = {1, 20, 6, 4, 5};
    int count = mergeSortAndCount(arr, 0, arr.length - 1);
    System.out.println("Sorted Array: " + Arrays.toString(arr));
    System.out.println("Inversion Count: " + count);
  }
  /* 🔹 Dry Run for
  Step 1: Divide {1, 20, 6,    4, 5}
  Left: {1, 20, 6}
  Right: {4, 5}
  Left Part: Divide {1, 20, 6} into {1, 20} and {6}
  Right Part: Divide {4, 5} into {4} and {5}

  Step 2: Merge and Count
  Merge {1, 20} → {1, 20} (0 inversions)
  Merge {1, 20} and {6} → {1, 6, 20} (1 inversion: (20,6))

  Merge {4, 5} → {4, 5} (0 inversions)

  Merge {1, 6, 20} and {4, 5}

  (6,4), (6,5), (20,4), (20,5) → 4 inversions

  Total Inversion Count = 5

          🔹 Time & Space Complexity
  Step	Complexity
  Merge Sort	O(N log N)
  Merge Step Counting	O(N)
  Total Complexity	O(N log N)
  Space Complexity: O(N) (extra space for merging)*/
}
