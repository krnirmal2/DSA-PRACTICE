package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.VI_MATRIX_CHAIN_MULTIPLICATION_DP;

import java.util.Arrays;

public class MatrixChainMultiplication {

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
