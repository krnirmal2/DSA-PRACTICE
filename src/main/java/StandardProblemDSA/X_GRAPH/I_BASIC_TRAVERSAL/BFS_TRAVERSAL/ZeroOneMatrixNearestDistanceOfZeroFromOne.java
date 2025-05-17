package StandardProblemDSA.X_GRAPH.I_BASIC_TRAVERSAL.BFS_TRAVERSAL;

import StandardProblemDSA.X_GRAPH.GraphUtility;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixNearestDistanceOfZeroFromOne {

  /*

  Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
  The distance between two cells sharing a common edge is 1.
  Example 1:
  Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
  Output: [[0,0,0],[0,1,0],[0,0,0]]
  Example 2:
  Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
  Output: [[0,0,0],[0,1,0],[1,2,1]]


  Constraints:

  m == mat.length
  n == mat[i].length
  1 <= m, n <= 104
  1 <= m * n <= 104
  mat[i][j] is either 0 or 1.
  There is at least one 0 in mat.*/
  public int[][] updateMatrix(int[][] mat) {
    Queue<int[]> queue = new LinkedList<>();
    int row = mat.length;
    int col = mat[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (mat[i][j] == 0) {
          queue.offer(new int[] {i, j});
        }
        if (mat[i][j] == 1) {
          mat[i][j] = -1;
        }
      }
    }
    // Step 2: Define directions for moving in 4 possible directions (Up, Down, Left, Right)
    int[][] directions = GraphUtility.getFourDirection();
    while (!queue.isEmpty()) {
      // take the element from the queue which contain array of index of x and y
      int[] cell = queue.poll();
      int x = cell[0];
      int y = cell[1];
      for (int[] dir : directions) {
        int newX = GraphUtility.setNewX(dir, x);
        int newY = GraphUtility.setNewY(dir, y);
        // step checking boundaries
        if (GraphUtility.checkFourBoundaryOfMatrix(mat, newX, newY, row, col)) {
          mat[newX][newY] = mat[x][y] + 1; // Update distance
          queue.offer(new int[] {newX, newY}); // Add new cell to queue
        }
      }
    }
    return mat;
  }
}
