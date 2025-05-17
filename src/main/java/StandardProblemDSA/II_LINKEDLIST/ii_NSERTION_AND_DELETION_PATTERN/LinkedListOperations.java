package StandardProblemDSA.II_LINKEDLIST.ii_NSERTION_AND_DELETION_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class LinkedListOperations {

  // Head pointer of the linked list.
  private ListNode head;

  // Constructor: Initializes an empty linked list.
  public LinkedListOperations() {
    head = null;
  }

  // 1a. Insert Node at the Beginning
  public void insertAtBeginning(int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = head;
    head = newNode;
  }

  // 1b. Insert Node at the End
  public void insertAtEnd(int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
      head = newNode;
      return;
    }
    ListNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
  }

  // 1c. Insert Node at a Specific Position (0-indexed)
  public void insertAtPosition(int value, int position) {
    ListNode newNode = new ListNode(value);
    // If inserting at the beginning.
    if (position == 0) {
      newNode.next = head;
      head = newNode;
      return;
    }
    ListNode current = head;
    // Traverse to the node before the target position.
    for (int i = 0; i < position - 1 && current != null; i++) {
      current = current.next;
    }
    if (current == null) {
      // Position is out of bounds.
      System.out.println("Position out of bounds.");
      return;
    }
    newNode.next = current.next;
    current.next = newNode;
  }

  // 2a. Delete Node with a Given Value (first occurrence)
  public void deleteNodeByValue(int value) {
    if (head == null) return;

    // If head node is the one to be deleted.
    if (head.val == value) {
      head = head.next;
      return;
    }

    ListNode current = head;
    while (current.next != null && current.next.val != value) {
      current = current.next;
    }
    // If found, bypass the node.
    if (current.next != null) {
      current.next = current.next.next;
    }
  }

  // 2b. Delete Node without Head Pointer
  // This method deletes the given node from the list.
  // Note: The node must not be the tail.
  public void deleteNodeWithoutHead(ListNode node) {
    if (node == null || node.next == null) {
      System.out.println("Cannot delete the given node.");
      return;
    }
    // Copy data from the next node into the current node.
    node.val = node.next.val;
    // Bypass the next node.
    node.next = node.next.next;
  }

  // For demonstration purposes
  public static void main(String[] args) {
    LinkedListOperations listOps = new LinkedListOperations();

    // Insert nodes at beginning, end, and specific positions.
    listOps.insertAtBeginning(3);
    listOps.insertAtEnd(5);
    listOps.insertAtEnd(7);
    listOps.insertAtPosition(4, 2); // Insert 4 at position 2

    System.out.println("Linked List after insertions:");
//    printList(); // Expected: 3 -> 5 -> 4 -> 7 (if head inserted first, then end, then at pos
    // 2)

    // Delete node with a given value.
    listOps.deleteNodeByValue(4);
    System.out.println("Linked List after deleting value 4:");
//    printList(); // Expected: 3 -> 5 -> 7

    // Demonstrate deletion without head pointer:
    // Let's delete the node with value 5. First, get a reference to it.
    // (For demonstration, we assume we know the node; in a real scenario, you would locate it.)
    ListNode current = listOps.head;
    while (current != null && current.val != 5) {
      current = current.next;
    }
    if (current != null) {
      listOps.deleteNodeWithoutHead(current);
      System.out.println(
          "Linked List after deleting node without head pointer (deleting value 5):");
//      printList(); // Expected: 3 -> 7
    }
  }
}
