package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION;

public class MaximaumSumOfNonAdjacentElements {
  /*
        Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence
         such that no two elements of the subsequence are adjacent elements in the array.
    Note: A subsequence of an array is a list with elements of the array where some elements are deleted ( or not deleted at all)
     and the elements should be in the same order in the subsequence as in the array.
     Examples:
    Input: nums = [1, 2, 4]
    Output: 5
    Explanation: [1, 2, 4], the underlined elements are taken to get the maximum sum.
    Input: nums = [2, 1, 4, 9]
    Output: 11
    Explanation: [2, 1, 4, 9], the underlined elements are taken to get the maximum sum.
  todo

     Pattern:
        - Classic DP (House Robber pattern)
        - Choose between:
            1. Picking the current element → nums[i] + dp[i-2]
            2. Not picking the current element → dp[i-1]

        Approach:
        1. Use two variables to store the maximum sum until the previous and the one before previous.
        2. Iterate through the array, updating max sum by choosing the best option at each index.

        Time Complexity: O(n)
        Space Complexity: O(1) (optimized version)

        Similar LeetCode Problems:
        - LC 198: House Robber I
        - LC 213: House Robber II
        - LC 740: Delete and Earn (variation)


        */
}
