package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import java.util.Arrays;

public class MinimumNoOfPlatformsRequiredRailway {
  /*Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the platform.
  We need to find the minimum number of platforms needed at the railway station so that no train has to wait.
  Examples 1:
  Input: N=6,
  arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00}
  dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}
  Output:3
  Explanation: There are at-most three trains at a time. The train at 11:00 arrived but the trains which had arrived at 9:45 and 9:55 have still not departed.
   So, we need at least three platforms here.

   Steps 1: sort both arrival and departure
   Steps 2: Intialise two pointer
            -- one for arrival i
            -- one for depart j
    Steps 3: iterate though the arrival
          -- if arrival time > departure times , a no new platforms count-- , means freeing platform
          -- else there is new platform have to add means count++;
         update the maximum no. of platforms required after each step
         continue this process untill all trainse are processed

   */

  private static int minPlatform(int[] arr, int[] dep) {
    int n = arr.length;
    // sort te arrays
    Arrays.sort(arr);
    Arrays.sort(dep);
    int result = 0;
    // pointer arrives and departure times
    int deptPointer = 0;
    // tracks the no. of platforms needed at any given time
    int platformCount = 0;
    for (int arrPointer = 0; arrPointer < n; arrPointer++) {
      // check the condition
      while (deptPointer < n && dep[deptPointer] < arr[arrPointer]) {
        platformCount--;
        deptPointer++;
      }
      // one platform for current train
      platformCount++;
      result = Math.max(result, platformCount);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = {900, 940, 950, 1100, 1500, 1800};
    int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
    System.out.println(minPlatform(arr, dep));
  }
}
