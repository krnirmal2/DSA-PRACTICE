package StandardProblemDSA.XI_GREEDYALGO.II_ONE_PASS_LOCAL_OPTIMISATION;

public class JumpGame {
  //    https://leetcode.com/problems/jump-game/description/
  /*You are given an integer array nums. You are initially positioned at the array's first index,
        and each element in the array represents your maximum jump length at that position.
    Return true if you can reach the last index, or false otherwise.

    Example 1:
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it
     impossible to reach the last index.
    Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 105
     - Maintain `maxReach`, the farthest index you can reach so far.
      - Iterate through the array:
          * If current index `i` > `maxReach`, you can’t move further → return false.
          * Update `maxReach = max(maxReach, i + nums[i])`.
          * If `maxReach >= n - 1`, you can reach the end → return true.

  Pattern:
      - **Greedy**: Always track the farthest reachable index.

  LeetCode:
      - LeetCode 55: Jump Game. done

  Time Complexity:
      - O(n), single pass.
  Space Complexity:
      - O(1), constant extra space.

  Follow-up:
      - Jump Game II: Find minimum jumps to reach the last index.*/

  public boolean canJump(int[] nums) {
    int n = nums.length;
    int maxReach = 0; // Tracks the farthest index we can reach

    for (int i = 0; i < n; i++) {
      // If we are at a position we cannot reach, return false
      if (i > maxReach) {
        return false;
      }
      // Update the maximum reachable index
      maxReach = Math.max(maxReach, i + nums[i]);

      // If the maximum reachable index is beyond or at the last index, return true
      if (maxReach >= n - 1) {
        return true;
      }
    }

    return false; // If we finish the loop without reaching the last index
  }
}
