package StandardProblemDSA.VII_BACKTRACKING;

public class WordSearch {
  /*79. Word Search
  Given an m x n grid of characters board and a string word, return true if word exists in the grid.

  The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
  Example 1:
  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
  Output: true
  Example 2:
  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
  Output: true
  Example 3:
  Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
  Output: false
  */
  public boolean exist(char[][] board, String word) {
    int n = board.length;
    int m = board[0].length;

    boolean[][] visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // Try to start from every cell
        if (dfs(board, word, 0, i, j, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
    int n = board.length;
    int m = board[0].length;

    // Out of bounds or already visited or character doesn't match
    if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || board[x][y] != word.charAt(index)) {
      return false;
    }

    // Found all characters
    if (index == word.length() - 1) {
      return true;
    }

    visited[x][y] = true;

    // Move in all four directions
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    for (int d = 0; d < 4; d++) {
      int newX = x + dx[d];
      int newY = y + dy[d];

      if (dfs(board, word, index + 1, newX, newY, visited)) {
        return true;
      }
    }

    // Backtrack
    visited[x][y] = false;
    return false;
  }
}
