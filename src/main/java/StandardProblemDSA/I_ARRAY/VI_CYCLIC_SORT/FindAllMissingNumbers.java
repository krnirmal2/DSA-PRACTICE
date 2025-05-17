package StandardProblemDSA.I_ARRAY.VI_CYCLIC_SORT;

import StandardProblemDSA.Utility;

import java.util.ArrayList;
import java.util.List;


public class FindAllMissingNumbers {
  public static List<Integer> findMissingNumbers(int[] nums) {
    //cyclic sort
    Utility.cyclicSort(nums);

    // Find missing numbers
    List<Integer> missingNumbers = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        missingNumbers.add(i + 1);
      }
    }

    return missingNumbers;
  }

  public static void main(String[] args) {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1}; // Missing numbers = [5, 6]
    System.out.println("Missing Numbers: " + findMissingNumbers(nums));
    // Output: [5, 6]
  }
}
