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

public class EquilibriumIndex {

  static int solve(int[] A) {
    int n = A.length;
    if (n == 0) return -1; // Edge case: Empty array

    int[] prefixSum = new int[n];
    int[] suffixSum = new int[n];

    // Compute prefix sum
    prefixSum[0] = A[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] + A[i];
    }

    // Compute suffix sum
    suffixSum[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      suffixSum[i] = suffixSum[i + 1] + A[i];
    }

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

  public static void main(String[] args) {
    int[] A = {-7, 1, 5, 2, -4, 3, 0};
    System.out.println(solve(A)); // Expected output: 3
  }

  public static class ClosestMaxMin {
    static int solve(int[] A) {
      int n = A.length;
      if (n == 0) return 0; // Edge case: empty array

      // Step 1: Find min and max values
      int min = A[0], max = A[0];
      for (int num : A) {
        if (num > max) max = num;
        if (num < min) min = num;
      }

      if (min == max) return 1; // If all elements are the same, the answer is 1

      // Step 2: Store the last seen positions of min and max
      int[] prefixMin = new int[n];
      int[] prefixMax = new int[n];

      int lastMinIndex = -1, lastMaxIndex = -1;
      int ans = n;

      for (int i = 0; i < n; i++) {
        if (A[i] == min) lastMinIndex = i;
        if (A[i] == max) lastMaxIndex = i;

        prefixMin[i] = lastMinIndex;
        prefixMax[i] = lastMaxIndex;
      }

      // Step 3: Find the smallest subarray containing both min and max
      for (int i = 0; i < n; i++) {
        if (A[i] == min && prefixMax[i] != -1) {
          ans = Math.min(ans, i - prefixMax[i] + 1);
        }
        if (A[i] == max && prefixMin[i] != -1) {
          ans = Math.min(ans, i - prefixMin[i] + 1);
        }
      }

      return ans;
    }

    public static void main(String[] args) {
      int[] a = {1, 3, 2, 1, 4, 5, 1, 4, 2};
      System.out.println(
          solve(a)); // Expected output: The length of the closest subarray containing both min and
      // max
    }
    /*🔹 Input:
        int[] A = {1, 3, 2, 1, 4, 5, 1, 4, 2};
        Step 1: Find min and max values
        Minimum (min) = 1 (smallest element in the array)

        Maximum (max) = 5 (largest element in the array)

        Step 2: Construct prefixMin[] and prefixMax[]
        We iterate over the array and store the last seen index of min and max as we traverse.

        Index (i)	A[i]	Last Min Index (lastMinIndex)	Last Max Index (lastMaxIndex)	prefixMin[i]	prefixMax[i]
                0	1	0	-1	0	-1
                1	3	0	-1	0	-1
                2	2	0	-1	0	-1
                3	1	3	-1	3	-1
                4	4	3	-1	3	-1
                5	5	3	5	3	5
                6	1	6	5	6	5
                7	4	6	5	6	5
                8	2	6	5	6	5
        Step 3: Find the Smallest Subarray Containing Both Min & Max
        We traverse again and update the minimum possible subarray length.

        Index (i)	A[i]	prefixMin[i]	prefixMax[i]	Current Window (if valid)	Minimum Subarray Length
    0	1	0	-1	Invalid (No max seen)	-
                1	3	0	-1	Invalid	-
                2	2	0	-1	Invalid	-
                3	1	3	-1	Invalid	-
                4	4	3	-1	Invalid	-
                5	5	3	5	(5 - 3 + 1) = 3	3
                6	1	6	5	(6 - 5 + 1) = 2	2
                7	4	6	5	(7 - 5 + 1) = 3	2
                8	2	6	5	(8 - 5 + 1) = 4	2
                🔹 Final Answer: 2
                ✅ The smallest subarray containing both min (1) and max (5) has length 2, found between indices 5-6 → {5, 1}.

    */
  }
}
