package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.III_TWO_D_GRID_PATTERN;

public class MinimamMaximamFallingPathSum {
  /*https://leetcode.com/problems/minimum-falling-path-sum/description/
       Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
    A falling path starts at any element in the first row and chooses the element in the next row that is
     either directly below or diagonally left/right. Specifically, the next element from
     position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
    Example 1:

    Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
    Output: 13
    Explanation: There are two falling paths with a minimum sum as shown.
    Example 2:
    Input: matrix = [[-19,57],[-40,-5]]
    Output: -59
    Explanation: The falling path with a minimum sum is shown.
    Constraints:

    n == matrix.length == matrix[i].length
    1 <= n <= 100
    -100 <= matrix[i][j] <= 100

  Pattern:
  - Dynamic Programming on a grid.
  - At each cell, pick the minimum of the three possible moves from the next row.
  - State: dp[row][col] = matrix[row][col] + min(dp[row+1][col], dp[row+1][col-1], dp[row+1][col+1]).

  Approach:
  1. Start from the last row (base case: dp[lastRow][col] = matrix[lastRow][col]).
  2. Move upwards, filling dp for each cell using the minimum of the three valid moves.
  3. Answer = minimum value in dp[0][col] (any column in the first row).

  Time Complexity: O(n²)
  Space Complexity: O(n²) (can be optimized to O(n) using a single row).

  Similar / Follow-up Problems:
  - LC 1289: Minimum Falling Path Sum II (no adjacent column in the next row)
  - Ninja’s Training (maximize score, constraint on previous choice)
  - LC 120: Triangle (minimum path sum in triangle-shaped grid)
  - LC 64: Minimum Path Sum (only right and down moves)  */

  /*Yes,
      * **
      * LeetCode 931: Minimum Falling Path Sum** is a **similar type** of dynamic programming problem,
      *  but there’s a key difference:

  ### **Ninja’s Training**
  * `n` days, **3 fixed tasks** each day.
  * You **must choose one task per day**, and you **cannot pick the same task** as the previous day.
  * **State:** `dp[day][last]` – maximum points up to this day if last task was `last`.
  *
  ### **Minimum Falling Path Sum**
  * Square matrix `n × n`, can start from **any cell in the first row**.
  * On each step, you can go **straight down, diagonally left, or diagonally right**.
  * Goal: **minimize** the sum.
  * **State:** `dp[row][col]` – minimum path sum to reach cell `(row, col)`.

  ---

  ### **Similarity**

  * Both are **row-by-row DP** problems.
  * At each step, you **consider multiple choices** and take **min/max** accordingly.
  * The recurrence:

    ```
    dp[row][col] = matrix[row][col] + min(dp[row-1][col],
                                          dp[row-1][col-1],
                                          dp[row-1][col+1])

    is similar to:
    dp[day][last] = max(points[day][task] + dp[day-1][task]) for all task != last
    ```
  ### **Main Difference**

  * Ninja’s Training → maximize score; tasks are fixed (3 columns); **cannot repeat previous task**.
  * Falling Path Sum → minimize path; matrix columns vary; movement restricted by adjacency (can reuse same column if valid).

  ---

  ### Would you like me to give you a **side-by-side table** comparing **Ninja’s Training vs Minimum Falling Path Sum**, with recurrence, base case, and tabulation logic?

  It’ll help you quickly see the pattern similarity for DP interviews. Should I proceed?
  */

  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int minSum = Integer.MAX_VALUE;

    // Try starting from every column in the first row
    for (int col = 0; col < n; col++) {
      minSum = Math.min(minSum, helper(0, col, matrix));
    }
    return minSum;
  }

  private int helper(int row, int col, int[][] matrix) {
    int n = matrix.length;

    // Out of bounds → invalid path, return "infinity"
    if (col < 0 || col >= n) return Integer.MAX_VALUE;

    // Base case: last row
    if (row == n - 1) return matrix[row][col];

    // Recurse for the three possible moves
    int down = helper(row + 1, col, matrix);
    int leftDiag = helper(row + 1, col - 1, matrix);
    int rightDiag = helper(row + 1, col + 1, matrix);

    return matrix[row][col] + Math.min(down, Math.min(leftDiag, rightDiag));
  }
  /*Why It’s Slow
  Time complexity: O(3^n) because each cell calls 3 subproblems.
  Works for small matrices but TLE for larger n.*/

  /*

      public class Solution {
          public int minFallingPathSum(int[][] matrix) {
              int n = matrix.length;
              int[][] dp = new int[n][n];
              for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

              int minSum = Integer.MAX_VALUE;

              // Try starting from every column in the first row
              for (int col = 0; col < n; col++) {
                  minSum = Math.min(minSum, helper(0, col, matrix, dp));
              }
              return minSum;
          }

          private int helper(int row, int col, int[][] matrix, int[][] dp) {
              int n = matrix.length;

              // Out of bounds -> invalid path
              if (col < 0 || col >= n) return Integer.MAX_VALUE;

              // Base case: last row
              if (row == n - 1) return matrix[row][col];

              // Memoization check
              if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

              // Recursive calls for 3 possible moves
              int down = helper(row + 1, col, matrix, dp);
              int leftDiag = helper(row + 1, col - 1, matrix, dp);
              int rightDiag = helper(row + 1, col + 1, matrix, dp);

              // Store and return result
              dp[row][col] = matrix[row][col] + Math.min(down, Math.min(leftDiag, rightDiag));
              return dp[row][col];
          }
      }
      How it works
  dp[row][col] caches the minimum falling path sum starting from (row, col).

  Each state computed only once, reducing complexity from O(3^n) to O(n²).

  No repeated computation of overlapping subproblems.


  */

}
