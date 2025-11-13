package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

/*
Question:
Find the equilibrium index of an integer array A where the sum of elements before index i
equals the sum of elements after index i. Return the smallest such index if multiple exist,
or -1 if none.

Example:
Input: A = [-7, 1, 5, 2, -4, 3, 0]
Output: 3
Explanation:
- Sum of elements before index 3 = (-7 + 1 + 5) = -1
- Sum of elements after index 3 = (-4 + 3 + 0) = -1
- Both are equal, so index 3 is an equilibrium index.

Input: A = [1, 2, 3]
Output: -1
Explanation: No index satisfies the condition.

Approach:
1. Compute prefix and suffix sums for the array.
2. For each index i:
   - leftSum = sum of elements before i (prefix[i-1]).
   - rightSum = sum of elements after i (suffix[i+1]).
3. If leftSum == rightSum, return i (the first equilibrium index).
4. If no such index is found, return -1.

Pattern:
- Prefix Sum Pattern.
- Uses cumulative sums to quickly calculate left and right sums for each index.

Time Complexity:
- O(n), single pass to build prefix and suffix sums + one pass to check indices.
Space Complexity:
- O(n), additional arrays for prefix and suffix sums.
- Can be optimized to O(1) by using total sum and running left sum.

Follow-up Questions:
1. Can you solve it in O(1) space without prefix and suffix arrays?
2. How to handle multiple equilibrium indices (return all of them)?
3. How would the solution change for a circular array?
4. Can we adapt this for large datasets with streaming data?
5. What if we need to find equilibrium indices in a matrix (row-wise and column-wise)?

Similar LeetCode/Interview Questions:
- LeetCode 724. Find Pivot Index
- LeetCode 1991. Find the Middle Index in Array
- InterviewBit: Equilibrium Index of an Array
*/

import StandardProblemDSA.Utility;

public class EquilibriumIndex {
  // sum of elements before i == sum of elements after i
  static int solve(int[] A) {
    int n = A.length;
    if (n == 0) return -1; // Edge case: Empty array

    int[] prefixSum = new int[n];
    int[] suffixSum = new int[n];

    Utility.prefixSum(A, prefixSum);
    Utility.suffixSum(A, suffixSum);

    // Find equilibrium index
    for (int i = 0; i < n; i++) {
      int leftSum = (i == 0) ? 0 : prefixSum[i - 1];
      int rightSum = (i == n - 1) ? 0 : suffixSum[i + 1];

      if (leftSum == rightSum) {
        return i; // Return first equilibrium index found
      }
    }

    return -1; // No equilibrium index found
  }

  // runs in O(n) time with O(n) space due to prefix/suffix array
  public static void main(String[] args) {
    int[] A = {-7, 1, 5, 2, -4, 3, 0};
    System.out.println(solve(A)); // Expected output: 3
  }
}
