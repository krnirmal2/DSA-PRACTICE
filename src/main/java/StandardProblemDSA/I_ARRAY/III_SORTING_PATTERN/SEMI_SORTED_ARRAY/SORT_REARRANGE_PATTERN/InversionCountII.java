package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.Arrays;

public class InversionCountII {
  /*Given an integer array nums, return the number of reverse pairs in the array.
  A reverse pair is a pair (i, j) where:
  0 <= i < j < nums.length and
  nums[i] > 2 * nums[j].
  Example 1:

  Input: nums = [1,3,2,3,1]
  Output: 2
  Explanation: The reverse pairs are:
  (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1*/

  public static int reversePairs(int[] nums) {
    return mergeSortAndCount(nums, 0, nums.length - 1);
  }

  public static int mergeSortAndCount(int[] arr, int left, int right) {
    int count = 0;
    if (left < right) {
      int mid = (left + right) / 2;

      count += mergeSortAndCount(arr, left, mid);
      count += mergeSortAndCount(arr, mid + 1, right);

      // 🔁 Count reverse pairs BEFORE merge
      /*Why it must be done before merge?
      Because at this point:
      Both the left half and right half are already sorted individually, due to recursive merge sort.
      You can then use two pointers to efficiently find all pairs (i, j) where:
      i ∈ left half
      j ∈ right half
      and arr[i] > 2 * arr[j]
      This two-pointer logic only works if both halves are sorted — which they are before you call merge.*/
      int j = mid + 1;
      for (int i = left; i <= mid; i++) {
        while (j <= right && (long) arr[i] > 2L * arr[j]) {
          /*Why this matters:If arr[i] = 2_000_000_000 and arr[j] = 1_200_000_000,
          then 2 * arr[j] = 2_400_000_000 → this overflows and becomes negative in Java int.*/
          j++;
        }
        count +=
            (j - (mid + 1)); // For the current i, all j in the range [mid+1, j-1] are valid reverse
        // pairs.And you do this for every i in the left half.
      }

      // Merge the two sorted halves
      merge(arr, left, mid, right);
    }
    return count;
  }

  private static int merge(int[] arr, int left, int mid, int right) {
    int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
    int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
    int i = 0, j = 0, k = left, swaps = 0;
    while (i < leftArr.length && j < rightArr.length) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
      }
    }

    // Copy remaining elements
    while (i < leftArr.length) arr[k++] = leftArr[i++];
    while (j < rightArr.length) arr[k++] = rightArr[j++];

    return swaps;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 3, 1};
    int count = reversePairs(arr);
    System.out.println("Sorted Array: " + Arrays.toString(arr));
    System.out.println("Reverse Pairs Count: " + count);
  }
}
