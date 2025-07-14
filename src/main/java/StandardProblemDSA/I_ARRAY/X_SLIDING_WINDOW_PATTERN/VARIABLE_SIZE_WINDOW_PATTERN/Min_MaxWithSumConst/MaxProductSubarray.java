package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.Min_MaxWithSumConst;

public class MaxProductSubarray {
  /* Given an integer array nums, find a subarray that has the largest product, and return the product.
  The test cases are generated so that the answer will fit in a 32-bit integer.
  Example 1:
  Input: nums = [2,3,-2,4]
  Output: 6
  Explanation: [2,3] has the largest product 6.
  Example 2:

  Input: nums = [-2,0,-1]
  Output: 0
  Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

  Constraints:
          1 <= nums.length <= 2 * 104
          -10 <= nums[i] <= 10
  The product of any subarray of nums is guaranteed to fit in a 32-bit integer.*/
  /*We need to find the maximum product of any contiguous subarray.
  But with multiplication, some tricky things happen:
  A negative number can flip a large product into a negative one.
  But two negative numbers can create a positive product.
  A zero wipes out everything and creates a hard boundary.

  🔥 Realization:
  To handle all cases (positive, negative, zero), we must keep track of:
  maxSoFar: the maximum product ending at current index
  minSoFar: the minimum product ending at current index

  ❗ Why track minSoFar?
  Because a negative number multiplied by the current minSoFar (also negative) can become the next maxSoFar.*/
  public static int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int maxSoFar = nums[0];
    int minSoFar = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int current = nums[i];

      if (current < 0) {
        // Swap max and min when negative
        int temp = maxSoFar;
        maxSoFar = minSoFar;
        minSoFar = temp;
      }

      maxSoFar = Math.max(current, maxSoFar * current);
      minSoFar = Math.min(current, minSoFar * current);

      result = Math.max(result, maxSoFar);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(maxProduct(new int[] {2, 3, -2, 4})); // 6
    System.out.println(maxProduct(new int[] {-2, 0, -1})); // 0
    System.out.println(maxProduct(new int[] {-2, 3, -4})); // 24
    System.out.println(maxProduct(new int[] {1, 2, 3, 4})); // 24
  }
}
