package StandardProblemDSA.XI_GREEDYALGO.XI_MERGE_INTERVAL_PATTERN;

import StandardProblemDSA.XI_GREEDYALGO.StartEndPair;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
  /*   Statement
        Given a sorted list of non-overlapping intervals and a new interval,
        insert the new interval into the list and merge if necessary.

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

        Pattern:
  - Interval merging
  - Greedy scan + merge overlapping

  Follow-up:
  - How to handle unsorted intervals? (Need sort by start time first — O(n log n))
  - Can it be done in-place to save space?

  Time Complexity:
  - O(n) time (single pass through intervals)
  - O(n) space for output list
    */
  public List<StartEndPair> insertInterval(List<StartEndPair> intervals, StartEndPair newInterval) {
    List<StartEndPair> result = new ArrayList<>();
    int i = 0, n = intervals.size();

    // Step1 :Add all intervals ending before newInterval starts.
    while (i < n && intervals.get(i).end < newInterval.start) {
      result.add(intervals.get(i));
      i++;
    }

    // Step 2:  Merge overlapping intervals with newInterval.
    while (i < n && intervals.get(i).start <= newInterval.end) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
      i++;
    }
    result.add(newInterval);

    // Step 3: Add remaining intervals.
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
