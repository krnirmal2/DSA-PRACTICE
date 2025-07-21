package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH;

public class FindPeakIIin2D {
  /*A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
  Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
  You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
  You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
  Example 1:
  Input: mat = [[1,4],[3,2]]
  Output: [0,1]
  Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
  Example 2:
  Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
  Output: [1,1]
  Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
  Constraints:

  m == mat.length
  n == mat[i].length
  1 <= m, n <= 500
  1 <= mat[i][j] <= 105
  No two adjacent cells are equal.*/

  /*The algorithm is as follows:
  Pick the middle column.
  Find the global maximum in the column.
  If the row-neighbours of this element are smaller, then we found a 2D peak. Else, we recurse at the right-half of the matrix if the right-neighbour was bigger, and left-half of the matrix if the left-neighbour was bigger.
  Here is a little intuition as to why this works.

  When we find a row-neighbour that is bigger than the global maximum of a column, it means that the row-neighbour is bigger than all the elements of that column. Thus, the global maximum of the neighbour's column must be bigger than its corresponding row-neighbour in our column.

  To put it more formally, consider column j whose global maximum lies in row i

  // if matrix[i][j + 1] > matrix[i][j]
  // then matrix[i][j + 1] is bigger than all elements in column j
  // thus maximum of column j + 1 is bigger than its row-neighbour in column j
  // thus, there exists some peak in the right half of the matrix
  Complexity Analysis
  To find the the maximum of a list of numbers, the best we can do is a linear scan.
  We do as many linear scans as log2(m), where m is the number of columns. This is because at every iteration, we discard half of the columns by moving either right or left.

  // Thus, the overall time complexity is O(n * log(m))
  // n = number of rows, m = number of columns
  The space complexity remains constant since we do not create any additional data structures.*/

  public int[] findPeakGrid(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length, lo = 0, hi = m - 1, mid;
    while (lo <= hi) {
      mid = lo + (hi - lo) / 2;
      int max_row = 0;
      for (int i = 0; i < n; ++i) {
        if (matrix[max_row][mid] < matrix[i][mid]) max_row = i;
      }
      if ((mid == 0 || matrix[max_row][mid] > matrix[max_row][mid - 1])
          && (mid == m - 1 || matrix[max_row][mid] > matrix[max_row][mid + 1]))
        return new int[] {max_row, mid};
      else if (mid > 0 && matrix[max_row][mid - 1] > matrix[max_row][mid]) hi = mid - 1;
      else lo = mid + 1;
    }
    return new int[] {-1, -1};
  }
}
