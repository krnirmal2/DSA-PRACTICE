package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import java.util.Arrays;

/*
Question:
Given an array A, make all elements unique by incrementing elements as needed.
Return the minimum number of increments required.

Example:
Input: A = [1, 1, 2]
Output: 1
Explanation:
- After sorting: [1, 1, 2]
- The second "1" needs to be incremented to "2", but "2" already exists,
  so increment again to "3".
- Final array: [1, 2, 3], increments = 1.

Approach:
1. Sort the array.
2. Iterate through the array:
   - If the current element A[i] is less than or equal to the previous element A[i-1],
     increment it to A[i-1] + 1.
   - Add the number of increments to a running total.
3. Return the total count of increments.

Pattern:
- Sorting + Greedy Adjustment.
- Increment elements minimally to make all values unique.

Time Complexity:
- Sorting: O(n log n)
- Single pass adjustment: O(n)
- Overall: O(n log n)
Space Complexity: O(1) (in-place modifications).

Follow-up Questions:
1. Can we solve this without sorting in O(n) using a HashSet?
2. What happens if the array contains negative numbers?
3. Can we track the final modified array in addition to the count?
4. How does the solution change if we can decrement elements instead of incrementing?
5. Can we apply the same logic to make all elements unique with minimal sum?

Similar LeetCode Questions:
- LeetCode 945. Minimum Increment to Make Array Unique
- LeetCode 1647. Minimum Deletions to Make Character Frequencies Unique
- LeetCode 409. Longest Palindrome (uses frequency adjustments)
*/

public class UniqueElement {

  public static int solve(int[] A) {
    int N = A.length;
    Arrays.sort(A);
    int count = 0;
    for (int i = 1; i < N; i++) {
      if (A[i - 1] >= A[i]) {
        count += A[i - 1] + 1 - A[i];
        A[i] = A[i - 1] + 1;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 2};

    solve(a);
  }
}
