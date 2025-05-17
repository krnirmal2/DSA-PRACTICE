package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

import StandardProblemDSA.Utility;

public class SumOfEvenEqualOddIndexSum {

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
