package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import StandardProblemDSA.I_ARRAY.ArrayUtility;
import StandardProblemDSA.Utility;

/*
Question:
Given an array A consisting of 0s, 1s, and 2s, sort the array in-place so that all 0s come first,
followed by all 1s, and then all 2s. You must not use the library's sort function.

Example:
Input: A = [2, 0, 2, 1, 1, 0]
Output: [0, 0, 1, 1, 2, 2]

Approach (Shown in commented code):
- Count the occurrences of each color by traversing the array three times:
  1. Copy all 0s to the result.
  2. Copy all 1s next.
  3. Copy all 2s at the end.
- Construct a new sorted array based on these counts.
- Time Complexity: O(n)
- Space Complexity: O(n) (extra array used).

Pattern:
- Sorting Pattern (Counting Sort variation).
- Solves "Dutch National Flag" problem in a straightforward way.

Optimized Approach (Follow-up):
- Use a single-pass, in-place algorithm with three pointers (low, mid, high).
- Rearrange elements by swapping in O(n) time and O(1) space.

Follow-up Questions:
1. Can you implement an in-place version with O(1) space? (Dutch National Flag algorithm)
2. What happens if there are more than three colors (k colors)?
3. Can this be solved using one-pass counting?
4. Compare the three-pointer approach to counting sort in terms of performance and space.
5. Can you adapt this algorithm to sort linked lists of 0s, 1s, and 2s?

Similar LeetCode Questions:
- LeetCode 75. Sort Colors (Dutch National Flag problem)
- LeetCode 905. Sort Array by Parity (two-way partitioning)
- LeetCode 88. Merge Sorted Array (array rearrangement)
*/

public class ThreeColorSorting {
  /* public static int[] sortColors(int[] A) {
      int count = 0;
      int index = 0;
      int[] result = new int[A.length];
      for (int i = 0; i < A.length; i++) {
        if (A[i] < 1) {
          result[count] = A[i];
          count++;
        }
      }
      for (int k = 0; k < A.length; k++) {
        if (A[k] == 1) {
          result[count] = A[k];
          count++;
        }
      }
      for (int j = 0; j < A.length; j++) {
        if (A[j] > 1) {
          result[count] = A[j];
          count++;
        }
      }
      return result;
    }
  */
  // todo , remain two pointer
  public static int[] sortColors(int[] A) {
    int low = 0, mid = 0, high = A.length - 1;

    // steps 1. while mid doesn't reached to high
    // we will check
    // if element at mid is equal to zero , swap low with mid and increase both
    // if element at mid is equal to one , just increase mid
    // if element at mid is 2 , swap mid with high and just decrease high
    while (mid <= high) {
      if (A[mid] == 0) {
        ArrayUtility.swap(A, low, mid);
        low++;
        mid++;
      } else if (A[mid] == 1) {
        mid++;
      } else { // A[mid] == 2
        ArrayUtility.swap(A, mid, high);
        high--;
      }
    }
    return A;
  }

  public static void main(String[] args) {
    int[] A = Utility.onlyThreeValueArray();
    A = new int[] {0, 1, 1, 0, 0, 2, 1, 0};
    A = sortColors(A);
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i]);
    }
  }
}
