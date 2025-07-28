package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.i_MATRIX_TRAVERSAL_PATTERN;

public class AntiDiagonal {
  /*
  -----------------------------------------------------------------------------------
  📌 Question:
  -----------------------------------------------------------------------------------
  "Given a square matrix of size N x N, print all of its **anti-diagonals**
     (diagonals starting from top-left to bottom-right)."

  Example:
  Input:
   1  2  3
   4  5  6
   7  8  9

  Output anti-diagonals:
  [1]
  [2, 4]
  [3, 5, 7]
  [6, 8]
  [9]

  -----------------------------------------------------------------------------------
  🧠 Pattern: Matrix Traversal
  -----------------------------------------------------------------------------------
  - Anti-diagonals are grouped by indices where (i + j) is constant.
  - For each diagonal index `d = 0 to 2*(N-1)`:
    - Traverse all (i, j) such that i + j = d and indices are valid.
  - Append elements to respective anti-diagonal list.

  Time Complexity: O(N²)
  Space Complexity: O(N²) for storing all anti-diagonals.

  */

  public static void main(String[] args) {}
}
