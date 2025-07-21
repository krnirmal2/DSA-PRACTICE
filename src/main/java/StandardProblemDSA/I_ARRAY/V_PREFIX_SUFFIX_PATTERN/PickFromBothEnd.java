package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

import StandardProblemDSA.Utility;

public class PickFromBothEnd {
  /*Find the maximum sum of B elements picked from either start or end (or both) of the array A.
  This is a classic sliding window + prefix/suffix trick problem — similar to "Pick B elements from either end of array to maximize the sum".*/
  public static int solve(int[] A, int B) {
    int n = A.length;
    int[] suff = new int[n + 1];
    suff[n] = 0;
    Utility.suffixSum(A, suff);
    int pref_sum = 0;
    int ans = suff[n - B];
    for (int i = 0; i < B; i++) {
      pref_sum = pref_sum + A[i];
      int suff_sum = suff[n - B + (i + 1)];
      ans = Math.max(ans, pref_sum + suff_sum);
    }
    return ans;
  }

  // O(B + N) — efficient for large arrays.
  public static void main(String[] args) {
    System.out.println(solve(new int[] {1, 2, 3, 4, 5}, 3));
  } // Output: 12
}
