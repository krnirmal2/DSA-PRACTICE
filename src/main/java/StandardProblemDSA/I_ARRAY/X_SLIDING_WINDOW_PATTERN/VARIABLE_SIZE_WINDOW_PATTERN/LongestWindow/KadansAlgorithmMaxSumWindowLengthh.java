package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.LongestWindow;

import java.util.ArrayList;
import java.util.List;

/*
------------------------------------------------------
Problem Statement
------------------------------------------------------
Given an array `a`, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:
Input:  a = [2, -1, 3, 4, -5]
Output: 8
Explanation: Maximum sum subarray is [2, -1, 3, 4].

------------------------------------------------------
Pattern
------------------------------------------------------
Pattern Name: Kadane’s Algorithm (Dynamic Programming / Sliding Window)
- Maintain `currentSum` for the current subarray.
- If adding the current element decreases `currentSum`, start a new subarray from this element.
- Keep track of `maxSum` across all subarrays.
- Optionally, keep track of start and end indices for the subarray.

Why Kadane’s?
- It avoids recomputation by carrying forward the best sum so far.
- Time complexity reduced to O(n).

------------------------------------------------------
Follow-up Questions
------------------------------------------------------
1. Can we find not only the maximum sum but also the subarray itself?
   - Yes, track `start`, `end`, and `tempStart` indices.

2. What if all elements are negative?
   - Kadane’s still works, but `maxSum` will be the maximum single element.

3. Can we modify Kadane’s to find:
   - The minimum sum subarray? (Yes, invert signs or change comparisons)
   - The maximum product subarray? (Requires handling negative products separately)

4. How to handle circular arrays?
   - Compute max normal subarray + max wrapping subarray using `totalSum - minSubarray`.

5. Can this be extended to 2D arrays?
   - Yes, using Kadane’s on rows with O(n³) approach.

------------------------------------------------------
Similar LeetCode Questions
------------------------------------------------------
- LeetCode 53 – Maximum Subarray (classic Kadane’s)
- LeetCode 918 – Maximum Sum Circular Subarray
- LeetCode 152 – Maximum Product Subarray
- LeetCode 121 – Best Time to Buy and Sell Stock (variation of Kadane’s)

------------------------------------------------------
Time & Space Complexity
------------------------------------------------------
- Time Complexity: O(n) – single pass through the array.
- Space Complexity: O(1) – constant extra space.
*/

public class KadansAlgorithmMaxSumWindowLengthh {
  // Find the maximum sum of a contiguous subarray in an array.
  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>(List.of(2, -1, 3, 4, -5));
    System.out.println(maxiMumSubArraySum(a));
  }

    /*  public int maxSubArray(int[] nums) {
      int maxSum = nums[0];
      int currentSum = nums[0];
      for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
      }
      return maxSum;
    }*/
  private static int maxiMumSubArraySum(ArrayList<Integer> a) {
      //    List<Integer> a = Arrays.stream(nums) // convert to IntStream
      //            .boxed()      // box to Integer
      //            .collect(Collectors.toList());

    // Edge case: empty list
    if (a.isEmpty()) {
      return 0;
    }

    int current = a.get(0);
    int maxEndOfEachSubArray = a.get(0);
    int start = 0, end = 0, tempStart = 0;

    for (int i = 1; i < a.size(); i++) {
      // if current sum is negative then the current element then set the sum to that
      // element and from here the start of the array is on
      if (current + a.get(i)
          < a.get(i)) { // sum become less then current element then no benefit to take it
        current = a.get(i); // resest the curren sum with current eleemnt
        tempStart = i; // New potential subarray start
      } else {
        // if no negative go on
        current += a.get(i);
      }
      // update the maximum value on each addition with current sum
      // also update the start and end also
      if (current > maxEndOfEachSubArray) {
        maxEndOfEachSubArray = current;
        start = tempStart;
        end = i;
      }
    }

    // Print the maximum subarray indices and elements
    System.out.println("Maximum Subarray Sum: " + maxEndOfEachSubArray);
    System.out.println("Subarray Indices: [" + start + " to " + end + "]");
    System.out.println("Subarray: " + a.subList(start, end + 1));

    return maxEndOfEachSubArray;
  }
}
