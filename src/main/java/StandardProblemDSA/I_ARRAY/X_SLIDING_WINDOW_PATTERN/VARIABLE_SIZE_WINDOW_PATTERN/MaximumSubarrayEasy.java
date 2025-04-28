package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarrayEasy {
  /*Question: Maximum Subarray Sum (with a Twist)
  You are given an array of positive integers C of size A. You are also given an integer B.
  Your task is to find the maximum possible sum of a contiguous subarray within C such that
   this sum is less than or equal to B.
  Constraints:
  1 <= A <= 10^5 (Size of the array C)
  1 <= B <= 10^9
  1 <= C[i] <= 10^3 for each element in C
  Example:
  A = 5
  B = 12
  C = [2, 1, 3, 4, 5]*/
  public static int maxSubarray(int B, ArrayList<Integer> C) {
    int i = 0, j = 0, sum = 0, max = 0;
    while (j < C.size()) {
      if (sum + C.get(j) <= B) {
        // safe to include C[j]
        sum += C.get(j);
        max = Math.max(max, sum);
        j++;
      } else if (i < j) {
        // shrink from left until it fits
        sum -= C.get(i);
        i++;
      } else {
        // i == j and C[j] alone > B: skip this element
        i++;
        j++;
        sum = 0;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<>(List.of(2, 1, 3, 4, 5));
    maxSubarray(12, a);
  }
}
