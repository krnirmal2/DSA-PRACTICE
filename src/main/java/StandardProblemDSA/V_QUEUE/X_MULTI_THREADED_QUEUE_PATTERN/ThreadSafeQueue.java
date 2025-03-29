package StandardProblemDSA.V_QUEUE.X_MULTI_THREADED_QUEUE_PATTERN;

/*

1️⃣ Implement Thread-Safe Queue
🔹 Problem Statement
Implement a thread-safe queue that:
Supports multiple producers and consumers.
        Ensures synchronized access to avoid race conditions.
🔹 Approach
Use synchronized methods or ConcurrentLinkedQueue (a thread-safe non-blocking queue).
The queue allows multiple threads to enqueue and dequeue safely.
*/

import java.util.concurrent.ConcurrentLinkedQueue;

class ThreadSafeQueue<T> {
  private ConcurrentLinkedQueue<T> queue = new ConcurrentLinkedQueue<>();

  // ✅ Enqueue (Thread-Safe)
  public void enqueue(T item) {
    queue.add(item);
  }

  // ✅ Dequeue (Thread-Safe)
  public T dequeue() {
    return queue.poll();
  }

  // ✅ Check if Empty
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public static void main(String[] args) {
    ThreadSafeQueue<Integer> queue = new ThreadSafeQueue<>();

    // Multiple producers
    Runnable producer =
        () -> {
          for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(Thread.currentThread().getName() + " enqueued " + i);
          }
        };

    // Multiple consumers
    Runnable consumer =
        () -> {
          while (!queue.isEmpty()) {
            Integer item = queue.dequeue();
            if (item != null)
              System.out.println(Thread.currentThread().getName() + " dequeued " + item);
          }
        };

    Thread producerThread1 = new Thread(producer);
    Thread producerThread2 = new Thread(producer);
    Thread consumerThread1 = new Thread(consumer);
    Thread consumerThread2 = new Thread(consumer);

    producerThread1.start();
    producerThread2.start();

    try {
      producerThread1.join();
      producerThread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    consumerThread1.start();
    consumerThread2.start();
  }
}
/*
✅ Time Complexity:

O(1) for enqueue and dequeue

Thread-safe and lock-free*/
