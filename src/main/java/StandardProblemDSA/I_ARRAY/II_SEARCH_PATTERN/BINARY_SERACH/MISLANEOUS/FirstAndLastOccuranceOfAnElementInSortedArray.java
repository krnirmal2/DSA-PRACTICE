package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MISLANEOUS;

import java.util.Arrays;

public class FirstAndLastOccuranceOfAnElementInSortedArray {
  /* We use binary search twice:
          1. First Binary Search:
  To find the first occurrence of the target element.
  If we find the target, we move left to see if it's found earlier.
          2. Second Binary Search:
  To find the last occurrence of the target element.
  If we find the target, we move right to see if it's found later.*/
  // Main method to find both first and last positions
  public static int[] findFirstAndLast(int[] arr, int target) {
    // Call helper for first occurrence (left-most)
    int first = findOccurrence(arr, target, true);

    // Call helper for last occurrence (right-most)
    int last = findOccurrence(arr, target, false);

    // Return result in array format
    return new int[] {first, last};
  }

  // Binary Search helper method
  private static int findOccurrence(int[] arr, int target, boolean findFirst) {
    int ans = -1; // Default answer if not found
    int low = 0, high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2; // Avoid overflow

      if (arr[mid] == target) {
        ans = mid; // Found target, record position

        // Check whether to go left or right
        if (findFirst) {
          // Move to left half to find earlier occurrence
          high = mid - 1;
        } else {
          // Move to right half to find later occurrence
          low = mid + 1;
        }
      } else if (arr[mid] < target) {
        // If target is larger, move right
        low = mid + 1;
      } else {
        // If target is smaller, move left
        high = mid - 1;
      }
    }

    return ans;
  }

  // Driver code to test
  public static void main(String[] args) {
    int[] arr = {1, 2, 2, 2, 3, 4, 5}; // Sorted input
    int target = 2;

    int[] result = findFirstAndLast(arr, target);

    // Output: [1, 3] => First at index 1, Last at index 3
    System.out.println("First and Last Occurrence of " + target + ": " + Arrays.toString(result));
  }
}
