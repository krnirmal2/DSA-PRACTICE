package StandardProblemDSA.V_QUEUE.EVENT_DRIVEN_PATTERN;

/*

1️⃣ Simulate Event Processing Using Queue
        🔹 Problem Statement
        Simulate an event-driven system where:
        Events arrive at different times.
        Events are processed in FIFO order.
        🔹 Approach
        Use a queue to store events.
        Process events one by one, simulating event execution time.
*/

import java.util.LinkedList;
import java.util.Queue;

class Event {
  int eventId;
  String eventType;

  public Event(int eventId, String eventType) {
    this.eventId = eventId;
    this.eventType = eventType;
  }
}

class EventProcessor {
  private Queue<Event> eventQueue;

  // ✅ Constructor
  public EventProcessor() {
    eventQueue = new LinkedList<>();
  }

  // ✅ Add Event to Queue
  public void addEvent(int eventId, String eventType) {
    eventQueue.add(new Event(eventId, eventType));
    System.out.println("Event " + eventId + " (" + eventType + ") added.");
  }

  // ✅ Process Events (FIFO)
  public void processEvents() {
    while (!eventQueue.isEmpty()) {
      Event event = eventQueue.poll();
      System.out.println("Processing Event ID: " + event.eventId + " - Type: " + event.eventType);
      try {
        Thread.sleep(500); // Simulate event processing delay
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("All events processed.");
  }

  public static void main(String[] args) {
    EventProcessor processor = new EventProcessor();
    processor.addEvent(1, "Login");
    processor.addEvent(2, "Payment");
    processor.addEvent(3, "Logout");

    processor.processEvents();
  }
} /*
  ✅ Time Complexity:

  O(1) for adding events

  O(N) for processing events

  🔹 Dry Run
  Operation	Queue State
  addEvent(1, "Login")	[1]
  addEvent(2, "Payment")	[1, 2]
  addEvent(3, "Logout")	[1, 2, 3]
  processEvents()	Processes: 1 → 2 → 3*/
