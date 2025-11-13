package StandardProblemDSA.V_QUEUE.XI_CIRCULAR_QUEUE_PATTERN;

class CircularQueue {
  private int[] queue;
  private int front, rear, size, capacity;

  /*2. Circular Queue Operations
  (i) Enqueue (Insert)
  Check if the queue is full.
  Insert the element at (rear + 1) % capacity.
  Increase size.
  (ii) Dequeue (Remove)
  Check if the queue is empty.
  Remove the front element.
  Move front to (front + 1) % capacity.
  Decrease size.
  (iii) Peek (Front Element)
  Return queue[front].*/
  public CircularQueue(int capacity) {
    this.capacity = capacity;
    this.queue = new int[capacity];
    this.front = this.size = 0;
    this.rear = -1;
  }

  // Enqueue: Add element at the rear
  public boolean enqueue(int item) {
    if (isFull()) {
      System.out.println("Queue is full!");
      return false;
    }
    rear = (rear + 1) % capacity; // Move rear circularly
    queue[rear] = item;
    size++;
    return true;
  }

  // Dequeue: Remove element from the front
  public int dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty!");
    }
    int item = queue[front];
    front = (front + 1) % capacity; // Move front circularly
    size--;
    return item;
  }

  // Peek: Get front element
  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty!");
    }
    return queue[front];
  }

  // Check if queue is empty
  public boolean isEmpty() {
    return size == 0;
  }

  // Check if queue is full
  public boolean isFull() {
    return size == capacity;
  }

  // Display Queue
  public void display() {
    if (isEmpty()) {
      System.out.println("Queue is empty!");
      return;
    }
    System.out.print("Queue: ");
    for (int i = 0; i < size; i++) {
      System.out.print(queue[(front + i) % capacity] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    CircularQueue queue = new CircularQueue(5);
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);
    queue.display(); // Output: Queue: 10 20 30 40 50

    queue.dequeue();
    queue.dequeue();
    queue.display(); // Output: Queue: 30 40 50

    queue.enqueue(60);
    queue.enqueue(70);
    queue.display(); // Output: Queue: 30 40 50 60 70
  }
}
