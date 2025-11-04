package StandardProblemDSA.I_ARRAY.VI_CYCLIC_SORT;

import StandardProblemDSA.Utility;
import java.util.Arrays;

/*
Question:
Given an array containing numbers from 1 to N in random order, sort the array in-place
without using extra space and in linear time.

Example:
Input: nums = [3, 5, 2, 1, 4]
Output: [1, 2, 3, 4, 5]

Approach:
1. Use Cyclic Sort – an in-place, O(n) sorting algorithm for arrays where elements are in the range 1 to N.
2. Iterate through the array:
   - For the current index i, the correct position of nums[i] is nums[i] - 1.
   - If nums[i] is not at its correct position, swap nums[i] with nums[nums[i] - 1].
   - Otherwise, move to the next index.
3. Repeat until all elements are at their correct positions.

Pattern:
- Cyclic Sort Pattern – commonly used for problems where numbers are within a known range (1 to N).

Time Complexity:
- O(N) since each number is swapped at most once.
Space Complexity:
- O(1) as sorting is done in-place.

Follow-up Questions:
1. How would you modify the algorithm to handle duplicates?
2. Can you adapt this to find the missing or duplicate numbers in the array?
3. What if numbers are not guaranteed to be within 1 to N?
4. Can you detect cycles or misplaced elements during sorting?
5. How does Cyclic Sort compare to other in-place algorithms like selection sort?

Similar LeetCode/Interview Questions:
- LeetCode 448. Find All Numbers Disappeared in an Array
- LeetCode 442. Find All Duplicates in an Array
- LeetCode 268. Missing Number
- LeetCode 287. Find the Duplicate Number
*/

public class CyclicSortOfAnArray {

  public static void main(String[] args) {
    int[] nums = {3, 5, 2, 1, 4};
    Utility.cyclicSort(nums);
    System.out.println(Arrays.toString(nums)); // Output: [1, 2, 3, 4, 5]
  }
}
