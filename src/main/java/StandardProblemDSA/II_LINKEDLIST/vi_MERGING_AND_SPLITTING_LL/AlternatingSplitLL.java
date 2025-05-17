package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;

public class AlternatingSplitLL {
  // Function to split a linked list into two alternate lists
  static void AlternatingSplit(Node source, Node[] aRef, Node[] bRef) {
    if (source == null) return; // Edge case: Empty list

    Node a = null, b = null; // Pointers to keep track of last nodes
    Node current = source;
    int count = 0; // To track even/odd positions

    while (current != null) {
      if (count % 2 == 0) { // Even index -> Goes to list 'a'
        a = setNode(aRef, a, current);
      } else { // Odd index -> Goes to list 'b'
        b = setNode(bRef, b, current);
      }

      current = current.next; // Move to the next node
      count++;
    }

    // Properly terminate both lists
    if (a != null) a.next = null;
    if (b != null) b.next = null;
  }

  private static Node setNode(Node[] bRef, Node lastNode, Node current) {
    if (lastNode == null) {
      bRef[0] = current;
      lastNode = current;
    } else {
      lastNode.next = current;
      lastNode = lastNode.next;
    }
    return lastNode;
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
