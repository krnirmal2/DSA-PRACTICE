package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MISLANEOUS;

import java.util.Arrays;

/*
Problem Statement:
------------------
Given a sorted array `arr` (possibly containing duplicates) and an integer `target`,
find the **first and last occurrence indices** of `target` in the array.
If `target` is not present, return [-1, -1].

Example 1:
----------
Input: arr = [1, 2, 2, 2, 3, 4, 5], target = 2
Output: [1, 3]
Explanation: The element 2 first appears at index 1 and last appears at index 3.

Example 2:
----------
Input: arr = [1, 3, 5, 7], target = 4
Output: [-1, -1]
Explanation: 4 is not present in the array.

Constraints:
------------
- 1 <= arr.length <= 10^5
- -10^9 <= arr[i], target <= 10^9
- Array is sorted in non-decreasing order.

Pattern Used:
-------------
- **Binary Search Pattern** (applied twice):
    1. First binary search to find the first occurrence (move `high` leftwards).
    2. Second binary search to find the last occurrence (move `low` rightwards).

Follow-up Questions:
--------------------
1. Can you solve it in O(log n) without using any linear scans? (Yes, by using two binary searches)
2. How would you handle this in a rotated sorted array?
3. Can you modify the code to count the number of occurrences directly?
4. How to find the closest element if the target does not exist?

LeetCode Tag:
-------------
- [34. Find First and Last Position of Element in Sorted Array] -- DONE
- Companies: Microsoft, Amazon, Google
*/

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

      // Even if find the mid , then for first occurance go
      // till  low<=high
      if (arr[mid] == target) {
        ans = mid; // Found target, record position

        // Check whether to go left or right
        if (findFirst) { // to shrink high to left
          // Move to left half to find earlier occurrence
          high = mid - 1;
        } else {

          // Move to right half to find later occurrence
          low = mid + 1;
        }
      }

      // if target is greater than the elemnt then mid value
      // means it is in the right part
      else if (arr[mid] < target) {
        // If target is larger, move right
        low = mid + 1;
      } else {
        // if target is smaller than the element then mid value
        // means it is in the left part
        // update high with shirnk it
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
