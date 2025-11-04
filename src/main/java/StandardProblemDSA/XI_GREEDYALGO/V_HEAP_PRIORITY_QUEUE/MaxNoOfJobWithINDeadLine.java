package StandardProblemDSA.XI_GREEDYALGO.V_HEAP_PRIORITY_QUEUE;

import StandardProblemDSA.XI_GREEDYALGO.TripletClass;
import java.util.*;

public class MaxNoOfJobWithINDeadLine {
  /*Problem Restatement
  We have a set of tasks, each with:
  Processing time p[i]
  Deadline d[i]
  We want to schedule tasks to minimize missed deadlines.
  Known Optimal Strategy (Greedy + Min-Priority Queue)
  The classical greedy approach is:
  Sort tasks by deadline (earliest deadline first).
  Use a min-priority queue (or max-heap depending on interpretation) to keep track of chosen tasks’ processing times.
  Iterate over tasks:
  Add the current task’s processing time to the queue.
  Keep a running sum of processing times.
  If at any point total_time > current_deadline, remove the longest processing time task from the queue (since dropping the biggest task frees the most time).
  This ensures we keep the largest possible set of tasks that can meet their deadlines.
  After processing all tasks, the queue contains the optimal set of tasks.
  Use a standard queue (FIFO) to actually execute tasks in Earliest Deadline First (EDF) order.
  Example*/

  public static List<TripletClass> scheduleTasks(List<TripletClass> tasks) {
    // we have to sort the triplet class based on dead line
    // that is third parameter , deadline
    tasks.sort(Comparator.comparingInt(x -> x.third));
    // now use priority quque for remove the highest procesing time first
    PriorityQueue<TripletClass> pq = new PriorityQueue<>((a, b) -> (b.second) - a.second);

    /// now iterate over the task and try to find max no of job can be fit
    // with in this time
    int totaltime = 0;
    for (TripletClass task : tasks) {
      totaltime += task.second;
      pq.offer(task);

      // step 2 : if deadline viioltated remove the longest task
      if (totaltime > task.third) {
        TripletClass removed = pq.poll();
        totaltime -= removed.second;
      }
    }
    // Step 3: collect chosen tasks in edf deadline order
    List<TripletClass> choosen = new ArrayList<>(pq);
    choosen.sort(Comparator.comparingInt(x -> x.third));
    return choosen;
  }

  public static void main(String[] args) {
    List<TripletClass> TripletClasss =
        Arrays.asList(
            new TripletClass(1, 3, 4),
            new TripletClass(2, 2, 5),
            new TripletClass(3, 1, 7),
            new TripletClass(4, 2, 3));

    List<TripletClass> result = scheduleTasks(TripletClasss);

    System.out.println("\nFinal Schedule (EDF order):");
    for (TripletClass task : result) {
      System.out.println(task.first);
    }
  }
}
