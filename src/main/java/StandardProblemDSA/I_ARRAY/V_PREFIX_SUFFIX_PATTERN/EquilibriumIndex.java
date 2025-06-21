package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

/* Problem Description
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.



Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105


Input Format
First arugment is an array A .


Output Format
Return the equilibrium index of the given array. If no such index is found then return -1.


Example Input
Input 1:
A=[-7, 1, 5, 2, -4, 3, 0]
Input 2:

A=[1,2,3]


Example Output
Output 1:
3
Output 2:

-1


Example Explanation
Explanation 1:
3 is an equilibrium index, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
Explanation 1:

There is no such index.
*/

import StandardProblemDSA.Utility;

public class EquilibriumIndex {
//sum of elements before i == sum of elements after i
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
