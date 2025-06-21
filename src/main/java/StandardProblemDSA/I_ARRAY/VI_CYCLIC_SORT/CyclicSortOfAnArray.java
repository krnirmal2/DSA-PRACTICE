package StandardProblemDSA.I_ARRAY.VI_CYCLIC_SORT;

import StandardProblemDSA.Utility;
import java.util.Arrays;

public class CyclicSortOfAnArray {

  public static void main(String[] args) {
    int[] nums = {3, 5, 2, 1, 4};
    Utility.cyclicSort(nums);
    System.out.println(Arrays.toString(nums)); // Output: [1, 2, 3, 4, 5]
  }
}
