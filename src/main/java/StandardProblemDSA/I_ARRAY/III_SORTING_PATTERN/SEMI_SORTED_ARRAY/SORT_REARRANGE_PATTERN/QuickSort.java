package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.Arrays;

public class QuickSort {
  /*  🔹 Steps of Quick Sort
  Choose a pivot (e.g., last element, first element, or median).
  Partition the array:
  Elements less than pivot go to the left.
  Elements greater than pivot go to the right.
  Recursively apply QuickSort to left and right subarrays.*/
  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      // Partition the array and get the pivot index
      int pivotIndex = partition(arr, low, high);

      // Recursively sort the left and right subarrays
      quickSort(arr, low, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[low]; // Choosing the first element as pivot
    int i = low + 1; // Start comparing from the next element
    int j = high; // End pointer

    while (i <= j) {
      // Move i to the right as long as elements are smaller than pivot
      while (i <= j && arr[i] <= pivot) {
        i++;
      }
      // Move j to the left as long as elements are greater than pivot
      while (i <= j && arr[j] > pivot) {
        j--;
      }
      // Swap elements if i and j haven't crossed
      if (i < j) {
        swap(arr, i, j);
      }
    }
    // Swap pivot element with j to place it in the correct position
    swap(arr, low, j);
    return j; // Return the pivot index
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {10, 7, 8, 9, 1, 5};
    quickSort(arr, 0, arr.length - 1);
    System.out.println("Sorted Array: " + Arrays.toString(arr));
  }
}
