package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.i_MATRIX_TRAVERSAL_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraversal {
  public List<Integer> mainDiagonalTraversal(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int n = matrix.length; // assuming square matrix: n x n
    for (int i = 0; i < n; i++) {
      result.add(matrix[i][i]);
    }
    return result;
  }

  public List<Integer> antiDiagonalTraversal(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int n = matrix.length; // assuming square matrix: n x n
    for (int i = 0; i < n; i++) {
      result.add(matrix[i][n - 1 - i]);
    }
    return result;
  }
}
