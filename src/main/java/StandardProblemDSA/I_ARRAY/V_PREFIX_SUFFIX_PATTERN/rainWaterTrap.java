package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

import StandardProblemDSA.Utility;
import java.util.ArrayList;
import java.util.List;

public class rainWaterTrap {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public static int trap(List<Integer> A) {
    int n = A.size();
    //            ArrayList<Integer> left_max = new
    // ArrayList<Integer>(Collections.nCopies(A.size(),0));
    //            ArrayList<Integer> right_max = new
    // ArrayList<Integer>(Collections.nCopies(A.size(),0));

    int[] left_max = new int[A.size()];
    int[] right_max = new int[A.size()];
    Utility.prefixMaxValues(A, left_max);
    Utility.suffixMaxValues(A, right_max, n);

    int totalUnitOfWater = 0;
    int left_closest_max, right_closest_max;
    // find the left and right max of the currenet element during iteration
    // so need to take min(left and right max)-currenet element and them up
    int min_of_left_right_max = 0;
    for (int k = 1; k < A.size() - 1; k++) {
      // so closest max of left and right
      left_closest_max = left_max[k - 1];
      right_closest_max = right_max[k + 1];
      //                left_closest_max = left_max.get(k - 1);
      //                right_closest_max = right_max.get(k + 1);

      min_of_left_right_max = Math.min(left_closest_max, right_closest_max) - A.get(k);

      totalUnitOfWater += min_of_left_right_max;
    }

    return totalUnitOfWater;
  }

  public static void main(String[] args) {
    //        ArrayList<Integer> a = new ArrayList<>(List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
    ArrayList<Integer> a = new ArrayList<>(List.of(4, 2, 5, 7, 4, 2, 3, 6, 8, 2, 3));
    //        a.add(3);
    //        a.add(1);
    //        a.add(0);
    //        a.add(2);
    //        a.add(-4);
    //        System.out.println(a.get(0));
    System.out.println(trap(a));
  }
}
