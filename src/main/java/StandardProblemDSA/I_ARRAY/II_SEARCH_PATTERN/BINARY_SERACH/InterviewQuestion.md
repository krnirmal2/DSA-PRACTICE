Below is a comprehensive outline for solving each of the following problems. In all cases, the methods are assumed to reside within a single class (for example, `BitonicOperations`), and any common utility methods (such as a swap function for QuickSelect) are shared across the methods.

---

## 26. Find the Longest Bitonic Subarray in a Given Array

### Problem Statement
Given an array, find the length of the longest subarray that is bitonic (first increasing and then decreasing).

### Brute Force Approach
- **Idea:**  
  Consider every possible subarray, check whether it is bitonic, and keep track of the maximum length found.
- **Steps:**
    1. Enumerate all subarrays.
    2. For each subarray, verify that it first strictly increases then strictly decreases.
    3. Update the maximum length if the subarray qualifies.
- **Drawbacks:**
    - Inefficient: O(n²) or worse, as checking each subarray is expensive.

### Optimal Approach
- **Idea:**  
  Compute two auxiliary arrays:
    - `inc[]`: the length of the increasing sequence ending at each index.
    - `dec[]`: the length of the decreasing sequence starting at each index.  
      Then, for each index, the bitonic subarray length is `inc[i] + dec[i] - 1`. The maximum of these values is the answer.
- **Simplified Code (Java/Pseudo-code):**
  ```java
  public class BitonicOperations {

      public int longestBitonicSubarray(int[] arr) {
          int n = arr.length;
          if(n == 0) return 0;
          int[] inc = new int[n];
          int[] dec = new int[n];
          
          // Build increasing sequence lengths.
          for (int i = 0; i < n; i++) {
              inc[i] = 1;
              if (i > 0 && arr[i] > arr[i - 1]) {
                  inc[i] = inc[i - 1] + 1;
              }
          }
          
          // Build decreasing sequence lengths.
          for (int i = n - 1; i >= 0; i--) {
              dec[i] = 1;
              if (i < n - 1 && arr[i] > arr[i + 1]) {
                  dec[i] = dec[i + 1] + 1;
              }
          }
          
          int maxLen = 0;
          for (int i = 0; i < n; i++) {
              maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
          }
          return maxLen;
      }
      
      // Other methods below...
  }
  ```
- **Complexity:**
    - **Time:** O(n)
    - **Space:** O(n)
- **Example:**
    - **Input:** `[1, 3, 5, 4, 2]`
    - **Output:** `5`

---

## 27. Find the Smallest Number in a Rotated Bitonic Array with Duplicates

### Problem Statement
Given a rotated bitonic array (an array that was originally bitonic, then rotated) which may contain duplicates, find the smallest element in the array.

### Brute Force Approach
- **Idea:**  
  Simply traverse the entire array and track the minimum element.
- **Steps:**
    1. Iterate over each element.
    2. Keep updating a variable that stores the smallest value found.
- **Drawbacks:**
    - Time complexity is O(n).

### Optimal Approach
- **Idea:**  
  Use a modified binary search (similar to the one for rotated sorted arrays) that handles duplicates:
    1. Initialize pointers `low` and `high`.
    2. Compare the middle element with the element at `high` to decide whether to move left or right.
    3. If duplicates are encountered, reduce the search space by decrementing `high`.
- **Simplified Code (Java/Pseudo-code):**
  ```java
  public class BitonicOperations {

      // Other methods above...
      
      public int findMinInRotatedBitonic(int[] arr) {
          int n = arr.length;
          int low = 0, high = n - 1;
          while (low < high) {
              int mid = low + (high - low) / 2;
              if (arr[mid] > arr[high]) {
                  low = mid + 1;
              } else if (arr[mid] < arr[high]) {
                  high = mid;
              } else {
                  high--;  // When duplicates are present.
              }
          }
          return arr[low];
      }
  }
  ```
- **Complexity:**
    - **Time:** Average O(log n), worst-case O(n) due to duplicates
    - **Space:** O(1)
- **Example:**
    - **Input:** `[4, 2, 1, 3, 8, 12]`
    - **Output:** `1`

---

## 28. Find k-th Largest Element in a Rotated Bitonic Array

### Problem Statement
Given a rotated bitonic array, find the k-th largest element.

### Brute Force Approach
- **Idea:**  
  Sort the array in descending order and then return the element at index `k - 1`.
- **Drawbacks:**
    - Time complexity is O(n log n).

### Optimal Approach
- **Idea:**  
  Use the QuickSelect algorithm to efficiently select the k-th largest element.  
  Since QuickSelect finds the k-th smallest element, we adjust by selecting the element at index `arr.length - k`.
