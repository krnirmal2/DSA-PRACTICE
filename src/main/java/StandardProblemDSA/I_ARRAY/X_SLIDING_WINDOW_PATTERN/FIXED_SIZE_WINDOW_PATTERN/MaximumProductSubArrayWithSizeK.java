package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

public class MaximumProductSubArrayWithSizeK {
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
      // CASE 1; If the element exiting the window is zero, recompute product.
      if (arr[i - k] == 0) {
        product = 1.0;
        for (int j = i - k + 1; j <= i; j++) {
          product *= arr[j];
        }
      } else { // CASE 2; without zero element
        // Update product using division and multiplication.
        product = product / arr[i - k] * arr[i];
      }
      maxProduct = Math.max(maxProduct, product);
    }
    return maxProduct;
  }
  /*Great question! Here's a breakdown of the **approach we're following for the sliding window** in this `maxProductSubarray` code:
  ### ✅ **Approach: Sliding Window with Zero Handling**
  #### 📌 Goal:
  Find the **maximum product** of any **contiguous subarray of size `k`**.
  ### 🔍 Key Challenges with Product:
  - Unlike sum, **product can't be updated simply by subtracting and adding**.
  - **Zeros** make product **zero**, and **division by zero** is undefined.
  - Floating-point **division can introduce errors**.
  ### ✅ Step-by-Step Sliding Window Strategy:
  1. **Initialize first window (size `k`):**
     - Multiply each element
     - Count how many zeros appear

  2. **Start sliding the window from index `k` to `n-1`:**
     For each new element coming in and one going out:
     - If the outgoing element is `0`, decrease `zeroCount`.
     - Else, divide `product` by it.
     - If the incoming element is `0`, increase `zeroCount`.
     - Else, multiply `product` by it.

  3. **Update `maxProduct`:**
     - If `zeroCount == 0`, the product is valid → update max
     - If there’s any zero in the window → product is zero → consider `0` as a candidate
  ### 🧠 What Makes This a Good Approach?

  | Feature              | Benefit                               |
  |----------------------|----------------------------------------|
  | Sliding Window (O(N)) | Efficient – no need to recompute product each time |
  | Zero Handling        | Prevents division by zero and resets |
  | Constant Space       | Only few variables used               |
  | Works with Negatives | No special cases for sign             |
  ### 🧭 Analogy:
  It’s like you're moving a **glass window of size `k`** over the array, carefully updating what goes out and what comes in — and keeping track if any **glass is cracked (zero)**, which would invalidate that view.

  Let me know if you'd like to compare this with a **sum-based window** visually!*/
}
