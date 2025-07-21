package StandardProblemDSA.II_LINKEDLIST.v_FAST_AND_SLOW_POINTER_POINTER;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class DetectCycleStart {
  // Find the Start of a Cycle
  public static ListNode detectCycleStart(ListNode head) {
    ListNode slow = head, fast = head, start = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) { // slow == fast means cycle detected now detect the first point
        /* Once cycle is detected, move one pointer to the head(start)
        and another remains at the meeting point(Slow).
        Move both one step at a time.
        The node where they meet again is the start of the cycle.*/
        while (start
            != slow) { // this means where they are not meet , once meet this will break and we got
          // starting point
          start = start.next;
          slow = slow.next;
        }
        return start;
      }
    }

    return null;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    ListNode head = Utility_linkedList.arrayToLinkedList(arr);
    // Check for Cycle
    System.out.println("Has Cycle? " + Utility_linkedList.hasCycle(head));
  }
}
