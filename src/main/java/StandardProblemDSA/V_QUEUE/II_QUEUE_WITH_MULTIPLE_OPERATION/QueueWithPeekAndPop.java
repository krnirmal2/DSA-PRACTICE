package StandardProblemDSA.V_QUEUE.II_QUEUE_WITH_MULTIPLE_OPERATION;

/*

1️⃣ Implement Queue with Peek and Pop at Any Time
        🔹 Problem Statement
        Implement a queue where:
        You can peek at any index in the queue.
        You can pop (remove) an element at any index.
        🔹 Approach
        Use a LinkedList (Deque<Integer>) for efficient peek and removal at any position.
        Peek at any index: Convert to an array and fetch the element.
        Pop at any index: Convert to an array, remove the element, and reconstruct the queue.
*/

import java.util.Deque;
import java.util.LinkedList;

class QueueWithPeekAndPop {
  private Deque<Integer> queue;

  // ✅ Constructor
  public QueueWithPeekAndPop() {
    queue = new LinkedList<>();
  }

  // ✅ Enqueue
  public void enqueue(int value) {
    queue.addLast(value);
  }

  // ✅ Dequeue (FIFO removal)
  public int dequeue() {
    return queue.isEmpty() ? -1 : queue.pollFirst();
  }

  // ✅ Peek at any index
  public int peekAt(int index) {
    if (index < 0 || index >= queue.size()) return -1;
    return (Integer) queue.toArray()[index];
  }

  // ✅ Pop at any index
  public void popAt(int index) {
    if (index < 0 || index >= queue.size()) return;
    queue.remove((Integer) queue.toArray()[index]);
  }

  // ✅ Print Queue
  public void printQueue() {
    System.out.println("Queue: " + queue);
  }

  public static void main(String[] args) {
    QueueWithPeekAndPop queue = new QueueWithPeekAndPop();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.printQueue(); // [10, 20, 30]

    System.out.println("Peek at index 1: " + queue.peekAt(1)); // 20
    queue.popAt(1);
    queue.printQueue(); // [10, 30]
  }
} /*
  ✅ Time Complexity:

  O(1) for enqueue, dequeue

  O(N) for peekAt() and popAt() (due to array conversion)

          🔹 Dry Run
  Operation	Queue State
  enqueue(10)	[10]
  enqueue(20)	[10, 20]
  enqueue(30)	[10, 20, 30]
  peekAt(1) → 20	[10, 20, 30]
  popAt(1) (removes 20)	[10, 30]*/
