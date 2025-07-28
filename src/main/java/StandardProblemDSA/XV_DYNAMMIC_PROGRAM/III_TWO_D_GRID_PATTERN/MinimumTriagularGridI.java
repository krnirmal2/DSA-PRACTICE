package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.III_TWO_D_GRID_PATTERN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTriagularGridI {
  /*Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
    Example 1:

    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
       2
      3 4
     6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
    Example 2:

    Input: triangle = [[-10]]
    Output: -10
    Constraints:

    1 <= triangle.length <= 200
    triangle[0].length == 1
    triangle[i].length == triangle[i - 1].length + 1
    -104 <= triangle[i][j] <= 104


  Pattern:
  - Triangle-based DP (variation of grid DP).
  - State: dp[row][col] = triangle[row][col] + min(dp[row+1][col], dp[row+1][col+1]).
  - Base case: last row → value = triangle[row][col].

  Approach:
  1. Recursively explore both possible moves (down and diagonal).
  2. Use memoization to store already computed results.
  3. Time complexity: O(n²), Space complexity: O(n²) for memo.
  4. Optimization: Bottom-up DP reduces space to O(n).

  Similar / Follow-up Problems:
  - LC 64: Minimum Path Sum (grid, moves only right/down)
  - LC 931: Minimum Falling Path Sum (matrix, moves down/diagonal)
  - LC 62/63: Unique Paths (count paths instead of minimizing sum)
  - LC 2218: Maximum Value of K Coins (similar DP structure)

    Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

    */
  public static int minimumTotal(List<List<Integer>> triangle) {
    /*At position (row, col), you have 2 options:
    Go straight down to (row+1, col)
    Go diagonally right to (row+1, col+1)
    You recursively compute the minimum path sum from those two choices.
    At each step, you add the current value (triangle[row][col]) to the minimum of those two recursive results.

    */
    /*Time: O(n²), Space: O(n)*/
    // used memo as recursiong take power(2,n)
    int[][] memo = new int[triangle.size()][triangle.size()];
    // fill each row
    for (int[] row : memo) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    return recursionUtil(triangle, 0, 0, memo);
  }

  private static int recursionUtil(List<List<Integer>> triangle, int row, int col, int[][] memo) {
    // base case
    if (row == triangle.size() - 1) {
      return triangle.get(row).get(col);
    }
    if (memo[row][col] != Integer.MAX_VALUE) return memo[row][col];

    // go to down below to ith of next row
    int down = recursionUtil(triangle, row + 1, col, memo);
    int diagonal = recursionUtil(triangle, row + 1, col + 1, memo);

    return memo[row][col] = triangle.get(row).get(col) + Math.min(down, diagonal);
  }

  public static void main(String[] args) {
    List<List<Integer>> triangle =
        new ArrayList<>(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)));
    System.out.println(minimumTotal(triangle));
  }
  /*
      dfs(0, 0) = 2 + min(dfs(1, 0), dfs(1, 1))

  -> dfs(1, 0) = 3 + min(dfs(2, 0), dfs(2, 1))
       → dfs(2, 0) = 6 + min(dfs(3, 0), dfs(3, 1))
            → dfs(3, 0) = 4 (base case)
            → dfs(3, 1) = 1 (base case)
            → dfs(2, 0) = 6 + min(4, 1) = 6 + 1 = 7
       → dfs(2, 1) = 5 + min(dfs(3, 1), dfs(3, 2))
            → dfs(3, 1) = 1 (base case)
            → dfs(3, 2) = 8 (base case)
            → dfs(2, 1) = 5 + min(1, 8) = 5 + 1 = 6
       → dfs(1, 0) = 3 + min(7, 6) = 3 + 6 = 9

  → dfs(1, 1) = 4 + min(dfs(2, 1), dfs(2, 2))
       → dfs(2, 1) = 5 + min(dfs(3, 1), dfs(3, 2))
            → dfs(3, 1) = 1
            → dfs(3, 2) = 8
            → dfs(2, 1) = 5 + min(1, 8) = 6
       → dfs(2, 2) = 7 + min(dfs(3, 2), dfs(3, 3))
            → dfs(3, 2) = 8
            → dfs(3, 3) = 3
            → dfs(2, 2) = 7 + min(8, 3) = 10
       → dfs(1, 1) = 4 + min(6, 10) = 10

  Final:
  → dfs(0, 0) = 2 + min(9, 10) = 11
  */
}
