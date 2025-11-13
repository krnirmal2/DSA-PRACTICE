package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.ii_ROTATION_PATTERN;

/*
-----------------------------------------------------------------------------------
📌 Question:
-----------------------------------------------------------------------------------
"Given an N x N matrix, rotate it by **90 degrees clockwise**, in-place."

Example:
Input:
1 2
3 4

Output:
3 1
4 2

-----------------------------------------------------------------------------------
🧠 Approach:
-----------------------------------------------------------------------------------
We can achieve a **90-degree clockwise rotation** using two steps:
1️⃣ **Transpose the matrix**
   - Swap elements across the diagonal (A[i][j] ↔ A[j][i]).
2️⃣ **Reverse each row**
   - Swap elements in each row from left to right.

This transforms the original matrix into its 90° rotated version.

-----------------------------------------------------------------------------------
⏱️ Complexity:
-----------------------------------------------------------------------------------
- Time: O(N²) – each element is touched once for transpose + once for reversal.
- Space: O(1) – in-place rotation, no extra matrix used.

-----------------------------------------------------------------------------------
🧩 Pattern:
-----------------------------------------------------------------------------------
Matrix Manipulation → Transpose + Reverse Rows

-----------------------------------------------------------------------------------
🔁 Follow-up Questions:
-----------------------------------------------------------------------------------
1️⃣ How to rotate the matrix **90° counter-clockwise**?
2️⃣ How to rotate by **180° or 270°** without extra space?
3️⃣ How to handle **non-square (M x N) matrices**?
4️⃣ Can you implement it using **layer-by-layer rotation**?

-----------------------------------------------------------------------------------
🔗 Similar Problems:
-----------------------------------------------------------------------------------
- LeetCode 48 – Rotate Image
- GFG – In-place matrix rotation
*/

public class Rotate90DegreeMatrix {
  public static int[][] solve(int[][] A) {
    if (A == null || A.length == 0 || A[0].length == 0) return A;

    int temp;
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A[0].length; j++) {
        temp = A[i][j];
        A[i][j] = A[j][i];
        A[j][i] = temp;
      }
    }

    for (int i = 0; i < A.length; i++) {
      int left = 0, right = A[0].length - 1;
      while (left < right) {
        temp = A[i][left];
        A[i][left] = A[i][right];
        A[i][right] = temp;
        left++;
        right--;
      }
    }
    return A;
  }

  public static void main(String[] args) {
    int[][] arr = {{1, 2}, {3, 4}};
    arr = solve(arr);

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.println("arr[" + i + "][" + j + "] = " + arr[i][j]);
      }
    }
  }
}
