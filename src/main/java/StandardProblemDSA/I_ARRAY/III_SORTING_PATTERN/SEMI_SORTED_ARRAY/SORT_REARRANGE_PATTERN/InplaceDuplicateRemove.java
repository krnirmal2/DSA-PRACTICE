package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

/*/*
Question:
Given an integer array `nums`, remove duplicate elements in-place such that each unique element appears only once
and return the new length. The relative order of elements should be preserved.
You must use O(1) extra space.

Example:
Input: nums = [1, 2, 2, 3, 1]
Output: 3
Explanation: The first three elements are [1, 2, 3]; duplicates removed.

Pattern:
- Brute Force Duplicate Removal.
- Uses Nested Loops (O(n²) complexity).
- Related to "Two Pointers" pattern (optimized version uses two pointers and sorted array).

Follow-up Questions:
1. Optimize to O(n) or O(n log n):
   - Can we do it in a single pass using a hash set?
2. Sorted Input Case:
   - If the input array is already sorted, can we remove duplicates in-place in O(n)?
3. Memory Constraint:
   - What if we are not allowed to use extra memory (no hash set)?
4. Counting Duplicates:
   - Instead of removing duplicates, return the frequency of each number.
5. Stable Order Guarantee:
   - Is it necessary to preserve the relative order of unique elements?

Similar LeetCode Questions:
- LeetCode 26. Remove Duplicates from Sorted Array
- LeetCode 80. Remove Duplicates from Sorted Array II
- LeetCode 83. Remove Duplicates from Sorted List
- LeetCode 27. Remove Element
*/

public class InplaceDuplicateRemove {
  public static int removeDuplicates(int[] nums) {
    /*Approach:
    Loop through each element in the array.
    For each element, compare it with all previous elements.
    If it has not appeared before, keep it; otherwise, remove it.*/
    if (nums.length == 0) {
      return 0; // No elements to process
    }

    int n = nums.length;
    int index = 0; // Pointer to track the position of unique elements

    for (int i = 0; i < n; i++) {
      boolean isDuplicate = false;
      // Compare with previous elements to check for duplicates
      for (int j = 0; j < i; j++) {
        if (nums[i] == nums[j]) {
          isDuplicate = true;
          break;
        }
      }

      // If no duplicate, place the element at the unique position
      if (!isDuplicate) {
        nums[index] = nums[i];
        index++;
      }
    }

    // The first `index` elements in nums are unique
    return index; // The number of unique elements
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 2, 3, 3, 4};
    int length = removeDuplicates(nums);

    System.out.println("Number of unique elements: " + length);
    for (int i = 0; i < length; i++) {
      System.out.print(nums[i] + " ");
    }
  }
  /*public class InplaceDuplicateRemoveOptimizedSet {
      public static int removeDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int index = 0;

        for (int num : nums) {
          if (!seen.contains(num)) {
            seen.add(num);
            nums[index++] = num; // overwrite in place
          }
          // else it is skipping the duplicate element on next unique
          // element as it is overwrite
        }
        return index;
      }

      public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + length);
        for (int i = 0; i < length; i++) {
          System.out.print(nums[i] + " ");
        }
      }
    }
  */
}
