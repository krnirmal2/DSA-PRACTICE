package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class KadansAlgorithm {

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>(List.of(2, -1, 3, 4, -5));
    System.out.println(maxiMumSubArraySum(a));
  }

  private static int maxiMumSubArraySum(ArrayList<Integer> a) {
    // Edge case: empty list
    if (a.isEmpty()) {
      return 0;
    }

    int current = a.get(0);
    int maxEndOfEachSubArray = a.get(0);
    int start = 0, end = 0, tempStart = 0;

    for (int i = 1; i < a.size(); i++) {
      // if current sum is negative then the current element then set the sum to that
      // element and from here the start of the array is on
      if (current + a.get(i) < a.get(i)) {
        current = a.get(i);
        tempStart = i; // New potential subarray start
      } else {
        // if no negative go on
        current += a.get(i);
      }
      // update the maximum value on each addition with current sum
      // also update the start and end also
      if (current > maxEndOfEachSubArray) {
        maxEndOfEachSubArray = current;
        start = tempStart;
        end = i;
      }
    }

    // Print the maximum subarray indices and elements
    System.out.println("Maximum Subarray Sum: " + maxEndOfEachSubArray);
    System.out.println("Subarray Indices: [" + start + " to " + end + "]");
    System.out.println("Subarray: " + a.subList(start, end + 1));

    return maxEndOfEachSubArray;
  }
}
