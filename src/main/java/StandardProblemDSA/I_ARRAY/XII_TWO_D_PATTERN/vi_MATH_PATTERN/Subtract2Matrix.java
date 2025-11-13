package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.vi_MATH_PATTERN;

public class Subtract2Matrix {
  /*
  -----------------------------------------------------------------------------------
  📌 Question:
  -----------------------------------------------------------------------------------
  "Given two matrices A and B of the same dimensions, compute the matrix C = A - B
  where each element C[i][j] = A[i][j] - B[i][j]."

  Example:
  A = [[1, 2],
       [3, 4]]

  B = [[4, 3],
       [2, 1]]

  Output:
  C = [[-3, -1],
       [ 1,  3]]

  -----------------------------------------------------------------------------------
  🧠 Approach:
  -----------------------------------------------------------------------------------
  - Ensure both matrices A and B have the same dimensions.
  - Create a result matrix C of size rows × columns.
  - For each cell C[r][c], perform subtraction: A[r][c] - B[r][c].
  - Use two nested loops:
        - Outer loop: iterate rows r.
        - Inner loop: iterate columns c.

  -----------------------------------------------------------------------------------
  ⏱️ Complexity:
  -----------------------------------------------------------------------------------
  - Time: O(m × n), where m = number of rows, n = number of columns.
  - Space: O(m × n), for storing the result matrix.

  -----------------------------------------------------------------------------------
  🧩 Pattern:
  -----------------------------------------------------------------------------------
  - **Element-wise Matrix Operation Pattern** (addition, subtraction, scalar multiplication).

  -----------------------------------------------------------------------------------
  🔁 Follow-up Questions:
  -----------------------------------------------------------------------------------
  1️⃣ What happens if A and B have different dimensions?
  2️⃣ Can we perform subtraction **in-place** (modify A directly)?
  3️⃣ How to handle very large matrices efficiently (e.g., sparse representations)?

  -----------------------------------------------------------------------------------
  🔗 Similar Problems:
  -----------------------------------------------------------------------------------
  - GFG – Matrix Subtraction in Java
  - Matrix Addition (element-wise)
  - LeetCode 311 – Sparse Matrix Multiplication (related concept)
  */

  public static int[][] solve(int[][] A, int[][] B) {
    int sizeOfRow = A.length;
    int sizeofColoumn = A[0].length;
    int[][] sumOfAB = new int[sizeOfRow][sizeofColoumn];

    for (int r = 0; r < sizeOfRow; r++) {
      for (int c = 0; c < sizeofColoumn; c++) {
        sumOfAB[r][c] = A[r][c] - B[r][c];
      }
    }

    return sumOfAB;
  }

  public static void main(String[] args) {
    int[][] A = {
      {1, 1, 1, 1},
      {2, 2, 2, 2},
      {3, 3, 3, 3},
      {4, 4, 4, 4}
    };

    int[][] B = {
      {1, 13, 1, 1},
      {2, 2, 2, 2},
      {3, 3, 3, 3},
      {4, 4, 4, 4}
    };

    int row = A.length, col = A[0].length;
    int[][] C = new int[row][col];
    C = solve(A, B);
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) System.out.print(C[i][j] + " ");
      System.out.print("\n");
    }
  }
}
