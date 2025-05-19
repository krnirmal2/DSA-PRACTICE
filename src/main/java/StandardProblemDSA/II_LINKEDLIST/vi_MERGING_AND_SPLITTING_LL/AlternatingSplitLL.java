package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class AlternatingSplitLL {
  // Function to split a linked list into two alternate lists
  // Splits linked list into two alternate node lists: even-indexed → listA, odd-indexed → listB
  public static void splitAlternatingNodes(Node head, Node[] listARef, Node[] listBRef) {
    if (head == null) return;

    Node lastA = null, lastB = null;
    Node current = head;
    int index = 0;

    while (current != null) {
      if (index % 2 == 0) {
        lastA = appendNode(listARef, lastA, current);
      } else {
        lastB = appendNode(listBRef, lastB, current);
      }
      current = current.next;
      index++;
    }

    // Terminate both lists
    if (lastA != null) lastA.next = null;
    if (lastB != null) lastB.next = null;
  }

  // Appends the current node to the new list, returns updated tail
  private static Node appendNode(Node[] headRef, Node tail, Node current) {
    if (tail == null) {
      headRef[0] = current;
      return current;
    } else {
      tail.next = current;
      return tail.next;
    }
  }

  // Driver code
  public static void main(String[] args) {

    // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    Node head = null;
    head = Utility_linkedList.createLinkedListOfSizeK(head, 6);

    System.out.print("Original Linked List: ");
    printList(head);

    Node[] aRef = new Node[1];
    Node[] bRef = new Node[1];

    // Splitting the linked list into two
    splitAlternatingNodes(head, aRef, bRef);

    System.out.print("\nResultant Linked List 'a': ");
    printList(aRef[0]);

    System.out.print("Resultant Linked List 'b': ");
    printList(bRef[0]);
  }
}
