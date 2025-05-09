package StandardProblemDSA.II_LINKEDLIST.iii_RECURSIVE_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;
import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.reverseRecursive;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class RecursiveReverseLL {

  public static void main(String[] args) {
    // Example List: 1 -> 2 -> 3 -> 4 -> null
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    System.out.println("Original List:");
    printList(head);

    head = reverseRecursive(head);

    System.out.println("Reversed List:");
    printList(head);
  }
}
