package StandardProblemDSA.V_QUEUE.V_MULTIPLE_QUEUE_PATTERN;

/*

2️⃣ Load Balancing Using Multiple Queues
        🔹 Problem Statement
        Simulate load balancing where:

        Requests are distributed across multiple queues (servers).

        Each request is sent to the queue with the least load.

        🔹 Approach
        Use N queues (servers).

        Find the queue with the smallest size and assign the request.

        Process requests in FIFO order.
*/

import java.util.LinkedList;
import java.util.Queue;

class LoadBalancer {
  private Queue<String>[] servers;
  private int numServers;

  // ✅ Constructor (Initialize multiple queues)
  public LoadBalancer(int numServers) {
    this.numServers = numServers;
    servers = new LinkedList[numServers];
    for (int i = 0; i < numServers; i++) {
      servers[i] = new LinkedList<>();
    }
  }

  // ✅ Assign request to the least loaded server
  public void addRequest(String request) {
    int minLoadIndex = 0;
    for (int i = 1; i < numServers; i++) {
      if (servers[i].size() < servers[minLoadIndex].size()) {
        minLoadIndex = i;
      }
    }
    servers[minLoadIndex].add(request);
    System.out.println("Request '" + request + "' assigned to Server " + (minLoadIndex + 1));
  }

  // ✅ Process requests from all servers
  public void processRequests() {
    for (int i = 0; i < numServers; i++) {
      while (!servers[i].isEmpty()) {
        System.out.println("Processing request from Server " + (i + 1) + ": " + servers[i].poll());
      }
    }
  }

  public static void main(String[] args) {
    LoadBalancer balancer = new LoadBalancer(3);
    balancer.addRequest("Login");
    balancer.addRequest("File Upload");
    balancer.addRequest("Data Sync");
    balancer.addRequest("API Request");
    balancer.processRequests();
  }
} /*
  ✅ Time Complexity:

  O(N) for finding least loaded server

  O(1) for assigning requests

  🔹 Dry Run
  Operation	Queue States
  addRequest("Login")	Server 1: [Login]
  addRequest("File Upload")	Server 2: [File Upload]
  addRequest("Data Sync")	Server 3: [Data Sync]
  addRequest("API Request")	Server 1: [Login, API Request]
  processRequests()	Processes: Server 1 → Server 2 → Server 3
  */
