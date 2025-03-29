package StandardProblemDSA.V_QUEUE.VI_SIMULATION_PROBLEM_USING_QUEUE;

/*

3️⃣ Design a Call Center Simulation Using Queue
        🔹 Problem Statement
        Simulate a call center where:

        Incoming calls are queued.

        Agents handle calls in FIFO order.

        🔹 Approach
        Use a queue for incoming calls.

        An agent picks up the first call.
*/

import java.util.LinkedList;
import java.util.Queue;

class Call {
  int callerId;

  public Call(int callerId) {
    this.callerId = callerId;
  }
}

class CallCenter {
  private Queue<Call> callQueue;

  // ✅ Constructor
  public CallCenter() {
    callQueue = new LinkedList<>();
  }

  // ✅ Receive Call
  public void receiveCall(int callerId) {
    callQueue.add(new Call(callerId));
    System.out.println("Call received from Caller " + callerId);
  }

  // ✅ Process Call
  public void processCall() {
    if (!callQueue.isEmpty()) {
      Call call = callQueue.poll();
      System.out.println("Agent handling call from Caller " + call.callerId);
    } else {
      System.out.println("No calls in queue.");
    }
  }

  public static void main(String[] args) {
    CallCenter center = new CallCenter();
    center.receiveCall(5001);
    center.receiveCall(5002);
    center.receiveCall(5003);

    center.processCall();
    center.processCall();
    center.processCall();
  }
} /*
  ✅ Time Complexity:

  O(1) for receiving calls

  O(1) for processing calls

  🔹 Dry Run
  Operation	Queue State
  receiveCall(5001)	[5001]
  receiveCall(5002)	[5001,5002]
  receiveCall(5003)	[5001,5002,5003]
  processCall()	Serves 5001
  processCall()	Serves 5002
  processCall()	Serves 5003
  */
