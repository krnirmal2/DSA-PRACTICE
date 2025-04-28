package StandardProblemDSA.IV_STACK.IV_MONOTONIC_NEXT_PREVIOUS_ELEMENT_PATTERN;

import java.util.*;

public class MinimumElementSumInEachSubarray {
  /*Approach:
  We can approach this problem efficiently using Monotonic Stack. Here's the reasoning:

  Stack Usage: The idea is to use a stack to efficiently compute the "next smaller" and "previous smaller" elements for each element in the array.

  Previous Smaller Element (PSE): For each element, we want to find the closest element that is smaller and to the left of it. This will help in identifying how long this element can act as the minimum in the subarray.

  Next Smaller Element (NSE): Similarly, we want to find the closest element smaller and to the right of the current element.

  Subarray Contribution: For each element, the number of subarrays in which it is the minimum element is determined by its position relative to these two boundaries (PSE and NSE).

  Steps:
  Initialize:

  Create two arrays, prevSmaller and nextSmaller, to store the indices of the previous smaller and next smaller elements for each index.

  Traverse the array:

  Use a stack to efficiently find the previous smaller element.

  Use another stack to find the next smaller element.

  Calculate the contribution of each element:

  For each element A[i], it contributes to the sum as the minimum of all subarrays where it is the minimum. This can be calculated as:

  The number of subarrays where A[i] is the minimum is i - prevSmaller[i] (count of subarrays ending at i).

  The number of subarrays where A[i] is the minimum is nextSmaller[i] - i (count of subarrays starting at i).

  Summing up the contributions:

  The total sum is the sum of A[i] * (i - prevSmaller[i]) * (nextSmaller[i] - i) for each element.*/
  public int sumSubarrayMins(int[] A) {
    int n = A.length;
    long mod = 1000000007;

    int[] prevSmaller = findPrevSmaller(A);
    int[] nextSmaller = findNextSmaller(A);

    long sum = 0;
    for (int i = 0; i < n; i++) {
      long left = i - prevSmaller[i];
      long right = nextSmaller[i] - i;
      sum = (sum + A[i] * left * right) % mod;
    }

    return (int) sum;
  }

  private int[] findPrevSmaller(int[] A) {
    int n = A.length;
    int[] prevSmaller = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
        stack.pop();
      }
      prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }

    return prevSmaller;
  }

  private int[] findNextSmaller(int[] A) {
    int n = A.length;
    int[] nextSmaller = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
        stack.pop();
      }
      nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
      stack.push(i);
    }

    return nextSmaller;
  }
  /*All subarrays of [3, 1, 2, 4]:


  Subarray	Minimum
  [3]	3
  [3,1]	1
  [3,1,2]	1
  [3,1,2,4]	1
  [1]	1
  [1,2]	1
  [1,2,4]	1
  [2]	2
  [2,4]	2
  [4]	4
  Now, adding all minimums:

  Copy
  Edit
  3 + 1 + 1 + 1 + 1 + 1 + 1 + 2 + 2 + 4 = 17
  ✅ So yes, the correct sum is 17, NOT 15.

  So why was our previous calculation showing 15?
  Let's spot the mistake:

  Earlier when calculating contributions:


  i	A[i]	prevSmaller[i]	nextSmaller[i]	Left (i-prev)	Right (next-i)	Contribution
  0	3	-1	1	1	1	3
  1	1	-1	4	2	3	6
  2	2	1	3	1	1	2
  3	4	2	4	1	1	4
  Sum = 3 + 6 + 2 + 4 = 15

  ➔ Problem is with next smaller element calculation!
  Let’s review again carefully:

  When finding Next Smaller for index 1 (A[1] = 1):

  After popping elements greater than or equal to 1, the next smaller is nothing, so it should be n = 4 (correct).

  When finding Next Smaller for index 2 (A[2] = 2):

  At i = 2 (A[2] = 2), looking to the right:

  A[3] = 4 (which is > 2), so no smaller on immediate next.

  So nextSmaller[2] = 4 (not 3)!

  In previous dry-run, I wrote nextSmaller[2] = 3, which was wrong. It should be 4.

  Hence, corrected nextSmaller array:

  text
  Copy
  Edit
  nextSmaller = [1, 4, 4, 4]
  ✅ Corrected!

  Now, recalculate:

  i	A[i]	prevSmaller[i]	nextSmaller[i]	Left (i-prev)	Right (next-i)	Contribution
  0	3	-1	1	1	1	3
  1	1	-1	4	2	3	6
  2	2	1	4	1	2	4
  3	4	2	4	1	1	4
  Now, sum of contributions:

  Copy
  Edit
  3 + 6 + 4 + 4 = 17
  ✅ Now it's matching!

  */
}
