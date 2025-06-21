package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import StandardProblemDSA.Utility;
import java.util.HashMap;
import java.util.HashSet;

public class commonElementofTwoArray {
  /*Given two integer arrays A and B, return an array that represents their intersection,
   where each element in the result should appear as many times as it shows in both arrays
    (i.e., the minimum frequency of the element in both arrays).
You may return the result in any order.*/
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
    HashSet<Integer> visited = new HashSet<>(); // use proper visited
    Utility.countFrequencyEachElement(A, mapA);
    Utility.countFrequencyEachElement(B, mapB);

    // iterate over each element of the A
    for (int i = 0; i < A.length; i++) {
      //Check if it's already been handled (you use a visited map, but it's not fully necessary since frequency maps are enough).
      int current = A[i];
      if (visited.contains(current)) continue; // skip already added elements

      visited.add(current);
      if (mapB.containsKey(current)) {
        //If the element exists in both maps:
        //Get its min frequency in both arrays.
        //Add it that many times to result[].
        int minFreq = Math.min(mapA.get(current), mapB.get(current));
        for (int c = 0; c < minFreq && index < sizeOfResultArrray; c++) {
          result[index++] = current;
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
      System.out.println(result[i]);
    }
  }
}
