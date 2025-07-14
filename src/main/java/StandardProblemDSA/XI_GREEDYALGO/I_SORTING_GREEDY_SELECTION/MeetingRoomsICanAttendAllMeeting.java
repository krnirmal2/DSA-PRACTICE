package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import StandardProblemDSA.XI_GREEDYALGO.GreedyAlgoUtil;
import StandardProblemDSA.XI_GREEDYALGO.XI_MERGE_INTERVAL_PATTERN.MergeInterval;

public class MeetingRoomsICanAttendAllMeeting {
  /*   3. Meeting Rooms I (Checking Overlap)
      Problem Statement
      Given an array of meeting time intervals, determine if a person can attend all
       meetings (i.e., no overlapping intervals).

      Brute Force Approach
      Idea:
      Compare every pair of intervals to detect any overlap.

              Drawbacks:
      Inefficient with O(n²) comparisons.

      Optimal Approach
      Idea:
      Sort the intervals by start time and then check if any interval’s start time is
       less than the previous interval’s end time.

              Simplified Code (Java/Pseudo-code):
  */
  public boolean canAttendMeetings(MergeInterval[] intervals) {
    GreedyAlgoUtil.sortByStartTimeArray(intervals);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start
          > intervals[i - 1]
              .end) { // if a single meeting is overlap then it will not attend all the
        // meeting hence return false other wise all the meeting have gap time
        return false;
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
