package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.ii_ROTATION_PATTERN;

public class spiralMatrix {
  /*
  -----------------------------------------------------------------------------------
  📌 SpiralTraverse (Next Problem):
  -----------------------------------------------------------------------------------
  "Given a 2D matrix, return all elements of the matrix in spiral order."

  Example:
  Input:
  1 2 3
  4 5 6
  7 8 9

  Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

  Pattern:
  - Use 4 pointers: top, bottom, left, right.
  - Traverse in layers:
      1. Left → Right along top row
      2. Top → Bottom along right column
      3. Right → Left along bottom row (if top ≤ bottom)
      4. Bottom → Top along left column (if left ≤ right)
  - Shrink the boundary pointers after each direction.

  Time Complexity: O(M*N)
  Space Complexity: O(1) extra space (output list not counted).

  -----------------------------------------------------------------------------------
  🔁 Follow-up Questions:
  -----------------------------------------------------------------------------------
  1️⃣ How to modify for clockwise vs. counter-clockwise spiral?
  2️⃣ How to print in zigzag or wave form?
  3️⃣ Can we do anti-diagonal traversal in reverse order?
  4️⃣ How to handle non-square matrices or jagged arrays?

  -----------------------------------------------------------------------------------
  🔗 Similar LeetCode / Interview Questions:
  -----------------------------------------------------------------------------------
  - Leetcode 54 – Spiral Matrix
  - Leetcode 59 – Spiral Matrix II (generate matrix)
  - Leetcode 498 – Diagonal Traverse
  - Common matrix-based interview problems*/

  // Function print matrix in spiral form
  static void spiralPrint(int m, int n, int[][] a) {
    int i, k = 0, l = 0;

    /* k - starting_row_index
    m - ending_row_index
    l - starting_column_index
    n - ending_column_index
    i - iterator
    */

    while (k < m && l < n) {
      // Print the first row from the remaining rows
      for (i = l; i < n; ++i) {
        System.out.print(a[k][i] + " ");
      }
      k++;

      // Print the last column from the remaining
      // columns
      for (i = k; i < m; ++i) {
        System.out.print(a[i][n - 1] + " ");
      }
      n--;

      // Print the last row from the remaining rows */
      if (k < m) {
        for (i = n - 1; i >= l; --i) {
          System.out.print(a[m - 1][i] + " ");
        }
        m--;
      }

      // Print the first column from the remaining
      // columns */
      if (l < n) {
        for (i = m - 1; i >= k; --i) {
          System.out.print(a[i][l] + " ");
        }
        l++;
      }
    }
  }

  // Driver Code
  public static void main(String[] args) {
    int R = 4;
    int C = 4;
    int[][] a = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    // Function Call
    spiralPrint(R, C, a);
  }
}

// Contributed by Pramod Kumar

/*public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int rows, cols;
        int row, col;
        rows = cols = A;
        int num = 1;
        int max = A * A;
        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < rows; j++) {
                res.get(i).add(0);
            }
        }
        row = col = 0;
        int dir = 0;
        int layer = 0;
        res.get(0).set(0, 1);
        for (int step = 2; step <= A * A; step++) {
            switch(dir) {
                // Go right
                case 0:
                    if (col == cols - layer - 1) {
                        row++;
                        dir = 1;
                    }
                    else
                        col++;
                    break;
                // Go down
                case 1:
                    if (row == rows - layer - 1) {
                        dir = 2;
                        col--;
                    } else
                        row++;
                    break;
                // Go left
                case 2:
                    if (col == layer) {
                        row--;
                        dir = 3;
                    } else
                        col--;
                    break;
                // Go up
                case 3:
                    if (row == layer + 1) {
                        dir = 0;
                        col++;
                        layer++;
                    } else
                        row--;
                    break;
            }
            res.get(row).set(col, step);
        }
        return res;
    }
}*/
