package StandardProblemDSA.V_QUEUE.V_MULTIPLE_QUEUE_PATTERN;

import java.util.LinkedList;
import java.util.Queue;

public class MultilevelQueueInOS {}

/*
4️⃣ Multi-Level Queues in Operating Systems
🔹 Problem Statement
Simulate multi-level scheduling where:

Processes are classified into Foreground (interactive) and Background (batch).

Foreground jobs get priority over background jobs.
*/

class MultiLevelQueueOS {
  private Queue<String> foregroundQueue = new LinkedList<>();
  private Queue<String> backgroundQueue = new LinkedList<>();

  // ✅ Add process to queue
  public void addProcess(String process, String level) {
    if (level.equalsIgnoreCase("foreground")) {
      foregroundQueue.add(process);
    } else {
      backgroundQueue.add(process);
    }
  }

  // ✅ Execute processes (Foreground first)
  public void executeProcesses() {
    while (!foregroundQueue.isEmpty() || !backgroundQueue.isEmpty()) {
      if (!foregroundQueue.isEmpty())
        System.out.println("Executing Foreground Process: " + foregroundQueue.poll());
      else if (!backgroundQueue.isEmpty())
        System.out.println("Executing Background Process: " + backgroundQueue.poll());
    }
  }

  public static void main(String[] args) {
    MultiLevelQueueOS os = new MultiLevelQueueOS();
    os.addProcess("Browser", "foreground");
    os.addProcess("System Update", "background");
    os.addProcess("IDE", "foreground");
    os.executeProcesses();
  }
}
// ✅ Foreground prioritized scheduling implemented! 🚀
