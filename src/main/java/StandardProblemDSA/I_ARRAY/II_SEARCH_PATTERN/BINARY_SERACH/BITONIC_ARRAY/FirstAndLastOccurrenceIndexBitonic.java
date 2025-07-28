package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.BITONIC_ARRAY;

import StandardProblemDSA.Utility;

/*Problem Statement:
You are given a bitonic array arr of length n — an array that first strictly increases to a peak, then strictly decreases (duplicates may exist).
You are also given an integer target.
Your task is to find the first and last occurrence indices of target in arr.
If the target appears in both halves (increasing and decreasing), return the first index from the left and the last index from the right.
If it appears only in one half, return its first and last index there.
If the target does not appear at all, return [-1, -1].
Example 1:
Input: arr = [1, 3, 8, 12, 14, 11, 5, 5, 2], target = 5
Output: [6, 7]
Explanation: The target 5 first occurs at index 6 and last occurs at index 7.
Example 2:

Input: arr = [1, 3, 8, 12, 14, 11, 5, 2], target = 12
Output: [3, 3]
Explanation: 12 occurs only once at index 3.

-----------------------------------------------------------------------------------
🧠 Approach (Modified Binary Search on Bitonic Array):
-----------------------------------------------------------------------------------
1. **Find the peak index** using a helper function `peakElement()`.
2. **Search the left increasing part**:
      - Apply **binary search** to find the **first occurrence**.
3. **Search the right decreasing part**:
      - Apply **binary search** (modified for descending order) to find the **last occurrence**.
4. **Combine results**:
      - If both halves have occurrences → return `[firstOccurrence, lastOccurrence]`.
      - If found only in one half → return `[index, index]`.
      - If not found → return `[-1, -1]`.

-----------------------------------------------------------------------------------
⏱️ Complexity:
-----------------------------------------------------------------------------------
- **Time:** O(log N) + O(log N) ≈ O(log N), as we perform binary search on both halves.
- **Space:** O(1), no extra data structures used.

-----------------------------------------------------------------------------------
🧩 Pattern:
-----------------------------------------------------------------------------------
- **Binary Search**
- **Bitonic Array Search**
- Uses **first occurrence / last occurrence** variants of binary search.

-----------------------------------------------------------------------------------
🔁 Follow-up Questions:
-----------------------------------------------------------------------------------
1️⃣ Can we handle cases where the array is strictly increasing or strictly decreasing?
2️⃣ How to modify for multiple queries with different targets?
3️⃣ Can we avoid finding the peak if the target lies entirely in one half?

-----------------------------------------------------------------------------------
🔗 Similar Problems:
-----------------------------------------------------------------------------------
- LeetCode 1095 – Find in Mountain Array
- Find first and last occurrence in sorted array
- Peak Index in a Mountain Array
*/
public class FirstAndLastOccurrenceIndexBitonic {

  private static int searchBitonic(int[] bitonicArr, int target) {
    int peakIndex = Utility.peakElement(bitonicArr);

    // Find first occurrence in the left increasing part
    int firstOccurrence = findFirstOccurrence(0, peakIndex, bitonicArr, target);

    // Find last occurrence in the right decreasing part
    int lastOccurrence = findLastOccurrence(peakIndex, bitonicArr.length - 1, bitonicArr, target);

    // If the target exists in both halves, return first and last occurrence
    if (firstOccurrence != -1 && lastOccurrence != -1) {
      return firstOccurrence + lastOccurrence;
    }

    // If found only in one half, return that index
    return (firstOccurrence != -1) ? firstOccurrence : lastOccurrence;
  }

  private static int findFirstOccurrence(int low, int high, int[] bitonicArr, int target) {
    int result = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (bitonicArr[mid] == target) {
        result = mid; // Store the index
        high = mid - 1; // Move left to find first occurrence
      } else if (bitonicArr[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return result;
  }

  private static int findLastOccurrence(int low, int high, int[] bitonicArr, int target) {
    int result = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (bitonicArr[mid] == target) {
        result = mid; // Store the index
        low = mid + 1; // Move right to find last occurrence
      } else if (bitonicArr[mid] > target) {
        low = mid + 1; // Move right as it's a descending array
      } else {
        high = mid - 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] bitonicArr = {1, 3, 8, 12, 14, 11, 5, 5, 2};
    int target = 5;
    int result = searchBitonic(bitonicArr, target);

    if (result != -1) System.out.println("First and Last occurrence indices: " + result);
    else System.out.println("Element not found");
  }
}
