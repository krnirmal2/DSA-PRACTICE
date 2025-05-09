package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import static StandardProblemDSA.I_ARRAY.ArrayUtility.twoSum;
import static StandardProblemDSA.I_ARRAY.I_TRAVERSAL.ThreeSum.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);

    int n = nums.length;
    for (int i = 0; i < n - 3; i++) {
      // Skip duplicate values for i
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      long newTarget = (long) target - nums[i];
      List<List<Integer>> triplets = threeSum(nums, i + 1, newTarget);

      for (List<Integer> triplet : triplets) {
        res.add(Arrays.asList(nums[i], triplet.get(0), triplet.get(1), triplet.get(2)));
      }
    }

    return res;
  }

  // ✅ Reusable threeSum that calls twoSum
  private List<List<Integer>> threeSum(int[] nums, int start, long target) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;

    for (int i = start; i < n - 2; i++) {
      // Skip duplicate values for j
      if (i > start && nums[i] == nums[i - 1]) continue;

      long newTarget = target - nums[i];
      List<List<Integer>> pairs = twoSum(nums, i + 1, (int) newTarget);

      for (List<Integer> pair : pairs) {
        res.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
      }
    }

    return res;
  }
}
