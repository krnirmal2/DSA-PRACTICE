package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import java.util.Arrays;

public class Non_overlapping_intervals {
  /*Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
    you need to remove to make the rest of the intervals non-overlapping.
    Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
    Example 1:

    Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
    Output: 1
    Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
    Example 2:

    Input: intervals = [[1,2],[1,2],[1,2]]
    Output: 2
    Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
    Example 3:

    Input: intervals = [[1,2],[2,3]]
    Output: 0
    Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


    Constraints:

    1 <= intervals.length <= 105
    intervals[i].length == 2
    -5 * 104 <= starti < endi <= 5 * 10
    Approach:
      1. Sort intervals by end time (earliest finishing first).
      2. Keep track of the end of the last included interval (prevEnd).
      3. Iterate through intervals:
         - If current start < prevEnd → overlap → increment removal count.
         - Else → update prevEnd to current end.
      4. Return total removals.

  Pattern:
      - **Greedy Interval Scheduling** (minimize removals by keeping earliest finishing intervals).

  LeetCode:
      - LeetCode 435: Non-overlapping Intervals.

  Time Complexity:
      - O(n log n) due to sorting, O(n) for scanning.
  Space Complexity:
      - O(1) extra space.

  Follow-up:
      - Can also solve variant problems like counting max non-overlapping intervals
        (total intervals - removals).4*/
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) return 0;

    // Sort by end time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

    int count = 0;
    int prevEnd = intervals[0][1]; // First interval's end

    for (int i = 1; i < intervals.length; i++) {
      // Overlap: current start < previous end
      if (intervals[i][0] < prevEnd) {
        count++; // remove this interval
      } else {
        prevEnd = intervals[i][1]; // update last kept end
      }
    }

    return count;
  }
}
