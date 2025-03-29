package StandardProblemDSA.V_QUEUE.VI_SIMULATION_PROBLEM_USING_QUEUE;

/*
1️⃣ Print Job Scheduling Using Queue
        🔹 Problem Statement
        Simulate a printer queue where:

        Jobs are added to a queue.

        The printer processes jobs in FIFO order.

        🔹 Approach
        Use a queue to store print jobs.

        Each job has an ID and a processing time.

        The printer dequeues jobs and prints them one at a time.
*/

import java.util.LinkedList;
import java.util.Queue;

class PrintJob {
  int jobId;
  int pages;

  public PrintJob(int jobId, int pages) {
    this.jobId = jobId;
    this.pages = pages;
  }
}

class PrintJobScheduler {
  private Queue<PrintJob> jobQueue;

  // ✅ Constructor
  public PrintJobScheduler() {
    jobQueue = new LinkedList<>();
  }

  // ✅ Add Job to Queue
  public void addJob(int jobId, int pages) {
    jobQueue.add(new PrintJob(jobId, pages));
    System.out.println("Job " + jobId + " added to print queue.");
  }

  // ✅ Process Print Jobs
  public void processJobs() {
    while (!jobQueue.isEmpty()) {
      PrintJob job = jobQueue.poll();
      System.out.println("Printing Job ID: " + job.jobId + " (Pages: " + job.pages + ")");
      try {
        Thread.sleep(job.pages * 100); // Simulate print delay
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("All jobs completed.");
  }

  public static void main(String[] args) {
    PrintJobScheduler printer = new PrintJobScheduler();
    printer.addJob(1, 5);
    printer.addJob(2, 10);
    printer.addJob(3, 3);

    printer.processJobs();
  }
} /*
  ✅ Time Complexity:

  O(1) for enqueueing jobs

  O(N) for processing jobs

  🔹 Dry Run
  Operation	Queue State
  addJob(1,5)	[1]
  addJob(2,10)	[1,2]
  addJob(3,3)	[1,2,3]
  processJobs()	Prints 1 → 2 → 3*/
