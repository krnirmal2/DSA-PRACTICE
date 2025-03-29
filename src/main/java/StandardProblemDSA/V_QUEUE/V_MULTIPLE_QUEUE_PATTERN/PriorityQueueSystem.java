package StandardProblemDSA.V_QUEUE.V_MULTIPLE_QUEUE_PATTERN;

/*

1️⃣ Implement Multiple Queues with Priority
        🔹 Problem Statement
        Simulate a priority-based system where:

        Tasks are assigned to different queues based on priority (High, Medium, Low).

        High-priority tasks are processed first, then Medium, then Low.

        🔹 Approach
        Use three queues (highPriorityQueue, mediumPriorityQueue, lowPriorityQueue).

        Process queues in priority order (High → Medium → Low).

        If one queue is empty, move to the next.
*/

import java.util.LinkedList;
import java.util.Queue;

class PriorityQueueSystem {
  private Queue<String> highPriorityQueue = new LinkedList<>();
  private Queue<String> mediumPriorityQueue = new LinkedList<>();
  private Queue<String> lowPriorityQueue = new LinkedList<>();

  // ✅ Add task based on priority
  public void addTask(String task, String priority) {
    switch (priority.toLowerCase()) {
      case "high":
        highPriorityQueue.add(task);
        break;
      case "medium":
        mediumPriorityQueue.add(task);
        break;
      case "low":
        lowPriorityQueue.add(task);
        break;
      default:
        System.out.println("Invalid priority!");
    }
  }

  // ✅ Process tasks in order of priority
  public void processTasks() {
    while (!highPriorityQueue.isEmpty()) {
      System.out.println("Processing HIGH priority task: " + highPriorityQueue.poll());
    }
    while (!mediumPriorityQueue.isEmpty()) {
      System.out.println("Processing MEDIUM priority task: " + mediumPriorityQueue.poll());
    }
    while (!lowPriorityQueue.isEmpty()) {
      System.out.println("Processing LOW priority task: " + lowPriorityQueue.poll());
    }
    System.out.println("All tasks processed.");
  }

  public static void main(String[] args) {
    PriorityQueueSystem system = new PriorityQueueSystem();
    system.addTask("Fix critical bug", "high");
    system.addTask("Optimize database queries", "medium");
    system.addTask("Code refactoring", "low");
    system.processTasks();
  }
} /*
  ✅ Time Complexity:

  O(1) for adding tasks

  O(N) for processing tasks

  🔹 Dry Run
  Operation	Queue States
  addTask("Fix critical bug", "high")	High: [Fix critical bug]
  addTask("Optimize DB", "medium")	Medium: [Optimize DB]
  addTask("Refactor code", "low")	Low: [Refactor code]
  processTasks()	Serves: High → Medium → Low*/
