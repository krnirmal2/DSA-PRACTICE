package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XII_LIS_PATTERN;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence_I {
  /*
      Longest Increasing Subsequence – Printing the LIS
      Given an integer array arr of size n, find and print the actual Longest Increasing Subsequence (LIS) along with its length.

      Example:
      --------
      Input: arr = [10, 9, 2, 5, 3, 7, 101, 18]
      Output:
          The subsequence elements are 2 3 7 101
          Length: 4

      Approach (DP with reconstruction):
      ----------------------------------
      • Maintain two arrays:
          dp[i]   – length of LIS ending at index i.
          hash[i] – index of the previous element in the LIS ending at i.

      • For each i, check all previous indices j < i:
          if arr[j] < arr[i] and 1 + dp[j] > dp[i]:
              update dp[i] and set hash[i] = j.

      • Find the index of the maximum LIS length.
      • Reconstruct the LIS by following hash[] from last index to start.
      • Reverse the sequence for correct order.

      Pattern:
      --------
      • Dynamic Programming with LIS reconstruction.
      • Hash array helps backtrack the subsequence.

      Complexity:
      -----------
      • Time: O(n²) – two nested loops for DP.
      • Space: O(n) – dp[] and hash[] arrays.

      Follow-ups:
      -----------
      1. Optimize LIS length computation to O(n log n) using Binary Search (patience sorting).
      2. Count all LIS of maximum length.
      3. Find Longest Decreasing Subsequence (LDS) or Bitonic Subsequence.

      Related LeetCode Problems:
      --------------------------
      • 300 – Longest Increasing Subsequence
      • 673 – Number of LIS
      • 368 – Largest Divisible Subset
  */

  static int longestIncreasingSubsequence(int[] arr, int n) {

    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    int[] hash = new int[n];
    Arrays.fill(hash, 1);

    for (int i = 0; i <= n - 1; i++) {
      hash[i] = i; // initializing with current index
      for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
        if (arr[prev_index] < arr[i] && 1 + dp[prev_index] > dp[i]) {
          dp[i] = 1 + dp[prev_index];
          hash[i] = prev_index;
        }
      }
    }

    int ans = -1;
    int lastIndex = -1;

    for (int i = 0; i <= n - 1; i++) {
      if (dp[i] > ans) {
        ans = dp[i];
        lastIndex = i;
      }
    }

    ArrayList<Integer> temp = new ArrayList<>();
    temp.add(arr[lastIndex]);

    while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
      lastIndex = hash[lastIndex];
      temp.add(arr[lastIndex]);
    }

    // reverse the array
    System.out.print("The subsequence elements are ");
    for (int i = temp.size() - 1; i >= 0; i--) {
      System.out.print(temp.get(i) + " ");
    }
    System.out.println();
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
    int n = arr.length;
    longestIncreasingSubsequence(arr, n);
  }
  //    Output:
  //
  //    The length of the longest increasing subsequence is 4
  //
  //    Time Complexity: O(N*N)
  //
  //    Reason: There are two nested loops
  //
  //    Space Complexity: O(N*N)
  //
  //    Reason: We are using an external array of size ‘(N+1)*(N+1)’. Stack Space is eliminated.
}
