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
    if (a.isEmpty()) return 0;

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

  public static class LeastAverageSubarrayOfSizeB {
    //        private int findMinAvgSubarray(int arr[], int n, int k)
    //        {
    //
    //            // Initialize  beginning index of result
    //            int res_index = 0;
    //
    //            // Compute sum of first subarray of size k
    //            int curr_sum = 0;
    //            for (int i = 0; i < k; i++)
    //                curr_sum += arr[i];
    //
    //            // Initialize minimum sum as current sum
    //            int min_sum = curr_sum;
    //
    //            // Traverse from (k+1)'th element to n'th element
    //            for (int i = k; i < n; i++) {
    //                // Add current item and remove first item of
    //                // previous subarray
    //                curr_sum += arr[i] - arr[i - k];
    //
    //                // Update result if needed
    //                if (curr_sum < min_sum) {
    //                    min_sum = curr_sum;
    //                    res_index = (i - k + 1);
    //                }
    //            }
    //            return res_index;
    //        }

    public class Solution {
      public static int findMinAvgSubarray(int[] A, int B) {
        int i = 0, j = 0;
        int sum = 0;
        int leastavergae = Integer.MAX_VALUE;
        int temp = -1;
        // 3,7,90,20,10,50,40
        while (j < A.length) {
          sum = sum + A[j];
          if (j - i + 1 < B) {
            j++;
          } else if (j - i + 1 == B) {
            // float average = sum/B;
            // // leastavergae = Math.min(leastavergae, average);
            // if(leastavergae>=average){
            //     leastavergae= average;
            //     if(temp<i)
            //     {
            //         temp =j-B+1;
            //         }
            // }
            if (sum < leastavergae) {
              leastavergae = sum;
              if (temp < i) {
                temp = i;
              }
            }
            sum = sum - A[i];

            i++;
            j++;
          }
        }
        return temp;
      }

      public static void main(String[] args) {

        int[] arr = {3, 7, 90, 20, 10, 50, 40};
        int B = 3;
        //            for (int i = 0; i < n; i++) arr[i] = A[i];
        System.out.println(findMinAvgSubarray(arr, B));
      }
    }
  }
}
