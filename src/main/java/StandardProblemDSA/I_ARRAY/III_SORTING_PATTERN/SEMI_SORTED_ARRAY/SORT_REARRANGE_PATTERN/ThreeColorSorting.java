package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import StandardProblemDSA.I_ARRAY.ArrayUtility;
import StandardProblemDSA.Utility;

public class ThreeColorSorting {
 /* public static int[] sortColors(int[] A) {
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
*/  // todo , remain two pointer
 public static int[] sortColors(int[] A) {
   int low = 0, mid = 0, high = A.length - 1;

   // steps 1. while mid doesn't reached to high
     // we will check
     // if element at mid is equal to zero , swap low with mid and increase both
     // if element at mid is equal to one , just increase mid
     // if element at mid is 2 , swap mid with high and just decrease high
   while (mid <= high) {
     if (A[mid] == 0) {
       ArrayUtility.swap(A, low, mid);
       low++;
       mid++;
     } else if (A[mid] == 1) {
       mid++;
     } else { // A[mid] == 2
       ArrayUtility.swap(A, mid, high);
       high--;
     }
   }
   return A;
 }

  public static void main(String[] args) {
    int[] A = Utility.onlyThreeValueArray();
    A= new int[]{0, 1, 1, 0, 0, 2, 1, 0};
    A = sortColors(A);
    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i]);
    }
  }
}
