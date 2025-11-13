package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MULTI_PEAK_AND_VALLEY_PATTERN;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement:
------------------
Given an integer array `arr`, find all indices of "valleys" in the array.
A **valley element** is defined as an element that is strictly smaller than its immediate neighbors.

- The first element is considered a valley if it's smaller than the second element.
- The last element is considered a valley if it's smaller than the second last element.
- For elements in between, `arr[i]` is a valley if `arr[i-1] > arr[i] < arr[i+1]`.

Return a list of all such indices.

Example 1:
----------
Input: arr = [5, 3, 8, 1, 4, 6, 2, 7]
Output: [1, 3, 6]
Explanation:
    arr[1] = 3 < arr[0] = 5 and arr[2] = 8
    arr[3] = 1 < arr[2] = 8 and arr[4] = 4
    arr[6] = 2 < arr[5] = 6 and arr[7] = 7

Example 2:
----------
Input: arr = [9, 7, 5, 3, 1]
Output: [4]
Explanation: Only the last element 1 is a valley.

Constraints:
------------
- 1 <= arr.length <= 10^5
- -10^9 <= arr[i] <= 10^9

Pattern Used:
-------------
- **Linear Scan Pattern**
    - Traverse the array and check each element against its neighbors.
    - Time Complexity: O(n)
    - Space Complexity: O(1)

Follow-up Questions:
--------------------
1. Can you find a **single valley** in O(log n) using binary search?
2. How would you handle multiple valleys in a **bitonic array**?
3. Can you modify the function to return the **values** of valleys instead of indices?
*/

public class FindAllValleys {
  public static List<Integer> findAllValleys(int[] arr) {
    List<Integer> valleys = new ArrayList<>();
    int n = arr.length;

    if (n == 0) return valleys;

    // Check first element
    if (n > 1 && arr[0] < arr[1]) valleys.add(0);

    // Check middle elements
    for (int i = 1; i < n - 1; i++) {
      if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
        valleys.add(i);
      }
    }

    // Check last element
    if (n > 1 && arr[n - 1] < arr[n - 2]) valleys.add(n - 1);

    return valleys;
  }

  public static void main(String[] args) {
    int[] arr = {5, 3, 8, 1, 4, 6, 2, 7};
    List<Integer> valleys = findAllValleys(arr);
    System.out.println("Valley indices: " + valleys);
  }
}
