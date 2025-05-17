package StandardProblemDSA.I_ARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtility {

  /**
   * Prints the array elements in a single line.
   *
   * @param arr the array to print
   */
  public static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  /**
   * Reverses the given array in place.
   *
   * @param arr the array to reverse
   */
  public static void reverseArray(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
      swap(arr, left, right);
      left++;
      right--;
    }
  }

  /**
   * Swaps two elements in the array.
   *
   * @param arr the array
   * @param i index of first element
   * @param j index of second element
   */
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /**
   * Rotates the array to the right by k positions. Example: [1,2,3,4,5] rotated by 2 => [4,5,1,2,3]
   *
   * @param arr the array to rotate
   * @param k number of positions to rotate
   */
  public static void rotateArray(int[] arr, int k) {
    if (arr == null || arr.length == 0) return;
    k = k % arr.length;
    // Reverse entire array
    reverse(arr, 0, arr.length - 1);
    // Reverse first k elements
    reverse(arr, 0, k - 1);
    // Reverse remaining elements
    reverse(arr, k, arr.length - 1);
  }

  /**
   * Helper method to reverse a subarray from index 'left' to 'right'.
   *
   * @param arr the array
   * @param left starting index
   * @param right ending index
   */
  private static void reverse(int[] arr, int left, int right) {
    while (left < right) {
      swap(arr, left, right);
      left++;
      right--;
    }
  }

  /**
   * Performs binary search on a sorted array.
   *
   * @param arr sorted array
   * @param target the value to search for
   * @return index of target if found, otherwise -1
   */
  public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) return mid;
      else if (arr[mid] < target) left = mid + 1;
      else right = mid - 1;
    }
    return -1;
  }

  /**
   * Finds and returns the maximum element in the array.
   *
   * @param arr the array
   * @return maximum value in the array
   */
  public static int findMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int num : arr) {
      if (num > max) max = num;
    }
    return max;
  }

  /**
   * Finds and returns the minimum element in the array.
   *
   * @param arr the array
   * @return minimum value in the array
   */
  public static int findMin(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int num : arr) {
      if (num < min) min = num;
    }
    return min;
  }

  // ✅ Reusable twoSum with two pointers
  public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int left = start, right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == target) {
        res.add(Arrays.asList(nums[left], nums[right]));

        // Skip duplicates
        while (left < right && nums[left] == nums[left + 1]) left++;
        while (left < right && nums[right] == nums[right - 1]) right--;

        left++;
        right--;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return res;
  }
}
