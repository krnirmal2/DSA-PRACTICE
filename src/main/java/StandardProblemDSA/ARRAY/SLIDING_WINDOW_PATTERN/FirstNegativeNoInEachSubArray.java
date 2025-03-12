package StandardProblemDSA.ARRAY.SLIDING_WINDOW_PATTERN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNoInEachSubArray {
    /*  public static List<Integer> firstNegativeBruteForce(int[] arr, int k) {
          List<Integer> result = new ArrayList<>();
          for (int i = 0; i <= arr.length - k; i++) {
              boolean found = false;
              for (int j = i; j < i + k; j++) {
                  if (arr[j] < 0) {
                      result.add(arr[j]);
                      found = true;
                      break;
                  }
              }
              if (!found) result.add(0);
          }
          return result;
      }*/
    public static List<Integer> firstNegativeInWindow(int[] Arr, int K) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> negatives = new LinkedList<>();
        while (j < Arr.length) {
            // Store negative numbers in queue
            if (Arr[j] < 0) {
                negatives.add(Arr[j]);
            }
            // Window size reached
            if (j - i + 1 == K) {
                // Get the first negative number
                if (!negatives.isEmpty()) {
                    result.add(negatives.peek());
                } else {
                    result.add(0); // If no negative found
                }
// Slide window: Remove Arr[i] from queue if it's negative
                if (!negatives.isEmpty() && negatives.peek() == Arr[i]) {
                    negatives.poll();
                }
                i++; // Shrink window from left
            }
            j++; // Expand window from right
        }
        return result;
    }

    public static void main(String[] args) {
        int[] Arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int K = 3;
        System.out.println(firstNegativeInWindow(Arr, K));
    }


}
