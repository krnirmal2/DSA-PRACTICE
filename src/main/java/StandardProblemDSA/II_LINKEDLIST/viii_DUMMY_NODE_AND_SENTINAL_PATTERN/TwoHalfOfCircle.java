package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class TwoHalfOfCircle {
  public static void splitList(ListNode head) {
    if (head == null || head.next == head) {
      System.out.println("List is too small to split.");
      return;
    }
    ListNode slow = head;
    ListNode fast = head;

    // Use Floyd’s cycle to find mid point
    while (fast.next != head && fast.next.next != head) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode head1 = head; // first half
    ListNode head2 = slow.next; // second half

    // Make two halves circular
    slow.next = head1;

    if (fast.next == head) fast.next = head2;
    else fast.next.next = head2;

    // Print both halves
    printList(head1);
    printList(head2);
  }

  public void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = head; // circular link

    splitList(head);
  }
}
