package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.ROTETED_ARRAY;

public class FindInRotatedArrayWithoutDuplication {
  /*Search in a Rotated Sorted Array (No Duplicates)
  There is an integer array nums sorted in ascending order (with distinct values).
  Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
  Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
  You must write an algorithm with O(log n) runtime complexity.

  Example 1:
  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4
  Example 2:

  Input: nums = [4,5,6,7,0,1,2], target = 3
  Output: -1
  Example 3:

  Input: nums = [1], target = 0
  Output: -1
  Constraints:

  1 <= nums.length <= 5000
  -104 <= nums[i] <= 104
  All values of nums are unique.
  nums is an ascending array that is possibly rotated.
  -104 <= target <= 104
    You are given a sorted array that has been rotated at some unknown pivot.
     Your task is to search for a target element in this array and return its index.
     If it doesn’t exist, return -1.*/
  //  All elements are distinct.
  //  Array was originally sorted in ascending order, then rotated.
  //  Time complexity must be better than O(n) (i.e., O(log n) using binary search).
  public static int search(int[] a, int target) {

    int high = a.length - 1;
    int low = 0;
    int mid;
    while (low <= high) {
      // serach in left and right sorted array
      mid = low + (high - low) / 2;
      // if the element is found in the mid return  the mid
      if (a[mid] == target) {
        return mid;
      }
      // Check which part is sorted and serach on that part
      if (a[low] <= a[mid]) {
        //  left sorted array serach in this paret
        if (a[low] <= target && target < a[mid]) {
          high = mid - 1; // reduce search space ; // Target is in the left half
        } else {
          // we are not found that in this subarray then serach in the next sorted
          low = mid + 1; // Target is in the right half
        }
      } else {
        System.out.println("mid " + mid);
        //  right srted array search in the
        if (a[mid] < target && target <= a[high]) {
          low = mid + 1; // Target is in the right half
        } else { // if the element not in the above range than we will shift the search to next
          // subarray

          high = mid - 1; // Target is in the left half
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2}; // Rotated at index 4
    int target = 0;
    System.out.println("Index of target: " + search(arr, target)); // Output: 4
  }
}
