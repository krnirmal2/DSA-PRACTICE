package StandardProblemDSA.XI_GREEDYALGO.IV_INTERVAL_COVERING_AND_BURSTING;

import java.util.Arrays;

public class Non_overlapping_intervals {
  /*Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
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
  -5 * 104 <= starti < endi <= 5 * 104*/
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
