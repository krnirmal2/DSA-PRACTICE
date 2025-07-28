package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION;

import StandardProblemDSA.Utility;

/*45. Jump Game II
You are given an integer array nums. Each element represents your maximum jump length at that position.
Return the minimum number of jumps to reach the last index.

Pattern:
- Greedy: track the farthest position we can reach in the current jump.
- Use variables:
    - jumps → number of jumps taken
    - currentEnd → farthest index we can reach in the current jump
    - farthest → farthest index we can reach overall.

Approach:
1. Iterate through nums (except last index):
    - Update farthest = max(farthest, i + nums[i]).
    - If we reach currentEnd:
        - Increment jumps.
        - Update currentEnd = farthest.
2. Return jumps.

Time Complexity: O(n)
Space Complexity: O(1)

Similar / Follow-up Problems:
- LC 55: Jump Game I (check if reachable)
- LC 1306: Jump Game III (BFS approach)
- LC 1345: Jump Game IV (minimum jumps with value-based jumps)
*/
public class JumpGameII {
  public int jump(int[] nums) {
    int n = nums.length;
    int[] dp = Utility.linearArrayMemo(n);
    return jumpUtil(nums, 0, dp);
  }

  public int jumpUtil(int[] nums, int i, int[] dp) {
    if (Utility.isReachedLastIndex(nums, i)) return 0;

    if (dp[i] != -1) return dp[i];

    int minJump = Integer.MAX_VALUE;
    for (int j = 1; j <= nums[i]; j++) {
      int next = jumpUtil(nums, i + j, dp);
      if (next != Integer.MAX_VALUE) {
        minJump = Math.min(minJump, 1 + next);
      }
    }
    dp[i] = minJump;
    return dp[i];
  }
} /*
  public int jump(int[] nums) {
      int n= nums.length;
      // jump util give the all jump regarding minimum jump
      // start from index 0
      return jumpUtil(nums,0);

  }
  public int jumpUtil(int [] nums,int i){
      if(i>=nums.length-1) return 0;
      int minJump  = Integer.MAX_VALUE;
      // iterate over all the possible index jump
      for(int j=1 ; j<=nums[i] ;j++){
          int next = jumpUtil(nums, i + j);
          if (next != Integer.MAX_VALUE) {
              minJump = Math.min(minJump, 1 + next);
          }
      }
      return minJump;

  }*/
