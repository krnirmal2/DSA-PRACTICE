package StandardProblemDSA.XI_GREEDYALGO;

import StandardProblemDSA.XI_GREEDYALGO.XI_MERGE_INTERVAL_PATTERN.MergeInterval;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyAlgoUtil {

  /**
   * Sorts intervals by start time
   *
   * @param intervals Array of intervals to sort
   */
  public static void sortByStartTimeArray(MergeInterval[] intervals) {
    Arrays.sort(intervals, (a, b) -> a.start - b.start);
  }

  public static void sortByStartTimeList(List<MergeInterval> intervals) {
    Collections.sort(intervals, (a, b) -> a.start - b.start);
  }

  /**
   * Sorts intervals by end time
   *
   * @param intervals Array of intervals to sort
   */
  public static void sortByEndTime(MergeInterval[] intervals) {
    Arrays.sort(intervals, (a, b) -> a.end - b.end);
  }

  /**
   * Checks if two intervals overlap
   *
   * @param interval1 First interval
   * @param interval2 Second interval
   * @return true if intervals overlap, false otherwise
   */
  public static boolean isOverlapping(MergeInterval interval1, MergeInterval interval2) {
    return interval1.start <= interval2.end && interval2.start <= interval1.end;
  }

  /**
   * Creates a min heap priority queue for intervals sorted by end time
   *
   * @return Priority queue sorted by end time
   */
  public static PriorityQueue<MergeInterval> createEndTimeMinHeap() {
    return new PriorityQueue<>((a, b) -> a.end - b.end);
  }

  /**
   * Creates a min heap priority queue for intervals sorted by start time
   *
   * @return Priority queue sorted by start time
   */
  public static PriorityQueue<MergeInterval> createStartTimeMinHeap() {
    return new PriorityQueue<>((a, b) -> a.start - b.start);
  }

  /**
   * Merges two intervals if they overlap
   *
   * @param interval1 First interval
   * @param interval2 Second interval
   * @return Merged interval if they overlap, null otherwise
   */
  public static MergeInterval mergeIfOverlapping(MergeInterval interval1, MergeInterval interval2) {
    if (isOverlapping(interval1, interval2)) {
      return new MergeInterval(
          Math.min(interval1.start, interval2.start), Math.max(interval1.end, interval2.end));
    }
    return null;
  }

  /**
   * Finds the maximum number of overlapping intervals at any point
   *
   * @param intervals Array of intervals
   * @return Maximum number of overlapping intervals
   */
  public static int findMaxOverlappingIntervals(MergeInterval[] intervals) {
    PriorityQueue<Integer> endTimes = new PriorityQueue<>();
    sortByStartTimeArray(intervals);

    int maxRooms = 0;
    endTimes.add(intervals[0].end);

    for (int i = 1; i < intervals.length; i++) {
      while (!endTimes.isEmpty() && intervals[i].start >= endTimes.peek()) {
        endTimes.poll();
      }
      endTimes.add(intervals[i].end);
      maxRooms = Math.max(maxRooms, endTimes.size());
    }
    return maxRooms;
  }
}
