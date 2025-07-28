package StandardProblemDSA.XI_GREEDYALGO.I_SORTING_GREEDY_SELECTION;

import StandardProblemDSA.XI_GREEDYALGO.TripletClass;

import java.util.PriorityQueue;

/*Tip : Pattern Recognition
You have tasks/jobs/events with time constraints (start/end/deadline).
You need to maximize something (profit, number of jobs, events) or minimize resources (machines, arrows).
Greedy choice works:
    Sort by deadline, end time, or profit.
    Assign jobs to the latest available slot.
    Use a priority queue or slot array to track free resources.*/
public class JobSequenceProblem {
  /* problem Statement: You are given a set of N jobs where each job comes with a deadline and profit.
   The profit can only be earned upon completing the job within its deadline.
   Find the number of jobs done and the maximum profit that can be obtained.
   Each job takes a single unit of time and only one job can be performed at a time.
  Example 1:
  Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
  Output: 2 60
  Explanation: The 3rd job with a deadline 1 is performed during the first unit of time .
  The 1st job is performed during the second unit of time as its deadline is 4.
  Profit = 40 + 20 = 60
  Example 2:
  Input: N = 5, Jobs = {(1,2,100),(2,1,19),(3,2,27),(4,1,25),(5,1,15)}
  Output: 2 127
  Explanation: The  first and third job both having a deadline 2 give the highest profit.
  Profit = 100 + 27 = 127*/
  public static int[] jobScheduling(TripletClass[] jobs) {

    // Idea : sort the element based on third parameter which profit
    // because each task will take 1 unit time even if its dead line given more than 1 one
    // means we can use any slot with in that maximum deadline to finished that task
    // so we have to focus on the profit as much we can do
    // and once a job take we are not gone a remove this means likely to greedy
    // and we also sort it with profit value
    // Step 1: Sort jobs by profit in descending order (highest profit first) by putting them in
    // Priortiy queue
    PriorityQueue<TripletClass> pq =
        new PriorityQueue<>((a, b) -> Integer.compare(b.third, a.third));
    for (int i = 0; i < jobs.length; i++) {
      pq.offer(new TripletClass(jobs[i].first, jobs[i].second, jobs[i].third));
    }
    // now we have to compare the element
    int count = 0;
    int profit = 0;
    int maxDeadline = 0;
    // Step 2: Find maximum deadline to know how many slots we need
    for (TripletClass job : jobs) {
      maxDeadline = Math.max(maxDeadline, job.second);
    }
    // Step 3: Create slot array (index 1..maxDeadline)
    // use for if free 1 unit of slots avaialble then we can put that job on that slots with max
    // profit
    boolean[] slots = new boolean[maxDeadline + 1]; // index 1 to maxDeadline
    // Step 4: Pick jobs greedily
    while (!pq.isEmpty()) {
      TripletClass job = pq.poll(); // Get most profitable job
      // if a slot means the deadline is take by any job then no other job can take that slot that
      // is why we put
      // true , after check and we put earliest slot last
      for (int i = job.second; i > 0; i--) { // Try to find a free slot before deadline
        if (!slots[i]) {
          slots[i] = true; // Mark slot as used
          count++;
          profit += job.third;
          break; // Move on to next job
        }
      }
    }
    return new int[] {count, profit};
  }

  public static void main(String[] args) {
    // Example 1:
    TripletClass[] jobs1 = {
      new TripletClass(1, 4, 20),
      new TripletClass(2, 1, 10),
      new TripletClass(3, 1, 40),
      new TripletClass(4, 1, 30)
    };

    int[] result1 = jobScheduling(jobs1);
    System.out.println("Max Jobs: " + result1[0] + ", Max Profit: " + result1[1]); // Output: 2 60

    // Example 2:
    TripletClass[] jobs2 = {
      new TripletClass(1, 2, 100),
      new TripletClass(2, 1, 19),
      new TripletClass(3, 2, 27),
      new TripletClass(4, 1, 25),
      new TripletClass(5, 1, 15)
    };

    int[] result2 = jobScheduling(jobs2);
    System.out.println("Max Jobs: " + result2[0] + ", Max Profit: " + result2[1]); // Output: 2 127
  }
}
