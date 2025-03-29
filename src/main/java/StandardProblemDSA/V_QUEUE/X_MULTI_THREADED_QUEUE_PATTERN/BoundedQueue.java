package StandardProblemDSA.V_QUEUE.X_MULTI_THREADED_QUEUE_PATTERN;

/*

3️⃣ Implement Bounded Queue
     🔹 Problem Statement
        Implement a bounded queue with a fixed capacity where:
        Producers wait when the queue is full.
        Consumers wait when the queue is empty.

     🔹 Approach
        Use a fixed-size queue with wait() and notify().
        Producers must wait when full.
        Consumers must wait when empty.
*/

import java.util.LinkedList;
import java.util.Queue;

class BoundedQueue<T> {
  private Queue<T> queue;
  private int capacity;

  public BoundedQueue(int capacity) {
    this.queue = new LinkedList<>();
    this.capacity = capacity;
  }

  // ✅ Enqueue with Blocking
  public synchronized void enqueue(T item) throws InterruptedException {
    while (queue.size() == capacity) {
      wait(); // Wait if full
    }
    queue.add(item);
    /* Wakes up all threads that are waiting on this object's monitor. A thread waits on an object's monitor by calling one of the wait methods.
            The awakened threads will not be able to proceed until the current thread relinquishes the lock on this object. The awakened threads will compete in the usual manner with any other threads that might be actively competing to
    synchronize on this object; for example, the awakened threads enjoy no reliable privilege or disadvantage in being the next thread to lock this object.*/
    notifyAll(); // Notify waiting consumers
  }

  // ✅ Dequeue with Blocking
  public synchronized T dequeue() throws InterruptedException {
    while (queue.isEmpty()) {
      wait(); // Wait if empty
    }
    T item = queue.poll();
    notifyAll(); // Notify waiting producers that the queue is empty you can produce item
    return item;
  }

  public static void main(String[] args) {
    BoundedQueue<Integer> boundedQueue = new BoundedQueue<>(3);
    Runnable producer =
        () -> {
          try {
            for (int i = 1; i <= 5; i++) {
              boundedQueue.enqueue(i);
              System.out.println("Produced: " + i);
              Thread.sleep(500);
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        };

    Runnable consumer =
        () -> {
          try {
            for (int i = 1; i <= 5; i++) {
              int item = boundedQueue.dequeue();
              System.out.println("Consumed: " + item);
              Thread.sleep(1000);
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        };

    new Thread(producer).start();
    new Thread(consumer).start();
  }
} /*
  ✅ Time Complexity:

  O(1) for enqueue and dequeue

  Thread-safe with wait/notify mechanism*/
