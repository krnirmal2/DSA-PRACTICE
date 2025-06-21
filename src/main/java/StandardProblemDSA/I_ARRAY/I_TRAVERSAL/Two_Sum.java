package StandardProblemDSA.I_ARRAY.I_TRAVERSAL;

import StandardProblemDSA.Utility;
import java.util.HashMap;

public class Two_Sum {
  // Find the minmum index of two sum if there is multiple
  public static int[] twoSum(int[] arr, int target) {

    // take an integer map for elemet and index
    HashMap<Integer, Integer> mp = new HashMap<>();
    // take a result array of size 2 for start and end indexes
    int[] result = new int[2];
    int minIndex = Utility.getMiniMumValue();
    for (int i = 0; i < Utility.getArrayLength(arr); i++) {
      // check if the target - current element present in map or not
      // if yes then put the start index =
      if (mp.containsKey(target - arr[i])) {
        // first element index as it is present in map with index
        result[0] = mp.get(target - arr[i]) + 1;
        result[1] = i + 1; // second element index
        //if we got the value then just break
        break;
      } else {
        if (!mp.containsKey(arr[i])) {
          minIndex = Math.min(minIndex, mp.get(arr[i]));
          mp.put(arr[i], i);
        }
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
