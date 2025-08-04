package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import StandardProblemDSA.XI_GREEDYALGO.GreedyAlgoUtil;
import StandardProblemDSA.XI_GREEDYALGO.StartEndPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFreeTime {
  /*
  Problem:
      Given multiple employees' work schedules (lists of non-overlapping intervals),
      find the common free time intervals across all employees.

  Approach:
      1. Combine all employees' intervals into one list.
      2. Sort intervals by start time.
      3. Merge overlapping intervals to get overall busy times.
      4. Identify gaps between merged intervals → these are free times.

  Pattern:
      - **Merge Intervals** + **Gap Finding**.

  LeetCode Similar:
      - LeetCode 759: Employee Free Time.

  Time Complexity:
      - O(n log n): n = total intervals across all employees (sorting dominates).
  Space Complexity:
      - O(n): to store all intervals and merged intervals.

  Follow-up:
      - Can use a min-heap (priority queue) for streaming data.
      - Extend to handle dynamic schedules or online updates.
  */

  /*   Employee Free Time (Finding Gaps Between Merged Intervals)
      Problem Statement
      Given a list of employees’ schedules (each schedule is a list of non-overlapping intervals)
      , return the common free time intervals across all employees.

      Brute Force Approach
      Idea:
      Merge all intervals from every employee and then look for gaps between the merged intervals.

              Drawbacks:
      Direct merging may become inefficient if not properly organized.

              Optimal Approach
      Idea:
      Combine all intervals, sort by start time, merge them, and then
      identify gaps between consecutive merged intervals.

      Simplified Code (Java/Pseudo-code):
  */
  public static List<StartEndPair> employeeFreeTime(List<List<StartEndPair>> schedule) {
    List<StartEndPair> allIntervals = new ArrayList<>();
    // Step 1 : Combine all intervals from each employee.
    for (List<StartEndPair> employee : schedule) {
      allIntervals.addAll(employee);
    }
    // Step2 : Sort intervals by start time.
    GreedyAlgoUtil.sortByStartTimeList(allIntervals);

    // step 3:  Merge overlapping intervals.
    List<StartEndPair> mergedInteralList = GreedyAlgoUtil.getMergeIntervals(allIntervals);

    // Step 4: Find gaps between merged intervals (these are free times).
    return GreedyAlgoUtil.getFreeTimeAfterMerged(mergedInteralList);
  }

  public static void main(String[] args) {
    // Create schedule for multiple employees
    List<List<StartEndPair>> schedule = new ArrayList<>();
    schedule.add(Arrays.asList(new StartEndPair(1, 2), new StartEndPair(5, 6)));
    schedule.add(List.of(new StartEndPair(1, 3)));
    schedule.add(List.of(new StartEndPair(4, 10)));

    // Find free time
    List<StartEndPair> freeTime = employeeFreeTime(schedule);
    freeTime.forEach(
            item -> {
                System.out.println(item.start);
                System.out.println(item.end);
            });

    //    System.out.println("Free time intervals: " + ); // Expected Output: [[3,4]
  }
  /* Complexity:
      Time: O(n log n) due to sorting
      Space: O(n)
      Example:
      Input:
  [
          [[1,2], [5,6]],
          [[1,3]],
          [[4,10]]
          ]
      Output: [[3,4]]*/
}
