package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import static StandardProblemDSA.I_ARRAY.ArrayUtility.twoSum;

import java.util.*;

public class StandardKsumProblem {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums); // Sorting is crucial for two-pointer deduplication
    return kSum(nums, 0, 4, target);
  }

  // Generalized kSum function
  private List<List<Integer>> kSum(int[] nums, int start, int k, long target) {
    List<List<Integer>> res = new ArrayList<>();

    int n = nums.length;

    // Base case: not enough elements
    if (k > n - start) return res;

    // Base case optimization: check min & max possible sums
    long minSum = 0L, maxSum = 0L;
    for (int i = 0; i < k; i++) {
      minSum += nums[start + i];
      maxSum += nums[n - 1 - i];
    }
    if (target < minSum || target > maxSum) return res;

    // Base case: 2Sum using two pointers
    if (k == 2) {
      return twoSum(nums, start, (int) target);
    }

    // Recursive case: reduce kSum to (k-1)Sum
    for (int i = start; i < n - k + 1; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates

      List<List<Integer>> subLists = kSum(nums, i + 1, k - 1, target - nums[i]);

      for (List<Integer> sub : subLists) {
        List<Integer> newList = new ArrayList<>();
        newList.add(nums[i]);
        newList.addAll(sub);
        res.add(newList);
      }
    }

    return res;
  }
}
