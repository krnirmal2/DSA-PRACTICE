package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.VI_MATRIX_CHAIN_MULTIPLICATION_DP;

import java.util.Arrays;

public class MatrixChainMultiplication {
  /*
    Matrix Chain Multiplication (MCM)
    Given an array `dimensions[]` of length n, where the i-th matrix has dimensions
    dimensions[i-1] x dimensions[i], find the minimum number of scalar multiplications
    needed to multiply the sequence of matrices.

    ---
    Example 1:
    Input: dimensions = [40, 20, 30, 10, 30]
    Output: 26000
    Explanation:
      - Order: ((M1 x M2) x M3) x M4
      - Minimum cost = 40×20×30 + 40×30×10 + 40×10×30 = 26000

    Example 2:
    Input: dimensions = [10, 20, 30]
    Output: 6000
    Explanation:
      - Only one way: (M1 x M2)
      - Cost = 10 × 20 × 30 = 6000

    ---
    ❓ Why:
    - Parenthesization affects multiplication cost because matrix multiplication is associative.
    - We need to find the order that minimizes total scalar multiplications.

    ---
    💡 Pattern:
    - **Matrix Chain Multiplication (MCM)** / **Interval DP**.
    - We try every partition `k` between `i` and `j`:
        cost(i, j) = min over k [ cost(i, k) + cost(k, j) + dimensions[i] × dimensions[k] × dimensions[j] ]
    - Memoization table `dp[i][j]` stores the minimum cost for multiplying matrices from i to j.

    ---
    ⏱ Time Complexity: O(n³)
    📦 Space Complexity: O(n²)

  Time Complexity: O(N*N*N)
  Reason: There are N*N states and we explicitly run a loop inside the function which will run for N times, therefore at max ‘N*N*N’ new problems will be solved.

  ### 1. **Number of States**
  - The DP table `dp[i][j]` stores results for each `(i, j)` pair.
  - `i` and `j` can each go from `1` to `N` (where `N` is the number of matrices or array length - 1).
  - That gives **O(N²)** possible `(i, j)` states.

  ### 2. **Work per State**
  - For each `(i, j)` state, you loop over `k` from `i` to `j-1`.
  - That’s **O(N)** iterations in the worst case.

  ### 3. **Total Complexity**
  - Total = **Number of states × Work per state**
    O(N^2) \times O(N) = O(N^3)
  ---

  Space Complexity: O(N*N) + O(N)
  Reason: We are using an auxiliary recursion stack space(O(N))and a 2D array ( O(N*N)).
    ---
    🔄 Follow-up:
    - Print the optimal parenthesization.
    - Convert recursion + memoization to bottom-up DP.
    - Use Knuth’s optimization for reducing time in some cases.

    ---
    🔗 LeetCode / Related:
    - GFG: Matrix Chain Multiplication
    - Related: 312. Burst Balloons, Boolean Parenthesization, Optimal BST
    */
  // Recursive function with memoization to compute the minimum number of scalar multiplications
  // needed to multiply matrices from index 'start' to 'end' in the chain.
  private static int computeMinMultiplications(
      int[] dimensions, int start, int end, int[][] dpMemo) {
    // Base Case: Only one matrix, no multiplication needed
    if (start + 1 == end) {
      return 0;
    }

    // Return already computed value if present
    if (dpMemo[start][end] != -1) {
      return dpMemo[start][end];
    }

    int minCost = Integer.MAX_VALUE;

    // Try placing parenthesis at every possible position between start and end
    // and choose the minimum cost among all valid splits
    for (int partition = start + 1; partition < end; partition++) {
      int costLeft = computeMinMultiplications(dimensions, start, partition, dpMemo);
      int costRight = computeMinMultiplications(dimensions, partition, end, dpMemo);
      int costToMultiply = dimensions[start] * dimensions[partition] * dimensions[end];

      int totalCost = costLeft + costRight + costToMultiply;
      minCost = Math.min(minCost, totalCost);
    }

    // Store the result in the memoization table
    dpMemo[start][end] = minCost;
    return minCost;
  }

