package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.Arrays;

public class InplaceDuplicateRemove {
  public static int removeDuplicates(int[] nums) {
    /*Approach:
    Loop through each element in the array.
    For each element, compare it with all previous elements.
    If it has not appeared before, keep it; otherwise, remove it.*/
    if (nums.length == 0) {
      return 0; // No elements to process
    }

    int n = nums.length;
    int index = 0; // Pointer to track the position of unique elements

    for (int i = 0; i < n; i++) {
      boolean isDuplicate = false;
      // Compare with previous elements to check for duplicates
      for (int j = 0; j < i; j++) {
        if (nums[i] == nums[j]) {
          isDuplicate = true;
          break;
        }
      }

      // If no duplicate, place the element at the unique position
      if (!isDuplicate) {
        nums[index] = nums[i];
        index++;
      }
    }

    // The first `index` elements in nums are unique
    return index; // The number of unique elements
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 2, 3, 3, 4};
    int length = removeDuplicates(nums);

    System.out.println("Number of unique elements: " + length);
    for (int i = 0; i < length; i++) {
      System.out.print(nums[i] + " ");
    }
  }

  public static class InsertionSort {

    /*In this implementation, we start by iterating through the array starting from the second
         element (i.e., index 1). For each element, we store it in a temporary variable key and then
          iterate backwards from the current element to the start of the array. During this backwards
          iteration, we move any elements that are greater than key one position to the right to make room for key.
    Once we've found the correct position for key, we insert it into the array. We repeat this
    process for each element in the array until the entire array is sorted in ascending order.
    */

    public static void insertionSort(int[] arr) {
      int n = arr.length;
      for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

        // Move elements of arr[0..i-1], that are greater than key, to one position ahead
        // of their current position
        while (j >= 0 && arr[j] > key) {
          arr[j + 1] = arr[j];
          j = j - 1;
        }
        arr[j + 1] = key;
      }
    }

    public static void main(String[] args) {
      int[] arr = {5, 2, 7, 3, 1, 6};
      insertionSort(arr);
      System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 5, 6, 7]
    }
  }
}
