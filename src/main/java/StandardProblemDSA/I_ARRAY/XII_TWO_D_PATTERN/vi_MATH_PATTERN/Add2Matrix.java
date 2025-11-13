package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.vi_MATH_PATTERN;

public class Add2Matrix {
  /*
  -----------------------------------------------------------------------------------
  📌 Question:
  -----------------------------------------------------------------------------------
  "Given two matrices A and B of the same size, return their sum matrix C."

  Example:
  Input:
  A = [[1, 1, 1, 1],
       [2, 2, 2, 2],
       [3, 3, 3, 3],
       [4, 4, 4, 4]]

  B = [[1, 1, 1, 1],
       [2, 2, 2, 2],
       [3, 3, 3, 3],
       [4, 4, 4, 4]]

  Output:
  C = [[2, 2, 2, 2],
       [4, 4, 4, 4],
       [6, 6, 6, 6],
       [8, 8, 8, 8]]

  -----------------------------------------------------------------------------------
  🧠 Approach:
  -----------------------------------------------------------------------------------
  - Traverse through each cell (i, j).
  - Perform element-wise addition: `C[i][j] = A[i][j] + B[i][j]`.
  - Since A and B have the same dimensions, no special checks needed.

  -----------------------------------------------------------------------------------
  ⏱️ Complexity:
  -----------------------------------------------------------------------------------
  - Time: O(m × n), where m = rows, n = columns.
  - Space: O(1) if we modify A in place, otherwise O(m × n) if storing in a new matrix.

  -----------------------------------------------------------------------------------
  🧩 Pattern:
  -----------------------------------------------------------------------------------
  - **Matrix Traversal Pattern** (Row by Row, Column by Column)

  -----------------------------------------------------------------------------------
  🔁 Follow-up Questions:
  -----------------------------------------------------------------------------------
  1️⃣ How to handle cases where A and B have different dimensions?
  2️⃣ How to perform **matrix subtraction** or **scalar multiplication**?
  3️⃣ Can this be done using **streams or parallel processing** for optimization?

  -----------------------------------------------------------------------------------
  🔗 Similar Problems:
  -----------------------------------------------------------------------------------
  - LeetCode 867 – Transpose Matrix (different operation, similar traversal)
  - GFG – Addition of two matrices
  */

  public static int[][] solve(int[][] A, int[][] B) {
    int row = A.length, col = A[0].length;
    for (int i = 0; i < row; i++) for (int j = 0; j < col; j++) A[i][j] += B[i][j];
    return A;
  }

  // Driver code
  public static void main(String[] args) {
    int[][] A = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};

    int[][] B = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};

    int row = A.length, col = A[0].length;
    int[][] C = new int[row][col];
    C = solve(A, B);
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) System.out.print(C[i][j] + " ");
      System.out.print("\n");
    }
  }
}
