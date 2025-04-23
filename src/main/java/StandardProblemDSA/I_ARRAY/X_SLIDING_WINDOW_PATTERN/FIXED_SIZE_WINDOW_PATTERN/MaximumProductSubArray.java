package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

public class MaximumProductSubArray {
  // ---------------------------------------------------
  // 4. Maximum Product Subarray in Sliding Window
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given an array and a fixed window size k, find the subarray (of length k)
       with the maximum product.

    Brute Force Approach:
       - For each window, compute the product of k elements and track the maximum.
       - Time Complexity: O(n*k)

    Optimal Approach:
       - If the array contains no zeros, we can compute the product of the first window,
         then for subsequent windows divide by the element leaving the window and multiply by the new element.
       - If zeros are present, we may need to recompute the product for that window.
       - Average Time Complexity: O(n) (worst-case: O(n*k) when zeros force recomputation)

    Example:
       Input: arr = [1, 5, 2, 3, 7, 1], k = 3
       Output: Maximum product = 42 (subarray [2,3,7])
  */
  public static double maxProductSubarray(int[] arr, int k) {
    if (arr == null || arr.length < k) {
      return -1; // or throw exception
    }
    double maxProduct = Double.NEGATIVE_INFINITY;
    double product = 1.0;
    int n = arr.length;

    // Compute product for the first window.
    for (int i = 0; i < k; i++) {
      product *= arr[i];
    }
    maxProduct = Math.max(maxProduct, product);

    for (int i = k; i < n; i++) {
      // If the element exiting the window is zero, recompute product.
      if (arr[i - k] == 0) {
        product = 1.0;
        for (int j = i - k + 1; j <= i; j++) {
          product *= arr[j];
        }
      } else {
        // Update product using division and multiplication.
        product = product / arr[i - k] * arr[i];
      }
      maxProduct = Math.max(maxProduct, product);
    }
    return maxProduct;
  }
}
