package StandardProblemDSA.V_QUEUE.X_MULTI_THREADED_QUEUE_PATTERN;

/*

2️⃣ Blocking Queue for Producer-Consumer Problem
        🔹 Problem Statement
        Implement a blocking queue where:

        Producers add items to a queue.

        Consumers remove items from the queue.

        If the queue is empty, consumers wait.

        If the queue is full, producers wait.

        🔹 Approach
        Use BlockingQueue (LinkedBlockingQueue).

        put() blocks if the queue is full.

        take() blocks if the queue is empty.
*/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ProducerConsumer {
  private static final int CAPACITY = 5;
  private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(CAPACITY);

  // ✅ Producer Task
  class Producer implements Runnable {
    public void run() {
      try {
        for (int i = 1; i <= 10; i++) {
          queue.put(i);
          System.out.println("Produced: " + i);
          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  // ✅ Consumer Task
  class Consumer implements Runnable {
    public void run() {
      try {
        while (true) {
          int item = queue.take();
          System.out.println("Consumed: " + item);
          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    ProducerConsumer pc = new ProducerConsumer();

    Thread producerThread = new Thread(pc.new Producer());
    Thread consumerThread = new Thread(pc.new Consumer());

    producerThread.start();
    consumerThread.start();
  }
}
/*
✅ Time Complexity:

O(1) for enqueue and dequeue

Blocking mechanism ensures smooth execution*/
