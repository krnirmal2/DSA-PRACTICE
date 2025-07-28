package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.vi_MATH_PATTERN;

import java.util.Scanner;

/*
-----------------------------------------------------------------------------------
📌 Question:
-----------------------------------------------------------------------------------
"Perform matrix multiplication of two matrices A and B.
Print the resulting matrix if multiplication is possible, otherwise print a message."

Example:
Input:
A = [[1, 2, 3],
     [4, 5, 6]]

B = [[7, 8],
     [9, 10],
     [11, 12]]

Output:
C = [[58, 64],
     [139, 154]]

-----------------------------------------------------------------------------------
🧠 Approach:
-----------------------------------------------------------------------------------
- To multiply two matrices:
    - The number of columns of A must equal the number of rows of B (col1 == row2).
    - Result matrix C will have dimensions: row1 × col2.
- For each element C[i][j], compute the sum of products:
      C[i][j] = Σ (A[i][k] × B[k][j]) for k = 0 to col1 - 1
- Use 3 nested loops:
      - Outer loop: iterate rows of A (i).
      - Middle loop: iterate columns of B (j).
      - Inner loop: compute dot product using corresponding row of A and column of B (k).

-----------------------------------------------------------------------------------
⏱️ Complexity:
-----------------------------------------------------------------------------------
- Time: O(row1 × col2 × col1) → For each cell in C, we do col1 multiplications.
- Space: O(row1 × col2) → For storing result matrix.

-----------------------------------------------------------------------------------
🧩 Pattern:
-----------------------------------------------------------------------------------
- **Matrix Multiplication Pattern** (triple nested loops: row × col × shared-dimension)

-----------------------------------------------------------------------------------
🔁 Follow-up Questions:
-----------------------------------------------------------------------------------
1️⃣ Can we optimize this using **Strassen's Algorithm** (divide-and-conquer)?
2️⃣ How to handle **sparse matrices** efficiently (only store non-zero elements)?
3️⃣ Can this be parallelized using **multithreading** for large matrices?

-----------------------------------------------------------------------------------
🔗 Similar Problems:
-----------------------------------------------------------------------------------
- LeetCode 311 – Sparse Matrix Multiplication
- GFG – Matrix Multiplication in Java
- Any competitive programming matrix chain multiplication problems.
*/

public class MatrixMultiply {
  public static void main(String[] args) {

    int row1, col1, row2, col2;
    Scanner s = new Scanner(System.in);
    System.out.print("Enter number of rows in first matrix:");
    row1 = s.nextInt();
    System.out.print("Enter number of columns in first matrix:");
    col1 = s.nextInt();
    System.out.print("Enter number of rows in second matrix:");
    row2 = s.nextInt();
    System.out.print("Enter number of columns in second matrix:");
    col2 = s.nextInt();

    if (col1 != row2) {
      System.out.println("Matrix multiplication is not possible");
    } else {
      int[][] a = new int[row1][col1];
      int[][] b = new int[row2][col2];
      int[][] c = new int[row1][col2];

      System.out.println("Enter values for matrix A : \n");
      for (int i = 0; i < row1; i++) {
        for (int j = 0; j < col1; j++) a[i][j] = s.nextInt();
      }
      System.out.println("Enter values for matrix B : \n");
      for (int i = 0; i < row2; i++) {
        for (int j = 0; j < col2; j++) b[i][j] = s.nextInt();
      }

      System.out.println("Matrix multiplication is : \n");
      for (int i = 0; i < row1; i++) {
        for (int j = 0; j < col2; j++) {
          c[i][j] = 0;
          for (int k = 0; k < col1; k++) {
            c[i][j] += a[i][k] * b[k][j];
          }
          System.out.print(c[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
