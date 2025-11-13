package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.IV_KNAPSACK.ZERO_ONE_KNAPSACK;

import java.util.Arrays;

/*Given an array arr[] of non-negative integers and a value sum, the task is to check if there is a
subset of the given array whose sum is equal to the given sum.

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.

bservation:
- Classic **decision version** of the subset sum problem.
- Similar to 0/1 Knapsack:
    - For each element, we have two choices: **include** it or **exclude** it.
    - We must check if any combination reaches `sum`.

Approaches:
1. **Recursion (brute force):**
    - Explore all subsets: include/exclude each element.
    - Time: O(2^n), Space: O(n) recursion stack.

2. **Top-down DP (Memoization):**
    - State: dp[n][sum] → true if subset with sum `sum` can be formed using first `n` elements.
    - Avoid recomputation by caching results.
    - Time: O(n * sum), Space: O(n * sum).

3. **Bottom-up DP (Tabulation):**
    - Build a table where dp[i][j] = true if subset of first i elements can sum to j.
    - Time: O(n * sum), Space: O(n * sum).
    - Space-optimized: Use 1D array dp[sum + 1].

Edge Cases:
- sum = 0 → always true (empty subset).
- arr[] empty and sum > 0 → false.
- All elements greater than sum → false.

Similar Problems:
- Partition Equal Subset Sum (LC 416).
- Minimum Subset Sum Difference.
- Target Sum (LC 494).
- Count of Subsets with Given Sum.
*/
public class SubsetSum {
  // Recursive function to check if a subset
  // with the given sum exists
  static boolean isSubsetSumRec(int[] arr, int n, int sum, int[][] memo) {

    // If the sum is zero, we found a subset
    if (sum == 0) {
      return true;
    }

    // If no elements are left
    if (n <= 0) {
      return false;
    }

    // If the value is already computed, return it
    if (memo[n][sum] != -1) {
      return memo[n][sum] == 1;
    }

    // If the last element is greater than the sum,
    // ignore it
    if (arr[n - 1] > sum) {
      memo[n][sum] = isSubsetSumRec(arr, n - 1, sum, memo) ? 1 : 0;
    } else {
      // Include or exclude the last element directly
      memo[n][sum] =
          (isSubsetSumRec(arr, n - 1, sum, memo)
                  || isSubsetSumRec(arr, n - 1, sum - arr[n - 1], memo))
              ? 1
              : 0;
    }

    return memo[n][sum] == 1;
  }

  // Function to initiate the subset sum check
  static boolean isSubsetSum(int[] arr, int sum) {
    int n = arr.length;
    int[][] memo = new int[n + 1][sum + 1];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return isSubsetSumRec(arr, n, sum, memo);
  }

  public static void main(String[] args) {

    int[] arr = {1, 5, 3, 7, 4};
    int sum = 12;

    if (isSubsetSum(arr, sum)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }
}

       /* // Function to check if there is a subset of arr[]
       // with sum equal to the given sum using tabulation
       static boolean isSubsetSum(int[] arr, int sum) {
           int n = arr.length;

           // Create a 2D array for storing results of
           // subproblems
           boolean[][] dp = new boolean[n + 1][sum + 1];

           // If sum is 0, then answer is true
           // (empty subset)
           for (int i = 0; i <= n; i++) {
               dp[i][0] = true;
           }

           // Fill the dp table in bottom-up manner
           for (int i = 1; i <= n; i++) {
               for (int j = 1; j <= sum; j++) {
                   if (j < arr[i - 1]) {

                       // Exclude the current element
                       dp[i][j] = dp[i - 1][j];
                   }
                   else {

                       // Include or exclude
                       dp[i][j] = dp[i - 1][j]
                               || dp[i - 1][j - arr[i - 1]];
                   }
               }
           }

           return dp[n][sum];
       }*/
/*[Expected Approach] Using Space Optimized DP – O(sum*n) Time and O(sum) Space*/
/*In previous approach of dynamic programming we have derive the relation between states as given below:


if (arr[i-1] > j)
    dp[i][j] = dp[i-1][j]
else
    dp[i][j] = dp[i-1][j] OR dp[i-1][j-arr[i-1]]


If we observe that for calculating current dp[i][j] state we only need previous row dp[i-1][j]
 or dp[i-1][j-arr[i-1]]. There is no need to store all the previous states just one previous state
  is used to compute result.
  Approach:

Define two arrays prev and curr of size sum+1 to store the just previous row result and current row result respectively.
Once curr array is calculated then curr becomes our prev for the next row.
When all rows are processed the answer is stored in prev array.
  // Returns true if there is a subset of arr[]
    // with sum equal to given sum
    static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];

        // Mark prev[0] = true as it is true to
        // make sum = 0 using 0 elements
        prev[0] = true;

        // Fill the subset table in bottom-up
        // manner
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    curr[j] = prev[j];
                }
                else {
                    curr[j]
                        = prev[j] || prev[j - arr[i - 1]];
                }
            }

            // Update prev to be the current row
            System.arraycopy(curr, 0, prev, 0, sum + 1);
        }
        return prev[sum];
    }


  */
