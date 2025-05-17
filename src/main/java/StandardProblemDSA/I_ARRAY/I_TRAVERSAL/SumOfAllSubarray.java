package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import StandardProblemDSA.Utility;

public class SumOfAllSubarray {

  public static long subarraySum(int[] A) {
    return Utility.getTotalSubArraySumOfArray(A);
  }


  // time o(n*n) space = o(1)
  public static void main(String[] args) {
    int[] A = {1, 2, 3};
    System.out.println(subarraySum(A));
  }
}
