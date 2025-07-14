package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.LongestWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LongestSequenceSumEqualZero {

  /*✅ Question (Interviewer-style):
  "Given an integer array, find the longest contiguous subarray whose sum is zero.
   Return the elements of that subarray."

  ✅ Approach (How to explain):
  "We'll use a prefix sum approach along with a HashMap to efficiently
  track cumulative sums and their earliest occurrences.
   The key idea is that if the cumulative sum up to two indices is the same,
    the subarray between those indices has a sum of zero."

  Step-by-step:
  Initialize a HashMap to store (prefixSum -> earliest index where that sum was seen).
  Start with prefixSum = 0 mapped to index -1 (helps when subarray starts from index 0).
  Traverse the array:
  Update the cumulative sum.
  If the sum has been seen before,
  calculate the length of the subarray between the previous index and current index.
  If this length is greater than the current longest, update the result range.
  Finally, extract and return the subarray using the recorded range.
  */

  public static ArrayList<Integer> findLongestZeroSumSubarray(ArrayList<Integer> nums) {
    ArrayList<Integer> longestZeroSumSubarray = new ArrayList<>();
    HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

    if (nums == null) {
      return longestZeroSumSubarray;
    }

    int maxLength = 0;
    int prefixSum = 0;
    int startIndex = -1, endIndex = -1;

    // Initialize with prefixSum = 0 at index -1
    sumIndexMap.put(0, -1);

    for (int i = 0; i < nums.size(); i++) {
      prefixSum += nums.get(i);

      // if the prefix sum is not present then put this to the map with the current index

      if (!sumIndexMap.containsKey(prefixSum)) {
        // Store first occurrence of this prefix sum
        sumIndexMap.put(prefixSum, i);
      } else {
        // if the prefix sum is present in the map then get the previous index from the map for
        // this
        // prefixsum and substract the current index with it and store as current length;
        // and for maximum window we will
        // theen update the max length with current length above and startIndex is previous index
        // +1
        // and endindex = is i

        // Found a zero-sum subarray from sumIndexMap.get(prefixSum) + 1 to i
        int previousIndex = sumIndexMap.get(prefixSum);
        int currentLength = i - previousIndex;

        if (currentLength > maxLength) {
          maxLength = currentLength;
          startIndex = previousIndex + 1;
          endIndex = i;
        }
      }
    }

    // Build the result subarray
    if (startIndex >= 0) {
      for (int i = startIndex; i <= endIndex; i++) {
        longestZeroSumSubarray.add(nums.get(i));
      }
    }

    return longestZeroSumSubarray;
  }

  public static void main(String[] args) {
    ArrayList<Integer> inputList = new ArrayList<>(List.of(1, 2, -2, 4, -4));
    System.out.println(findLongestZeroSumSubarray(inputList));
  }

  /*
  ### Input:
  `[1, 2, -2, 4, -4]`
   **Initial State:**
  | Variable         | Value            |
  |------------------|------------------|
  | `prefixSum`      | 0                |
  | `sumIndexMap`    | `{0: -1}`        |
  | `maxLength`      | 0                |
  | `startIndex`     | -1               |
  | `endIndex`       | -1               |
  🔁 Iteration-by-Iteration Walkthrough:
  #### ✅ i = 0 → `nums[0] = 1`
  - `prefixSum = 0 + 1 = 1`
  - `1` not in `sumIndexMap` → store: `{0: -1, 1: 0}`
  - No update to `maxLength`
  #### ✅ i = 1 → `nums[1] = 2`
  - `prefixSum = 1 + 2 = 3`
  - `3` not in map → store: `{0: -1, 1: 0, 3: 1}`
  - No update to `maxLength`
  #### ✅ i = 2 → `nums[2] = -2`
  - `prefixSum = 3 + (-2) = 1`
  - `1` **already exists** in map at index 0
    → subarray from index `0+1 = 1` to `2` has sum = 0
    → length = `2 - 0 = 2` > `maxLength = 0`
    → update: `maxLength = 2`, `startIndex = 1`, `endIndex = 2`

  ---

  #### ✅ i = 3 → `nums[3] = 4`
  - `prefixSum = 1 + 4 = 5`
  - `5` not in map → store: `{0: -1, 1: 0, 3: 1, 5: 3}`
  - No update to `maxLength`

  ---

  #### ✅ i = 4 → `nums[4] = -4`
  - `prefixSum = 5 + (-4) = 1`
  - `1` exists at index 0 → subarray from `1` to `4`
    → length = `4 - 0 = 4` > `maxLength = 2`
    → update: `maxLength = 4`, `startIndex = 1`, `endIndex = 4`

  ---

  ### ✅ Final Result:

  Extract subarray from index 1 to 4 → `[2, -2, 4, -4]`

  ---

  ### 🧾 Summary Table:

  | Index (i) | Num | Prefix Sum | Action |
  |-----------|-----|------------|--------|
  | 0         | 1   | 1          | Insert 1 into map |
  | 1         | 2   | 3          | Insert 3 into map |
  | 2         | -2  | 1          | Found zero-sum [1, 2], length 2 |
  | 3         | 4   | 5          | Insert 5 into map |
  | 4         | -4  | 1          | Found zero-sum [2, -2, 4, -4], length 4 (new max) |

  ---

  ### Final Output:
  ```java
  [2, -2, 4, -4]
  ```

  Let me know if you’d like to see a visual representation or dry run for a different input!*/
}
