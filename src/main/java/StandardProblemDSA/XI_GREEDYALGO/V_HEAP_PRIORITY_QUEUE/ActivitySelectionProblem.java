package StandardProblemDSA.XI_GREEDYALGO.V_HEAP_PRIORITY_QUEUE;

import StandardProblemDSA.XI_GREEDYALGO.GreedyAlgoUtil;
import StandardProblemDSA.XI_GREEDYALGO.StartEndPair;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ActivitySelectionProblem {
  // so it is a stand Greedy algo
  // independent subproblem give optimal solution of the whole problem
  // they are not overlap
  // either sort or heap can solve it or by both
  public static void main(String[] arg) {
    // given two array of start and finished time
    int[] start = {1, 3, 0, 5, 8, 5};
    int[] finish = {2, 4, 6, 7, 9, 9};

    // call the method to solve this
    // so if the array is given already sorted then we need
    // to compare only last finished time with new satrt time
    // start time is smaller than finished time
    activitySelection(start, finish);
  }

  private static void activitySelection(int[] start, int[] finish) {
    // so we need to sort the finished array time
    // and put them into priority queue for picking up based on the minimum finished time
    // lamda function shorthand of compartor for sorting based on end date in ascending order
    PriorityQueue<StartEndPair> pq = new PriorityQueue<>((a, b) -> a.end - b.end); // lamda funciton
    // now put them in the priority queue
    GreedyAlgoUtil.insertElementInPQAfterSort(start, finish, pq);

    // now we have to select the first element which is always a pick
    ArrayList<StartEndPair> activities = new ArrayList<>();
    StartEndPair activity = pq.poll();
    activities.add(activity);

    // now loop through the priority queue and check the
    // last finished time should smaller than the new start time
    // if yes take the
    while (!pq.isEmpty()) {

      StartEndPair nextActivity = pq.poll();
      if (activity.end <= nextActivity.start) {
        activities.add(nextActivity);
        activity = nextActivity;
      }
    }
  }

  /*You are given two arrays:
  start[i] → start time of the i-th activity
  finish[i] → finish time of the i-th activity
  Your task is to select the maximum number of activities that don’t overlap, i.e., for each selected activity, its start time must be after or equal to the finish time of the previously selected one.
  You may assume:
  One person can only perform one activity at a time.
  You must select as many non-overlapping activities as possible.
  ✨ Constraints
  1 ≤ start.length, finish.length ≤ 10⁵
  0 ≤ start[i] < finish[i] ≤ 10⁹

  🔍 Example
  start  = [1, 3, 0, 5, 8, 5]
  finish = [2, 4, 6, 7, 9, 9]*/
}
