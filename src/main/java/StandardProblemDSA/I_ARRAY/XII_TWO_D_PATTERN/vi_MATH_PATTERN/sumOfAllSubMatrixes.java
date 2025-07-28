package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.vi_MATH_PATTERN;

public class sumOfAllSubMatrixes {
  /*
  -----------------------------------------------------------------------------------
  📌 Question:
  -----------------------------------------------------------------------------------
  "Given a 2D matrix A of size N × M, find the sum of all elements of all possible
  submatrices of A."

  Example:
  A = [[1, 2],
       [3, 4]]

  All possible submatrices:
  - [1], [2], [3], [4]
  - [1, 2], [3, 4], [1, 3], [2, 4]
  - [1, 2, 3, 4]

  Sum = 40

  -----------------------------------------------------------------------------------
  🧠 Approach (Contribution Technique):
  -----------------------------------------------------------------------------------
  - Each element A[row][col] will appear in several submatrices.
  - Count how many submatrices include A[row][col]:
        - Top-left choices = (row + 1) × (col + 1)
        - Bottom-right choices = (N - row) × (M - col)
  - Total submatrices including A[row][col] =
        (row + 1) × (col + 1) × (N - row) × (M - col)
  - Contribution of A[row][col] = A[row][col] × above count.
  - Sum contributions of all elements.

  -----------------------------------------------------------------------------------
  ⏱️ Complexity:
  -----------------------------------------------------------------------------------
  - Time: O(N × M) → single traversal.
  - Space: O(1) → constant extra space.

  -----------------------------------------------------------------------------------
  🧩 Pattern:
  -----------------------------------------------------------------------------------
  - **Contribution Technique / Inclusion Counting** (used for sum of all subarrays,
    sum of all submatrices, etc.)

  -----------------------------------------------------------------------------------
  🔁 Follow-up Questions:
  -----------------------------------------------------------------------------------
  1️⃣ Can we extend this to find the **average of all submatrices**?
  2️⃣ How would this change for a **non-rectangular grid**?
  3️⃣ Can we apply the same logic for **3D matrices**?

  -----------------------------------------------------------------------------------
  🔗 Similar Problems:
  -----------------------------------------------------------------------------------
  - Sum of all subarrays of an array (1D version)
  - GFG – Sum of all submatrices
  - LeetCode 1314 – Matrix Block Sum (variation)
  */

  public static int solve(int[][] A) {

    int sum = 0;
    for (int row = 0; row < A.length; row++) {
      for (int col = 0; col < A[0].length; col++) {
        sum += A[row][col] * ((row + 1) * (col + 1) * (A.length - row) * (A[0].length - col));
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    int[][] arr = {{1, 2}, {3, 4}};

    int result = solve(arr);
    System.out.println(result);
    for (int i = 0; i < 2; i++)
      for (int j = 0; j < 2; j++) System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
  }
}
