package StandardProblemDSA.V_QUEUE.X_MULTI_THREADED_QUEUE_PATTERN;

/*

4️⃣ Queue for Task Distribution in Multithreaded Systems
        🔹 Problem Statement
        Simulate task distribution where:

        Multiple workers process tasks from a queue.

        Tasks are assigned dynamically.

        🔹 Approach
        Use a thread pool and a queue.

        Each worker picks a task and processes it.
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class TaskDistributor {
  private static final int NUM_WORKERS = 3;
  private LinkedBlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();

  // ✅ Add Task to Queue
  public void addTask(String task) {
    taskQueue.add(task);
    System.out.println("Task Added: " + task);
  }

  // ✅ Worker Thread Task
  class Worker implements Runnable {
    public void run() {
      while (!taskQueue.isEmpty()) {
        try {
          String task = taskQueue.poll();
          if (task != null) {
            System.out.println(Thread.currentThread().getName() + " Processing: " + task);
            Thread.sleep(1000); // Simulate task processing
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void distributeTasks() {
    ExecutorService executor = Executors.newFixedThreadPool(NUM_WORKERS);
    for (int i = 0; i < NUM_WORKERS; i++) {
      executor.execute(new Worker());
    }
    executor.shutdown();
  }

  public static void main(String[] args) {
    TaskDistributor distributor = new TaskDistributor();
    distributor.addTask("Task 1");
    distributor.addTask("Task 2");
    distributor.addTask("Task 3");
    distributor.addTask("Task 4");

    distributor.distributeTasks();
  }
}
// ✅ Uses a thread pool for efficient task distribution! 🚀
