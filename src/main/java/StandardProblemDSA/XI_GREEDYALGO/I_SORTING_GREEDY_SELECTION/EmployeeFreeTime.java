package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import StandardProblemDSA.XI_GREEDYALGO.GreedyAlgoUtil;
import StandardProblemDSA.XI_GREEDYALGO.XI_MERGE_INTERVAL_PATTERN.MergeInterval;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime {
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
  public List<MergeInterval> employeeFreeTime(List<List<MergeInterval>> schedule) {
    List<MergeInterval> allIntervals = new ArrayList<>();
    // Step1 : Combine all intervals from each employee.
    for (List<MergeInterval> employee : schedule) {
      allIntervals.addAll(employee);
    }
    // Step2 : Sort intervals by start time.
    GreedyAlgoUtil.sortByStartTimeList(allIntervals);

    // step 3:  Merge overlapping intervals.
    List<MergeInterval> merged = GreedyAlgoUtil.getMergeIntervals(allIntervals);

    // Step 4: Find gaps between merged intervals (these are free times).
    return GreedyAlgoUtil.getFreeTimeAfterMerged(merged);
  }

  /* Complexity:

      Time: O(n log n) due to sorting

      Space: O(n)

      Example:

      Input:

      lua
              Copy
      Edit
  [
          [[1,2], [5,6]],
          [[1,3]],
          [[4,10]]
          ]
      Output: [[3,4]]*/
}
