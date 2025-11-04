package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import StandardProblemDSA.Utility;
import java.util.HashMap;

/*
Problem Statement:
------------------
Given an array `arr` of integers and an integer `target`, find indices of two distinct numbers such that
their sum equals `target`.
- Return the pair of indices (1-based indexing) for which the second index is the smallest possible.
- If multiple pairs have the same second index, return the one with the smallest first index.
- If no such pair exists, return [-1, -1].

Example:
--------
Input: arr = [2, 7, 11, 15], target = 9
Output: [1, 2]
Explanation: arr[0] + arr[1] = 2 + 7 = 9

Input: arr = [1, 5, 3, 3], target = 6
Output: [3, 4]
Explanation: Two pairs: (1,2) -> (1,5), (3,4) -> (3,3); second index minimum is 4.

Constraints:
------------
- 2 <= arr.length <= 10^5
- -10^9 <= arr[i], target <= 10^9

Pattern Used:
-------------
- **HashMap (Value -> Index)** for O(n) lookup.
- Known as **Two Sum Pattern** (classic problem in array hashing).
- Technique ensures smallest second index by updating only when a better pair is found.

LeetCode & Company Tags:
------------------------
- LeetCode: "Two Sum" (#1) done
- Companies: Frequently asked at Microsoft, Amazon, Facebook, Google.
- Category: Array, Hashing, Two Pointers (variation).

Approach:
---------
- Iterate through array, for each element check if its complement exists in the map.
- Update the result only if it improves (lower second index, or lower first index in tie).
- Store the first occurrence of each number to guarantee smallest indices.
*/
public class Two_Sum_MinimumIndex {
  // Find the minmum index of two sum if there is multiple
  public static int[] twoSum(int[] arr, int target) {

    HashMap<Integer, Integer> mp = new HashMap<>();
    int[] result = {-1, -1};
    int minSecondIndex = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      int complement = target - arr[i];
      if (mp.containsKey(complement)) {
        int firstIndex = mp.get(complement);
        // check if this pair is better (based on second index, or first if tie)
        if (i < minSecondIndex || (i == minSecondIndex && firstIndex < result[0])) {
          result[0] = firstIndex + 1; // +1 for 1-based index
          result[1] = i + 1;
          minSecondIndex = i;
        }
      }

      // Only store the first occurrence of each number
      if (!mp.containsKey(arr[i])) {
        mp.put(arr[i], i);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = Utility.arrayWithPosiNegativeValue();
    int[] k = twoSum(a, -3);
    for (int i = 0; i < 2; i++) System.out.println(k[i]);
  }
}
