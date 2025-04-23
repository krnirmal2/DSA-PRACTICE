package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.II_LINEAR_SEQUENC_WITH_CONSTANTTRNSATION;

import java.util.Arrays;

public class JumpGameII {
  public int jump(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return jumpUtil(nums, 0, dp);
  }

  public int jumpUtil(int[] nums, int i, int[] dp) {
    if (i >= nums.length - 1) return 0;

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
