package StandardProblemDSA.X_GRAPH.IV_SHORETEST_PATH_MOVE_TIME_PATTEN.MULTIPLE_SOURCE_MULTIPLE_DESTINATION;

import java.util.*;

public class FloydWarshalAlgo {
  // algo  also handle negative edge
  // go via every vertex to every other

  class Solution {
    public void shortest_distance(int[][] matrix) {
      int n = matrix.length;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (matrix[i][j] == -1) {
            matrix[i][j] = (int) (1e9);
          }
          if (i == j) matrix[i][j] = 0;
        }
      }

      for (int via = 0; via < n; via++) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
          }
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (matrix[i][j] == (int) (1e9)) {
            matrix[i][j] = -1;
          }
        }
      }
    }
  }

  public class tUf {
    public void main(String[] args) {
      int V = 4;
      int[][] matrix = new int[V][V];

      for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
          matrix[i][j] = -1;
        }
      }

      matrix[0][1] = 2;
      matrix[1][0] = 1;
      matrix[1][2] = 3;
      matrix[3][0] = 3;
      matrix[3][1] = 5;
      matrix[3][2] = 4;

      Solution obj = new Solution();
      obj.shortest_distance(matrix);

      for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
          System.out.print(matrix[i][j] + " ");
        }
        System.out.println("");
      }
    }
  }
}
