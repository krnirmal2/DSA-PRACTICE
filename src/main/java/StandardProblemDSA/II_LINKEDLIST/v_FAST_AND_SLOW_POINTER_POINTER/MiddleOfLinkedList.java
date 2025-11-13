package StandardProblemDSA.II_LINKEDLIST.v_FAST_AND_SLOW_POINTER_POINTER;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class MiddleOfLinkedList {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    ListNode head = Utility_linkedList.arrayToLinkedList(arr);

    // Find Middle Node
    ListNode middle = Utility_linkedList.findMiddle(head);

    // Check for Cycle
    System.out.println("Has Cycle? " + Utility_linkedList.hasCycle(head));
  }
}
