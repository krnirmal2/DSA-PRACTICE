package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XII_LIS_PATTERN;

import java.util.Arrays;

/*
    300. Longest Increasing Subsequence (LIS)
    Given an integer array nums, return the length of the longest strictly increasing subsequence (LIS).
    Examples:
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: LIS = [2,3,7,101]

    Input: nums = [0,1,0,3,2,3]
    Output: 4

    Input: nums = [7,7,7,7,7,7,7]
    Output: 1

    Why Important?
    --------------
    • Fundamental DP problem – builds foundation for subsequence-based problems.
    • Appears in interviews for FAANG regularly.
    • Variations: printing LIS, number of LIS, LDS, Bitonic subsequence, etc.

    Pattern:
    • DP recursion with two states: index and prevIndex.
        helper(index, prev):
            → Either skip current element.
            → Or take current element if nums[index] > nums[prev].
        Transition:
            dp[index][prev+1] = max(take, skip).

    • Top-down with memoization: O(n²)
    • Bottom-up tabulation: O(n²)
    • Optimized with Binary Search: O(n log n)

    Follow-ups:
    -----------
    1. Print LIS elements, not just length.
    2. Count all LIS of maximum length.
    3. Can we optimize to O(n log n) with patience sorting?
    4. Solve for Longest Decreasing Subsequence (LDS) or Bitonic Subsequence.

    Complexities:
    -------------
    Recursive + Memoization:
        Time: O(n × n) = O(n²)
        Space: O(n²) for memo + O(n) recursion stack.

    Related Problems:
    -----------------
    • LeetCode 300 – Longest Increasing Subsequence
    • LeetCode 673 – Number of Longest Increasing Subsequence
    • LeetCode 354 – Russian Doll Envelopes
    • LeetCode 368 – Largest Divisible Subset
      Increasing Triplet Subsequence
      Russian Doll Envelopes
      Maximum Length of Pair Chain
      Number of Longest Increasing Subsequence
      Minimum ASCII Delete Sum for Two Strings
      Minimum Number of Removals to Make Mountain Array
      Find the Longest Valid Obstacle Course at Each Position
      Minimum Operations to Make the Array K-Increasing
      Longest Ideal Subsequence
      Maximum Number of Books You Can Take
      Longest Increasing Subsequence II
      Find the Maximum Length of a Good Subsequence II
      Find the Maximum Length of a Good Subsequence I
      Find the Maximum Length of Valid Subsequence I
      Find the Maximum Length of Valid Subsequence II
      Longest Subsequence With Decreasing Adjacent Difference
*/

public class LongestIncreasingSubsequence {
  public int Lis(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return 1;
    // memoise it what we will do
    int[][] memo = new int[nums.length][nums.length + 1];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }

    return helper(nums, 0, -1, memo);
    //

  }

  // approach
  public int helper(int[] nums, int index, int prev, int[][] memo) {
    /*    // if reach the last element
       // then we have to return 0
       if(index == nums.length-1) return memo[0];
       int notTake =  helper(nums, index+1,index);

       // we take
       int take= 0;
       if(nums[prev] <nums[index]) {
            take = 1+ helper(nums, index + 1, index);
       }
    return   Math.max(take, notTake);

       */

    // MEmoisation of the above recursion
    if (index == nums.length - 1) return 0;
    if (memo[index][prev + 1] != 1) {
      return memo[index][prev + 1];
    }
    int notTake = helper(nums, index + 1, index, memo);

    // we take
    int take = 0;
    if (prev == -1 || nums[prev] < nums[index]) {
      take = 1 + helper(nums, index + 1, index, memo);
    }
    memo[index][prev + 1] = Math.max(take, notTake);
    return memo[index][prev + 1];
  }
  /*📌 Time and Space Complexity
  • Time: O(n²) because we have n indices × n+1 prevIndex states.
     Space: O(n²) for DP + O(n) stack (recursion depth)*/
}
