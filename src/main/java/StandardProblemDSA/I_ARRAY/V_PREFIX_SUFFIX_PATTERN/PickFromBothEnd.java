package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

import StandardProblemDSA.Utility;

/*
Question:
Given an integer array A and an integer B, you need to pick exactly B elements from either the start or the end of the array to maximize the sum.

Example:
Input: A = [1, 2, 3, 4, 5], B = 3
Output: 12
Explanation:
- Possible picks:
  - [1, 2, 3] → sum = 6
  - [1, 2] + [5] → sum = 8
  - [1] + [4, 5] → sum = 10
  - [3, 4, 5] → sum = 12 (maximum)

Approach:
1. Precompute the suffix sums array (sum of elements from i to end).
2. Iterate through i = 0 to B-1:
   - Take i+1 elements from the start (prefix sum).
   - Take (B - i - 1) elements from the end using suffix sums.
   - Update the maximum sum.
3. Also consider the case where all B elements are taken from the end.

Pattern:
- Sliding Window + Prefix/Suffix Sum Pattern.
- Combines elements from both ends efficiently.

Time Complexity:
- O(B + N), where N = size of array and B = elements to pick.
Space Complexity:
- O(N) for suffix sum array; can be optimized to O(1) by calculating sums on the fly.

Follow-up Questions:
1. Can you optimize space to O(1) by using two pointers?
2. How would the solution change if we were allowed to pick elements in any order (not just contiguous from start or end)?
3. Can we extend this to pick B elements from k different ends (e.g., in a circular array)?
4. What if B > N? How should we handle it?
5. How would we handle negative numbers to ensure maximum sum?

Similar LeetCode/Interview Questions:
- InterviewBit: Pick from both sides!
- LeetCode 1423. Maximum Points You Can Obtain from Cards
- LeetCode 209. Minimum Size Subarray Sum (similar prefix-suffix window logic)
*/

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
