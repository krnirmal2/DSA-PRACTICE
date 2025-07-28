package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.ROTETED_ARRAY;

public class FindRotationCount {
  public static int findMin(int[] a) {
    /*
     * Problem Statement:
     * ------------------
     * Find the Rotation Count in a Rotated Sorted Array (No Duplicates).
     * You're given an array that was originally sorted in ascending order but has been rotated
     * at some unknown pivot. Your task is to determine the number of times the array was rotated.
     *
     * Key Insight:
     * ------------
     * - The number of rotations is equal to the index of the smallest element in the rotated array.
     * - Example: [5, 6, 1, 2, 3, 4] → minimum = 1 at index 2 → rotated 2 times.
     *
     * Approach:
     * ---------
     * - Use Binary Search to find the smallest element.
     * - Compare mid with high to decide whether to go left or right:
     *    1. If a[mid] <= a[high]: right half is sorted, so pivot is in the left half.
     *    2. Else: pivot is in the right half.
     * - Handle edge cases where mid itself or mid + 1 is the smallest.
     * - Continue narrowing until low points to the smallest element.
     *
     * Pattern:
     * --------
     * - Binary Search on Rotated Sorted Array (finding pivot/minimum element).
     *
     * Time and Space Complexity:
     * --------------------------
     * - Time: O(log n) because we halve the search space at each step.
     * - Space: O(1) since no extra data structures are used.
     *
     * Related LeetCode Questions:
     * ---------------------------
     * - 153. Find Minimum in Rotated Sorted Array
     * - 154. Find Minimum in Rotated Sorted Array II (handles duplicates)
     * - 33. Search in Rotated Sorted Array
     * - 81. Search in Rotated Sorted Array II
     *
     * Follow-up Questions:
     * --------------------
     * - How would you handle duplicates? (Hint: Need to skip equal elements)
     * - Can you also return the pivot value instead of the index?
     * - How to find the number of rotations if the array is rotated multiple times?
     */

    // we can find theis using order of n but use binary serch
    int high = a.length - 1;
    int low = 0;
    int mid;
    // iterate over the array
    // approach '
    // 1. if a[mid] <= a[high] means from mid to high the array is already sorted
    // 2. if a[mid]> a[high] means from low to mid array is sorted
    // so if both side is sorted means it is rotated sorted array and
    // and we will came to add the end where low and mid and high will be point same pinoint
    // and low pointer will give the lowest element
    while (low < high) {
      // Case 1: Array is already sorted
      // the minimum is at the low index
      if (a[low] < a[high]) {
        return low;
      }
      // We reach here when we have at least
      // two elements and the current subarray
      // is rotated
      mid = low + (high - low) / 2;
      // if mid element is greateer than next means mid+1 is the smallest so we just return that
      // element
      // Case 2: Check if mid+1 is the smallest
      if (mid < high && a[mid] > a[mid + 1]) {
        return mid + 1;
      }
      // Case 3: Check if mid is the smallest
      // IF mid element is smaller tthan previous element than mid is the smallest
      if (mid > low && a[mid] < a[mid - 1]) {
        return mid;
      }

      // The right half is not sorted.search in right half So
      // the minimum element must be in the
      // right hal
      // Case 4: Decide to move left or right
      if (a[mid] > a[high]) {
        low = mid + 1;
      } // The right half is sorted. Note that in
      // this case, we do not change high to mid - 1
      // but keep it to mid. As the mid element
      // itself can be the smallest
      else {
        high = mid - 1;
      }
    }
    // return at the low
    return low;
  }

  /*| Metric           | Value    |
  | ---------------- | -------- |
  | Time Complexity  | O(log n) |
  | Space Complexity | O(1)     |
  */
  public static void main(String[] args) {
    int[] arr = {5, 6, 1, 2, 3, 4};
    System.out.println(findMin(arr));
  }
}