- **Simplified Code (Java/Pseudo-code):**
  ```java
  public class BitonicOperations {

      // Common utility method for swapping elements.
      private void swap(int[] arr, int i, int j) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
      
      // QuickSelect method to find the k-th smallest element.
      private int quickSelect(int[] arr, int low, int high, int k) {
          if (low == high) return arr[low];
          int pivotIndex = partition(arr, low, high);
          if (pivotIndex == k) {
              return arr[pivotIndex];
          } else if (pivotIndex < k) {
              return quickSelect(arr, pivotIndex + 1, high, k);
          } else {
              return quickSelect(arr, low, pivotIndex - 1, k);
          }
      }
      
      private int partition(int[] arr, int low, int high) {
          int pivot = arr[high];
          int i = low;
          for (int j = low; j < high; j++) {
              if (arr[j] <= pivot) {
                  swap(arr, i, j);
                  i++;
              }
          }
          swap(arr, i, high);
          return i;
      }
      
      public int kthLargestInRotatedBitonic(int[] arr, int k) {
          int n = arr.length;
          // kth largest is (n - k)th smallest.
          return quickSelect(arr, 0, n - 1, n - k);
      }
  }
  ```
- **Complexity:**
    - **Time:** Average O(n), worst-case O(n²)
    - **Space:** O(1) (ignoring recursion stack)
- **Example:**
    - **Input:** `[4, 2, 1, 3, 8, 12]` with `k = 2`
    - **Output:** `8` (largest is 12, second largest is 8)

---

## 29. Find the Maximum Profit by Buying and Selling Stock in a Bitonic Array

### Problem Statement
Given a bitonic array where elements represent stock prices (first increasing then decreasing), determine the maximum profit obtainable by buying once and selling once.

### Brute Force Approach
- **Idea:**  
  Consider every possible pair of buy (i) and sell (j) where `i < j` and calculate the profit. Keep track of the maximum profit.
- **Drawbacks:**
    - Time complexity of O(n²).

### Optimal Approach
- **Idea:**  
  Use a single pass to track the minimum price seen so far (buy) and compute profit if selling at the current price.  
  In a bitonic array, the maximum profit is typically achieved by buying at the minimum (in the increasing portion) and selling at the peak.
- **Simplified Code (Java/Pseudo-code):**
  ```java
  public class BitonicOperations {

      // Other methods above...
      
      public int maxProfitInBitonic(int[] prices) {
          int minPrice = Integer.MAX_VALUE;
          int maxProfit = 0;
          for (int price : prices) {
              minPrice = Math.min(minPrice, price);
              maxProfit = Math.max(maxProfit, price - minPrice);
          }
          return maxProfit;
      }
  }
  ```
- **Complexity:**
    - **Time:** O(n)
    - **Space:** O(1)
- **Example:**
    - **Input:** `[1, 3, 8, 12, 4, 2]`
    - **Output:** `11` (buy at 1 and sell at 12)

---

## Find the k-th Peak or k-th Valley in an Array

### Problem Statement
Given an array, find the k-th occurrence of either a peak (an element greater than its neighbors) or a valley (an element smaller than its neighbors).

### Brute Force Approach
- **Idea:**  
  Traverse the array, check each element (except the boundaries) to see if it is a peak or valley, count the occurrences, and return the k-th one found.
- **Steps:**
    1. Loop from index 1 to `n - 2`.
    2. Check if an element qualifies as a peak (or valley) based on its neighbors.
    3. Increment a counter when a peak (or valley) is found.
    4. Return the element once the counter reaches k.

### Optimal Approach
- **Idea:**  
  Perform a single pass through the array while counting peaks or valleys. Return as soon as the k-th occurrence is encountered.
- **Simplified Code (Java/Pseudo-code):**
  ```java
  public class BitonicOperations {

      // Other methods above...
      
      public int kthPeakOrValley(int[] arr, int k, boolean findPeak) {
          int count = 0;
          // Traverse the array; boundaries cannot be peaks or valleys.
          for (int i = 1; i < arr.length - 1; i++) {
              if (findPeak && arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                  count++;
                  if (count == k) return arr[i];
              }
              if (!findPeak && arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                  count++;
                  if (count == k) return arr[i];
              }
          }
          return -1;  // or throw an exception if kth occurrence doesn't exist.
      }
  }
  ```
- **Complexity:**
    - **Time:** O(n)
    - **Space:** O(1)
- **Example:**
    - **Input:** `arr = [1, 3, 2, 5, 4, 6, 4]`, `k = 2`, `findPeak = true`
    - **Output:** `5` (the peaks here are 3 at index 1, 5 at index 3, and 6 at index 5; the 2nd peak is 5)

---

### Overall Summary
All the methods above are implemented as part of a single class (e.g., `BitonicOperations`). They share common utility methods (such as a swap for QuickSelect) and illustrate both brute force and optimal approaches with clear code snippets, complexity analysis, and examples for each problem. This modular design promotes code reuse and ease of maintenance.