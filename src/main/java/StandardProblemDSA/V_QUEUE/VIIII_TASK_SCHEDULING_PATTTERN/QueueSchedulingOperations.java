package StandardProblemDSA.V_QUEUE.VIIII_TASK_SCHEDULING_PATTTERN;

import java.util.*;

public class QueueSchedulingOperations {

  // ---------------------------------------------------
  // Process Class Definition (used for scheduling problems)
  // ---------------------------------------------------
  class Process {
    int processId; // Unique process identifier.
    int burstTime; // Total CPU burst time required.
    int remainingTime; // Time remaining for process execution.

    public Process(int id, int bt) {
      this.processId = id;
      this.burstTime = bt;
      this.remainingTime = bt;
    }
  }

  // ---------------------------------------------------
  // 1. Task Scheduling Using Queue (Round-robin)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a list of tasks (processes) with burst times, schedule them using round-robin.

    Brute Force Approach:
       - Process tasks sequentially until completion.
       - Inefficient when tasks need to be re-inserted.

    Optimal Approach:
       - Use a queue to repeatedly cycle through tasks.
       - At each step, process a task for a fixed time quantum.
       - If a task isn’t finished, reinsert it at the back of the queue.

    Time Complexity: O(n * number_of_rounds), where each round does O(1) work per process.

    Example:
       Processes: P1 (burst = 10), P2 (burst = 4), P3 (burst = 5), P4 (burst = 6)
       Time Quantum: 3
       Expected order: P1 (3 units), P2 (3 units), P3 (3 units), P4 (3 units), then back to P1, etc.
  */
  public void roundRobinScheduling(List<Process> processes, int timeQuantum) {
    Queue<Process> queue = new LinkedList<>();
    // Enqueue all processes.
    for (Process p : processes) {
      queue.offer(p);
    }
    System.out.println("Round Robin Scheduling Order:");
    // Process the queue until empty.
    while (!queue.isEmpty()) {
      Process p = queue.poll();
      if (p.remainingTime > timeQuantum) {
        System.out.println("Processing P" + p.processId + " for " + timeQuantum + " time units.");
        p.remainingTime -= timeQuantum;
        queue.offer(p);
      } else {
        System.out.println(
            "Processing P" + p.processId + " for " + p.remainingTime + " time units. Completed.");
        p.remainingTime = 0;
      }
    }
  }

  // ---------------------------------------------------
  // 2. Queueing Theory Problems (Little's Law)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Apply Little's Law from queueing theory, which states:
         L = λ * W
       where L is the average number of items in the system,
       λ (lambda) is the arrival rate, and W is the average time an item spends in the system.

    Brute Force Approach:
       - Not applicable; the formula directly provides the answer.

    Optimal Approach:
       - Simply calculate L using the formula.

    Time Complexity: O(1)

    Example:
       If arrival rate (λ) = 2 items/minute and average time (W) = 3.5 minutes,
       then L = 2 * 3.5 = 7 items.
  */
  public double littlesLaw(double arrivalRate, double avgTimeInSystem) {
    return arrivalRate * avgTimeInSystem;
  }

  // ---------------------------------------------------
  // 3. Implement Scheduler for CPU Scheduling Using Queue
  // ---------------------------------------------------
  /*
    Problem Statement:
       Simulate a CPU scheduler that uses round-robin scheduling via a queue.
       (This is essentially the same as task scheduling using a queue.)

    Brute Force Approach:
       - Sequentially process each task.

    Optimal Approach:
       - Use a round-robin scheduler (see roundRobinScheduling).

    Time Complexity: O(n * rounds)

    Example:
       Same as in roundRobinScheduling.
  */
  public void cpuScheduler(List<Process> processes, int timeQuantum) {
    System.out.println("CPU Scheduler (Round Robin):");
    roundRobinScheduling(processes, timeQuantum);
  }

  // ---------------------------------------------------
  // 4. Round Robin Scheduling for Processes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Schedule processes in a round-robin fashion using a queue.

    Brute Force Approach:
       - Process one by one without cycling.

    Optimal Approach:
       - Use the round-robin scheduling method described above.

    Time Complexity: O(n * rounds)

    Example:
       Same as roundRobinScheduling.
  */
  public void roundRobinForProcesses(List<Process> processes, int timeQuantum) {
    System.out.println("Round Robin Scheduling for Processes:");
    roundRobinScheduling(processes, timeQuantum);
  }

  // ---------------------------------------------------
  // Main Method for Demonstration
  // ---------------------------------------------------
  public static void main(String[] args) {
    QueueSchedulingOperations ops = new QueueSchedulingOperations();

    // Create sample processes.
    List<Process> processes = new ArrayList<>();
    processes.add(ops.new Process(1, 10)); // Process 1 with burst time 10
    processes.add(ops.new Process(2, 4)); // Process 2 with burst time 4
    processes.add(ops.new Process(3, 5)); // Process 3 with burst time 5
    processes.add(ops.new Process(4, 6)); // Process 4 with burst time 6

    int timeQuantum = 3;

    // Demonstrate Round Robin Scheduling using a queue.
    ops.roundRobinScheduling(processes, timeQuantum);

    // For additional demonstrations, reset process states.
    processes.clear();
    processes.add(ops.new Process(1, 10));
    processes.add(ops.new Process(2, 4));
    processes.add(ops.new Process(3, 5));
    processes.add(ops.new Process(4, 6));

    // Demonstrate CPU Scheduling using the scheduler (round robin).
    ops.cpuScheduler(processes, timeQuantum);

    // Reset processes again for round robin demonstration.
    processes.clear();
    processes.add(ops.new Process(1, 10));
    processes.add(ops.new Process(2, 4));
    processes.add(ops.new Process(3, 5));
    processes.add(ops.new Process(4, 6));
    ops.roundRobinForProcesses(processes, timeQuantum);

    // Demonstrate Little's Law calculation.
    double arrivalRate = 2.0; // For example, 2 items per minute.
    double avgTime = 3.5; // For example, each item spends 3.5 minutes in the system.
    double avgItems = ops.littlesLaw(arrivalRate, avgTime);
    System.out.println("Little's Law: Average number of items in system = " + avgItems);
  }
}
