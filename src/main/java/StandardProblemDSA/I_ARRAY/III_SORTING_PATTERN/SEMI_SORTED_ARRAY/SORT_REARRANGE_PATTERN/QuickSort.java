package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import StandardProblemDSA.I_ARRAY.ArrayUtility;
import java.util.Arrays;

/*
Question:
Implement the Quick Sort algorithm. Given an array of integers, sort it in ascending order
using the divide-and-conquer approach.

Approach:
1. Choose a pivot (here the first element is chosen).
2. Partition the array so that:
   - All elements smaller than pivot go to its left.
   - All elements greater than pivot go to its right.
3. Recursively apply quickSort on left and right subarrays.
4. Base case: if the subarray has less than 2 elements, it is already sorted.

Pattern:
- Sorting Pattern using Divide & Conquer.
- Recursive in nature.
- In-place sort (no additional significant memory used).
- Not a stable sort (does not preserve order of equal elements).

Time Complexity:
- Best & Average Case: O(n log n)
- Worst Case: O(n²) (when the pivot selection is poor, e.g., sorted/reverse-sorted array with first-element pivot)
Space Complexity: O(log n) due to recursion stack.

Follow-up Questions:
1. How can we improve pivot selection to avoid worst-case performance? (e.g., use random or median-of-three pivot)
2. Can we make Quick Sort stable?
3. How does Quick Sort compare to Merge Sort in terms of performance and memory?
4. Can Quick Sort be implemented iteratively?
5. Why is Quick Sort often preferred in practice despite its worst-case behavior?

Similar LeetCode/Interview Questions:
- LeetCode 912. Sort an Array
- LeetCode 215. Kth Largest Element in an Array (uses Quickselect, based on Quick Sort)
- LeetCode 973. K Closest Points to Origin (partition-based selection)
*/

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
        ArrayUtility.swap(arr, i, j);
      }
    }
    // Swap pivot element with j to place it in the correct position
    ArrayUtility.swap(arr, low, j);
    return j; // Return the pivot index
  }

  public static void main(String[] args) {
    int[] arr = {10, 7, 8, 9, 1, 5};
    quickSort(arr, 0, arr.length - 1);
    System.out.println("Sorted Array: " + Arrays.toString(arr));
  }
  /*

  ### 📌 **Initial Array**
  `[10, 7, 8, 9, 1, 5]`
  ### 🔁 **1st Call: quickSort(arr, 0, 5)**
  | Pivot                                                      | i | j | Comparisons                              | Swaps                | Array after Step     |
  | ---------------------------------------------------------- | - | - | ---------------------------------------- | -------------------- | -------------------- |
  | 10                                                         | 1 | 5 | 7, 8, 9, 1, 5 ≤ 10 (i stops at 6); j = 5 | No i < j swap needed | \[10, 7, 8, 9, 1, 5] |
  |                                                            |   |   | i > j → swap pivot (10) with arr\[5] = 5 | swap(0, 5)           | \[5, 7, 8, 9, 1, 10] |
  | 🔁 Recurse Left: quickSort(arr, 0, 4)                      |   |   |                                          |                      |                      |
  | 🔁 Recurse Right: quickSort(arr, 6, 5) → skip (low > high) |   |   |                                          |                      |                      |

  ### 🔁 **2nd Call: quickSort(arr, 0, 4)**

  | Pivot                                             | i | j | Comparisons                      | Swaps              | Array after Step     |
  | ------------------------------------------------- | - | - | -------------------------------- | ------------------ | -------------------- |
  | 5                                                 | 1 | 4 | 7 > 5 (i stops); 1 < 5 (j stops) | swap(1, 4)         | \[5, 1, 8, 9, 7, 10] |
  |                                                   |   |   | 1 < 5 (i=2); 7 > 5 (j=3)         | i > j → swap(0, 1) | \[1, 5, 8, 9, 7, 10] |
  | 🔁 Recurse Left: quickSort(arr, 0, 0) (base case) |   |   |                                  |                    |                      |
  | 🔁 Recurse Right: quickSort(arr, 2, 4)            |   |   |                                  |                    |                      |

  ### 🔁 **3rd Call: quickSort(arr, 2, 4)**

  | Pivot                                  | i | j | Comparisons                       | Swaps      | Array after Step     |
  | -------------------------------------- | - | - | --------------------------------- | ---------- | -------------------- |
  | 8                                      | 3 | 4 | 9 > 8 (j--); 7 < 8 (i stops, j=4) | swap(3, 4) | \[1, 5, 8, 7, 9, 10] |
  |                                        |   |   | i > j → swap(2, 3)                | swap(2, 3) | \[1, 5, 7, 8, 9, 10] |
  | 🔁 Recurse Left: quickSort(arr, 2, 2)  |   |   |                                   |            |                      |
  | 🔁 Recurse Right: quickSort(arr, 4, 4) |   |   |                                   |            |                      |
  ### ✅ **Final Sorted Array**:
  `[1, 5, 7, 8, 9, 10]`
  ### 🧠 **Summary Table of Recursive Calls**

  | Call            | Pivot | Partitioned Index | Subarrays to Sort |
  | --------------- | ----- | ----------------- | ----------------- |
  | quickSort(0, 5) | 10    | 5                 | \[0–4], \[6–5]    |
  | quickSort(0, 4) | 5     | 1                 | \[0–0], \[2–4]    |
  | quickSort(2, 4) | 8     | 3                 | \[2–2], \[4–4]    |

  ---

  Let me know if you want visual diagrams or want this explained step-by-step with pointer illustrations!
  */
}
