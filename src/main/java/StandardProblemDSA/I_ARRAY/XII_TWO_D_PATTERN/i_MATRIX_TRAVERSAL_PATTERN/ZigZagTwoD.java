package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.i_MATRIX_TRAVERSAL_PATTERN;

import java.util.ArrayList;
import java.util.List;

/*
-----------------------------------------------------------------------------------
📌 Question:
-----------------------------------------------------------------------------------
"Given a 2D matrix, traverse it in a **zigzag row-wise order**:
   - For even-indexed rows (0, 2, 4, ...), traverse left ➡ right.
   - For odd-indexed rows (1, 3, 5, ...), traverse right ➡ left.

Example:
Input:
1  2  3
4  5  6
7  8  9

Output (Zigzag): [1, 2, 3, 6, 5, 4, 7, 8, 9]

-----------------------------------------------------------------------------------
🧠 Pattern: Matrix Traversal – Zigzag
-----------------------------------------------------------------------------------
- Iterate through rows using index `i`.
- Check if `i` is even → traverse columns from 0 to n - 1.
- If `i` is odd → traverse columns from n - 1 to 0.

Time Complexity: O(M × N)
Space Complexity: O(1) (excluding output list)

-----------------------------------------------------------------------------------
🔁 Follow-up Questions:
-----------------------------------------------------------------------------------
1️⃣ How to implement a **diagonal zigzag traversal** (like in LeetCode 498)?
2️⃣ How to do a **snake pattern traversal** column-wise?
3️⃣ Can we do zigzag traversal in **spiral order**?
4️⃣ How to handle **jagged matrices** (rows with different lengths)?

-----------------------------------------------------------------------------------
🔗 Similar Problems:
-----------------------------------------------------------------------------------
- Leetcode 498 – Diagonal Traverse
- GeeksForGeeks – Zigzag (Snake) Matrix Traversal
- Variations of spiral and snake traversal
*/

public class ZigZagTwoD {
  public List<Integer> zigzagTraverse(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      if (i % 2 == 0) { // left-to-right
        for (int j = 0; j < matrix[i].length; j++) result.add(matrix[i][j]);
      } else { // right-to-left
        for (int j = matrix[i].length - 1; j >= 0; j--) result.add(matrix[i][j]);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    //        ArrayUtility.
    //        ArrayUtility.print2DArray(a);
  }
}
