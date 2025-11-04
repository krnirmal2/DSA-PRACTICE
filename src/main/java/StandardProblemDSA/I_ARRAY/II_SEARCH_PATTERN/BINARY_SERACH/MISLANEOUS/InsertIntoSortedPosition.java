package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MISLANEOUS; // package

/*
Problem Statement:
------------------
Given a sorted array of distinct integers and a target value, return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
------------
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

Pattern Used:
-------------
- **Binary Search Pattern**
    - Time Complexity: O(log N)
    - Space Complexity: O(log N) due to recursive calls.

Follow-up Questions:
--------------------
1. Can you return the **insert position** if `B` is not found (like in LeetCode 35: Search Insert Position)? DONE
2. Can you implement it iteratively to reduce space complexity to O(1)?
3. How would you handle duplicates (first or last occurrence)?
4. Can you adapt this for a rotated sorted array?
*/

public class InsertIntoSortedPosition {

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 5, 6, 7, 9};
    int left = 0;
    int right = A.length - 1;

    System.out.println(searchInsert(A, 4));
  }

  public static int searchInsert(int[] nums, int target) {
    int n = nums.length;
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (target == nums[mid]) return mid;
      if (target < nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
