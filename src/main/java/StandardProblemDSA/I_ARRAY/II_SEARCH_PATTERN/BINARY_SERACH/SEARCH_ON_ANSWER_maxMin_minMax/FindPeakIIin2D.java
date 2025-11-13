package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

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
  No two adjacent cells are equal.
    Pattern:
       - Binary search on columns (or rows).
       - At each step, find the global max in the middle column.
       - Decide to move left or right based on neighbors.

     LeetCode Reference:
       - 1901. Find a Peak Element II DONE

     Follow-ups:
       1. How to modify if diagonals are also considered neighbors?
       2. How to find all peak elements?
       3. Can we do O(m + n)?
  */

  /*The algorithm is as follows:
  Pick the middle column.
  Find the global maximum in the column.
  If the row-neighbours of this element are smaller, then we found a 2D peak. Else, we recurse at the right-half of
  the matrix if the right-neighbour was bigger, and left-half of the matrix if the left-neighbour was bigger.
  Here is a little intuition as to why this works.

  When we find a row-neighbour that is bigger than the global maximum of a column, it means that the row-neighbour is
  bigger than all the elements of that column. Thus, the global maximum of the neighbour's column must be bigger than
  its corresponding row-neighbour in our column.

  To put it more formally, consider column j whose global maximum lies in row i

  // if matrix[i][j + 1] > matrix[i][j]
  // then matrix[i][j + 1] is bigger than all elements in column j
  // thus maximum of column j + 1 is bigger than its row-neighbour in column j
  // thus, there exists some peak in the right half of the matrix
  Complexity Analysis
  To find the the maximum of a list of numbers, the best we can do is a linear scan.
  We do as many linear scans as log2(m), where m is the number of columns. This is because at every iteration,
   we discard half of the columns by moving either right or left.

  // Thus, the overall time complexity is O(n * log(m))
  // n = number of rows, m = number of columns
  The space complexity remains constant since we do not create any additional data structures.*/

  public int[] findPeakGrid(int[][] matrix) {
    int n = matrix.length; // number of rows
    int m = matrix[0].length; // number of columns
    int lo = 0, hi = m - 1;

    // Binary search on columns
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      // Find the row index of the maximum element in this column
      int maxRow = 0;
      for (int i = 0; i < n; i++) {
        if (matrix[i][mid] > matrix[maxRow][mid]) {
          maxRow = i;
        }
      }

      // Check if this is a peak
      boolean leftIsSmaller = (mid == 0 || matrix[maxRow][mid] > matrix[maxRow][mid - 1]);
      boolean rightIsSmaller = (mid == m - 1 || matrix[maxRow][mid] > matrix[maxRow][mid + 1]);

      if (leftIsSmaller && rightIsSmaller) {
        return new int[] {maxRow, mid}; // found a peak
      }

      // Move towards the larger neighbor
      if (mid > 0 && matrix[maxRow][mid - 1] > matrix[maxRow][mid]) {
        hi = mid - 1; // move left
      } else {
        lo = mid + 1; // move right
      }
    }

    return new int[] {-1, -1}; // should not happen with valid input
  }
}
