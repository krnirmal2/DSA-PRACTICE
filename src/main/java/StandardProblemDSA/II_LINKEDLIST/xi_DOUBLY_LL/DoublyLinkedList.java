package StandardProblemDSA.II_LINKEDLIST.xi_DOUBLY_LL;

import StandardProblemDSA.II_LINKEDLIST.DoubllyNode;

public class DoublyLinkedList { // DoubllyNode class (inner class)
  // Head and tail pointers of the DLL
  private DoubllyNode head, tail;

  // Constructor for the DLL
  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  // Main method to test the implementation
  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();

    // Test inserting at the front
    dll.insertAtFront(10);
    dll.insertAtFront(5);
    dll.insertAtFront(1);
    System.out.println("After inserting at the front:");
    dll.traverseForward();

    // Test inserting at the end
    dll.insertAtEnd(20);
    dll.insertAtEnd(30);
    System.out.println("After inserting at the end:");
    dll.traverseForward();

    // Test traversal backward
    System.out.println("Traverse backward:");
    dll.traverseBackward();

    // Test deleting a DoubllyNode
    dll.delete(10);
    System.out.println("After deleting 10:");
    dll.traverseForward();

    // Test deleting a DoubllyNode not in the list
    dll.delete(50);

    // Test clearing the list
    dll.clear();
    System.out.println("After clearing the list:");
    dll.traverseForward();
  }

  /*How It Works
  Insertion at the Front:

  Adds a new DoubllyNode as the first element.
  Updates head pointer and handles cases where the list is empty

  Insertion at the End:
  Adds a new DoubllyNode as the last element.
  Updates tail pointer and handles cases where the list is empty.

  Deletion:
  Searches for the DoubllyNode with the given value.
  Deletes it by updating pointers of the previous and next DoubllyNodes.
  Handles cases where the DoubllyNode is the head, tail, or in between.

  Traversal:
  Forward traversal starts from head.
  Backward traversal starts from tail.
  Clear:

  Resets both head and tail to null.*/
  // Insert at the front
  public void insertAtFront(int data) {
    DoubllyNode newDoubllyNode = new DoubllyNode(data);
    if (head == null) { // If list is empty
      head = tail = newDoubllyNode;
    } else {
      newDoubllyNode.next = head;
      head.prev = newDoubllyNode;
      head = newDoubllyNode;
    }
  }

  // Insert at the end
  public void insertAtEnd(int data) {
    DoubllyNode newDoubllyNode = new DoubllyNode(data);
    if (head == null) { // If list is empty
      head = tail = newDoubllyNode;
    } else {
      tail.next = newDoubllyNode;
      newDoubllyNode.prev = tail;
      tail = newDoubllyNode;
    }
  }

  // Delete a DoubllyNode with a given value
  public void delete(int data) {
    if (head == null) { // If list is empty
      System.out.println("List is empty.");
      return;
    }

    DoubllyNode current = head;

    // Search for the DoubllyNode to delete
    while (current != null && current.data != data) {
      current = current.next;
    }

    if (current == null) { // DoubllyNode not found
      System.out.println("DoubllyNode with data " + data + " not found.");
      return;
    }

    // If the DoubllyNode is the head
    if (current == head) {
      head = head.next;
      if (head != null) {
        head.prev = null;
      } else {
        tail = null; // List becomes empty
      }
    }
    // If the DoubllyNode is the tail
    else if (current == tail) {
      tail = tail.prev;
      if (tail != null) {
        tail.next = null;
      } else {
        head = null; // List becomes empty
      }
    }
    // If the DoubllyNode is in the middle
    else {
      current.prev.next = current.next;
      current.next.prev = current.prev;
    }

    System.out.println("DoubllyNode with data " + data + " deleted.");
  }

  // Traverse forward
  public void traverseForward() {
    if (head == null) {
      System.out.println("List is empty.");
      return;
    }
    DoubllyNode current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  // Traverse backward
  public void traverseBackward() {
    if (tail == null) {
      System.out.println("List is empty.");
      return;
    }
    DoubllyNode current = tail;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.prev;
    }
    System.out.println();
  }

  // Check if the list is empty
  public boolean isEmpty() {
    return head == null;
  }

  // Clear the entire list
  public void clear() {
    head = null;
    tail = null;
    System.out.println("List cleared.");
  }
}
