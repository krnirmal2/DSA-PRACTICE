package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import StandardProblemDSA.Utility;

/*
Question:
Rearrange the elements of an array `nums` into a "wiggle" sequence such that:
nums[0] <= nums[1] >= nums[2] <= nums[3] ...
Return the modified array in-place.

Example:
Input: nums = [3, 5, 2, 1, 6, 4]
Output: [3, 5, 1, 6, 2, 4]
Explanation:
- nums[0] <= nums[1], nums[1] >= nums[2], nums[2] <= nums[3], and so on.

Approach:
1. Traverse the array from index 0 to n-2.
2. For each index i:
   - If i is even, ensure nums[i] <= nums[i+1].
   - If i is odd, ensure nums[i] >= nums[i+1].
3. If any of the conditions are violated, swap nums[i] and nums[i+1].
4. This guarantees the wiggle property in one pass.

Pattern:
- Sorting and Rearranging Pattern.
- Single-pass greedy approach to enforce the alternating inequality.

Time Complexity:
- O(n), as we traverse the array once.
Space Complexity:
- O(1), in-place swapping.

Follow-up Questions:
1. How to achieve "Wiggle Sort II" where we require nums[0] < nums[1] > nums[2] < nums[3] ... ?
2. Can this be solved by first sorting and then swapping adjacent elements?
3. What is the difference between this linear-time greedy solution and the sorting-based approach?
4. How to handle cases where duplicate elements exist?
5. Can we do this for linked lists?

Similar LeetCode Questions:
- LeetCode 280. Wiggle Sort
- LeetCode 324. Wiggle Sort II
- LeetCode 75. Sort Colors (rearranging with conditions)
*/

public class WiggleSort {
  /*Explanation
  In Wiggle Sort, the goal is to rearrange the array such that it follows a peak-valley pattern. Specifically, for an array nums, the arrangement should satisfy:
  nums[0] <= nums[1] >= nums[2] <= nums[3] ...
  This means elements at odd indices are greater than their neighbors, while elements at even indices are smaller.
  Algorithm
  Traverse the array and compare adjacent elements.
  If the current index i is even, ensure nums[i] <= nums[i+1].
  If i is odd, ensure nums[i] >= nums[i+1].
  Swap elements if the above conditions are not met.*/
  public static void wiggleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      if ((i % 2 == 0 && nums[i] > nums[i + 1])
          || // if even index and it is greater than its next element just swap
          (i % 2 == 1
              && nums[i]
                  < nums[i + 1])) { // if odd index and it is smaller than its next element swap it
        // Swap nums[i] and nums[i+1]
        Utility.swap(nums, i, i + 1);
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {3, 5, 2, 1, 6, 4};
    wiggleSort(nums);
    System.out.println("Wiggle sorted array: " + java.util.Arrays.toString(nums));
  }
}
