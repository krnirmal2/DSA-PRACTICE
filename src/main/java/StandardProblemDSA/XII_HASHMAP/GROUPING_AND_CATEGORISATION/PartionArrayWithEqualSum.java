package StandardProblemDSA.XII_HASHMAP.GROUPING_AND_CATEGORISATION;

import StandardProblemDSA.I_ARRAY.ArrayUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*NOTE : Related Problems (that fit this pattern):
1. Partition to K Equal Sum Subsets (LeetCode 698).
2. Divide array into two subsets of equal sum (classic partition problem).
3. Fair distribution of cookies (distribute elements into K groups to minimize imbalance).
4. K-partition problem in combinatorics.
5. Load balancing problems where tasks are distributed into k servers with equal load.

*/

public class PartionArrayWithEqualSum {
  /*Question : Given:An array of integers nums . An integer k.
    Check if we can partition the array into k subarrays such that:
    Each subarray has the same sum.
    If possible, return one such partition.
      Input:
  nums = [2, 1, 3, 4, 2, 2, 3, 1]
  k = 3
  Output:
          true (Possible partition: [2, 4], [3, 3], [1, 1,2, 2])*/
  /* Tc : power (k,n)
  each of the have k subsets to go
  After optimise the code :  O(K∗power(2, N))*/
  public static List<List<Integer>> partitionKSubarrays(int[] nums, int k) {
    // note : to optimise
    // we can SORT and  then Prune Early
    Arrays.sort(nums);
    ArrayUtility.reverseArray(nums);
    int totalSum = Arrays.stream(nums).sum();
    if (totalSum % k != 0) return new ArrayList<>(); // Partitioning not possible

    int target = totalSum / k;
    boolean[] visited = new boolean[nums.length];
    List<List<Integer>> result = new ArrayList<>();
    // step : sort the array for place larger nubers first and fail early if currentSum>target
    // prune early stop recursion when a subset sum exceeds target

    if (backtrack(nums, visited, k, 0, 0, target, new ArrayList<>(), result)) {
      return result;
    }

    return new ArrayList<>(); // Return empty list if partitioning fails
  }

  /*Step 2  :Iterate over remaining elements.
  If an element isn’t visited and doesn’t exceed target, include it.
  Recurse. If this path leads to a solution, return true.
  Else, backtrack (unmark the element and remove it from currentSubarray).*/

  private static boolean backtrack(
      int[] nums,
      boolean[] visited,
      int k,
      int startIndex,
      int currentSum,
      int target,
      List<Integer> currentSubarray,
      List<List<Integer>> result) {
    if (k == 0) {
      // If all k subarrays are formed, we're done
      return true;
    }

    if (currentSum == target) {
      // One subarray is formed, add it to the result and reset for the next subarray
      result.add(new ArrayList<>(currentSubarray));
      return backtrack(nums, visited, k - 1, 0, 0, target, new ArrayList<>(), result);
    }

    for (int i = startIndex; i < nums.length; i++) {
      if (visited[i]) continue;
      if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
        continue; // note ;early pruning Skip duplicate empty subset states:
      if (currentSum == 0)
        break; // note : Symmetry pruning: if a subset is empty and fails, don’t try another empty
      // subset.

      if (!visited[i] && currentSum + nums[i] <= target) {
        // Include nums[i] in the current subarray
        visited[i] = true;
        currentSubarray.add(nums[i]);

        if (backtrack(
            nums, visited, k, i + 1, currentSum + nums[i], target, currentSubarray, result)) {
          return true;
        }

        // Backtrack
        visited[i] = false;
        currentSubarray.remove(currentSubarray.size() - 1);
      }
    }

    return false; // If no valid subarray is found, return false
  }

  public static void main(String[] args) {
    int[] nums = {2, 1, 3, 4, 2, 2, 3, 1};
    int k = 3;

    List<List<Integer>> result = partitionKSubarrays(nums, k);

    if (!result.isEmpty()) {
      System.out.println("Partitioned into " + k + " subarrays with equal sums:");
      for (int i = 0; i < result.size(); i++) {
        System.out.println("Subarray " + (i + 1) + ": " + result.get(i));
      }
    } else {
      System.out.println("Partitioning not possible!");
    }
  }
}
