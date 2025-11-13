package StandardProblemDSA.I_ARRAY.leetcode;

public class RemoveTargetedElementDuplicateWithoutSorted {

  public static int removeElement(int[] nums, int val) {
    /* Intuition:
    j: reads all elements.
    i: only writes when element is not equal to val.
    By end, all valid values are at front nums[0..i-1], rest doesn't matter.*/
    int i = 0; // write pointer
    int j = 0; // read pointer
    int n = nums.length;

    while (j < n) {
      if (nums[j]
          != val) { // when element at j is not equal to target value replace the ith with jth value
        nums[i] = nums[j];
        i++;
      }
      // if the element is at j is equal to target value then skip to next  , acting as
      j++;
    }
    return i;
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
    removeElement(arr, 2);
  }
}
