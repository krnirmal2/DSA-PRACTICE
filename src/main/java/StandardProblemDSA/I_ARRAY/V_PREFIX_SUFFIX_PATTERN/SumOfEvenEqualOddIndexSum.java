package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

import StandardProblemDSA.Utility;

public class SumOfEvenEqualOddIndexSum {
  /*
  Question:
  Given an array A[], count the number of ways to remove exactly one element such that
  the sum of the remaining odd-indexed elements equals the sum of the remaining even-indexed elements.

  Example:
  Input: A = {2, 1, 6, 4, 5, 3}
  Output: 1
  Explanation:
  - Removing A[4] = 5 results in:
      newEvenSum = prefixOdd[3] + (totalOdd - prefixOdd[4]) = 5 + 8 = 13
      newOddSum = prefixEven[3] + (totalEven - prefixEven[4]) = 8 + 5 = 13
      → sums are equal, valid removal.

  Approach:
  1. Precompute prefix sums for even and odd indices:
     - prefixEven[i]: sum of all even-indexed elements up to index i.
     - prefixOdd[i]: sum of all odd-indexed elements up to index i.
  2. Calculate total sums of even and odd indexed elements.
  3. For each index i:
     - After removing A[i], recompute newEvenSum and newOddSum:
       - newEvenSum = prefixOdd[i-1] + (totalOdd - prefixOdd[i])
       - newOddSum = prefixEven[i-1] + (totalEven - prefixEven[i])
     - Handle edge case for i = 0 separately.
  4. Count valid removals where newEvenSum == newOddSum.

  Pattern:
  - Prefix Sum Pattern for Even-Odd Index Handling.

  Time Complexity:
  - O(N) to compute prefix sums and check each removal.
  Space Complexity:
  - O(N) for storing prefixEven and prefixOdd.

  Follow-up Questions:
  1. Can you optimize space to O(1) by using running totals?
  2. What if multiple elements can be removed?
  3. How would the solution change if array indices are 1-based?
  4. Can you handle updates to the array efficiently (dynamic version)?
  5. How to extend this to "remove at most one element"?

  Similar LeetCode/Interview Questions:
  - InterviewBit: Special Index
  - LeetCode 1991. Find the Middle Index in Array (similar prefix sum logic)
  - LeetCode 724. Find Pivot Index (related equilibrium index problem)
  */

  /*Given an array A[], count the number of ways we can remove one element such that the sum of odd-indexed elements becomes equal to the sum of even-indexed elements in the remaining array.
      Approach Using Prefix & Suffix Sums
      We can solve this problem efficiently in O(N) using the prefix sum technique.
      Steps:
      Compute prefix sums for even and odd indices:
      prefixEven[i] → sum of even-indexed elements up to index i
      prefixOdd[i] → sum of odd-indexed elements up to index i
      Use suffix logic to check the condition after removing A[i]:
      When removing A[i], the remaining even and odd indexed sums will be adjusted.
      After removal, we need:
      newEvenSum
  =
      newOddSum
              newEvenSum=newOddSum
      Compute newEvenSum and newOddSum dynamically for each i.

      Count valid removals where the condition holds.

      Dry Run Example
      Input:
      java
              Copy
      Edit
              A = {2, 1, 6, 4, 5, 3}
      Step 1: Compute Prefix Sums
      Index	A[i]	PrefixEven[i]	PrefixOdd[i]
              0	2	2	0
              1	1	2	1
              2	6	8	1
              3	4	8	5
              4	5	13	5
              5	3	13	8
      Step 2: Check for Each Removal
      After removing each element at index i, check if:

      newEvenSum
  =
      newOddSum
              newEvenSum=newOddSum
      For example:

      Removing A[2] = 6, updated sums:

      newEvenSum = prefixOdd[1] + (TotalOddSum - prefixOdd[2]) = 1 + 8 = 9

      newOddSum = prefixEven[1] + (TotalEvenSum - prefixEven[2]) = 2 + 6 = 8 → Not valid

      Removing A[4] = 5, updated sums:

      newEvenSum = prefixOdd[3] + (TotalOddSum - prefixOdd[4]) = 5 + 8 = 13

      newOddSum = prefixEven[3] + (TotalEvenSum - prefixEven[4]) = 8 + 5 = 13 → Valid removal*/
  public static int countWays(int[] A) {
    int n = A.length;
    if (n == 1) return 1; // If one element, removing it makes sums equal (0 == 0)

    // Step 1: Compute prefix sums
    int[] prefixEven = new int[n];
    int[] prefixOdd = new int[n];
    Utility.prefixEvenOddSum(A, prefixEven, prefixOdd, n);

    // Step 2: Check removals
    int totalEven = prefixEven[n - 1];
    int totalOdd = prefixOdd[n - 1];
    int count = 0;

    for (int i = 0; i < n; i++) {
      int newEvenSum, newOddSum;

      if (i == 0) {
        newEvenSum = totalOdd;
        newOddSum = totalEven - A[i];
      } else {
        newEvenSum = prefixOdd[i - 1] + (totalOdd - prefixOdd[i]);
        newOddSum = prefixEven[i - 1] + (totalEven - prefixEven[i]);
      }

      if (newEvenSum == newOddSum) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[] A = {2, 1, 6, 4, 5, 3};
    System.out.println(countWays(A)); // Output: 1
  }
}
