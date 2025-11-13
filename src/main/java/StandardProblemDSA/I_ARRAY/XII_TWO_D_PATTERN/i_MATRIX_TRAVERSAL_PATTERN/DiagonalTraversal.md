Below are two common matrix traversal problems related to diagonals. As before, each solution is outlined with:

- **Problem Statement:** A description of the traversal.
- **Brute Force Approach:** A simple method explanation without code.
- **Optimal Approach:** A clear, minimal code snippet (assuming the methods reside in the same class, with any common utilities reused as needed).
- **Time and Space Complexity:** Analysis for the approach.
- **Example:** A sample input and expected output.

---

## 1. Main Diagonal Traversal (Top-Left to Bottom-Right)

### Problem Statement
Given a square matrix, traverse and return the elements that lie on the main diagonal (from the top-left corner to the bottom-right corner).

### Brute Force Approach
- **Idea:**
    - Iterate through every element of the matrix.
    - Check if the row index equals the column index (i.e., `i == j`).
    - If the condition holds, add the element to the result list.
- **Steps:**
    1. Loop through each row and each column.
    2. For each element, if `row index == column index`, then select that element.
    3. Collect these selected elements into a list.

### Optimal Approach
- **Idea:**
    - For a square matrix, simply iterate from `0` to `n-1` (where `n` is the size of the matrix) and pick the element at position `[i][i]`.
- **Simplified Code (Java/Pseudo-code):**
  ```java
  public List<Integer> mainDiagonalTraversal(int[][] matrix) {
      List<Integer> result = new ArrayList<>();
      int n = matrix.length;  // assuming square matrix: n x n
      for (int i = 0; i < n; i++) {
          result.add(matrix[i][i]);
      }
      return result;
  }
  ```

### Complexity
- **Time Complexity:** O(n) (single loop over n elements)
- **Space Complexity:** O(n) (for storing the result)

### Example
- **Input:**
  ```
  [ [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9] ]
  ```
- **Output:** `[1, 5, 9]`

---

## 2. Anti-Diagonal Traversal (Top-Right to Bottom-Left)

### Problem Statement
Given a square matrix, traverse and return the elements that lie on the anti-diagonal (from the top-right corner to the bottom-left corner).

### Brute Force Approach
- **Idea:**
    - Iterate through every element in the matrix.
    - Check if the sum of the row and column indices equals `n - 1` (for an n x n matrix).
    - If the condition holds, add the element to the result list.
- **Steps:**
    1. Loop through all rows and columns.
    2. For each element, if `i + j == n - 1`, select that element.
    3. Collect these elements in a list.

### Optimal Approach
- **Idea:**
    - For a square matrix, simply iterate with a single loop. For each row index `i`, the corresponding anti-diagonal element is at `[i][n-1-i]`.
- **Simplified Code (Java/Pseudo-code):**
  ```java
  public List<Integer> antiDiagonalTraversal(int[][] matrix) {
      List<Integer> result = new ArrayList<>();
      int n = matrix.length;  // assuming square matrix: n x n
      for (int i = 0; i < n; i++) {
          result.add(matrix[i][n - 1 - i]);
      }
      return result;
  }
  ```

### Complexity
- **Time Complexity:** O(n) (one loop over n elements)
- **Space Complexity:** O(n) (for storing the result)

### Example
- **Input:**
  ```
  [ [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9] ]
  ```
- **Output:** `[3, 5, 7]`

---

### Summary
Both diagonal traversal methods are designed as individual methods within the same class, enabling the use of shared utilities if needed (for example, if further matrix operations are required). The brute force method in each case involves checking each element for a condition, whereas the optimal method leverages the predictable index pattern of square matrices to perform the traversal in a single loop, resulting in linear time complexity and minimal additional space usage for storing results.