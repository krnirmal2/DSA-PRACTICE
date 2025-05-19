package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class AlternatingSplitLLWithDeepCopy {
  public static Node[] splitAlternate(Node head) {
    // step 1: create two dummy node with -1
    Node dummyHead1 = Utility_linkedList.createNewNode(-1);
    Node dummyHead2 = Utility_linkedList.createNewNode(-1);
    // step 2; create two extra node and assign them
    Node tail1 = dummyHead1;
    Node tail2 = dummyHead2;
    // Step 3 : iterate over the list and processed for the question
    boolean turn = true;
    while (head != null) {
      // Create a new node (deep copy)
      Node newNode = new Node(head.data);

      if (turn) {
        tail1.next = newNode;
        tail1 = tail1.next;
      } else {
        tail2.next = newNode;
        tail2 = tail2.next;
      }

      head = head.next;
      turn = !turn;
    }

    // step 4: here  Return actual heads (skip dummy nodes) and not merge two list as we need
    // separate list
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
