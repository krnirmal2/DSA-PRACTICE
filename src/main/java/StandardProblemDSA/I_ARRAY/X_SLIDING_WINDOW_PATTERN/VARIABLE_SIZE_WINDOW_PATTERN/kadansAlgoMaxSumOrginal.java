package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

public class kadansAlgoMaxSumOrginal {
  /*Question (interview style)
  You are given an integer array arr[] (which may contain both positive and negative numbers).
  Your task is to find the contiguous subarray that has the largest sum, and return that sum.
  Example
  Input:
  arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
  Output:
  6
  Explanation:
  The subarray [4, -1, 2, 1] has the largest sum = 6.*/
  /*Kadane’s Algorithm (Greedy + DP)
  Idea:
  Iterate through the array while keeping track of:
  currentSum: best sum ending at current index
  maxSum: global maximum seen so fa*/
  public static int maxSubArray(int[] nums) {
    int currentSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println("Maximum Subarray Sum = " + maxSubArray(arr));
  }
}
/*arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
currentSum = arr[0] = -2
maxSum     = -2

        | i | arr\[i] | currentSum calculation        | currentSum | maxSum | Comment                |
        | - | ------- | ----------------------------- | ---------- | ------ | ---------------------- |
        | 0 | -2      | init                          | -2         | -2     | start                  |
        | 1 | 1       | max(1, -2+1) = max(1, -1)     | 1          | 1      | restart at 1           |
        | 2 | -3      | max(-3, 1+(-3)) = max(-3, -2) | -2         | 1      | better to drop here    |
        | 3 | 4       | max(4, -2+4) = max(4, 2)      | 4          | 4      | new start at 4         |
        | 4 | -1      | max(-1, 4+(-1)) = max(-1, 3)  | 3          | 4      | extend \[4,-1]         |
        | 5 | 2       | max(2, 3+2) = max(2, 5)       | 5          | 5      | extend → \[4,-1,2]     |
        | 6 | 1       | max(1, 5+1) = max(1, 6)       | 6          | 6      | extend → \[4,-1,2,1] ✅ |
        | 7 | -5      | max(-5, 6+(-5)) = max(-5, 1)  | 1          | 6      | reset almost           |
        | 8 | 4       | max(4, 1+4) = max(4, 5)       | 5          | 6      | subarray \[4] at end   |
*/
