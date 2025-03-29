package StandardProblemDSA.V_QUEUE.EVENT_DRIVEN_PATTERN;

/*
3️⃣ Event Scheduling Using Queue (Priority-based)
        🔹 Problem Statement
        Simulate event scheduling where:

        Events are prioritized (High, Medium, Low).

        High-priority events are processed first.

        🔹 Approach
        Use three queues (High, Medium, Low priority).

        Process events in priority order.
*/

import java.util.LinkedList;
import java.util.Queue;

class ScheduledEvent {
  int eventId;
  String eventType;

  public ScheduledEvent(int eventId, String eventType) {
    this.eventId = eventId;
    this.eventType = eventType;
  }
}

class EventScheduler {
  private Queue<ScheduledEvent> highPriorityQueue = new LinkedList<>();
  private Queue<ScheduledEvent> mediumPriorityQueue = new LinkedList<>();
  private Queue<ScheduledEvent> lowPriorityQueue = new LinkedList<>();

  // ✅ Schedule an event
  public void scheduleEvent(int eventId, String eventType, String priority) {
    ScheduledEvent event = new ScheduledEvent(eventId, eventType);
    switch (priority.toLowerCase()) {
      case "high":
        highPriorityQueue.add(event);
        break;
      case "medium":
        mediumPriorityQueue.add(event);
        break;
      case "low":
        lowPriorityQueue.add(event);
        break;
      default:
        System.out.println("Invalid priority!");
    }
  }

  // ✅ Process events in priority order
  public void processEvents() {
    while (!highPriorityQueue.isEmpty()) {
      ScheduledEvent event = highPriorityQueue.poll();
      System.out.println("Processing HIGH priority event: " + event.eventType);
    }
    while (!mediumPriorityQueue.isEmpty()) {
      ScheduledEvent event = mediumPriorityQueue.poll();
      System.out.println("Processing MEDIUM priority event: " + event.eventType);
    }
    while (!lowPriorityQueue.isEmpty()) {
      ScheduledEvent event = lowPriorityQueue.poll();
      System.out.println("Processing LOW priority event: " + event.eventType);
    }
  }

  public static void main(String[] args) {
    EventScheduler scheduler = new EventScheduler();
    scheduler.scheduleEvent(1, "System Update", "high");
    scheduler.scheduleEvent(2, "Daily Report", "medium");
    scheduler.scheduleEvent(3, "User Login", "low");

    scheduler.processEvents();
  }
}
/*
✅ Time Complexity:

O(1) for scheduling events

O(N) for processing events
🔹 Dry Run
Operation	Queue States
scheduleEvent(1, "System Update", "high")	High: [1]
scheduleEvent(2, "Daily Report", "medium")	Medium: [2]
scheduleEvent(3, "User Login", "low")	Low: [3]
processEvents()	Processes: High → Medium → Low

*/
