package StandardProblemDSA.I_ARRAY.VI_CYCLIC_SORT;

import StandardProblemDSA.Utility;
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
  public static List<Integer> findDuplicates(int[] nums) {
    List<Integer> duplicates = new ArrayList<>();
    // cyclic sort
    Utility.cyclicSort(nums);
    // Identify duplicate numbers
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        duplicates.add(nums[i]);
      }
    }

    return duplicates;
  }

  public static void main(String[] args) {
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1}; // Duplicate numbers: 2, 3
    System.out.println("Duplicate Numbers: " + findDuplicates(nums));
    // Output: [2, 3]
  }
}
