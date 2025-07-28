package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION;

import StandardProblemDSA.Utility;

/*55. Jump Game
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
	• 1 <= nums.length <= 104
	• 0 <= nums[i] <= 105

From <https://leetcode.com/problems/jump-game/description/>

 Pattern:
- Greedy approach: track the furthest index reachable while iterating.
- If at any point the current index > maxReach, we can’t proceed → return false.

Approach:
1. Initialize maxReach = 0.
2. Iterate through nums:
    - If i > maxReach, return false.
    - Update maxReach = max(maxReach, i + nums[i]).
    - If maxReach >= last index, return true.
3. If loop completes, return true.

Time Complexity: O(n)
Space Complexity: O(1)

Similar/Follow-up LeetCode Problems:
- LC 45: Jump Game II (minimum jumps)
- LC 1306: Jump Game III (BFS from starting index)
- LC 1345: Jump Game IV (minimum jumps with value-based jumps)*/
public class JumpGame {

  public int jump(int[] nums) {
    // jump util give the all jump regarding minimum jump
    // start from index 0
    return jumpUtil(nums, 0);
  }

  public int jumpUtil(int[] nums, int i) {
    if (Utility.isReachedLastIndex(nums, i)) return 0;
    int minJump = Integer.MAX_VALUE;
    // iterate over all the possible index jump
    for (int j = 1; j <= nums[i]; j++) {
      int next = jumpUtil(nums, i + j);
      if (next != Integer.MAX_VALUE) {
        minJump = Math.min(minJump, 1 + next);
      }
    }
    return minJump;
  }

  // class Solution {
  //     public int jump(int[] nums) {
  //         int near = 0, far = 0, jumps = 0;

  //         while (far < nums.length - 1) {
  //             int farthest = 0;
  //             for (int i = near; i <= far; i++) {
  //                 farthest = Math.max(farthest, i + nums[i]);
  //             }
  //             near = far + 1;
  //             far = farthest;
  //             jumps++;
  //         }

  //         return jumps;
  //     }
  // }
}
