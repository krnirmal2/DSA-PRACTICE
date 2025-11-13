package StandardProblemDSA.V_QUEUE.VI_SIMULATION_PROBLEM_USING_QUEUE;

/*2️⃣ Implement Ticketing System Using Queue
        🔹 Problem Statement

        Simulate a ticket booking system where:
        Customers arrive and request tickets.
        The system processes them in FIFO order.

        🔹 Approach
        Use a queue for customer ticket requests.
        A counter serves requests in order.
*/
import java.util.LinkedList;
import java.util.Queue;

class TicketRequest {
  int customerId;
  int numTickets;

  public TicketRequest(int customerId, int numTickets) {
    this.customerId = customerId;
    this.numTickets = numTickets;
  }
}

class TicketingSystem {
  private Queue<TicketRequest> queue;

  // ✅ Constructor
  public TicketingSystem() {
    queue = new LinkedList<>();
  }

  // ✅ Add Ticket Request
  public void requestTicket(int customerId, int numTickets) {
    queue.add(new TicketRequest(customerId, numTickets));
    System.out.println("Customer " + customerId + " requested " + numTickets + " tickets.");
  }

  // ✅ Process Ticket Requests
  public void processRequests() {
    while (!queue.isEmpty()) {
      TicketRequest request = queue.poll();
      System.out.println(
          "Processing Ticket Request: Customer "
              + request.customerId
              + " ("
              + request.numTickets
              + " tickets)");
    }
    System.out.println("All ticket requests processed.");
  }

  public static void main(String[] args) {
    TicketingSystem system = new TicketingSystem();
    system.requestTicket(101, 2);
    system.requestTicket(102, 4);
    system.requestTicket(103, 1);

    system.processRequests();
  }
}
/*
✅ Time Complexity:

O(1) for requesting tickets

O(N) for processing tickets

🔹 Dry Run
Operation	Queue State
requestTicket(101,2)	[101]
requestTicket(102,4)	[101,102]
requestTicket(103,1)	[101,102,103]
processRequests()	Serves 101 → 102 → 103*/
