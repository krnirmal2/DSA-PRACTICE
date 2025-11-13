package StandardProblemDSA.XI_GREEDYALGO.V_HEAP_PRIORITY_QUEUE;

import StandardProblemDSA.XI_GREEDYALGO.GreedyAlgoUtil;
import StandardProblemDSA.XI_GREEDYALGO.StartEndPair;

public class MeetingRoomIIMinimumMeetingRoomsRequired {
  /* Meeting Rooms II (Tracking Multiple Overlaps with Min-Heap)
      Problem Statement
      Given an array of meeting time intervals, determine the minimum number of meeting rooms
      required to hold all meetings simultaneously.
         Input: [[0,30], [5,10], [15,20]]
          Output: 2
              Brute Force Approach
      Idea:
      Check every possible overlap by comparing each interval with all others.
              Drawbacks:
      O(n²) time complexity.

      Optimal Approach
      Idea:
      Use two arrays (or a min-heap) for tracking start and end times:
      Sort start times and end times.
      Use two pointers (or a min-heap) to track how many meetings overlap.
      Simplified Code (Java/Pseudo-code using Min-Heap):
  */
  public int minMeetingRooms(StartEndPair[] intervals) {
    /*   // Sort intervals by start time.
    Arrays.sort(intervals, (a, b) -> a.start - b.start);

    // Min-heap to track end times of ongoing meetings.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.add(intervals[0].end);

    for (int i = 1; i < intervals.length; i++) {
      // If the room due to free up the earliest is free before the next meeting starts.
      if (intervals[i].start >= minHeap.peek()) {
        minHeap.poll(); // Reuse the room.
      }
      // Allocate a new room.
      minHeap.add(intervals[i].end);
    }
    return minHeap.size();*/

    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    return GreedyAlgoUtil.findMaxOverlappingIntervals(intervals);
  }
  /* Complexity:

   Time: O(n log n) (sorting and heap operations)

   Space: O(n)

   Example:

  */
}
