package StandardProblemDSA.V_QUEUE.II_QUEUE_WITH_MULTIPLE_OPERATION;

import java.util.*;

/*3️⃣ Queue with Min/Max Operations
🔹 Problem Statement
Implement a queue that supports:
Finding minimum (getMin()) in O(1)
Finding maximum (getMax()) in O(1)

🔹 Approach
Use two deques (minDeque, maxDeque) to track min/max in O(1).
Maintain decreasing order in maxDeque, increasing order in minDeque.

*/
class QueueWithMinMax {
  private Queue<Integer> queue;
  private Deque<Integer> minDeque, maxDeque;

  // ✅ Constructor
  public QueueWithMinMax() {
    queue = new LinkedList<>();
    minDeque = new LinkedList<>();
    maxDeque = new LinkedList<>();
  }

  // ✅ Enqueue
  public void enqueue(int value) {
    queue.add(value);
    // if value is less than the peek element of the last element of the minDeque then we have to
    // remove the last element and insert the new minimum element into that , as it
    // will give min element every time
    while (!minDeque.isEmpty() && minDeque.peekLast() > value) minDeque.pollLast();
    // if value>maxDeque last element then remove to maintain the maximum value in that queue
    while (!maxDeque.isEmpty() && maxDeque.peekLast() < value) maxDeque.pollLast();
    // update min and max by the value
    minDeque.addLast(value);
    maxDeque.addLast(value);
  }

  // ✅ Dequeue (FIFO)
  public int dequeue() {
    if (queue.isEmpty()) return -1;
    int removed = queue.poll();
    if (removed == minDeque.peekFirst()) minDeque.pollFirst();
    if (removed == maxDeque.peekFirst()) maxDeque.pollFirst();
    return removed;
  }

  // ✅ Get Min/Max
  public int getMin() {
    return minDeque.peekFirst();
  }

  public int getMax() {
    return maxDeque.peekFirst();
  }

  // ✅ Print Queue
  public void printQueue() {
    System.out.println("Queue: " + queue);
  }

  public static void main(String[] args) {
    QueueWithMinMax queue = new QueueWithMinMax();
    queue.enqueue(5);
    queue.enqueue(1);
    queue.enqueue(8);
    queue.printQueue(); // [5, 1, 8]

    System.out.println("Min: " + queue.getMin()); // 1
    System.out.println("Max: " + queue.getMax()); // 8

    queue.dequeue();
    queue.printQueue(); // [1, 8]
  }
  /*✅ Time Complexity:
  O(1) for enqueue, dequeue, getMin(), getMax()
  🔹 Dry Run
  Operation	Queue State	Min	Max
  enqueue(5)	[5]	5	5
  enqueue(1)	[5, 1]	1	5
  enqueue(8)	[5, 1, 8]	1	8
  dequeue() (removes 5)	[1, 8]	1	8
  🔹 Summary
  Operation	Queue with Peek/Pop	Queue with Delete	Queue with Min/Max
  Enqueue (O(1))	✅	✅	✅
  Dequeue (O(1))	✅	✅	✅
  Peek/Pop at Any Index (O(N))	✅	❌	❌
  Delete Specific Element (O(N))	❌	✅	❌
  Min/Max in O(1)	❌	❌	✅*/
}
