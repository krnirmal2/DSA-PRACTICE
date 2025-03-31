package StandardProblemDSA.X_GRAPH.I_BASIC_TRAVERSAL.DFS_TRAVERSAL;

public class SurrandedRegion {}

/*
130. Surrounded Regions
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
        Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
        Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation:
In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
Example 2:
Input: board = [["X"]]
Output: [["X"]]

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.*/
class Solution {
  public void solve(char[][] board) {
    if (board == null || board.length == 0) return;

    int row = board.length;
    int col = board[0].length;

    // Step 1: Mark all border-connected 'O' regions
    for (int r = 0; r < row; r++) {
      // Check the first and last columns
      if (board[r][0] == 'O') dfs(board, r, 0);
      if (board[r][col - 1] == 'O') dfs(board, r, col - 1);
    }
    for (int c = 0; c < col; c++) {
      // Check the first and last rows
      if (board[0][c] == 'O') dfs(board, 0, c);
      if (board[row - 1][c] == 'O') dfs(board, row - 1, c);
    }

    // Step 2: Flip the rest of the 'O' regions to 'X' and marked '#' back to 'O'
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (board[r][c] == 'O') {
          board[r][c] = 'X'; // Surrounded regions
        } else if (board[r][c] == '#') {
          board[r][c] = 'O'; // Border-connected regions
        }
      }
    }
  }

  // Depth-First Search to mark border-connected 'O' cells
  private void dfs(char[][] board, int r, int c) {
    // Ensure we don't go out of bounds or revisit cells
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
      return;
    }

    // Mark the current cell
    board[r][c] = '#';

    // Explore all four directions
    dfs(board, r - 1, c); // Up
    dfs(board, r + 1, c); // Down
    dfs(board, r, c - 1); // Left
    dfs(board, r, c + 1); // Right
  }

  // Main function to test the solution
  public static void main(String[] args) {
    Solution solution = new Solution();

    // Example board
    char[][] board = {
      {'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'X', 'O', 'X'},
      {'X', 'O', 'X', 'X'}
    };

    // Call the solve function
    solution.solve(board);

    // Print the modified board
    for (char[] row : board) {
      System.out.println(java.util.Arrays.toString(row));
    }
  }
}
