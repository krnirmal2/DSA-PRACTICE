package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.VI_MATRIX_CHAIN_MULTIPLICATION_DP;

public class BurstBallon {
  /*
      312. Burst Balloons
  Hard
  You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
  If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
  Return the maximum coins you can collect by bursting the balloons wisely.

  Example 1:
  Input: nums = [3,1,5,8]
  Output: 167
  Explanation:
  nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
  coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
  Example 2:
  Input: nums = [1,5]
  Output: 10

  Constraints:
  	• n == nums.length
  	• 1 <= n <= 300
  0 <= nums[i] <= 100*/
  public int maxCoins(int[] nums) {
    int n = nums.length;

    // Extend nums with 1 at both ends
    int[] balloons = new int[n + 2];
    balloons[0] = balloons[n + 1] = 1;
    System.arraycopy(nums, 0, balloons, 1, n);

    // Call recursive function
    return solve(balloons, 1, n);
  }

  private int solve(int[] balloons, int i, int j) {
    // Base case: No balloons left to burst
    if (i > j) return 0;
    int maxCoins = 0;

    // Try bursting each balloon k as the last burst in the range [i, j]
    for (int k = i; k <= j; k++) {
      int coins =
          solve(balloons, i, k - 1) // Left subproblem
              + balloons[i - 1] * balloons[k] * balloons[j + 1] // Coins from bursting k last
              + solve(balloons, k + 1, j); // Right subproblem

      maxCoins = Math.max(maxCoins, coins);
    }

    return maxCoins;
  }
}
