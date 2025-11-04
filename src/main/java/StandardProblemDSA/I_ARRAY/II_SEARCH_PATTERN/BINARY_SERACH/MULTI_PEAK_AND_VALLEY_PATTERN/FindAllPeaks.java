package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MULTI_PEAK_AND_VALLEY_PATTERN;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement:
------------------
Given an integer array `arr`, find all indices of "peaks" in the array.
A **peak element** is defined as an element that is strictly greater than its immediate neighbors.

- The first element is considered a peak if it's greater than the second element.
- The last element is considered a peak if it's greater than the second last element.
- For elements in between, `arr[i]` is a peak if `arr[i-1] < arr[i] > arr[i+1]`.

Return a list of all such indices.

Example 1:
----------
Input: arr = [1, 3, 7, 1, 2, 6, 0, 8, 7]
Output: [2, 5, 7]
Explanation:
    arr[2] = 7 > arr[1] = 3 and arr[3] = 1
    arr[5] = 6 > arr[4] = 2 and arr[6] = 0
    arr[7] = 8 > arr[6] = 0 and arr[8] = 7

Example 2:
----------
Input: arr = [1, 2, 3, 4, 5]
Output: [4]
Explanation: Only the last element 5 is a peak.

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
1. Can you find a **single peak** in O(log n) using binary search? (LeetCode 162: Find Peak Element) --- DONE
2. How would you handle multiple peaks in a **bitonic array**?
3. Can you modify the function to return the **values** of peaks instead of indices?
*/

public class FindAllPeaks {
  public static List<Integer> findAllPeaks(int[] arr) {
    List<Integer> peaks = new ArrayList<>();
    int n = arr.length;

    if (n == 0) {
      return peaks;
    }

    // CASE 1 : FOR FIRST ELEMENT
    // Check first element is greater than the second element or not if yes then add to peak list
    if (n > 1 && arr[0] > arr[1]) {
      peaks.add(0);
    }

    // CASE 2: FOR  middle elements
    // if it is greater than both left and right element
    // then add those indexes
    for (int i = 1; i < n - 1; i++) {
      if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
        peaks.add(i);
      }
    }

    // CASE 3 : Check last element is greter then the second last
    // if yes add the last element index also
    if (n > 1 && arr[n - 1] > arr[n - 2]) {
      peaks.add(n - 1);
    }

    return peaks;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 7, 1, 2, 6, 0, 8, 7};
    List<Integer> peaks = findAllPeaks(arr);
    System.out.println("Peak indices: " + peaks);
  }
}
