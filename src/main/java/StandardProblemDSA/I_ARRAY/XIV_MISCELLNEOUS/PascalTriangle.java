package StandardProblemDSA.I_ARRAY.XIV_MISCELLNEOUS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
  /* Recursion Approach:

  Base case: If numRows is 1, return [[1]].
  Recursively generate the triangle for numRows - 1.
  Calculate the current row by summing adjacent elements from the previous row.*/
  /*[
          [1],
          [1, 1],
          [1, 2, 1],
          [1, 3, 3, 1],
          [1, 4, 6, 4, 1]
          ]
  */

  // we use TAIL recursion here

  public static List<List<Integer>> generate(int numRows) {
    // Base cases

    if (numRows == 0) return new ArrayList<>();
    if (numRows == 1) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(Arrays.asList(1));
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
