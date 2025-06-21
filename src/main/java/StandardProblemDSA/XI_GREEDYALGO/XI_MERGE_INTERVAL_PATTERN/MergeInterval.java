package StandardProblemDSA.XI_GREEDYALGO.XI_MERGE_INTERVAL_PATTERN;

import StandardProblemDSA.XI_GREEDYALGO.GreedyAlgoUtil;
import java.util.Collections;
import java.util.List;

public class MergeInterval {
  public int start;
  public int end;

  MergeInterval() {
    start = 0;
    end = 0;
  }

  public MergeInterval(int s, int e) {
    start = s;
    end = e;
  }

  /* 1. Merge Overlapping Intervals (Core Concept)
   Problem Statement
   Given a list of intervals, merge all overlapping intervals and return a list of non-overlapping intervals covering all the intervals in the input.

   Brute Force Approach
   Idea:
   Check every pair of intervals to see if they overlap and then merge them repeatedly until no overlaps remain.
           Drawbacks:
   Inefficient due to repeated comparisons and merging.

           Optimal Approach
   Idea:
   First, sort the intervals by their start times. Then, iterate through the list and merge intervals that overlap.

  */
  public List<MergeInterval> mergeIntervals(List<MergeInterval> intervals) {
    if (intervals.size() <= 1) {
      return intervals;
    }
    // Step1:  Sort intervals by start time so that easily get compare
    Collections.sort(intervals, (a, b) -> a.start - b.start);
    // use extra space for return the merge Intervale
    /*   List<MergeInterval> merged = new ArrayList<>();
    // start from the first element of list of interval
    MergeInterval current = intervals.get(0);
    //Step2; iterate over the intervals and compare end time with start time
    // if end time of current is greater then we merged
    // else add that interval directly and goto next interval , which
    //just next to it
    for (int i = 1; i < intervals.size(); i++) { // start from 2nd node
      MergeInterval next = intervals.get(i);
      if (current.end >= next.start) {
        // Merge overlapping intervals
        current.end = Math.max(current.end, next.end);
      } else {
        merged.add(current);
        current = next;
      }
    }
    merged.add(current);*/
    return GreedyAlgoUtil.getFreeTimeAfterMerged(intervals);
  }
  /* Complexity:

  Time: O(n log n) due to sorting

  Space: O(n) for the merged list

  Example:

  Input: [[1,3], [2,6], [8,10], [15,18]]

  Output: [[1,6], [8,10], [15,18]]*/
}
/*     this problem has a lot of corner cases that need to be handled correctly.

        Let us first talk about the approach.
        Given all the intervals, you need to figure out the sequence of intervals that intersect with the given new interval.

        Lets see how we check if interval 1 (a,b) intersects with interval 2 (c,d):

        Overlap case :

        a---------------------b                      OR       a------b
        c-------------------d                c------------------d
        Non-overlap case:

        a--------------------b   c------------------d
        Note that if max(a,c) > min(b,d), then the intervals do not overlap. Otherwise, they overlap.

        Once we figure out the intervals ( interval[i] to the interval[j] ) which overlap with the new interval, note that we can replace all the overlapping intervals with one interval, which would be

        (min(interval[i].start, newInterval.start), max(interval[j].end, newInterval.end)).

        Do make sure you cover the other corner cases.


Have you covered the following corner cases :

1) Size of interval array as 0.

2) newInterval being an interval preceding all intervals in the array.

    Given interval (3,6),(8,10), insert and merge (1,2)
3) newInterval being an interval succeeding all intervals in the array.

    Given interval (1,2), (3,6), insert and merge (8,10)
4) newInterval not overlapping with any interval and falling in between 2 intervals in the array.

    Given interval (1,2), (8,10) insert and merge (3,6)
5) newInterval covering all given intervals.

    Given interval (3, 5), (7, 9) insert and merge (1, 10)



        */
