package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION;

public class HouseRobberII {
  /*213. House Robber II
  Medium
  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
  Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

  Example 1:
  Input: nums = [2,3,2]
  Output: 3
  Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
  Example 2:
  Input: nums = [1,2,3,1]
  Output: 4
  Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
  Total amount you can rob = 1 + 3 = 4.
  Example 3:
  Input: nums = [1,2,3]
  Output: 3
  */
  class Solution {
    public int rob(int[] nums) {
      // as there circle so robberwill rob in two part
      // start from even index and rob all even index
      // or start from the odd index and rob all the odd index and collect
      // we will find the max amount them
      int n = nums.length;
      if (n == 1) return nums[0];

      int odd = util(1, n - 1, nums, n);
      int even = util(0, n - 2, nums, n);
      // return the max amoun odd and even start
      return Math.max(odd, even);
    }

    public int util(int start, int end, int[] nums, int n) {
      if (start > end) return 0;
      int robThis = nums[start] + util(start + 2, end, nums, n);
      int skipThis = util(start + 1, end, nums, n);
      return Math.max(robThis, skipThis);
    }
  }
}
