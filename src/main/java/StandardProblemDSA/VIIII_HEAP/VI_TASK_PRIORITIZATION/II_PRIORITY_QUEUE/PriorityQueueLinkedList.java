package StandardProblemDSA.VIIII_HEAP.VI_TASK_PRIORITIZATION.II_PRIORITY_QUEUE;

class Task {
  String name;
  int priority;

  Task(String name, int priority) {
    this.name = name;
    this.priority = priority;
  }
}

class Node {
  Task task;
  Node next;

  Node(Task task) {
    this.task = task;
    this.next = null;
  }
}

class PriorityQueueLinkedList {
  private Node head; // highest priority at head

  public PriorityQueueLinkedList() {
    this.head = null;
  }

  /*
  📌 Operations
  1. Insert a task
      Traverse the list to find the correct position based on priority.
      Insert the task node while maintaining the descending priority order.
      Time Complexity: O(n)
      Space Complexity: O(1) (not counting task object)
  2. Peek Max
      Return the task at the head.
      Time Complexity: O(1)
      Space Complexity: O(1)
  3. Extract Max
      Remove and return the head task (i.e., max priority).
      Update head to the next node.
      Time Complexity: O(1)
      Space Complexity: O(1)
  4. Update Priority
      Search the task by name.
      Remove it from its current position.
      Reinsert it at the correct position with the new priority.
      Time Complexity: O(n)
      Space Complexity: O(1)
  5. Print Queue
      Traverse and display all tasks in priority order.
      Time Complexity: O(n)
      Space Complexity: O(1)
  6. isEmpty
      Check if head is null.
      Time Complexity: O(1)
      Space Complexity: O(1)
  */

  // Insert a task based on its priority (sorted insertion)
  public void insert(String name, int priority) {
    Task newTask = new Task(name, priority);
    Node newNode = new Node(newTask);

    // If list is empty or new task has higher priority than head
    if (head == null || priority > head.task.priority) {
      newNode.next = head;
      head = newNode;
      return;
    }

    // Traverse and insert in sorted position
    Node current = head;
    while (current.next != null && current.next.task.priority >= priority) {
      current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;
  }

  // Peek the task with the highest priority
  public Task peekMax() {
    return head != null ? head.task : null;
  }

  // Extract and remove the highest priority task
  public Task extractMax() {
    if (head == null) return null;
    Task maxTask = head.task;
    head = head.next;
    return maxTask;
  }

  // Update a task's priority (find and reinsert)
  public boolean update(String name, int newPriority) {
    Node prev = null, current = head;

    // Find the task by name
    while (current != null && !current.task.name.equals(name)) {
      prev = current;
      current = current.next;
    }

    if (current == null) return false; // Not found

    // Remove the node
    if (prev == null) head = current.next;
    else prev.next = current.next;

    // Reinsert with new priority
    insert(name, newPriority);
    return true;
  }

  // Check if empty
  public boolean isEmpty() {
    return head == null;
  }

  // Utility: Print the queue
  public void printQueue() {
    Node current = head;
    while (current != null) {
      System.out.print(current.task + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    PriorityQueueLinkedList pq = new PriorityQueueLinkedList();

    pq.insert("Task A", 10);
    pq.insert("Task B", 50);
    pq.insert("Task C", 30);
    pq.insert("Task D", 70);

    pq.printQueue(); // Should print tasks in descending order of priority

    System.out.println("Peek Max: " + pq.peekMax()); // Task D
    System.out.println("Extract Max: " + pq.extractMax()); // Task D

    pq.printQueue(); // Remaining tasks

    pq.update("Task A", 80); // Re-prioritize Task A

    pq.printQueue(); // Task A should now be at front
  }
}
