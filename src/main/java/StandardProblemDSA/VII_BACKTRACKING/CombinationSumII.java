package StandardProblemDSA.VII_BACKTRACKING;

import java.util.*;

public class CombinationSumII {
  /*🧠 Approach
  Sort the array → Helps in skipping duplicates.
  Use backtracking.
  Skip duplicates at the same recursion level.
  Use index + 1 for next recursive call since an element can be used only once.*/
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates); // Sort to handle duplicates
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  private static void backtrack(
      List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
    if (remain == 0) {
      result.add(new ArrayList<>(tempList));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      // Skip duplicates at the same level
      if (i > start && candidates[i] == candidates[i - 1]) continue;

      if (candidates[i] > remain) break; // early pruning

      tempList.add(candidates[i]);
      backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
      tempList.remove(tempList.size() - 1); // backtrack
    }
  }

  /*🔍 Time and Space Complexity
  Time Complexity:
  Worst-case: O(2^n) due to the combinatorial nature

  Sorting: O(n log n)

  Space Complexity:
  O(n) recursion stack

  Plus O(result size) for storing valid combinations*/
  public static void main(String[] args) {
    int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    List<List<Integer>> results = combinationSum2(candidates, target);
    System.out.println(results); // [[1,1,6],[1,2,5],[1,7],[2,6]]
  }
}
