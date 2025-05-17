package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import StandardProblemDSA.Utility;

import java.util.HashMap;

public class commonElementofTwoArray {
  public static int[] solve(int[] A, int[] B) {
    int sizeOfResultArrray = Math.min(A.length, B.length);
    int[] result = Utility.createNewArrayOfSizeN(sizeOfResultArrray);

    int index = 0;
    int count = 0;
    // create two hashmap of A and B
    // we used map because we can't use hash set as the
    // array contain duplicate on this time hashset will failed
    HashMap<Integer, Integer> mapA = new HashMap();
    HashMap<Integer, Integer> mapB = new HashMap();
    HashMap<Integer, Boolean> visited = new HashMap();

    Utility.countFrequencyEachElement(A, mapA);
    Utility.countFrequencyEachElement(B, mapB);

    // iterate over each element of the A
    for (int i = 0; i < A.length; i++) {
      // if the element at i of A is presnt in map
      if (mapA.containsKey(A[i])) {
        // make that element as visited
        visited.put(A[i], true);
        // if same element also present in B;s mamp
        if (mapB.containsKey(A[i]) && index < sizeOfResultArrray) {
          if (mapA.get(A[i]) < mapB.get(A[i])) {
            count = 0;
            while (count < mapA.get(A[i])) {
              result[index] = A[i];
              index++;
              count++;
            }
          } else {
            count = 0;
            while (count < mapB.get(A[i]) && index < sizeOfResultArrray) {
              result[index] = A[i];
              index++;
              count++;
            }
          }
        }
      }
    }
    return result;
  }




  public static void main(String[] args) {
    int[] A = {1, 2, 2, 1};
    int[] B = {2, 3, 1, 2};
    int[] result = solve(A, B);

    for (int i = 0; i < result.length; i++) {
      System.out.println(A[i]);
    }
  }
}
