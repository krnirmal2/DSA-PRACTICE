package StandardProblemDSA.X_GRAPH.II_CONNECTIVITY_AND_COMPONENTS.SINGLE_SOURCE_BFS;

public class FloodFill {
    /*You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image.
       You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
      To perform a flood fill:
      Begin with the starting pixel and change its color to color.
      Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel,
      either horizontally or vertically) and shares the same color as the starting pixel.
      Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color
      if it matches the original color of the starting pixel.
      The process stops when there are no more adjacent pixels of the original color to update.
      Return the modified image after performing the flood fill.
    🚀 Approach: DFS (Depth-First Search)
    1. Get the initial color from image[sr][sc].
    2. Call DFS:
       - Change the current cell to newColor.
       - For each of the 4 directions, if the neighbor is within bounds, has the initial color, and hasn’t been recolored, recursively call DFS.

    ⏱️ Time Complexity: O(m × n)
    - In the worst case, all cells are visited once.

    📦 Space Complexity: O(m × n)
    - Due to recursion stack in DFS (can be optimized using BFS).

    🔁 Pattern:
    - DFS on a grid.
    - Same as island problems with a color change twist.

    ⚠️ Edge Case:
    - If `newColor == iniColor`, no change occurs, avoid infinite recursion by checking this upfront.

    ✅ LeetCode Problem:
    - 733. Flood Fill
       */
  private void dfs(
          int row,
          int col,
          int[][] ans,
          int[][] image,
          int newColor,
          int[] delRow,
          int[] delCol,
          int iniColor) {
    // color with new color
    ans[row][col] = newColor;
    int n = image.length;
    int m = image[0].length;
    // there are exactly 4 neighbours
    for (int i = 0; i < 4; i++) {
      int nrow = row + delRow[i];
      int ncol = col + delCol[i];
      // check for valid coordinate
      // then check for same initial color and unvisited pixel
      if (nrow >= 0
          && nrow < n
          && ncol >= 0
          && ncol < m
          && image[nrow][ncol] == iniColor
          && ans[nrow][ncol] != newColor) {
        dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
      }
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    // get initial color
    int iniColor = image[sr][sc];
    int[][] ans = image;
    // delta row and delta column for neighbours
    int[] delRow = {-1, 0, +1, 0};
    int[] delCol = {0, +1, 0, -1};
    dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
    return ans;
  }

  public void main(String[] args) {
    int[][] image = {
      {1, 1, 1},
      {1, 1, 0},
      {1, 0, 1}
    };

    // sr = 1, sc = 1, newColor = 2
    FloodFill obj = new FloodFill();
    int[][] ans = obj.floodFill(image, 1, 1, 2);
    for (int i = 0; i < ans.length; i++) {
      for (int j = 0; j < ans[i].length; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }
  }
}
