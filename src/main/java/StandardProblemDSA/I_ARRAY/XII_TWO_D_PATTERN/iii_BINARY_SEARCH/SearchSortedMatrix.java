package StandardProblemDSA.I_ARRAY.XII_TWO_D_PATTERN.iii_BINARY_SEARCH;

public class SearchSortedMatrix {
  /*
  -----------------------------------------------------------------------------------
  📌 Question:
  -----------------------------------------------------------------------------------
  "Given a 2D matrix where each row and each column is sorted in ascending order,
  find the position of a target value B.
  Return the encoded index using (rowIndex + 1) * 1009 + (colIndex + 1).
  If the value occurs multiple times, return the minimum encoded index.
  If not found, return -1."

  Example:
  Input:
  A = [ [1, 2, 3],
        [4, 6, 7],
        [10, 15, 20] ]
  B = 2

  Output: 1011 (for row = 0, col = 1)

  -----------------------------------------------------------------------------------
  🧠 Approach:
  -----------------------------------------------------------------------------------
  This matrix is sorted both row-wise and column-wise.
  We can use the **Staircase Search** technique:
  1️⃣ Start from the **top-right** element (i = 0, j = last column).
  2️⃣ If A[i][j] == B:
         - Compute encoded index = (i + 1) * 1009 + (j + 1)
         - Keep track of minimum encoded index
         - Move left (j--), since smaller indices might exist.
  3️⃣ Else if A[i][j] > B → Move left (j--).
  4️⃣ Else → Move down (i++).
  5️⃣ Stop when we run out of matrix bounds.

  Why top-right?
  - Moving left decreases the value.
  - Moving down increases the value.

  -----------------------------------------------------------------------------------
  ⏱️ Complexity:
  -----------------------------------------------------------------------------------
  - Time: O(m + n), where m = rows, n = columns (at most one pass along edges).
  - Space: O(1), as we use constant extra space.

  -----------------------------------------------------------------------------------
  🧩 Pattern:
  -----------------------------------------------------------------------------------
  - **Matrix Search Pattern** (Staircase Search)
  - Exploits row and column sorting.

  -----------------------------------------------------------------------------------
  🔁 Follow-up Questions:
  -----------------------------------------------------------------------------------
  1️⃣ What if the matrix is sorted only row-wise?
  2️⃣ Can you do it using **binary search** for O(log(mn))?
  3️⃣ How to find the **first and last occurrence** of B if duplicates exist?
  4️⃣ Modify to return the **row and column indices** directly.

  -----------------------------------------------------------------------------------
  🔗 Similar Problems:
  -----------------------------------------------------------------------------------
  - LeetCode 240 – Search a 2D Matrix II
  - LeetCode 74 – Search a 2D Matrix
  - GFG – Search in a row-column sorted matrix
  */

  public static int solve(int[][] A, int B) {

    int i = 0, j = A[0].length - 1;
    int index = -1;
    int mid = A[i][j];
    // iterate over the loop
    while (i < A.length && j >= 0) {
      if (A[i][j] == B) {
        //                index = (i+1)*1009 + (j+1);
        index = Math.min(index, (i + 1) * 1009 + j + 1);
        j--;
        break;
      }
      if (B < A[i][j]) {
        j--;
      } else i++;
    }

    return index;
  }

  public static void main(String[] args) {

    int[][] A = {
      {1, 2, 3},
      {4, 6, 7},
      {10, 15, 20},
    };
    System.out.println(solve(A, 2));
  }
}
// public class Solution {
//    public int solve(int[][] A, int B) {
//
//        int i =0,j=A[0].length-1;
//        int ans=Integer.MAX_VALUE;
//        while(i<A.length && j>=0)
//        {
//            if(A[i][j]==B)
//            {
//                ans=Math.min(ans,(i+1)*1009+j+1);
//                j--;
//            }
//            else if(B>A[i][j])
//                i++;
//            else
//                j--;
//        }
//
//        if(ans ==Integer.MAX_VALUE)
//            return -1;
//        return ans;
//    }
// }
