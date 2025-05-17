package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

import StandardProblemDSA.Utility;

public class ClosestMaxMin {
  static int solve(int[] A) {
    int n = A.length;
    if (n == 0) return 0; // Edge case: empty array

    // Step 1: Find min and max values
    int min = Utility.findMin(A), max = Utility.findMax(A);
    if (min == max) return 1; // If all elements are the same, the answer is 1
    int ans = n;
    // Step 2: Store the last seen positions of min and max
    int[] prefixMin = new int[n];
    int[] prefixMax = new int[n];
    Utility.prefixMinMaxWithMinusOneIntialisationINDEX(A, min, max, prefixMin, prefixMax);
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
