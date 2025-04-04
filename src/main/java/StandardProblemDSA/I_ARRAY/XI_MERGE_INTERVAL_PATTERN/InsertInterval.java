package StandardProblemDSA.I_ARRAY.XI_MERGE_INTERVAL_PATTERN;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
  /*  Problem Statement
      Given a sorted list of non-overlapping intervals and a new interval, insert the new interval into the list and merge if necessary.

      Brute Force Approach
      Idea:
      Insert the new interval into the correct position, then run a full merge on the resulting list.

              Drawbacks:
      May lead to unnecessary merging of non-overlapping intervals.

      Optimal Approach
      Idea:
      Traverse the intervals:

      Add all intervals that end before the new interval starts.

      Merge all overlapping intervals with the new interval.

      Add the remaining intervals.

      Simplified Code (Java/Pseudo-code):
  */
  public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<>();
    int i = 0, n = intervals.size();

    // Add all intervals ending before newInterval starts.
    while (i < n && intervals.get(i).end < newInterval.start) {
      result.add(intervals.get(i));
      i++;
    }

    // Merge overlapping intervals with newInterval.
    while (i < n && intervals.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }
    result.add(newInterval);

    // Add remaining intervals.
    while (i < n) {
      result.add(intervals.get(i));
      i++;
    }
    return result;
  }
  /* Complexity:

  Time: O(n)

  Space: O(n) for result list

  Example:

  Input:

  Intervals: [[1,3], [6,9]]

  New Interval: [2,5]

  Output: [[1,5], [6,9]]*/
}
