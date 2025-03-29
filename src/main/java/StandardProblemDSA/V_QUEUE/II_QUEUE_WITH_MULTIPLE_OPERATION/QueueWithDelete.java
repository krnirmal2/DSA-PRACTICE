package StandardProblemDSA.V_QUEUE.II_QUEUE_WITH_MULTIPLE_OPERATION;

/*

2️⃣ Implement Queue with Delete Operation
        🔹 Problem Statement
        Design a queue that allows removing a specific element (not just FIFO).

        🔹 Approach
        Use LinkedList to efficiently remove elements from anywhere in the queue.
        removeElement() directly removes the first occurrence of the element.
*/

import java.util.LinkedList;
import java.util.Queue;

class QueueWithDelete {
  private Queue<Integer> queue;

  // ✅ Constructor
  public QueueWithDelete() {
    queue = new LinkedList<>();
  }

  // ✅ Enqueue
  public void enqueue(int value) {
    queue.add(value);
  }

  // ✅ Dequeue (FIFO removal)
  public int dequeue() {
    return queue.isEmpty() ? -1 : queue.poll();
  }

  // ✅ Delete an element
  public boolean removeElement(int value) {
    return queue.remove(value);
  }

  // ✅ Print Queue
  public void printQueue() {
    System.out.println("Queue: " + queue);
  }

  public static void main(String[] args) {
    QueueWithDelete queue = new QueueWithDelete();
    queue.enqueue(5);
    queue.enqueue(10);
    queue.enqueue(15);
    queue.printQueue(); // [5, 10, 15]

    queue.removeElement(10);
    queue.printQueue(); // [5, 15]
  }
} /*
  ✅ Time Complexity:

  O(1) for enqueue, dequeue

  O(N) for removeElement()

  🔹 Dry Run
  Operation	Queue State
  enqueue(5)	[5]
  enqueue(10)	[5, 10]
  enqueue(15)	[5, 10, 15]
  removeElement(10)	[5, 15]*/
