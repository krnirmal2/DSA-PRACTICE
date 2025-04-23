package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

public class AlternatingSplitLL {
  // Function to split a linked list into two alternate lists
  static void AlternatingSplit(Node source, Node[] aRef, Node[] bRef) {
    if (source == null) return; // Edge case: Empty list

    Node a = null, b = null; // Pointers to keep track of last nodes
    Node current = source;
    int count = 0; // To track even/odd positions

    while (current != null) {
      if (count % 2 == 0) { // Even index -> Goes to list 'a'
        if (a == null) {
          aRef[0] = current;
          a = current;
        } else {
          a.next = current;
          a = a.next;
        }
      } else { // Odd index -> Goes to list 'b'
        if (b == null) {
          bRef[0] = current;
          b = current;
        } else {
          b.next = current;
          b = b.next;
        }
      }

      current = current.next; // Move to the next node
      count++;
    }

    // Properly terminate both lists
    if (a != null) a.next = null;
    if (b != null) b.next = null;
  }

  // Function to print nodes in a given linked list
  static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    System.out.println("NULL");
  }

  // Driver code
  public static void main(String[] args) {

    // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    Node head = null;
    for (int i = 6; i >= 1; i--) {
      Node newNode = new Node(i);
      newNode.next = head;
      head = newNode;
    }

    System.out.print("Original Linked List: ");
    printList(head);

    Node[] aRef = new Node[1];
    Node[] bRef = new Node[1];

    // Splitting the linked list into two
    AlternatingSplit(head, aRef, bRef);

    System.out.print("\nResultant Linked List 'a': ");
    printList(aRef[0]);

    System.out.print("Resultant Linked List 'b': ");
    printList(bRef[0]);
  }
}

// Linked list node
class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    next = null;
  }
}

class AlternateSplitWithCopy {
  public static Node[] splitAlternate(Node head) {
    // Dummy heads to simplify edge case handling
    Node dummyHead1 = new Node(-1);
    Node dummyHead2 = new Node(-1);

    Node tail1 = dummyHead1;
    Node tail2 = dummyHead2;

    Node current = head;
    boolean turn = true;

    while (current != null) {
      // Create a new node (deep copy)
      Node newNode = new Node(current.data);

      if (turn) {
        tail1.next = newNode;
        tail1 = tail1.next;
      } else {
        tail2.next = newNode;
        tail2 = tail2.next;
      }

      current = current.next;
      turn = !turn;
    }

    // Return actual heads (skip dummy nodes)
    return new Node[] {dummyHead1.next, dummyHead2.next};
  }

  // Utility to print a list
  public static void printList(Node head) {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " → ");
      current = current.next;
    }
    System.out.println("null");
  }

  // Example usage
  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);
    head.next.next.next.next.next = new Node(60);

    Node[] result = splitAlternate(head);

    System.out.println("List 1:");
    printList(result[0]);

    System.out.println("List 2:");
    printList(result[1]);
  }
}
