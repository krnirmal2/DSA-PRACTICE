package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import StandardProblemDSA.Utility;

public class ThreeColorSorting {
  public static int[] sortColors(int[] A) {// todo , remain two pointer
    int count = 0;
    int index = 0;
    int[] result = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      if (A[i] < 1) {
        result[count] = A[i];
        count++;
      }
    }
    for (int k = 0; k < A.length; k++) {
      if (A[k] == 1) {
        result[count] = A[k];
        count++;
      }
    }
    for (int j = 0; j < A.length; j++) {
      if (A[j] > 1) {
        result[count] = A[j];
        count++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] A = Utility.onlyThreeValueArray();
    A = sortColors(A);
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i]);
    }
  }


}
