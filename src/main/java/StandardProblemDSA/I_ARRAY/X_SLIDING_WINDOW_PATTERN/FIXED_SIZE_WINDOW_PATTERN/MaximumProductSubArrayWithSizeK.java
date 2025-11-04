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
      Example 1:
      Input: nums = [2,3,-2,4]
      Output: 6
      Explanation: [2,3] has the largest product 6.

      Example 2:
      Input: nums = [-2,0,-1]
      Output: 0
      Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
  Pattern:
  - Sliding Window (fixed size) with product tracking and zero handling.

  Time Complexity:
  - O(n) on average.
  - Worst case: O(n*k) if zeros force recomputation often.

  Space Complexity:
  - O(1), no extra data structures used.

  Follow-up Questions:
  1. How would you handle negative numbers where the maximum product might result from even/odd negatives?
  2. Can you find maximum product for subarrays of variable sizes?
  3. How would you handle very large products to prevent overflow?

  Similar LeetCode/Interview Questions:
  - LeetCode 713. Subarray Product Less Than K (variation)
  - GFG: Maximum product subarray of size k
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
    maxProduct = product;

    for (int i = k; i < n; i++) {
      // CASE 1; If the element exiting the window is zero, recompute product.
      int outgoing = arr[i - k];
      int incoming = arr[i];
      if (outgoing == 0) { // go to the index
        product = 1.0;
        // j will start from k steps back from i and reach to current i as we recompute the value
        for (int j = i - k + 1; j <= i; j++) {
          product *= arr[j];
        }
      } else { // CASE 2; without zero element
        // Update product using division and multiplication.
        product = product / outgoing * incoming;
      }
      maxProduct = Math.max(maxProduct, product);
    }
    return maxProduct;
  }

  public static void main(String[] args) {
    int[] arr = {1, 5, 2, 3, 7, 0, 4, 6};
    int k = 3;
    System.out.println(maxProductSubarray(arr, k)); // Output: 84.0
  }
  /*
  ### Example Input
  arr = [1, 5, 2, 3, 7, 0, 4, 6]
  k = 3

  | Step | Window (indices) | Outgoing Element | Incoming Element | Action Taken | Product After Step | Max Product |
  |------|------------------|------------------|------------------|--------------|--------------------|-------------|
  | Init | [0..2] → [1, 5, 2] | — | — | Initial product = 1×5×2 | 10 | 10 |
  | 1    | [1..3] → [5, 2, 3] | 1 | 3 | No zero → `(10 / 1) × 3` | 30 | 30 |
  | 2    | [2..4] → [2, 3, 7] | 5 | 7 | No zero → `(30 / 5) × 7` | 42 | 42 |
  | 3    | [3..5] → [3, 7, 0] | 2 | 0 | No zero → `(42 / 2) × 0` | 0 | 42 |
  | 4    | [4..6] → [7, 0, 4] | 3 | 4 | Outgoing ≠ 0 but prev product is 0 → `(0 / 3) × 4` | 0 | 42 |
  | 5    | [5..7] → [0, 4, 6] | 7 | 6 | Outgoing = 0 → Recompute: `4 × 6` | 24 | 42 |

  ### Key Observations
  - **Step 2** gives the highest product: `2 × 3 × 7 = 42`.
  - When a **zero** enters the window (Step 3), the product becomes `0`.
  - When a **zero** leaves the window (Step 5), we **recompute** the product from scratch for the new window.

  */
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
