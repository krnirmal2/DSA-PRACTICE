package StandardProblemDSA.V_QUEUE.VIII_DEQUE_PATTERN;

class DequeNode {
  int data;
  DequeNode next, prev;

  public DequeNode(int data) {
    this.data = data;
    this.next = this.prev = null;
  }
}

class LinkedListDeque {
  private DequeNode front, rear;
  private int size;

  public LinkedListDeque() {
    front = rear = null;
    size = 0;
  }

  // Add to the front
  public void addFront(int data) {
    DequeNode newNode = new DequeNode(data);
    if (isEmpty()) {
      front = rear = newNode;
    } else {
      newNode.next = front;
      front.prev = newNode;
      front = newNode;
    }
    size++;
  }

  // Add to the rear
  public void addRear(int data) {
    DequeNode newNode = new DequeNode(data);
    if (isEmpty()) {
      front = rear = newNode;
    } else {
      rear.next = newNode;
      newNode.prev = rear;
      rear = newNode;
    }
    size++;
  }

  // Remove from front
  public int removeFront() {
    if (isEmpty()) throw new RuntimeException("Deque is empty!");
    int value = front.data;
    front = front.next;
    if (front == null) rear = null; // If list is empty
    else front.prev = null;
    size--;
    return value;
  }

  // Remove from rear
  public int removeRear() {
    if (isEmpty()) throw new RuntimeException("Deque is empty!");
    int value = rear.data;
    rear = rear.prev;
    if (rear == null) front = null;
    else rear.next = null;
    size--;
    return value;
  }

  // Peek front
  public int peekFront() {
    if (isEmpty()) throw new RuntimeException("Deque is empty!");
    return front.data;
  }

  // Peek rear
  public int peekRear() {
    if (isEmpty()) throw new RuntimeException("Deque is empty!");
    return rear.data;
  }

  // Check if empty
  public boolean isEmpty() {
    return size == 0;
  }

  // Get size
  public int getSize() {
    return size;
  }

  // Display elements
  public void display() {
    DequeNode temp = front;
    System.out.print("Deque: ");
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedListDeque deque = new LinkedListDeque();
    deque.addFront(10);
    deque.addRear(20);
    deque.addFront(5);
    deque.display(); // Output: Deque: 5 10 20

    System.out.println("Removed Front: " + deque.removeFront()); // Output: 5
    System.out.println("Removed Rear: " + deque.removeRear()); // Output: 20
    deque.display(); // Output: Deque: 10
  }
}
