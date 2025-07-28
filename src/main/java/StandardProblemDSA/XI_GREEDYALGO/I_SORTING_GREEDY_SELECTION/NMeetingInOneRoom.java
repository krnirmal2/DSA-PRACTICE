package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import StandardProblemDSA.XI_GREEDYALGO.TripletClass;

import java.util.ArrayList;
import java.util.List;

public class NMeetingInOneRoom {
  /*N meetings in one room
    Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’,
    start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting.
     Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time.
      Print the order in which these meetings will be performed.
    Example:
    Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
    Output: 1 2 4 5
    Explanation: See the figure for a better understanding.
    Approach:
      1. Create (start, end, index) triplets.
      2. Sort by end time (earliest finish first → greedy choice).
      3. Iterate through sorted meetings, picking a meeting only if its start > last selected meeting's end.
      4. Collect indices of all selected meetings.

  Pattern:
      - **Greedy Interval Scheduling** (select earliest finishing meetings).

  LeetCode Similar:
      - LeetCode 435: Non-overlapping Intervals.
      - LeetCode 452: Minimum Number of Arrows to Burst Balloons.

  Time Complexity:
      - O(n log n) for sorting + O(n) selection.
  Space Complexity:
      - O(n) for storing triplets and result.

  Follow-up:
      - To handle meeting rooms with multiple capacities, see "Meeting Rooms II" (LeetCode 253).
  */
  /*❌ Your Steps (What needs fixing):
  Your step:
          1. Sort by start time → ❌ Not optimal
  Why wrong?
  We should sort by end time, not start time. This ensures:
  We always pick the meeting that finishes earliest, freeing up the room for the next.
  Correct Greedy Rule:
  Always pick the meeting with the earliest end time that doesn’t overlap.*/
  /*  Step 1: Pair all meetings with (start, end, index)
  Step 2: Sort the meetings by end time
  Step 3: Pick meetings one by one, only if they don’t overlap with the previous*/

  public static void main(String[] args) {
    int[] start = {1, 3, 0, 5, 8, 5};
    int[] end = {2, 4, 5, 7, 9, 9};

    List<Integer> result = maxMeetings(start, end);
    System.out.println("Meetings to attend: " + result); // Output: [1, 2, 4, 5]
  }

  /*| Operation | Complexity                |
  | --------- | ------------------------- |
  | Sorting   | O(n log n)                |
  | Selection | O(n)                      |
  | Total     | **O(n log n)**            |
  | Space     | O(n) for list of meetings |*/

  private static List<Integer> maxMeetings(int[] start, int[] end) {
    List<TripletClass> meetingWithIndex = new ArrayList<>();

    // create the triple class
    for (int i = 0; i < start.length; i++) {
      meetingWithIndex.add(new TripletClass(start[i], end[i], i + 1));
    }

    // sort the triplet class based on ending time
    meetingWithIndex.sort(
        (a, b) -> {
          if (a.second != b.second) return a.second - b.second;
          return a.third - b.third; // tie-break by index (optional)
        });

    List<Integer> result = new ArrayList<>();
    int lastEnd = -1;
    for (TripletClass m : meetingWithIndex) {
      if (m.first > lastEnd) {
        result.add(m.third);
        lastEnd = m.second;
      }
    }

    return result;
  }
}
