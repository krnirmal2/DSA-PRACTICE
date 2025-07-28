package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class TwoHalfOfCircle {
  /*
   Problem: Split a circular linked list into two equal halves.

   Given a circular singly linked list, split it into two circular linked lists of (almost) equal size.

   Example:
   Input: Circular list 1 -> 2 -> 3 -> 4 -> (back to 1)
   Output:
     First half: 1 -> 2 -> (back to 1)
     Second half: 3 -> 4 -> (back to 3)

   Pattern:
      - Linked List
      - Floyd’s Cycle (Slow & Fast pointers)
      - Circular List Manipulation
      - Two Pointer Technique

   Similar LeetCode Problems:
      - 876. Middle of the Linked List (finding middle)
      - 141. Linked List Cycle (cycle detection)
      - 142. Linked List Cycle II (cycle start node detection)

   Follow-up Questions:
      - How to handle odd number of nodes? (one half longer by one)
      - Can this be done for doubly circular lists?
      - How to merge two circular lists back into one?
      - What if list is not circular?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(1)
  */

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
