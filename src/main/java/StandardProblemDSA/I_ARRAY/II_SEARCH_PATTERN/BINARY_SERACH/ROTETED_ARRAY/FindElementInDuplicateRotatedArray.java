package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.ROTETED_ARRAY;

public class FindElementInDuplicateRotatedArray {
  /*Search in Rotated Sorted Array with Duplicates
    You are given a sorted array a that has been rotated at some unknown pivot
     and may contain duplicate elements. Your task is to find the index of a target element target in the array. If the target exists, return its index. Otherwise, return -1.
    🔧 Constraints:
    The array may contain duplicates.

    The time complexity must be better than linear in most cases (use modified binary search).

    Return any index of the target if it appears more than once.

    💡 Example 1:

    Input:  a = [4, 5, 6, 7, 0, 1, 2], target = 0
    Output: 4
    💡 Example 2:
    Input:  a = [2, 5, 6, 0, 0, 1, 2], target = 3
    Output: -1
    🧠 Note:
    The array was originally sorted but then rotated.

    Duplicate elements can cause ambiguity in determining which half is sorted, so extra care (like skipping equal elements) is needed in binary search.

    Pattern Used:
  -------------
  - **Modified Binary Search Pattern**:
      - Compare mid with target and adjust search space.
      - Skip duplicate values when `a[low] == a[mid] == a[high]`.

  Time Complexity:
  ----------------
  - O(log n) on average; O(n) in the worst case (when many duplicates).

  Follow-up Questions:
  --------------------
  1. How would you find the **minimum element** in such a rotated array with duplicates?
  2. Can you return all indices of `target` instead of just one?
  3. How would you adapt this for a rotated array with no duplicates (LeetCode 33)?
  4. Can you handle cases where the array is rotated multiple times?*/
  public static int search(int[] a, int target) {
    /*When duplicates are present, the normal binary search property
     (which side is sorted) becomes uncertain.
    So we skip equal values from both ends to restore sorted conditions.*/
    int high = a.length;
    int low = 0;
    int mid;
    while (low < high) {
      // serach in left and right sorted array
      mid = low + (high - low) / 2;
      // if the element is found in the mid return  the mid
      if (a[mid] == target) {
        return mid;
      }

      // if there is duplicate then we have to skip to continue to
      if (a[low] == a[mid] && a[mid] == a[high]) {
        low++;
        high++;
        continue;
      }
      // else if don't find
      if (a[low] < a[mid]) {
        // serach in the left sorted array
        if (a[low] < target && target < a[mid]) {
          high = mid - 1; // reduce search space ; // Target is in the left half
        } else {
          // we are not found that in this subarray then serach in the next sorted
          low = mid + 1; // Target is in the right half
        }
      } else {
        // search in the right srted array
        if (a[mid] < target && target < a[high]) {
          low = mid + 1; // Target is in the right half
        } else { // if the element not in the above range than we will shift the search to next
          // subarray

          high = mid - 1; // Target is in the left half
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {2, 5, 6, 0, 0, 1, 2}; // Rotated at index 4
    int target = 0;
    System.out.println("Index of target: " + search(arr, target)); // Output: 4
  }
}
