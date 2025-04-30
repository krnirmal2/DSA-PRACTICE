package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import StandardProblemDSA.Utility;

public class MaxAndMinOfAnArray {
  public int[] minMaxOfarray(int[] A) {
    int[] result = new int[2];
    result[0] = Utility.maxOfArray(A);
    result[1] = Utility.minOfArray(A);
    return result;
  }
}
