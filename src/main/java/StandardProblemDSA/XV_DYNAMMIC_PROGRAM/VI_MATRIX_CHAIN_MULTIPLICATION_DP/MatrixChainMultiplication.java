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
}