  // Driver function to initialize DP table and trigger recursion
  public static int findMinimumMultiplicationCost(int[] matrixDimensions) {
    int n = matrixDimensions.length;
    int[][] dpMemo = new int[n][n];

    // Initialize memoization table with -1 (uncomputed)
    for (int[] row : dpMemo) {
      Arrays.fill(row, -1);
    }

    // Compute minimum multiplication cost from matrix 0 to matrix n-1
    return computeMinMultiplications(matrixDimensions, 0, n - 1, dpMemo);
  }

  // Main method to run the program
  public static void main(String[] args) {
    int[] matrixDimensions = {1, 2, 3, 4, 3}; // Represents matrices of sizes 1x2, 2x3, 3x4, 4x3
    int minCost = findMinimumMultiplicationCost(matrixDimensions);
    System.out.println("Minimum number of multiplications: " + minCost);
  }

  /// convert to tabulation method
  static int matrixMultiplication(int[] arr, int N) {
    int[][] dp = new int[N][N];

    // Initialize the dp array with -1
    for (int row[] : dp) {
      Arrays.fill(row, -1);
    }

    // Initialize the diagonal with 0
    for (int i = 1; i < N; i++) {
      dp[i][i] = 0;
    }

    // Fill in the dp array using bottom-up approach
    for (int i = N - 1; i >= 1; i--) {
      for (int j = i + 1; j < N; j++) {
        int minOperations = Integer.MAX_VALUE;

        // Partitioning loop to find the optimal split point
        for (int k = i; k <= j - 1; k++) {
          int operations = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
          minOperations = Math.min(minOperations, operations);
        }

        dp[i][j] = minOperations;
      }
    }

    // The result is stored in dp[1][N-1]
    return dp[1][N - 1];
  }
  /*
    f(1,4)
  ├── k = 1 → cost = f(1,1) + f(2,4) + (10*20*50)
  │           f(1,1) = 0 // base case hit
  │           f(2,4):
  │           ├── k = 2 → cost = f(2,2) + f(3,4) + (20*30*50)
  │           │           f(2,2) = 0 // base case hit
  │           │           f(3,4):
  │           │           ├── k = 3 → cost = f(3,3) + f(4,4) + (30*40*50)
  │           │           │           f(3,3) = 0
  │           │           │           f(4,4) = 0
  │           │           └── min cost of f(3,4) = 30*40*50 = 60000
  │           └── cost for k=2 in f(2,4) = 0 + 60000 + (20*30*50) = 90000
  │
  │           ├── k = 3 → cost = f(2,3) + f(4,4) + (20*40*50)
  │           │           f(2,3):
  │           │           ├── k = 2 → cost = f(2,2) + f(3,3) + (20*30*40)
  │           │           │           = 0 + 0 + 24000
  │           │           └── min cost of f(2,3) = 24000
  │           └── cost for k=3 in f(2,4) = 24000 + 0 + (20*40*50) = 64000
  │
  │           min cost of f(2,4) = min(90000, 64000) = 64000
  │
  │   Total cost for k=1 in f(1,4) = 0 + 64000 + (10*20*50) = 74000
  │
  ├── k = 2 → cost = f(1,2) + f(3,4) + (10*30*50)
  │           f(1,2):
  │           ├── k = 1 → cost = f(1,1) + f(2,2) + (10*20*30) = 6000
  │           min cost of f(1,2) = 6000
  │
  │           f(3,4) = 60000 (from above)
  │
  │   Total cost for k=2 in f(1,4) = 6000 + 60000 + (10*30*50) = 111000
  │
  ├── k = 3 → cost = f(1,3) + f(4,4) + (10*40*50)
  │           f(1,3):
  │           ├── k = 1 → cost = f(1,1) + f(2,3) + (10*20*40)
  │           │           f(2,3) = 24000 (from above)
  │           │           total = 0 + 24000 + 8000 = 32000
  │           ├── k = 2 → cost = f(1,2) + f(3,3) + (10*30*40)
  │           │           = 6000 + 0 + 12000 = 18000
  │           min cost of f(1,3) = min(32000, 18000) = 18000
  │
  │   Total cost for k=3 in f(1,4) = 18000 + 0 + (10*40*50) = 38000
  │
  min cost of f(1,4) = min(74000, 111000, 38000) = **38000**
  */
}
