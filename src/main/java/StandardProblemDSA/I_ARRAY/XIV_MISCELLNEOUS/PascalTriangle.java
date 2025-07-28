package StandardProblemDSA.I_ARRAY.XIV_MISCELLNEOUS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
  /*
  -----------------------------------------------------------------------------------
  📌 Question:
  -----------------------------------------------------------------------------------
  "Generate Pascal's Triangle up to a given number of rows."

  Example:
  numRows = 5
  Output:
  [
   [1],
   [1, 1],
   [1, 2, 1],
   [1, 3, 3, 1],
   [1, 4, 6, 4, 1]
  ]

  -----------------------------------------------------------------------------------
  🧠 Approach (Recursive Construction):
  -----------------------------------------------------------------------------------
  1. **Base cases**:
        - If `numRows` = 0 → return empty list.
        - If `numRows` = 1 → return [[1]].
  2. **Recursive step**:
        - Generate triangle for `numRows - 1`.
        - Create a new row of size `numRows` initialized with 1s.
        - Fill inner elements:
          `newRow[i] = prevRow[i - 1] + prevRow[i]` for i = 1 to numRows - 2.
        - Append `newRow` to the triangle.
  3. Return the full triangle.

  -----------------------------------------------------------------------------------
  ⏱️ Complexity:
  -----------------------------------------------------------------------------------
  - Time: O(N²), since we generate N rows and each row requires ~N operations.
  - Space: O(N²) for storing all rows.

  -----------------------------------------------------------------------------------
  🧩 Pattern:
  -----------------------------------------------------------------------------------
  - **Dynamic Programming / Pascal’s Identity**
  - Uses previous row to build the next row.

  -----------------------------------------------------------------------------------
  🔁 Follow-up Questions:
  -----------------------------------------------------------------------------------
  1️⃣ Can we generate a **single row** of Pascal’s triangle in O(k)?
  2️⃣ How to generate it **iteratively** without recursion?
  3️⃣ Can we generate **all rows in-place** with O(numRows) space?

  -----------------------------------------------------------------------------------
  🔗 Similar Problems:
  -----------------------------------------------------------------------------------
  - LeetCode 118 – Pascal’s Triangle
  - LeetCode 119 – Pascal’s Triangle II
  - Binomial Coefficient computation
  */

  // we use TAIL recursion here

  public static List<List<Integer>> generate(int numRows) {
    // Base cases

    if (numRows == 0) return new ArrayList<>();
    if (numRows == 1) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(List.of(1));
      return result; // missing return
    }

    // recursively geerate the triangle for numrow -1
    List<List<Integer>> prevRows = generate(numRows - 1);
    List<Integer> newRow = new ArrayList<>();
    // add 1 to each of the new row
    for (int i = 0; i < numRows; i++) {
      newRow.add(1);
    }
    // add in each new row at ith column = element at previous(row) at i-1 + element at previous row
    // sum of ith column
    for (int i = 1; i < numRows - 1; i++) {
      newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));
    }

    prevRows.add(newRow);
    return prevRows;
  }

  /*        | Row (i) | j | Is Edge (j == 0 || j == i) | Value Calculation | Resulting Row |
  |---------|---|-------------------------------|----------------------------------|---------------------------|
  | 0 | 0 | ✅ Yes | 1 | [1] |
  | 1 | 0 | ✅ Yes | 1 | |
  | | 1 | ✅ Yes | 1 | [1, 1] |
  | 2 | 0 | ✅ Yes | 1 | |
  | | 1 | ❌ No | 1 + 1 = 2 | |
  | | 2 | ✅ Yes | 1 | [1, 2, 1] |
  | 3 | 0 | ✅ Yes | 1 | |
  | | 1 | ❌ No | 1 + 2 = 3 | |
  | | 2 | ❌ No | 2 + 1 = 3 | |
  | | 3 | ✅ Yes | 1 | [1, 3, 3, 1] |
  | 4 | 0 | ✅ Yes | 1 | |
  | | 1 | ❌ No | 1 + 3 = 4 | |
  | | 2 | ❌ No | 3 + 3 = 6 | |
  | | 3 | ❌ No | 3 + 1 = 4 | |
  | | 4 | ✅ Yes | 1 | [1, 4, 6, 4, 1] |*/
  /*
     List<List<Integer>> result = new ArrayList<>();
      if (numRows == 0) {
          return result;
      }

      if (numRows == 1) {
          List<Integer> firstRow = new ArrayList<>();
          firstRow.add(1);
          result.add(firstRow);
          return result;
      }

      result = generate(numRows - 1);
      List<Integer> prevRow = result.get(numRows - 2);
      List<Integer> currentRow = new ArrayList<>();
      currentRow.add(1);

      for (int i = 1; i < numRows - 1; i++) {
          currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
      }

      currentRow.add(1);
      result.add(currentRow);

      return result;
  }
  }*/
  public static void main(String[] args) {
    List<List<Integer>> result = generate(5);
    result.forEach(System.out::println);
  }
}
