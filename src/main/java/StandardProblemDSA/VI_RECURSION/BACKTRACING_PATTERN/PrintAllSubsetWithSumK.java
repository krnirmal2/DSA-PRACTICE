package StandardProblemDSA.VI_RECURSION.BACKTRACING_PATTERN;

import java.util.ArrayList;
import java.util.List;

/*
Problem:
Find all subsets of an array that sum to a given target k.

Pattern:
Backtracking / Recursion with decision tree (Include or Exclude).

Approach:
1️⃣ Recursively explore all subsets by including or excluding each element.
2️⃣ Maintain the current subset (curr) and reduce the target accordingly.
3️⃣ Base case: if index reaches the end and target == 0, store a copy of curr.
4️⃣ Backtrack by removing the last added element to explore other possibilities.

Time Complexity:
O(2^n) — each element has two choices: include or exclude.
Space Complexity:
O(n) — recursion depth + additional storage for subsets.

Similar LeetCode Questions:
- 39. Combination Sum
- 40. Combination Sum II
- 216. Combination Sum III

Follow-up Questions:
- How to handle duplicates in the array (return only unique subsets)?
- Can we optimize using memoization for large inputs?
- Modify to return the count of subsets instead of listing them.
*/

/*Using Recursion – O(2^n) Time and O(n) Space
The idea is to use recursion to explore all possible subsets of the given array. We either include or exclude each element while keeping track of the remaining target sum. If we reach the end of the array and the target
 becomes 0, we store the valid subset. Otherwise, we backtrack and explore other possibilities.*/
public class PrintAllSubsetWithSumK {
  static void findSubsets(
      int[] arr, int index, int target, List<Integer> curr, List<List<Integer>> result) {

    if (index >= arr.length) {

      // If we reach the end and the target
      // becomes 0, we found a valid subset
      if (target == 0) {
        result.add(new ArrayList<>(curr));
        return;
      }

      // Otherwise, we return as no valid
      // subset is found
      return;
    }

    // Include current element in subset
    curr.add(arr[index]);
    findSubsets(arr, index + 1, target - arr[index], curr, result);

    // Backtrack and exclude the current element
    curr.remove(curr.size() - 1);
    findSubsets(arr, index + 1, target, curr, result);
  }

  // Function to find all subsets summing to target
  static List<List<Integer>> perfectSum(int[] arr, int target) {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    findSubsets(arr, 0, target, curr, result);
    return result;
  }

  // Function to print subsets in required format
  static void print2dArray(List<List<Integer>> arr) {

    if (arr.isEmpty()) {

      // No valid subsets found
      System.out.println("-1");
      return;
    }

    for (int row = 0; row < arr.size(); row++) {
      System.out.print("[");
      for (int col = 0; col < arr.get(row).size(); col++) {
        System.out.print(arr.get(row).get(col));
        if (col != arr.get(row).size() - 1) {
          System.out.print(", ");
        }
      }
      System.out.print("]");

      if (row < arr.size() - 1) System.out.print(", ");
    }
  }

  public static void main(String[] args) {
    int[] arr = {5, 2, 3, 10, 6, 8};
    int target = 10;

    // Find subsets and print result
    List<List<Integer>> result = perfectSum(arr, target);
    print2dArray(result);
  }
}
