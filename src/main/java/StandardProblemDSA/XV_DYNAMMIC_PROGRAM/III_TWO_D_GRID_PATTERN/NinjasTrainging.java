package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.III_TWO_D_GRID_PATTERN;

import java.util.Arrays;

public class NinjasTrainging {
  /* Problem statement
    Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?

    You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

            For Example
    If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
    Detailed explanation ( Input/output format, Notes, Images )
    Constraints:
            1 <= T <= 10
            1 <= N <= 100000.
            1 <= values of POINTS arrays <= 100 .

    Time limit: 1 sec
    Sample Input 1:
            2
            3
            1 2 5
            3 1 1
            3 3 3
            3
            10 40 70
            20 50 80
            30 60 90
    Sample Output 1:
            11
            210
    Explanation of sample input 1:
    For the first test case,
    One of the answers can be:
    On the first day, Ninja will learn new moves and earn 5 merit points.
    On the second day, Ninja will do running and earn 3 merit points.
    On the third day, Ninja will do fighting and earn 3 merit points.
    The total merit point is 11 which is the maximum.
    Hence, the answer is 11.

    For the second test case:
    One of the answers can be:
    On the first day, Ninja will learn new moves and earn 70 merit points.
    On the second day, Ninja will do fighting and earn 50 merit points.
    On the third day, Ninja will learn new moves and earn 90 merit points.
    The total merit point is 210 which is the maximum.
    Hence, the answer is 210.
    Sample Input 2:
            2
            3
            18 11 19
            4 13 7
            1 8 13
            2
            10 50 1
            5 100 11
    Sample Output 2:
            45
            110

  Pattern:
  - Dynamic Programming (row-by-row DP, like grid DP).
  - State: dp[day][last] = max points up to this day if previous day’s task was `last`.
  - Transitions:
      For each task ≠ last:
          dp[day][last] = max(points[day][task] + dp[day-1][task])
  - Base Case: For day 0, pick the maximum of all valid tasks.

  Approach:
  1. Use recursion + memoization (top-down) or tabulation (bottom-up).
  2. Keep track of the previous task to avoid repetition.
  3. Time complexity: O(N × 4 × 3) ≈ O(12N) → O(N).
  4. Space complexity: O(N × 4) for memo; can be optimized to O(4).

  Similar / Follow-up Problems:
  - LC 931: Minimum Falling Path Sum (row-by-row DP, minimize instead of maximize)
  - LC 120: Triangle Minimum Path Sum (adjacent moves, minimize sum)
  - LC 62/63: Unique Paths (counting instead of maximizing score)
  - “Paint House” problem (DP with no adjacent same color)
            */

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(n - 1, 3, points, dp);
    }

    private static int helper(int day, int last, int[][] points, int[][] dp) {
        if (day < 0) return 0;

        if (dp[day][last] != -1) return dp[day][last];

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int score = points[day][task] + helper(day - 1, task, points, dp);
                max = Math.max(max, score);
            }
        }

        return dp[day][last] = max;
    }
}
 /*   Why this works
 	• dp[day][last] stores the result of the subproblem “best score up to this day with last activity.”
             • Each (day, last) pair is computed once.
             • Complexity drops to O(n × 4 × 3) ≈ O(12n) — easily fits within time limits for n ≤ 10^5.
 */
