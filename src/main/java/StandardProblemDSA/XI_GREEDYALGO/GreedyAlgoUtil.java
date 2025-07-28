package StandardProblemDSA.XI_GREEDYALGO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyAlgoUtil {

  /**
   * Sorts intervals by start time
   *
   * @param intervals Array of intervals to sort
   */
  public static void sortByStartTimeArray(StartEndPair[] intervals) {
    Arrays.sort(intervals, (a, b) -> a.start - b.start);
  }

  public static void sortByStartTimeList(List<StartEndPair> intervals) {
    intervals.sort((a, b) -> a.start - b.start);
  }

  /**
   * Sorts intervals by end time
   *
   * @param intervals Array of intervals to sort
   */
  public static void sortByEndTime(StartEndPair[] intervals) {
    Arrays.sort(intervals, (a, b) -> a.end - b.end);
  }

  /**
   * Checks if two intervals overlap
   *
   * @param interval1 First interval
   * @param interval2 Second interval
   * @return true if intervals overlap, false otherwise
   */
  public static boolean isOverlapping(StartEndPair interval1, StartEndPair interval2) {
    return interval1.start <= interval2.end && interval2.start <= interval1.end;
  }

  /**
   * Creates a min heap priority queue for intervals sorted by end time
   *
   * @return Priority queue sorted by end time
   */
  public static PriorityQueue<StartEndPair> createEndTimeMinHeap() {
    return new PriorityQueue<>((a, b) -> a.end - b.end);
  }

  /**
   * Creates a min heap priority queue for intervals sorted by start time
   *
   * @return Priority queue sorted by start time
   */
  public static PriorityQueue<StartEndPair> createStartTimeMinHeap() {
    return new PriorityQueue<>((a, b) -> a.start - b.start);
  }

  /**
   * Merges two intervals if they overlap
   *
   * @param interval1 First interval
   * @param interval2 Second interval
   * @return Merged interval if they overlap, null otherwise
   */
  public static StartEndPair mergeIfOverlapping(StartEndPair interval1, StartEndPair interval2) {
    if (isOverlapping(interval1, interval2)) {
      return new StartEndPair(
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
  public static int findMaxOverlappingIntervals(StartEndPair[] intervals) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    sortByStartTimeArray(intervals);

    int maxRooms = 0;
    pq.add(intervals[0].end);

    for (int i = 1; i < intervals.length; i++) {
      while (!pq.isEmpty() && intervals[i].start >= pq.peek()) {
        pq.poll();
      }
      pq.add(intervals[i].end);
      maxRooms = Math.max(maxRooms, pq.size());
    }
    return maxRooms;
  }

  public static List<StartEndPair> getMergeIntervals(List<StartEndPair> allIntervals) {
    // Step 1: create a List of Start and pair for store result , here merged interval
    List<StartEndPair> mergedIntervalList = new ArrayList<>();
    // step 2 : first pair will be the at zeroth index
    StartEndPair previousInterval = allIntervals.get(0);
    // Step 3 : iterate over each interval from 2nd interval
    for (int i = 1; i < allIntervals.size(); i++) {
      StartEndPair currentInterval = allIntervals.get(i);
      // Step 4 : check if the current interval start is less then the previous interval end
      // then we will set the previous end to the max of currrent and previous end for mergeing
      if (previousInterval.end >= currentInterval.start) {
        previousInterval.end = Math.max(previousInterval.end, currentInterval.end);
      } else {
        // Step 5 : else we will just pick the interval and update the prvious with the current
        // interval
        mergedIntervalList.add(previousInterval);
        previousInterval = currentInterval;
      }
    }
    // if only one then return the by adding the current interval
    mergedIntervalList.add(previousInterval);
    return mergedIntervalList;
  }

  public static List<StartEndPair> getFreeTimeAfterMerged(List<StartEndPair> mergedInteralList) {
    List<StartEndPair> freeTimes = new ArrayList<>();
    for (int i = 1; i < mergedInteralList.size(); i++) {
      freeTimes.add(
              new StartEndPair(mergedInteralList.get(i - 1).end, mergedInteralList.get(i).start));
    }
    return freeTimes;
  }

  public static boolean isFreeTimeAvailable(StartEndPair[] intervals) {
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < intervals[i - 1].end) {
        return false;
      }
    }
    return true;
  }

  public static void insertElementInPQAfterSort(
      int[] start, int[] finish, PriorityQueue<StartEndPair> pq) {
    for (int i = 0; i < start.length; i++) {
      pq.add(new StartEndPair(start[i], finish[i]));
    }
  }
}
