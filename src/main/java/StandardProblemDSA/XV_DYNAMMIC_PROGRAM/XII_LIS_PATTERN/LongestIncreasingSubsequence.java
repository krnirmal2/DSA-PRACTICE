package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XII_LIS_PATTERN;

import java.util.Arrays;

/*300. Longest Increasing Subsequence
Given an integer array nums, return the length of the longest strictly increasing subsequence.
Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:
	• 1 <= nums.length <= 2500
-104 <= nums[i] <= 104*/
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
