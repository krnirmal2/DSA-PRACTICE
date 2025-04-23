package StandardProblemDSA.II_LINKEDLIST.xiii_CIRCULAR_LINKLIST;

public class CircularLinkedListOperations {

  // Definition for a node in a circular linked list.
  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  // Head pointer of the circular linked list.
  private Node head;

  // ---------------------------------------------------
  // 1. Insert Node in Circular Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Insert a new node with a given value into a circular linked list.

    Brute Force Approach:
       - Traverse the entire list until you reach the last node,
         then insert the new node by linking it to head.

    Optimal Approach:
       - For inserting at the end, if the list is empty, create a new node
         that points to itself. Otherwise, traverse once and adjust pointers.

    Time Complexity: O(n) in worst-case (if non-empty).

    Example:
       If list = 10 -> 20 -> 30 (circular), inserting 40 results in:
       10 -> 20 -> 30 -> 40, with 40.next pointing to 10.
  */
  public void insertAtEnd(int value) {
    Node newNode = new Node(value);
    // If list is empty, create new circular list.
    if (head == null) {
      head = newNode;
      newNode.next = head;
      return;
    }
    Node curr = head;
    // Traverse until the last node (which points back to head).
    while (curr.next != head) {
      curr = curr.next;
    }
    curr.next = newNode;
    newNode.next = head;
  }

  // ---------------------------------------------------
  // 2. Delete Node from Circular Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Delete a node with a given value from the circular linked list.

    Brute Force Approach:
       - Traverse the list while keeping track of the previous node.
       - When the node with the given value is found, update the previous node's pointer.

    Optimal Approach:
       - Special handling is needed if the head needs to be deleted.
       - Traverse until the node to delete is found and adjust pointers accordingly.

    Time Complexity: O(n) in worst-case.

    Example:
       If list = 10 -> 20 -> 30 -> 40 (circular) and value=20,
       after deletion: 10 -> 30 -> 40 (circular).
  */
  public void deleteNode(int key) {
    if (head == null) {
      return;
    }

    Node curr = head, prev = null;
    // If head holds the key
    if (head.data == key) {
      // If list contains only one node.
      if (head.next == head) {
        head = null;
        return;
      }
      // Find the last node to update its pointer.
      while (curr.next != head) {
        curr = curr.next;
      }
      curr.next = head.next;
      head = head.next;
      return;
    }

    prev = head;
    curr = head.next;
    while (curr != head && curr.data != key) {
      prev = curr;
      curr = curr.next;
    }
    if (curr.data == key) {
      prev.next = curr.next;
    }
  }

  // ---------------------------------------------------
  // 3. Traverse a Circular Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Traverse and print the elements of a circular linked list.

    Brute Force Approach:
       - Start at the head and continue traversing until you reach the head again.

    Optimal Approach:
       - Use a do-while loop to ensure the list is traversed at least once.

    Time Complexity: O(n)

    Example:
       For list = 10 -> 20 -> 30 (circular), output: 10, 20, 30.
  */
  public void traverse() {
    if (head == null) {
      System.out.println("List is empty.");
      return;
    }
    Node curr = head;
    do {
      System.out.print(curr.data + " ");
      curr = curr.next;
    } while (curr != head);
    System.out.println();
  }

  // ---------------------------------------------------
  // 4. Split Circular Linked List into Two
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a circular linked list, split it into two halves. If the number of nodes is odd,
       the first list gets one extra node.

    Brute Force Approach:
       - Traverse the list to count nodes, then iterate again to split at the midpoint.

    Optimal Approach:
       - Use slow and fast pointers to find the midpoint in one traversal.

    Time Complexity: O(n)

    Example:
       For list = 10 -> 20 -> 30 -> 40 -> 50 (circular),
       first list: 10 -> 20 -> 30, second list: 40 -> 50.
  */
  public Node[] splitList() {
    Node[] result = new Node[2];
    if (head == null) {
      result[0] = result[1] = null;
      return result;
    }

    Node slow = head, fast = head;
    // Use slow and fast pointers; fast advances two steps and slow one.
    while (fast.next != head && fast.next.next != head) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Set head of first half.
    Node head1 = head;
    // Set head of second half.
    Node head2 = slow.next;
    // Make first half circular.
    slow.next = head1;

    // Make second half circular.
    Node curr = head2;
    while (curr.next != head) {
      curr = curr.next;
    }
    curr.next = head2;

    result[0] = head1;
    result[1] = head2;
    return result;
  }

  // ---------------------------------------------------
  // 5. Josephus Problem Using Circular List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Solve the Josephus problem using a circular linked list. Given n persons
       arranged in a circle, eliminate every kth person until only one person remains.

    Brute Force Approach:
       - Use an array simulation of the circle and remove every kth element.

    Optimal Approach:
       - Use the circular linked list structure to eliminate every kth node by adjusting pointers.

    Time Complexity: O(n*k) in worst-case.

    Example:
       For n = 7, k = 3,
       the safe position is 4 (1-indexed).
  */
  public int josephusProblem(int n, int k) {
    // Create circular linked list of n nodes.
    Node josephusHead = new Node(1);
    Node prev = josephusHead;
    for (int i = 2; i <= n; i++) {
      Node newNode = new Node(i);
      prev.next = newNode;
      prev = newNode;
    }
    prev.next = josephusHead; // Make it circular.

    // Simulate elimination.
    Node curr = josephusHead;
    while (curr.next != curr) { // Loop until only one node remains.
      // Move (k-1) times.
      for (int count = 1; count < k - 1; count++) {
        curr = curr.next;
      }
      // Delete the kth node.
      Node eliminated = curr.next;
      curr.next = eliminated.next;
      curr = curr.next; // Continue from the next node.
    }
    // Return the safe position.
    return curr.data;
  }

  // ---------------------------------------------------
  // Main method for demonstration of each functionality.
  // ---------------------------------------------------
  public static void main(String[] args) {
    CircularLinkedListOperations cllOps = new CircularLinkedListOperations();

    // Example for Insertion in Circular Linked List:
    System.out.println("Inserting nodes into Circular Linked List:");
    cllOps.insertAtEnd(10);
    cllOps.insertAtEnd(20);
    cllOps.insertAtEnd(30);
    cllOps.insertAtEnd(40);
    // Expected Circular List: 10 -> 20 -> 30 -> 40 -> (back to 10)
    cllOps.traverse();

    // Example for Deletion from Circular Linked List:
    System.out.println("Deleting node with value 20:");
    cllOps.deleteNode(20);
    // Expected List: 10 -> 30 -> 40 (circular)
    cllOps.traverse();

    // Example for Splitting Circular Linked List:
    System.out.println("Splitting the Circular Linked List into two halves:");
    Node[] splitHeads = cllOps.splitList();
    System.out.print("First half: ");
    cllOps.printCircularList(splitHeads[0]);
    System.out.print("Second half: ");
    cllOps.printCircularList(splitHeads[1]);

    // Example for Josephus Problem:
    int n = 7, k = 3;
    int safePosition = cllOps.josephusProblem(n, k);
    System.out.println(
        "Josephus Problem: For n = " + n + ", k = " + k + ", safe position is " + safePosition);
  }

  // Utility method to print a circular linked list starting at a given node.
  public void printCircularList(Node start) {
    if (start == null) {
      System.out.println("List is empty.");
      return;
    }
    Node curr = start;
    do {
      System.out.print(curr.data + " ");
      curr = curr.next;
    } while (curr != start);
    System.out.println();
  }
}
