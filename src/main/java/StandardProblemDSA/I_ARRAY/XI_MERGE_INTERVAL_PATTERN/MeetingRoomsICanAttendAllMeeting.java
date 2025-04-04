package StandardProblemDSA.I_ARRAY.XI_MERGE_INTERVAL_PATTERN;

import java.util.Arrays;

public class MeetingRoomsICanAttendAllMeeting {
  /*   3. Meeting Rooms I (Checking Overlap)
      Problem Statement
      Given an array of meeting time intervals, determine if a person can attend all meetings (i.e., no overlapping intervals).

      Brute Force Approach
      Idea:
      Compare every pair of intervals to detect any overlap.

              Drawbacks:
      Inefficient with O(n²) comparisons.

      Optimal Approach
      Idea:
      Sort the intervals by start time and then check if any interval’s start time is less than the previous interval’s end time.

              Simplified Code (Java/Pseudo-code):
  */
  public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, (a, b) -> a.start - b.start);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < intervals[i - 1].end) {
        return false; // Overlap found.
      }
    }
    return true;
  }
  /*    Complexity:

  Time: O(n log n) (due to sorting)

  Space: O(1)

  Example:

  Input: [[0,30], [35,50]]

  Output: true*/
}
