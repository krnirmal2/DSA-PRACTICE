package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;

public class AlternatingSplitLLWithDeepCopy {
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
