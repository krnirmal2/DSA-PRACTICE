package StandardProblemDSA.V_QUEUE.VI_SIMULATION_PROBLEM_USING_QUEUE;

/*
4️⃣ Implement a Queue for Customers in Bank Using Multiple Queues
        🔹 Problem Statement
        Simulate a bank service queue where:
        Customers choose different service types (Deposit, Withdraw, Loan).
        Each service type has its own queue.
        Bank tellers serve each queue separately.
        🔹 Approach
        Use multiple queues for different service types.
        Each queue is processed separately.
*/

import java.util.LinkedList;
import java.util.Queue;

class BankCustomer {
  int customerId;
  String serviceType;

  public BankCustomer(int customerId, String serviceType) {
    this.customerId = customerId;
    this.serviceType = serviceType;
  }
}

class BankQueueSystem {
  private Queue<BankCustomer> depositQueue = new LinkedList<>();
  private Queue<BankCustomer> withdrawQueue = new LinkedList<>();
  private Queue<BankCustomer> loanQueue = new LinkedList<>();

  // ✅ Add Customer to Appropriate Queue
  public void addCustomer(int customerId, String serviceType) {
    switch (serviceType.toLowerCase()) {
      case "deposit":
        depositQueue.add(new BankCustomer(customerId, serviceType));
        break;
      case "withdraw":
        withdrawQueue.add(new BankCustomer(customerId, serviceType));
        break;
      case "loan":
        loanQueue.add(new BankCustomer(customerId, serviceType));
        break;
      default:
        System.out.println("Invalid service type!");
    }
  }

  // ✅ Serve Customer from a Queue
  public void serveQueue(Queue<BankCustomer> queue, String service) {
    if (!queue.isEmpty()) {
      BankCustomer customer = queue.poll();
      System.out.println("Serving Customer " + customer.customerId + " for " + service);
    } else {
      System.out.println("No customers in " + service + " queue.");
    }
  }

  public void serveAll() {
    serveQueue(depositQueue, "Deposit");
    serveQueue(withdrawQueue, "Withdraw");
    serveQueue(loanQueue, "Loan");
  }
}
