package StandardProblemDSA.XI_GREEDYALGO.XIII_SWEEP_LINE_PATTERN_IN_GREEDY;

import java.util.Arrays;

public class MinimumNoOfPlatformsRequiredRailway {
  /*Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the platform.
    We need to find the minimum number of platforms needed at the railway station so that no train has to wait.
    Examples 1:
    Input: N=6,
    arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00}
    dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}
    Output:3
    Explanation: There are at-most three trains at a time. The train at 11:00 arrived but the trains which had arrived at
     9:45 and 9:55 have still not departed.
     So, we need at least three platforms here.

  Pattern:
  - Two pointers + sorting:
    1) Sort arrival[] and departure[].
    2) Iterate arrival[], keep a running count of platforms in use.
    3) If next arrival < earliest departure → need new platform.
       Else → free a platform (departure passed).
    4) Track the max platforms required.

  LeetCode Similar:
  - LC 253 (Meeting Rooms II)

  Follow-up:
  - Can we do this without sorting both arrays? (Using priority queue?)
  - Handle real-world time formats (HH:MM → integer conversion).
  - Extend to include train IDs and schedule optimization.

  Time Complexity:
  - Sorting: O(n log n)
  - Traversal: O(n)
  - Total: O(n log n)
  - Space: O(1) extra.
     */
  /*
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
        // Step  1: sort both arrival and departure
        Arrays.sort(arr);
        Arrays.sort(dep);
        int result = 0;
        //  Step 2: Intialise two pointer  arrives and departure times
        int deptPointer = 0;
        int platformCount = 0; // tracks the no. of platforms needed at any given time
        for (int arrPointer = 0; arrPointer < n; arrPointer++) {
            // if arrival time > departure times , a no new platforms count-- , means freeing platform
            while (deptPointer < n && dep[deptPointer] < arr[arrPointer]) {
                platformCount--; // NOTE : we decrease the count if no extra platform required
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
  /*Here’s the dry run table for:

  n this problem, the arr[] and dep[] arrays represent arrival and departure times of trains, but not for the same index after sorting.
  Initially, arr[i] and dep[i] correspond to the same train.
  But we don’t need to preserve that relationship when finding the minimum number of platforms.
  Why?
      Because we only care about:
      When a train arrives and
      When a train departs,
  to figure out at any moment how many trains are at the station.
    arr = {900, 945, 955, 1100, 1500, 1800}
    dep = {920, 1200, 1130, 1150, 1900, 2000}
  After sorting separately:
  arr = {900, 945, 955, 1100, 1500, 1800}
  dep = {920, 1130, 1150, 1200, 1900, 2000}
  Now, apply the two-pointer method:
  | Step | i (arrival) | j (departure) | arr\[i] vs dep\[j] | Action             | Platforms in use | Max Platforms |
  | ---- | ----------- | ------------- | ------------------ | ------------------ | ---------------- | ------------- |
  | 1    | 0 (900)     | 0 (920)       | 900 ≤ 920          | Train arrives (+1) | 1                | 1             |
  | 2    | 1 (945)     | 0 (920)       | 945 > 920          | Train departs (-1) | 0                | 1             |
  | 3    | 1 (945)     | 1 (1130)      | 945 ≤ 1130         | Train arrives (+1) | 1                | 1             |
  | 4    | 2 (955)     | 1 (1130)      | 955 ≤ 1130         | Train arrives (+1) | 2                | 2             |
  | 5    | 3 (1100)    | 1 (1130)      | 1100 ≤ 1130        | Train arrives (+1) | 3                | 3             |
  | 6    | 4 (1500)    | 1 (1130)      | 1500 > 1130        | Train departs (-1) | 2                | 3             |
  | 7    | 4 (1500)    | 2 (1150)      | 1500 > 1150        | Train departs (-1) | 1                | 3             |
  | 8    | 4 (1500)    | 3 (1200)      | 1500 > 1200        | Train departs (-1) | 0                | 3             |
  | 9    | 4 (1500)    | 4 (1900)      | 1500 ≤ 1900        | Train arrives (+1) | 1                | 3             |
  | 10   | 5 (1800)    | 4 (1900)      | 1800 ≤ 1900        | Train arrives (+1) | 2                | 3             |
  **Result**: Maximum platforms needed = **3**
  ### Why does sorting separately work?
  Because we only need to know **when trains arrive and leave** in chronological order.
  We’re just sweeping through all events.
  The `arr[i]`–`dep[i]` pairing is irrelevant for counting overlap.

  ---

  */
}
