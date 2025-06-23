package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import StandardProblemDSA.Utility;
import java.util.HashMap;

public class Two_Sum_MinimumIndex {
  // Find the minmum index of two sum if there is multiple
  public static int[] twoSum(int[] arr, int target) {

    HashMap<Integer, Integer> mp = new HashMap<>();
    int[] result = {-1, -1};
    int minSecondIndex = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      int complement = target - arr[i];
      if (mp.containsKey(complement)) {
        int firstIndex = mp.get(complement);
        // check if this pair is better (based on second index, or first if tie)
        if (i < minSecondIndex || (i == minSecondIndex && firstIndex < result[0])) {
          result[0] = firstIndex + 1; // +1 for 1-based index
          result[1] = i + 1;
          minSecondIndex = i;
        }
      }

      // Only store the first occurrence of each number
      if (!mp.containsKey(arr[i])) {
        mp.put(arr[i], i);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = Utility.arrayWithPosiNegativeValue();
    int[] k = twoSum(a, -3);
    for (int i = 0; i < 2; i++) System.out.println(k[i]);
  }
}
