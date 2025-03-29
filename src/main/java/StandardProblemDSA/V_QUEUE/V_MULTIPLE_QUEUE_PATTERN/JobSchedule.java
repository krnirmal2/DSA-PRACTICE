package StandardProblemDSA.V_QUEUE.V_MULTIPLE_QUEUE_PATTERN;

/*

3️⃣ Multi-Queue Job Scheduling
        🔹 Problem Statement
        Simulate job scheduling where:

        Jobs are assigned based on type (CPU-bound, I/O-bound).

        Each type has its own queue.
*/

import java.util.LinkedList;
import java.util.Queue;

class JobScheduler {
  private Queue<String> cpuBoundQueue = new LinkedList<>();
  private Queue<String> ioBoundQueue = new LinkedList<>();

  // ✅ Add job to correct queue
  public void addJob(String job, String type) {
    if (type.equalsIgnoreCase("cpu")) {
      cpuBoundQueue.add(job);
    } else if (type.equalsIgnoreCase("io")) {
      ioBoundQueue.add(job);
    }
  }

  // ✅ Process CPU and I/O jobs
  public void processJobs() {
    while (!cpuBoundQueue.isEmpty() || !ioBoundQueue.isEmpty()) {
      if (!cpuBoundQueue.isEmpty())
        System.out.println("Executing CPU Job: " + cpuBoundQueue.poll());
      if (!ioBoundQueue.isEmpty()) System.out.println("Executing I/O Job: " + ioBoundQueue.poll());
    }
  }

  public static void main(String[] args) {
    JobScheduler scheduler = new JobScheduler();
    scheduler.addJob("Image Processing", "cpu");
    scheduler.addJob("Database Backup", "io");
    scheduler.addJob("Data Analysis", "cpu");
    scheduler.processJobs();
  }
}
// ✅ Time Complexity: O(N)
