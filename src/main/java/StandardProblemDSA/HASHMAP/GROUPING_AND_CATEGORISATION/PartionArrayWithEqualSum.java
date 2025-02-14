package StandardProblemDSA.HASHMAP.GROUPING_AND_CATEGORISATION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartionArrayWithEqualSum {
    //    Input:
//    nums = [2, 1, 3, 4, 2, 2, 3, 1]
//    k = 3
//    Output:
//            true (Possible partition: [2, 4], [3, 3], [1, 1,2, 2])
    public static List<List<Integer>> partitionKSubarrays(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % k != 0) return new ArrayList<>(); // Partitioning not possible

        int target = totalSum / k;
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();

        if (backtrack(nums, visited, k, 0, 0, target, new ArrayList<>(), result)) {
            return result;
        }

        return new ArrayList<>(); // Return empty list if partitioning fails
    }

    private static boolean backtrack(int[] nums, boolean[] visited, int k, int startIndex, int currentSum, int target,
                                     List<Integer> currentSubarray, List<List<Integer>> result) {
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
            if (!visited[i] && currentSum + nums[i] <= target) {
                // Include nums[i] in the current subarray
                visited[i] = true;
                currentSubarray.add(nums[i]);

                if (backtrack(nums, visited, k, i + 1, currentSum + nums[i], target, currentSubarray, result)) {
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
