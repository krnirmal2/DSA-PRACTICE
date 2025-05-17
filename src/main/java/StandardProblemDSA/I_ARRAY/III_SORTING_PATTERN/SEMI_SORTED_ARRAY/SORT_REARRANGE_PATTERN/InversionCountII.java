package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.ArrayList;
import java.util.List;

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

  public int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  private int mergeSort(int[] nums, int left, int right) {
    if (left >= right) return 0;

    int mid = (left + right) / 2;
    int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

    // Count reverse pairs
    int j = mid + 1;
    for (int i = left; i <= mid; i++) {
      while (j <= right && (long) nums[i] > 2L * nums[j]) {
        j++;
      }
      count += (j - (mid + 1));
    }

    // Merge the two sorted halves
    merge(nums, left, mid, right);

    return count;
  }

  private void merge(int[] nums, int left, int mid, int right) {
    List<Integer> temp = new ArrayList<>();
    int i = left, j = mid + 1;

    while (i <= mid && j <= right) {
      if (nums[i] <= nums[j]) {
        temp.add(nums[i++]);
      } else {
        temp.add(nums[j++]);
      }
    }

    while (i <= mid) temp.add(nums[i++]);
    while (j <= right) temp.add(nums[j++]);

    for (int k = left; k <= right; k++) {
      nums[k] = temp.get(k - left);
    }
  }
}
