package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinWindowSizeForASum {
  /*
   Problem:
   Given an array A[] of positive integers and an integer B,
   find the minimum number of elements required such that their sum is >= B.
   If it is not possible, return -1.

   Example:
   A = [1,2,3,4,5], B = 10
   Pick 5 + 4 = 9 (not enough), add 3 -> sum = 12 >= 10 -> answer = 3
   But actually, if we take largest first: 5 + 4 = 9, add 3 -> 12 >= 10, so count = 3.

   Pattern:
   - Greedy: Take the largest numbers first to minimize the count.
   - Sort array in descending order and keep adding until sum >= B.

   Approach:
   1. Sort array in reverse order.
   2. Traverse and keep adding elements until sum >= B.
   3. Return count if possible, otherwise -1.

   Complexity:
   - Time: O(N log N) for sorting.
   - Space: O(1) extra space.

   LeetCode Similar:
   - No exact LeetCode problem, but relates to "Minimum Number of Coins to Make a Value" and Greedy subset problems.

   Follow-up:
   - Handle negative numbers? (sorting by absolute value doesn't guarantee minimal elements)
   - Can we do it without sorting? (Yes, using a Max Heap for O(N + K log N) complexity)
  */
  public static int solve(ArrayList<Integer> A, int B) {
    Collections.sort(A, Collections.reverseOrder()); // sort descending

    int sum = 0;
    int count = 0;

    for (int num : A) {
      sum += num;
      count++;
      if (sum >= B) {
        return count; // return as soon as we reach or exceed B
      }
    }
    return -1; // if even all elements can't reach B
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    System.out.println(solve(A, 10)); // Expected: 3 (5 + 4 + 3 = 12 >= 10)
  }
}
