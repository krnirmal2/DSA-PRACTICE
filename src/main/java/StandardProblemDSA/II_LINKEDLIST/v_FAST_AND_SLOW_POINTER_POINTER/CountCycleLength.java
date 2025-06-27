package StandardProblemDSA.II_LINKEDLIST.v_FAST_AND_SLOW_POINTER_POINTER;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class CountCycleLength {

  public class DetectCycleLength {

    public static int findCycleLength(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

      // Step 1: Detect cycle using Floyd’s algorithm
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
          // Step 2: Calculate length of the cycle
          // slow at the meeting point
          // for calculating length , we can fix the meeting point
          // and another pointer will traverse till again reach this meeting
          // point gives us the length
          return countCycleLength(slow);
        }
      }
      return 0; // No cycle
    }

    private static int countCycleLength(ListNode meetingPoint) {

      int count = 1;
      ListNode current = meetingPoint.next;// this will traverse and again reach and
      // we will get count
      while (current != meetingPoint) {
        count++;
        current = current.next;
      }
      return count;
    }

    public void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      // Creating a cycle: Node 5 -> Node 3
      head.next.next.next.next.next = head.next.next;

      int cycleLength = findCycleLength(head);
      System.out.println("Cycle Length: " + cycleLength);
    }
  }
}
