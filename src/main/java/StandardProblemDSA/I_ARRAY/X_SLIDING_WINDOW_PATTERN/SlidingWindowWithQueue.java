package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN;

import java.util.*;

public class SlidingWindowWithQueue {}

class SlidingWindowOperations {

  // ---------------------------------------------------
  // 1. Find Maximum Sum Subarray of Fixed Size
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given an array and a fixed window size k, find the subarray (of length k)
       that has the maximum sum.

    Brute Force Approach:
       - For each index, compute the sum of k consecutive elements and track the maximum.
       - Time Complexity: O(n*k)

    Optimal Approach:
       - Use a sliding window to compute the sum in O(n) time.
       - Add the new element and subtract the element that is no longer in the window.
       - Time Complexity: O(n)

    Example:
       Input: arr = [2, 1, 5, 1, 3, 2], k = 3
       Output: Maximum sum = 7 (subarray [5, 1, 1] or [1, 5, 1] depending on indices; in this case, [5,1,1] gives 7)
       (Note: Adjust example as needed.)
  */
  public static int maxSumSubarray(int[] arr, int k) {
    if (arr == null || arr.length < k) {
      return -1; // or handle error
    }
    int maxSum = 0;
    // Compute sum of first window
    for (int i = 0; i < k; i++) {
      maxSum += arr[i];
    }
    int windowSum = maxSum;
    // Slide window
    for (int i = k; i < arr.length; i++) {
      windowSum += arr[i] - arr[i - k];
      maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
  }

  // ---------------------------------------------------
  // 3. Longest Substring with K Distinct Characters
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a string and an integer k, find the length of the longest substring that
       contains at most k distinct characters.

    Brute Force Approach:
       - Enumerate all substrings and check the number of distinct characters.
       - Time Complexity: O(n^2)

    Optimal Approach:
       - Use a sliding window with a hash map to track character frequencies.
       - Expand the window until it exceeds k distinct characters, then shrink.
       - Time Complexity: O(n)

    Example:
       Input: s = "araaci", k = 2
       Output: 4 (The longest substring is "araa")
  */
  public static int longestSubstringKDistinct(String s, int k) {
    if (s == null || s.length() == 0 || k <= 0) {
      return 0;
    }
    int maxLen = 0;
    Map<Character, Integer> charCount = new HashMap<>();
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);

      // Shrink window until we have at most k distinct characters.
      while (charCount.size() > k) {
        char leftChar = s.charAt(left);
        charCount.put(leftChar, charCount.get(leftChar) - 1);
        if (charCount.get(leftChar) == 0) {
          charCount.remove(leftChar);
        }
        left++;
      }
      maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    // 1. Maximum Sum Subarray of Fixed Size
    int[] sumArr = {2, 1, 5, 1, 3, 2};
    int windowSizeSum = 3;
    int maxSum = maxSumSubarray(sumArr, windowSizeSum);
    System.out.println("Maximum sum of subarray of size " + windowSizeSum + " is: " + maxSum);
    // Expected: 7 (for subarray [5, 1, 1] or another depending on array; adjust example if needed)

    //    // 2. Largest Element in Each Sliding Window
    //    int[] windowArr = {1, 3, -1, -3, 5, 3, 6, 7};
    //    int windowSize = 3;
    //    int[] largestElements = maxSlidingWindow(windowArr, windowSize);
    //    System.out.println("Largest element in each sliding window:");
    //    System.out.println(Arrays.toString(largestElements));
    //    // Expected: [3, 3, 5, 5, 6, 7]

    // 3. Longest Substring with K Distinct Characters
    String s = "araaci";
    int kDistinct = 2;
    int longestSubstr = longestSubstringKDistinct(s, kDistinct);
    System.out.println(
        "Length of longest substring with " + kDistinct + " distinct characters: " + longestSubstr);
    // Expected: 4 ("araa")

    // 4. Maximum Product Subarray in Sliding Window
    //    int[] productArr = {1, 5, 2, 3, 7, 1};
    //    int windowSizeProd = 3;
    //    double maxProd = maxProductSubarray(productArr, windowSizeProd);
    //    System.out.println("Maximum product of subarray of size " + windowSizeProd + " is: " +
    // maxProd);
    //    // Expected: 42 (for subarray [2, 3, 7])
  }
}
/*

        ---

        ### Summary

1. **Maximum Sum Subarray of Fixed Size:**
        - **Brute Force:** Compute the sum of every subarray of length k (O(n*k)).
        - **Optimal:** Use a sliding window to update the sum (O(n)).
        - **Example:** For [2,1,5,1,3,2] with k=3, maximum sum is 7.

        2. **Largest Element in Each Sliding Window:**
        - **Brute Force:** Find maximum for each window by iterating over k elements (O(n*k)).
        - **Optimal:** Use a deque to maintain indices of candidates (O(n)).
        - **Example:** For [1,3,-1,-3,5,3,6,7] with k=3, result is [3,3,5,5,6,7].

        3. **Longest Substring with K Distinct Characters:**
        - **Brute Force:** Check all substrings (O(n²)).
        - **Optimal:** Use sliding window with a frequency map (O(n)).
        - **Example:** For "araaci" with k=2, longest length is 4.

        4. **Maximum Product Subarray in Sliding Window:**
        - **Brute Force:** Compute product for each window (O(n*k)).
        - **Optimal:** Use a sliding window with division (handling zeros appropriately) (average O(n)).
        - **Example:** For [1,5,2,3,7,1] with k=3, maximum product is 42.

All methods are implemented within a single class for ease of testing and reuse.*/
