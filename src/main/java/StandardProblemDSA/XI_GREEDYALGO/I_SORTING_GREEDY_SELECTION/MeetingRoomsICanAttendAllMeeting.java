package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import StandardProblemDSA.XI_GREEDYALGO.GreedyAlgoUtil;
import StandardProblemDSA.XI_GREEDYALGO.StartEndPair;

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


  Pattern:
      - **Interval Scheduling** (Overlap Check).

  LeetCode Similar:
      - LeetCode 252: Meeting Rooms. done

  Time Complexity:
      - O(n log n): sorting dominates.
  Space Complexity:
      - O(1): in-place check after sorting.

  Follow-up:
      - If need to minimize number of meeting rooms → see "Meeting Rooms II" (LeetCode 253).
    */
  public boolean canAttendMeetings(StartEndPair[] intervals) {
    // Step 1: Sort intervals by start time
    GreedyAlgoUtil.sortByStartTimeArray(intervals);
    // Step 2: Check for any overlap
    for (int i = 1; i < intervals.length; i++) {
      // TIP:  check opposite of can't attened fi condition failed else return true
      if (intervals[i].start
          < intervals[i - 1]
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
