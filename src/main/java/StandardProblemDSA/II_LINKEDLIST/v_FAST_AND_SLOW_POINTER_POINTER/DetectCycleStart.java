package StandardProblemDSA.II_LINKEDLIST.v_FAST_AND_SLOW_POINTER_POINTER;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class DetectCycleStart {
  // Find the Start of a Cycle
  public static ListNode detectCycleStart(ListNode head) {
    ListNode slow = head, fast = head, entry = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        while (entry != slow) {
          entry = entry.next;
          slow = slow.next;
        }
        return entry;
      }
    }

    return null;
  }

  static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    ListNode head = Utility_linkedList.arrayToLinkedList(arr);

    // Find Middle Node
    ListNode middle = detectCycleStart(head);

    // Check for Cycle
    System.out.println("Has Cycle? " + Utility_linkedList.hasCycle(head));
  }
}
