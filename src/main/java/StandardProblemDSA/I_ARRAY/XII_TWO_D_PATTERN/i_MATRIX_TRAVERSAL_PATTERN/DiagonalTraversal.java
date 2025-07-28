package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.i_MATRIX_TRAVERSAL_PATTERN;

import java.util.ArrayList;
import java.util.List;

/*
-----------------------------------------------------------------------------------
📌 Question:
-----------------------------------------------------------------------------------
"Given a square matrix of size N x N, implement methods to return:
   1️⃣ **Main diagonal**: elements where row index = column index.
   2️⃣ **Anti-diagonal**: elements where row index + column index = N - 1."

Example:
Input:
1  2  3
4  5  6
7  8  9

Main Diagonal: [1, 5, 9]
Anti Diagonal: [3, 5, 7]

-----------------------------------------------------------------------------------
🧠 Pattern: Matrix Traversal
-----------------------------------------------------------------------------------
- Main Diagonal: Iterate i = 0 to n - 1, take matrix[i][i].
- Anti Diagonal: Iterate i = 0 to n - 1, take matrix[i][n - 1 - i].
- Works only for square matrices (n x n).

Time Complexity: O(N) for each traversal
Space Complexity: O(N) for output list

-----------------------------------------------------------------------------------
🔁 Follow-up Questions:
-----------------------------------------------------------------------------------
1️⃣ How to collect all anti-diagonals (not just main one)?
2️⃣ How to generalize for rectangular matrices?
3️⃣ Can we traverse diagonals in zigzag order?
4️⃣ What if we need diagonal sums instead of elements?

-----------------------------------------------------------------------------------
🔗 Similar Problems:
-----------------------------------------------------------------------------------
- Leetcode 498 – Diagonal Traverse
- Leetcode 1424 – Diagonal Traverse II
- Common matrix traversal interview questions
*/

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
