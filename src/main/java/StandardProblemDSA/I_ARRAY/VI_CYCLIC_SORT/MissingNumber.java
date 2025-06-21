package StandardProblemDSA.I_ARRAY.VI_CYCLIC_SORT;

import StandardProblemDSA.Utility;

public class MissingNumber {
  public static int findMissingNumber(int[] nums) {
    Utility.cyclicSort(nums);
    // Check for the missing number
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return nums.length;
  }

  public static void main(String[] args) {
    int[] nums = {3, 0, 1};
    System.out.println(findMissingNumber(nums)); // Output: 2
  }
}
